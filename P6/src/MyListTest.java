

import java.util.*;

public class MyListTest
{
	//Elemente in Liste einf�gen
	static void fillList(MyLinkedList mll)
  	{
		//Zahlen von 0 bis 19 als Zeichenketten (Strings) einf�gen
    	for (int i = 0; i < 20; ++i) 
		{
      		mll.add("" + i);
    	}
  	}

	//Liste vom Anfang bis zum Ende durchlaufen und Elemente ausgeben
  	static void printList(MyLinkedList mll)
  	{
		ListIterator<String> it = mll.listIterator();
		while (it.hasNext()) 
		{
      		System.out.print((String)it.next()+" ");
    	}
    	System.out.println("\n-");
  	}


  	public static void main(String[] args)
  	{
    	// Testen der Operationen
    	
    	LinkedList<String> list1 = new LinkedList<String>();
    	ArrayList<String> list2 = new ArrayList<String>();
		fillList(list1);
		fillList(list2);

		printList(list1);
		printList(list2);
		
  	}
}