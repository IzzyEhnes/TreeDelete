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



    public void setLeftValue(int inValue)
    {
        left.value = inValue;
    }



    public int getLeftValue()
    {
        return left.value;
    }



    public void setLeft(Node inNode)
    {
        left = inNode;
    }



    public Node getLeft()
    {
        return left;
    }



    public void setRightValue(int inValue)
    {
        right.value = inValue;
    }



    public int getRightValue()
    {
        return right.value;
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
    BinarySearchTree tree;



    public BinarySearchTree()
    {
        root = null;
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
}






public class Main
{
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(tree, new Node(50));
        tree.insert(tree, new Node(30));
        tree.insert(tree, new Node(70));
        tree.insert(tree, new Node(20));
        tree.insert(tree, new Node(40));
        tree.insert(tree, new Node(60));
        tree.insert(tree, new Node(10));
    }
}
