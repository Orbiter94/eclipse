
public class Challenge 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		MyLinkedStack stapel = new MyLinkedStack();
	
		System.out.println("Der Stapel stapel ist leer: " + stapel.empty() + "\n");
		
		System.out.println("Ein nichtleeres Element soll eingefügt werden: " + stapel.push(null) + "\n");
		
		for (int einfügen = 1; einfügen <=5; einfügen+=2)
		{
			System.out.println("Ein nichtleeres Element soll eingefügt werden: " + stapel.push(einfügen));
			System.out.println("Das oberste Element im Stapel ist: " + stapel.getHead().data);
		}
		
		System.out.println();			
		while (stapel.size>0)
		System.out.println("Anzahl der im Stapel enthaltenen Elemente: " + stapel.size + " - das oberste Element ist: " + stapel.pop());
		System.out.println("Anzahl der im Stapel enthaltenen Elemente: " + stapel.size + " - das oberste Element ist: " + stapel.pop());
		
		System.out.println();
		System.out.println("Anzahl der im Stapel enthaltenen Elemente: " + stapel.size + " - das oberste Element ist: " + stapel.peek());
		for (int einfügen = 9; einfügen >=5; einfügen-=1)
		{
			System.out.println("Ein nichtleeres Element soll eingefügt werden: " + stapel.push(einfügen));
			System.out.println("Anzahl der im Stapel enthaltenen Elemente: " + stapel.size + " - das oberste Element ist: " + stapel.peek());
		}
		
		for (int suchen = 10; suchen >=4; suchen-=1)
		{
			System.out.println();
			if (stapel.search(suchen)!=-1)
			{
				System.out.println("Das Element " + suchen + " ist im Stapel vorhanden, der Abstand zum obersten Element beträgt " +
						stapel.search(suchen) + " Positionen!");
			}
			else
			{
				System.out.println("Das Element " + suchen + " ist nicht im Stapel vorhanden!");
			}
		}
	}

}
