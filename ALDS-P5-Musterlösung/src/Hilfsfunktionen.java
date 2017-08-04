import java.util.HashSet;

public class Hilfsfunktionen
{
	static int [] feldErstellen (HashSet <Integer> zahlen, int anzahl)
	{
		int erfolg=0;
		
		while (erfolg < anzahl)			
		{
			int a = zahlen.size();
			zahlen.add((int) (Math.random()*999999)+1);
			if (a < zahlen.size())
				erfolg++;			
		}		
		
		int [] feld = new int [zahlen.size()];		
		int index = 0;
		
		for (int a : zahlen)
		{
			feld [index] = a;
			index++;
		}
		
		return feld;
	}
	
		static void ausgabe (int [] zahlen, String Sortieralgorithmus)
		{		
			System.out.println("Sortieren mit " + Sortieralgorithmus + ":");
			
			System.out.println("Die ersten 10 Werte im unsortierten Feld:");
			
			for (int ausgabe = 0; ausgabe < 10; ausgabe ++)
				System.out.print(zahlen [ausgabe] + "\t");
			System.out.println();
		}
	
		static void ausgabe (long start, long ende, int [] zahlen)
		{
			System.out.println("Die ersten 10 Werte im sortierten Feld:");
			for (int ausgabe = 0; ausgabe < 10; ausgabe ++)
				System.out.print(zahlen [ausgabe] + "\t");
			System.out.println("\nZeitbedarf für das Sortieren: " + (ende - start)/1000f + " Sekunden!");
			System.out.println("==============================================================================================================");
		}
}
