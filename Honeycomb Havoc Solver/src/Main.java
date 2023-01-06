import java.util.ArrayList;

/**
 * 
 */

/**
 * @author alexe
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<Boolean> arr = new ArrayList<Boolean>();
		arr.add(false);
		arr.add(true);
		arr.add(false);
		arr.add(true);
		arr.add(false);
		arr.add(true);
		arr.add(false);
		arr.add(true);
		
		Sequence mySeq = new Sequence(arr);
		mySeq.print();

	}
}
