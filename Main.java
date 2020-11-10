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



    public void insert(Node inNode)
    {
        if (this.root == null)
        {
            this.root = inNode;
        }

        else
        {
            insertRecursive(this.root, inNode);
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



    public Node search(int target)
    {
        return searchRecursive(this.root, target);
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
}






public class Main
{
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(50));
        tree.insert(new Node(30));
        tree.insert(new Node(70));
        tree.insert(new Node(20));
        tree.insert(new Node(40));
        tree.insert(new Node(60));
        tree.insert(new Node(10));
    }
}
