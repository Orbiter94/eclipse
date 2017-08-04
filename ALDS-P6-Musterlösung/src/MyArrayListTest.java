
public class MyArrayListTest
{
//Elemente in Liste einfügen
	static void fillList(MyArrayList list)
	{
		//Zahlen von 0 bis 15 als Integer einfügen
  	for (int i = 0; i <= 15; ++i) 
		{
    		list.add(i);
		}		
	}

//Inhalt der ArrayList ausgeben	
	static void printList(MyArrayList list )
	{
		for (int i = 0; i < list.size(); ++i) 
		{
    		System.out.print(list.get(i)+"\t");
		}
		System.out.println();
	}
}
