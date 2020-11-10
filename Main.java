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
            Node currentNode = inTree.root;

            while (currentNode != null)
            {
                if (inNode.getValue() < currentNode.getValue())
                {
                    if (currentNode.getLeft() == null)
                    {
                        currentNode.setLeft(inNode);
                        currentNode = null;
                    }

                    else
                    {
                        currentNode = currentNode.getLeft();
                    }
                }

                else
                {
                    if (currentNode.getRight() == null)
                    {
                        currentNode.setRight(inNode);
                        currentNode = null;
                    }

                    else
                    {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }
    }
}






public class Main
{
    public static void main(String[] args)
    {
	// write your code here
    }
}
