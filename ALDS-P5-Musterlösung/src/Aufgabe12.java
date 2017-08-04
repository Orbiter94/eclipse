import java.util.HashSet;
import java.util.Stack;

public class Aufgabe12 
{

    public static void quickSortIt(int[] zahlen)
    {
    	class Auftrag
    	{
    		int von;
    		int bis;
    		
    		Auftrag(int von, int bis)
    		{
    			this.von = von;
    			this.bis = bis;
    		}
    	}
    	
    	Stack<Auftrag> ToDo = new Stack<Auftrag>();
    	ToDo.push(new Auftrag(0,zahlen.length-1));
    	
    	while (!ToDo.empty())
    	{
    		// nächsten Auftrag vom Stapel (ToDo) entnehmen
    		int uGrenze = ToDo.peek().von;
    		int oGrenze = ToDo.pop().bis;

    		// Pivot-Element bestimmen - hier über Dreiermedian
    		int PivotElement;
    		int k1 = zahlen[uGrenze];
    		int k2 = zahlen[(uGrenze + oGrenze)/2];
    		int k3 = zahlen[oGrenze];
    		if (((k2 <= k1) && (k1 <= k3)) || ((k3 <= k1) && (k1 <= k2)))
    			PivotElement = k1;
    		else if (((k1 <= k2) && (k2 <= k3)) || ((k3 <= k2) && (k2 <= k1)))
    			PivotElement = k2;
    		else // if (((k1 <= k3) && (k3 <= k2)) || ((k2 <= k3) && (k3 <= k1)))
    			PivotElement = k3;
    		
    		// Partitionierung des Feldes durchführen
    		int links = uGrenze;
    		int rechts = oGrenze;
    		while (links <= rechts)
    		{
    			while (zahlen[links] < PivotElement) links++;
    			while (PivotElement < zahlen[rechts]) rechts--;
    			if (links <= rechts)
    			{
    				int merker = zahlen[links];
    				zahlen[links] = zahlen[rechts]; 
    				zahlen[rechts] = merker;
    				links++; rechts--;
    			}
    		}
    		
    		// Aufträge für neue (vorher rekursive) Aufrufe auf Stapel ToDo legen
    		if (uGrenze < rechts) // quickSort(uGrenze, rechts, zahlen);
    			ToDo.push(new Auftrag(uGrenze,rechts));
    		if (links < oGrenze) // quickSort(links, oGrenze, zahlen);
    			ToDo.push(new Auftrag(links,oGrenze));
    	}
    }
    
	public static void main(String[] args) 
	{
		long start, ende;
		HashSet <Integer> erstellen = new HashSet <Integer>();
		System.out.println("Ich erstelle das Feld, das dauert ein wenig....");
		int [] zahlen = Hilfsfunktionen.feldErstellen (erstellen, 55555);			
		
		Hilfsfunktionen.ausgabe (zahlen, "QuickSort Iterativ");
		start = System.currentTimeMillis();
		quickSortIt (zahlen);
		ende = System.currentTimeMillis();			
		Hilfsfunktionen.ausgabe (start, ende, zahlen);
	}
}
