
public class Aufgabe16 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyArrayList löschen = new MyArrayList();
		
		int lösche = 0;
			
		MyArrayListTest.fillList (löschen);
		
		while (lösche < löschen.size() )
		{
			löschen.remove(lösche);
			MyArrayListTest.printList (löschen);
			lösche++;
		}	
	}
}