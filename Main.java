import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

class Node
{
    private int value;
    private Node right;
    private Node left;



    public Node(int inValue)
    {
        this.value = inValue;
        left = null;
        right = null;
    }



    public int getValue()
    {
        return this.value;
    }



    public void setLeft(Node inNode)
    {
        left = inNode;
    }



    public Node getLeft()
    {
        return left;
    }



    public void setRight(Node inNode)
    {
        right = inNode;
    }



    public Node getRight()
    {
        return right;
    }
}






class BinarySearchTree
{
    private Node root;
    int nodeCount = 1;

    private String preorder = "";
    private String inorder = "";
    private String postorder = "";
    private String levelOrder = "";



    public BinarySearchTree()
    {
        root = null;
    }



    public Node getRoot()
    {
        return root;
    }



    public String getInorderString()
    {
        return inorder;
    }



    public String getPreorderString()
    {
        return preorder;
    }



    public String getPostorderString()
    {
        return postorder;
    }



    public String getLevelOrderString()
    {
        return levelOrder;
    }



    public void insert(BinarySearchTree inTree, Node inNode)
    {
        if (inTree.root == null)
        {
            inTree.root = inNode;
        }

        else
        {
            insertRecursive(inTree.root, inNode);
            nodeCount++;
        }
    }



    public void insertRecursive(Node inRoot, Node inNode)
    {
        if (inNode.getValue() < inRoot.getValue())
        {
            if (inRoot.getLeft() == null)
            {
                inRoot.setLeft(inNode);
            }

            else
            {
                insertRecursive(inRoot.getLeft(), inNode);
            }
        }

        else
        {
            if (inRoot.getRight() == null)
            {
                inRoot.setRight(inNode);
            }

            else
            {
                insertRecursive(inRoot.getRight(), inNode);
            }
        }
    }



    public Node search(BinarySearchTree inTree, int target)
    {
        return searchRecursive(inTree.root, target);
    }



    public Node searchRecursive(Node inRoot, int target)
    {
        if (inRoot != null)
        {
            if (target == inRoot.getValue())
            {
                return inRoot;
            }

            else if (target < inRoot.getValue())
            {
                return searchRecursive(inRoot.getLeft(), target);
            }

            else
            {
                return searchRecursive(inRoot.getRight(), target);
            }
        }

        return null;
    }



    public Node getParent(BinarySearchTree inTree, Node inNode)
    {
        return getParentRecursive(inTree.root, inNode);
    }



    public Node getParentRecursive(Node subtreeRoot, Node inNode)
    {
        if (subtreeRoot == null)
        {
            return null;
        }

        if (subtreeRoot.getLeft() == inNode || subtreeRoot.getRight() == inNode)
        {
            return subtreeRoot;
        }

        if (inNode.getValue() < subtreeRoot.getValue())
        {
            return getParentRecursive(subtreeRoot.getLeft(), inNode);
        }

        return getParentRecursive(subtreeRoot.getRight(), inNode);
    }



    public void delete(BinarySearchTree inTree, int inValue)
    {
        Node newNode = search(inTree, inValue);
        Node parent = getParent(inTree, newNode);
        deleteNode(inTree, parent, newNode);
    }



    public boolean deleteNode(BinarySearchTree inTree, Node inParent, Node inNode)
    {
        if (inNode == null)
        {
            return false;
        }

        if (inNode.getLeft() != null && inNode.getRight() != null)
        {
            Node successor = inNode.getRight();
            Node successorParent = inNode;

            while (successor.getLeft() != null)
            {
                successorParent = successor;
                successor = successor.getLeft();
            }

            inNode= new Node(successor.getValue());

            deleteNode(inTree, successorParent, successor);
        }

        else if (inNode == inTree.root)
        {
            if (inNode.getLeft() != null)
            {
                inTree.root = inNode.getLeft();
            }

            else
            {
                inTree.root = inNode.getRight();
            }
        }

        else if (inNode.getLeft() != null)
        {
            if (inParent.getLeft() == inNode.getLeft())
            {
                inParent.setLeft(inNode.getLeft());
            }

            else
            {
                inParent.setRight(inNode.getLeft());
            }
        }

        else
        {
            if (inParent.getLeft() == inNode)
            {
                inParent.setLeft(inNode.getRight());
            }

            else
            {
                inParent.setRight(inNode.getRight());
            }
        }

        return true;
    }



