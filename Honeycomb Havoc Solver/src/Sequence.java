import java.util.ArrayList;
import java.util.List;

public class Sequence 
{
	List<Boolean> list = new ArrayList<Boolean>();
	int length;
	
	public Sequence(ArrayList<Boolean> myList)
	{
		length = myList.size();
		list = myList;
	}
	
	public void print()
	{
		Boolean bool;
		for(int i = 0; i < list.size()-1; i++)
		{
			bool = list.get(i);
			if (!bool)
				System.out.print("Fruit, ");
			else
				System.out.print("Honeycomb, ");
		}
		
		bool = list.get(list.size()-1);
		if (!bool)
			System.out.print("Fruit.\n");
		else
			System.out.print("Honeycomb.\n");
	}
}
