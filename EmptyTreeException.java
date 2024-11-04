/**
 * If tree is empty then throw this Exception.
 * @author Andrey
 *
 */
public class EmptyTreeException extends Exception {

	private static final long serialVersionUID = 1L;
	/**
	 * Constructor.
	 * @param errorMessage the error message.
	 */
	public EmptyTreeException(String errorMessage) {
        super(errorMessage);
    }
	

}
