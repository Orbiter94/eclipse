
public class ChallengeFolgewoche 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		MyLinkedQueue schlange = new MyLinkedQueue();
	
		System.out.println("Die Schlange ist leer: " + schlange.empty() + "\n");		
		
		System.out.println("Ein nichtleeres Element soll eingef�gt werden: " + schlange.enqueue(null) + "\n");
		
		schlange.kompletteQueueAusgeben();
		
		for (int einf�gen = 1; einf�gen <=5; einf�gen++)
		{
			System.out.println("Ein nichtleeres Element soll eingef�gt werden: " + schlange.enqueue("Person " + einf�gen));
			
			System.out.println("\nDas erste Element in der Schlange ist: " + schlange.getHead().data);
			System.out.println("Das letzte Element in der Schlange ist: " + schlange.getTail().data);
			
			schlange.kompletteQueueAusgeben();
		}
		
		for (int verlassen = 1; verlassen < 3; verlassen ++)
		{
			System.out.println("Die Schlange verl�sst: " + schlange.dequeue());
			schlange.kompletteQueueAusgeben();
		}
		
		System.out.println("Das erste Element in der Schlange ist jetzt: " + schlange.first() + "\n");
		
		Object suchWert = null;
		
		ausgeben (schlange.search(suchWert), suchWert);
		
		for (int test = 2; test <= 6; test ++)
			ausgeben (schlange.search("Person " + test), ("Person " + test));
	}
		
		public static void ausgeben (int abstand, Object suchWert)
		{
			if (abstand != -1)
				System.out.println("Der Wert " + suchWert + " ist enthalten, der Abstand zum vordersten"
						+ " Element betr�gt " + abstand + " Position(en).");
			else
				System.out.println("Der Wert " + suchWert + " ist nicht in der Schlange enthalten oder der "
						+ "Suchwert ist leer!");			
		}		
}

