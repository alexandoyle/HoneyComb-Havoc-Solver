import java.util.ArrayList;
import java.util.List;

public class Sequence 
{
	List<Boolean> list = new ArrayList<Boolean>();
	
	//Create Sequence Object
	public Sequence(ArrayList<Boolean> myList)
	{
		list = myList;
	}
	
	public Sequence(int num)
	{
		list = new ArrayList<Boolean>();
		
		addFruit(num);
		addHoneycomb();
	}

	//Print Contents of Sequence

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
	
	public void addFruit(int num)
	{
		for(int i = 0; i < num; i++)
		{
			list.add(false);
		}
	}
	
	public void addHoneycomb()
	{
		list.add(true);
	}
	
	public boolean remove()
	{
		boolean bool = list.get(0);
		list.remove(0);
		
		return bool;
	}
}
