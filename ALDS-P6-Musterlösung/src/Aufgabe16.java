
public class Aufgabe16 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyArrayList l�schen = new MyArrayList();
		
		int l�sche = 0;
			
		MyArrayListTest.fillList (l�schen);
		
		while (l�sche < l�schen.size() )
		{
			l�schen.remove(l�sche);
			MyArrayListTest.printList (l�schen);
			l�sche++;
		}	
	}
}