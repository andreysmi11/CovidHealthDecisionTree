/**
 * Binary Tree Class.
 * @author Andrey
 *
 * @param <T> is generic.
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {
	/**
	 * Generic Binary Node root of the tree.
	 * &lt;T&gt; is generic.
	 */
	private BinaryNode<T> root;
	/**
	 * Constructor.
	 * 
	 */
	public BinaryTree()
	{
		root = null;
	}
	/**
	 * Constructor.
	 * @param data
	 * data is value of the node.
	 */
	public BinaryTree(T data)
	{
		root = new BinaryNode<T>(data);
	}
	/**
	 * Constructor.
	 * @param data
	 * data is value of the node.
	 * @param leftTree
	 * Left Node of the node.
	 * @param rightTree
	 * Right Node of the node.
	 */
	public BinaryTree(T data, BinaryNode<T> leftTree, BinaryNode<T> rightTree)
	{
		root = new BinaryNode<T>(data, leftTree, rightTree);
	}
	/**
	 * Sets the data of the tree to new values.
	 * @param data is data of root.
	 * @param leftTree left subtree  of root.
	 * @param rightTree right subtree of root
	 */
	public void setTree(T data, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		if(root == null)
		{
			root = new BinaryNode<T>(data);
			if(leftTree != null && leftTree.getRootNode() != null)
				root.setLeftChild(leftTree.getRootNode());
			if(rightTree != null && rightTree.getRootNode() != null)
				root.setRightChild(rightTree.getRootNode());
		}
		else
		{
			root.setData(data);
			if(leftTree != null && leftTree.getRootNode() != null)
				root.setLeftChild(leftTree.getRootNode());
			if(rightTree != null && rightTree.getRootNode() != null)
				root.setRightChild(rightTree.getRootNode());
		}
		
	}
	/**
	 * Inorder Traversal of the tree.
	 */
	public void inorderTraversal()
	{
		if(isEmpty())
			return;
		BinaryTree<T> helperTree = new BinaryTree<T>(root.getData(),root.getLeftChild(),root.getRightChild());
		if(helperTree.getRootNode().isLeaf())
		{
			System.out.print(helperTree.getRootNode().getData());
			return;
		}

		BinaryTree<T> helperLeftTree = new BinaryTree<T>();
		helperLeftTree.setRootNode(helperTree.getRootNode().getLeftChild());
		if(helperTree.getRootNode().getLeftChild() != null)
		{
			helperLeftTree.inorderTraversal();
		}

		System.out.print(helperTree.getRootNode().getData());
	
		BinaryTree<T> helperRightTree = new BinaryTree<T>();
		helperRightTree.setRootNode(helperTree.getRootNode().getRightChild());
		if(helperTree.getRootNode().getRightChild() != null)
		{
			helperRightTree.inorderTraversal();
		}
	}

	@Override
	public T getRootData() throws EmptyTreeException {
		
		if(root == null)
			throw new EmptyTreeException("");
		else
			return root.getData();
	}

	@Override
	public BinaryNode<T> getRootNode() {
		BinaryNode<T> referenceRoot = root;
		return referenceRoot;
	}

	@Override
	public void setRootNode(BinaryNode<T> node) {
		root = node;
	}

	@Override
	public int getHeight() {
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes() + 1;
	}

	@Override
	public boolean isEmpty() {
		if(root != null)
			return false;
		return true;
	}

	@Override
	public void clear() {
		root = null;
	}
}
