
public class Aufgabe15 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyLinkedList löschen = new MyLinkedList();
		
		int lösche = 1;
			
		MyListTest.fillList (löschen);
		
		MyListTest.printList(löschen);
		
		while (lösche < 6 )
		{
			löschen.remove(lösche);
			MyListTest.printList(löschen);
			lösche++;
		}		
	}
}
