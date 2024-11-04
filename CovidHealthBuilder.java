import java.util.ArrayList;
import java.util.*;
import java.io.*;
/**
 * Covid Health Builder.
 * @author Andrey
 *
 */
public class CovidHealthBuilder {
	/**
	 * healthTree is a DecisonTreeInterface.
	 */
	DecisonTreeInterface<String> healthTree = new DecisionTree<String>();
	/**
	 * List from file in readDataList.
	 */
	private ArrayList<String> readDataList;
	/**
	 * Scanner to read the file.
	 */
	Scanner scan = new Scanner(System.in);
	/**
	 * Constructor.
	 * @param fileName the file.
	 * @throws FileNotFoundException if file is not found.
	 * @throws IOException if file cannot be read.
	 */
	public CovidHealthBuilder(String fileName) throws FileNotFoundException, IOException
	{
		readDataList = readData(fileName);
		healthTree.setRootNode(buildTree(readDataList, healthTree.getRootNode(), 0));
	}
	/**
	 * Reads data from a file and builds tree and puts it in the array.
	 * @param fileName the file.
	 * @return ArrayList
	 * @throws FileNotFoundException if file is not found.
	 * @throws IOException if file cannot be read.
	 */
	public ArrayList<String> readData(String fileName) throws FileNotFoundException, IOException
	{
		ArrayList<String> listOfContents = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
		{
			String line;
			while((line = reader.readLine()) != null)
			{
				String[] lineArray = line.split(",");
				for(int i = 0; i < lineArray.length; i++)
				{
					listOfContents.add(lineArray[i]);
				}
			}
		}
		return listOfContents;
	}
	/**
	 * Builds the health tree.
	 * @param listOfContents array with the contents
	 * @param tempRoot temporary root.
	 * @param index position in the array.
	 * @return BinaryNode
	 */
	public BinaryNode<String> buildTree(ArrayList<String> listOfContents, BinaryNode<String> tempRoot, int index)
	{
		if(index < listOfContents.size())
		{
			BinaryNode<String> tempHelperNode = new BinaryNode<String>(listOfContents.get(index));
			tempRoot = tempHelperNode;
			tempRoot.setLeftChild(buildTree(listOfContents,tempRoot.getLeftChild(), (2 * index) + 1));
			tempRoot.setRightChild(buildTree(listOfContents,tempRoot.getRightChild(), (2 * index) + 2));
		}
		
		return tempRoot;
	}
	/**
	 * Takes imput from the user and decides where to go in the binary tree.
	 * @throws EmptyTreeException if tree is empty.
	 */
	public void decide() throws EmptyTreeException
	{
		String userInput;
		healthTree.resetCurrentNode();
		if(healthTree.getRootNode().getData().equals("null") || healthTree.getRootNode() == null || healthTree == null)
			throw new EmptyTreeException("");
		while(!healthTree.getCurrentNode().isLeaf())
		{
			System.out.println(healthTree.getCurrentData());
			userInput = scan.nextLine();
			if(userInput.equals("no"))
				healthTree.moveToNo();
			if(userInput.equals("yes"))
				healthTree.moveToYes();
		}
		System.out.println(healthTree.getCurrentData());
		System.out.println("Satisfied by my intelligence?");
		userInput = scan.nextLine();
		if(userInput.contentEquals("no"))
			learn();
		if(userInput.contentEquals("yes"))
		{
			System.out.println("Try Again?");
			userInput = scan.nextLine();
			if(userInput.contentEquals("no"))
				System.out.println("Hava a nice day!");
			if(userInput.contentEquals("yes"))
				decide();
		}
	}
	/**
	 * Learns if the user wants to change something.
	 * @throws EmptyTreeException if tree is empty.
	 */
	public void learn() throws EmptyTreeException
	{
		System.out.println("What should be the answer?");
		String correctAnswer = scan.nextLine();
		System.out.println("Give me a question whose answer is yes for " + correctAnswer + " but no for " + healthTree.getCurrentData());
		String question = scan.nextLine();
		updateTree(question, (String)healthTree.getCurrentData(), correctAnswer);
		healthTree.resetCurrentNode();
	}
	/**
	 * Updates the tree.
	 * @param question question user want to change.
	 * @param noAnswer Answer No.
	 * @param yesAnswer Answer yes.
	 * @throws EmptyTreeException if tree is empty.
	 */
	public void updateTree(String question, String noAnswer, String yesAnswer) throws EmptyTreeException
	{
		healthTree.getCurrentNode().setData(question);
		healthTree.setResponses(noAnswer, yesAnswer);
	}
	/**
	 * Returns the health tree.
	 * @return DecisonTreeInterface
	 */
	public DecisonTreeInterface<String> getHealthTree()
	{
		return healthTree;
	}

}
