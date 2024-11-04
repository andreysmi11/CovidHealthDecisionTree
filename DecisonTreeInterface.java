/**
 * Decison Tree Interface.
 * @author Andrey
 *
 * @param <T> is generic.
 */
public interface DecisonTreeInterface<T> extends BinaryTreeInterface<T> {
	/**
	 * Checks if node is answer.
	 * @return boolean.
	 */
	public boolean isAnswer();
	/**
	 * Moves to the left node tree.
	 * @throws EmptyTreeException if tree is empty.
	 */
	public void moveToNo() throws EmptyTreeException;
	/**
	 * Moves to the right node tree.
	 * @throws EmptyTreeException if tree is empty.
	 */
	public void moveToYes() throws EmptyTreeException;
	/**
	 * resets the current node.
	 */
	public void resetCurrentNode();
	/**
	 * Returns current node.
	 * @return BinaryNode
	 */
	public BinaryNode<T> getCurrentNode();
	/**
	 * Returns current data.
	 * @return T
	 */
	public T getCurrentData();
	/**
	 * Sets new answers.
	 * @param responseForNo New No answer.
	 * @param responseForYes New Yes answer.
	 */
	public void setResponses(T responseForNo, T responseForYes);
}
