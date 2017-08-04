import java.util.HashSet;

public class Aufgabe11 
{

    public static void quickSort3M(int[] zahlen)
    {
    	quickSort3M(0,zahlen.length-1,zahlen);
    }

    public static void quickSort3M(int uGrenze, int oGrenze, int[] zahlen)
    {
    	int links = uGrenze; 
    	int rechts = oGrenze;
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
    	if (uGrenze < rechts) quickSort3M(uGrenze, rechts, zahlen);
    	if (links < oGrenze) quickSort3M(links, oGrenze, zahlen);
    }   

	public static void main(String[] args) 
	{
		long start, ende;
		HashSet <Integer> erstellen = new HashSet <Integer>();
		System.out.println("Ich erstelle das Feld, das dauert ein wenig....");
		int [] zahlen = Hilfsfunktionen.feldErstellen (erstellen, 55555);			
		
		Hilfsfunktionen.ausgabe (zahlen, "QuickSort3M");
		start = System.currentTimeMillis();
		quickSort3M (zahlen);
		ende = System.currentTimeMillis();			
		Hilfsfunktionen.ausgabe (start, ende, zahlen);
	}
}
