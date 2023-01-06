import java.util.ArrayList;
import java.util.List;

public class Sequence 
{
	List<Boolean> list = new ArrayList<Boolean>(); // Stores the objects; false represents a fruit, true represents a honeycomb
	
	// Create sequence with already populated arrayList
	public Sequence(ArrayList<Boolean> myList) 
	{
		list = myList;
	}
	
	// Create sequence with number of desired fruits and 1 honeycomb
	public Sequence(int num)
	{
		list = new ArrayList<Boolean>();
		
		addFruit(num);
		addHoneycomb();
	}

	// Prints formatted contents of sequence
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
	
	// Adds n fruits
	public void addFruit(int n)  
	{
		for(int i = 0; i < n; i++)
		{
			list.add(false);
		}
	}
	
	
	// Adds a honeycomb
	public void addHoneycomb()
	{
		list.add(true);
	}
	
	// Removes the next object in the sequence and returns it
	public boolean remove()
	{
		boolean bool = list.get(0);
		list.remove(0);
		
		return bool;
	}
	
	// Takes 1 object, and returns whether or not you lose
	public boolean take1()
	{
		if (remove() == true)
		{
			return true;
		}
		return false;
	}
	
	// Takes 1 object if the next object in the sequence is a honeycomb; Otherwise, takes two objects; Returns whether or not you lose
	public boolean take2()
	{
		if (remove() == true)
		{
			return true;
		}
		else if (remove() == true)
		{
			return true;
		}
		else return false;
	}
}
