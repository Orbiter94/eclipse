
public class ChallengeFolgewoche 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		MyLinkedQueue schlange = new MyLinkedQueue();
	
		System.out.println("Die Schlange ist leer: " + schlange.empty() + "\n");		
		
		System.out.println("Ein nichtleeres Element soll eingefügt werden: " + schlange.enqueue(null) + "\n");
		
		schlange.kompletteQueueAusgeben();
		
		for (int einfügen = 1; einfügen <=5; einfügen++)
		{
			System.out.println("Ein nichtleeres Element soll eingefügt werden: " + schlange.enqueue("Person " + einfügen));
			
			System.out.println("\nDas erste Element in der Schlange ist: " + schlange.getHead().data);
			System.out.println("Das letzte Element in der Schlange ist: " + schlange.getTail().data);
			
			schlange.kompletteQueueAusgeben();
		}
		
		for (int verlassen = 1; verlassen < 3; verlassen ++)
		{
			System.out.println("Die Schlange verlässt: " + schlange.dequeue());
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
						+ " Element beträgt " + abstand + " Position(en).");
			else
				System.out.println("Der Wert " + suchWert + " ist nicht in der Schlange enthalten oder der "
						+ "Suchwert ist leer!");			
		}		
}

