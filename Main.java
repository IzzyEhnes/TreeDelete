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



    public void insert(int inValue)
    {
        root = insertRecursive(root, inValue);
    }



    private Node insertRecursive(Node root, int inValue)
    {
        if (root == null)
        {
            root = new Node(inValue);

            return root;
        }

        if (inValue < root.getValue())
        {
            root.setLeft(insertRecursive(root.getLeft(), inValue));
        }

        else if (inValue > root.getValue())
        {
            root.setRight(insertRecursive(root.getRight(), inValue));
        }

        return root;
    }
}






public class Main
{
    public static void main(String[] args)
    {
	// write your code here
    }
}