    public void getInorder(Node inNode)
    {
        StringBuilder sb = new StringBuilder();

        if (inNode == null)
        {
            return;
        }

        getInorder(inNode.getLeft());

        sb.append(inorder).append(inNode.getValue() + "\n");
        inorder = sb.toString();

        getInorder(inNode.getRight());
    }



    public void getPreorder(Node inNode)
    {
        StringBuilder sb = new StringBuilder();

        if (inNode == null)
        {
            return;
        }

        sb.append(preorder).append(inNode.getValue() + "\n");
        preorder = sb.toString();

        getPreorder(inNode.getLeft());

        getPreorder(inNode.getRight());
    }



    public void getPostorder(Node inNode)
    {
        StringBuilder sb = new StringBuilder();

        if (inNode == null)
        {
            return;
        }

        getPostorder(inNode.getLeft());

        getPostorder(inNode.getRight());

        sb.append(postorder).append(inNode.getValue() + "\n");
        postorder = sb.toString();
    }



    public void getLevelOrder()
    {
        int height = getHeight(root);

        for (int level = 0; level < height; level++)
        {
            getLevelOrderRecursive(root, level);
        }
    }



    public void getLevelOrderRecursive(Node inNode, int level)
    {
        if (inNode == null)
        {
            return;
        }

        if (level == 0)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(levelOrder).append(inNode.getValue() + "\n");
            levelOrder = sb.toString();
        }

        else
        {
            getLevelOrderRecursive(inNode.getLeft(), level - 1);
            getLevelOrderRecursive(inNode.getRight(), level - 1);
        }
    }



    public int getHeight(Node inNode)
    {
        if (inNode == null)
        {
            return 0;
        }

        else
        {
            int leftHeight = getHeight(inNode.getLeft());
            int rightHeight = getHeight(inNode.getRight());

            if (leftHeight > rightHeight)
            {
                return (leftHeight + 1);
            }

            else
            {
                return (rightHeight + 1);
            }
        }
    }
}






class Driver
{
    public static BinarySearchTree readFile(String fileName)
    {
        BinarySearchTree tree = new BinarySearchTree();

        Scanner fileReader = null;

        try
        {
            fileReader = new Scanner(new File(fileName));
        }

        catch (FileNotFoundException fileError)
        {
            System.out.println(String.format
                    ("There was a problem opening file \"%s\": \n\tError = %s", fileName, fileError.getMessage()));

            System.out.println("Exiting program...");

            System.exit(1);
        }

        while (fileReader.hasNextLine())
        {
            String currentString = fileReader.next().trim();

            if (currentString.equals("Delete") || currentString.equals("delete"))
            {
                String deleteString = fileReader.next().trim();

                Node n = tree.search(tree, Integer.valueOf(deleteString));

                if (n == null)
                {
                    tree.insert(tree, new Node(Integer.valueOf(deleteString)));
                }

                else
                {
                    tree.delete(tree, Integer.valueOf(deleteString));
                }
            }

            else
            {
                tree.insert(tree, new Node(Integer.valueOf(currentString)));
            }
        }

        return tree;
    }



    public static void writeFile(BinarySearchTree inTree, String fileName)
    {
        try
        {
            File file = new File(fileName);

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("\nTree in preorder format:\n");
            inTree.getPreorder(inTree.getRoot());
            bw.write(inTree.getPreorderString());

            bw.write("\nTree in inorder format:\n");
            inTree.getInorder(inTree.getRoot());
            bw.write(inTree.getInorderString());

            bw.write("\nTree in postorder format:\n");
            inTree.getPostorder(inTree.getRoot());
            bw.write(inTree.getPostorderString());

            bw.write("\nTree in breadth search format:\n");
            inTree.getLevelOrder();
            bw.write(inTree.getLevelOrderString());

            bw.close();
        }

        catch (Exception ex)
        {
            System.out.print("\nError encountered when creating file: ");
            System.out.println(ex.getMessage());
        }
    }



    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        tree = readFile("src/input.txt");
        writeFile(tree, "src/output.txt");
    }
}