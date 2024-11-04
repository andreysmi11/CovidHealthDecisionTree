

/**
 * DecisionTree keep track of the current position in the tree.
 * @author Andrey
 *
 * @param <T> is generic.
 */
public class DecisionTree<T> extends BinaryTree<T> implements DecisonTreeInterface<T> {
	/**
	 * currentNode is the position in the tree.
	 */
	BinaryNode<T> currentNode;
	/**
	 * Constructor.
	 */
	public DecisionTree()
	{
		super();
		currentNode = null;
	}
	/**
	 * Constructor.
	 * @param data
	 * data is value of the node.
	 */
	public DecisionTree(T data)
	{
		super();
		currentNode = new BinaryNode<T>(data);
	}

	@Override
	public boolean isAnswer() {
		if(currentNode.isLeaf())
			return true;
		return false;
	}

	@Override
	public void moveToNo() throws EmptyTreeException {
		if(currentNode != null)
			currentNode = currentNode.getLeftChild();
	}

	@Override
	public void moveToYes() throws EmptyTreeException {
		if(currentNode != null)
			currentNode = currentNode.getRightChild();
	}

	@Override
	public void resetCurrentNode() {
		currentNode = getRootNode();
	}

	@Override
	public BinaryNode<T> getCurrentNode() {
		//return new BinaryNode<T>(this.currentNode.getData(), this.currentNode.getLeftChild(), this.currentNode.getRightChild());
		return currentNode;
	}

	@Override
	public T getCurrentData() {
		return currentNode.getData();
	}

	@Override
	public void setResponses(T responseForNo, T responseForYes) {
		if(!currentNode.hasLeftChild())
			currentNode.setLeftChild(new BinaryNode<T>(responseForNo));
		else
			currentNode.getLeftChild().setData(responseForNo);
		if(!currentNode.hasRightChild())
			currentNode.setRightChild(new BinaryNode<T>(responseForYes));
		else
			currentNode.getRightChild().setData(responseForYes);
	}
	
	

}
