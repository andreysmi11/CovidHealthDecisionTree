/**
 * Binary Tree Interface.
 * @author Andrey
 *
 * @param <T> is generic.
 */


public interface BinaryTreeInterface<T> {
	/**
	 * Returns root of the tree.
	 * @return T
	 * @throws EmptyTreeException
	 * If the root is empty.
	 */
	public T getRootData() throws EmptyTreeException;
	/**
	 * Returns the node of the tree.
	 * @return BinaryNode
	 */
	public BinaryNode<T> getRootNode();
	/**
	 * Sets the Root Node.
	 * @param node is a binary node.
	 */
	public void setRootNode(BinaryNode<T> node);
	/**
	 * Calculates the height.
	 * @return int
	 */
	public int getHeight();
	/**
	 * Calculates the Number Of Nodes.
	 * @return int
	 */
	public int getNumberOfNodes();
	/**
	 * Checks if tree is empty.
	 * @return boolean.
	 */
	public boolean isEmpty();
	/**
	 * Clears the tree.
	 */
	public void clear();
}
