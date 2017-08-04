
public class Aufgabe17 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int ausdruck=0;
		MyLinkedList indexSuchen = new MyLinkedList();
		
		MyListTest.fillList (indexSuchen);
		
		System.out.println("Index:\n");
		while (ausdruck<indexSuchen.size())
		{
			System.out.print(ausdruck +"\t");
			ausdruck++;
		}
		System.out.println("\nWerte:\n");
		
		MyListTest.printList(indexSuchen);		
		
		System.out.println("Gesucht wird der Wert 10");
		
		System.out.println("10 hat den Index: " + indexSuchen.indexOf ("10"));
		
		indexSuchen.add(0, "22");
		
		MyListTest.printList(indexSuchen);	
		
		System.out.println("10 hat den Index: " + indexSuchen.indexOf ("10"));

	}

}
