/**
 * Binary Node Class.
 * @author Andrey
 *
 * @param <T> is generic.
 */

public class BinaryNode<T> {
	/**
	 * Generic variable data.
	 * &lt;T&gt; is generic.
	 */
	private T data;
	/**
	 * Generic BinaryNode leftChild.
	 */
	private BinaryNode<T> leftChild;
	/**
	 * Generic BinaryNode rightChild.
	 */
	private BinaryNode<T> rightChild;
	/**
	 * Constructor.
	 */
	public BinaryNode()
	{
		data = null;
		leftChild = null;
		rightChild = null;
	}
	/**
	 * Constructor.
	 * @param data
	 * data is value of the node.
	 */
	public BinaryNode(T data)
	{
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
	/**
	 * Constructor.
	 * @param data
	 * data is value of the node.
	 * @param leftNode
	 * Left Node of the node.
	 * @param rightNode
	 * Right Node of the node.
	 */
	public BinaryNode(T data, BinaryNode<T> leftNode, BinaryNode<T> rightNode)
	{
		this.data = data;
		this.leftChild = leftNode;
		this.rightChild = rightNode;		
	}
	/**
	 * Sets this.data to generic data.
	 * @param data
	 * data is value of the node.
	 */
	public void setData(T data)
	{
		this.data = data;
	}
	/**
	 * Returns data of the node.
	 * @return data
	 */
	public T getData()
	{
		return this.data;
	}
	/**
	 * sets the left child to a new node.
	 * @param leftNode
	 * left node.
	 */
	public void setLeftChild(BinaryNode<T> leftNode)
	{
		this.leftChild = leftNode;
	}
	/**
	 * Gets the left node.
	 * @return leftChild.
	 */
	public BinaryNode<T> getLeftChild()
	{
		return this.leftChild;
	}
	/**
	 * sets the right child to a new node.
	 * @param rightNode
	 * right node.
	 */
	public void setRightChild(BinaryNode<T> rightNode)
	{
		this.rightChild = rightNode;
	}
	/**
	 * Gets the left node.
	 * @return rightChild.
	 */
	public BinaryNode<T> getRightChild()
	{
		return this.rightChild;
	}
	/**
	 * checks for left child.
	 * @return boolean
	 */
	public boolean hasLeftChild()
	{
		if(this.leftChild != null)
			return true;
		return false;
	}
	/**
	 * checks for right child.
	 * @return boolean
	 */
	public boolean hasRightChild()
	{
		if(this.rightChild != null)
			return true;
		return false;
	}
	/**
	 * checks if node is a leaf.
	 * @return boolean
	 */
	public boolean isLeaf()
	{
		if((this.rightChild == null && this.leftChild == null) || (this.rightChild.getData().equals("null") && this.leftChild.getData().equals("null")))
			return true;
		return false;
	}
	/**
	 * Calculates the height of the tree.
	 * @return int
	 */
	public int getHeight()
	{
		int leftHeight = 0;
		int rightHeight = 0;
		int retHeight = 0;
		if(isLeaf())
			return 0;
		if(leftChild != null)
	        leftHeight = leftHeight + leftChild.getHeight() + 1;
		if(rightChild != null)
	        rightHeight = rightHeight + rightChild.getHeight() + 1;
		if(leftHeight > rightHeight)
			retHeight = leftHeight + retHeight;
		else
			retHeight = rightHeight + retHeight;
		
		return retHeight;
	}
	/**
	 * Calculates the Number Of Nodes.
	 * @return int
	 */
	public int getNumberOfNodes()
	{
		int numberOfNodes = 0;
		if (leftChild == null && rightChild == null) 
            return 1; 
        else
        {
        	if(leftChild != null)
        		numberOfNodes = leftChild.getNumberOfNodes() + numberOfNodes;
        	if(leftChild != null)
        		numberOfNodes = numberOfNodes + rightChild.getNumberOfNodes();
        }
		return numberOfNodes + 1;
	}
	/**
	 * Returns a copy of node.
	 * @return BinaryNode
	 */
	public BinaryNode<T> copy()
	{
		BinaryNode<T> copyNode = new BinaryNode<T>(this.data, this.leftChild, this.rightChild);
		return copyNode;
	}
}