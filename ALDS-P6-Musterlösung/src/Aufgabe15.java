
public class Aufgabe15 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyLinkedList l�schen = new MyLinkedList();
		
		int l�sche = 1;
			
		MyListTest.fillList (l�schen);
		
		MyListTest.printList(l�schen);
		
		while (l�sche < 6 )
		{
			l�schen.remove(l�sche);
			MyListTest.printList(l�schen);
			l�sche++;
		}		
	}
}
