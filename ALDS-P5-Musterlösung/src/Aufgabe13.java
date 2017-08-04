import java.util.HashSet;

public class Aufgabe13 
{

	public static void heapSortDescending(int[] data)
	{
		int n = data.length;
		//	Phase 1: wandle data[0 .. n-1] in Heap-Struktur um
		for (int k = n/2; k > 0; k--)
			downheap(data, k-1, n);
		//	Phase 2: entnehme Elemente aus der Heap-Struktur
		do
		{
			//	 tausche data[0] mit data[n-1]
			int x = data[0];
			data[0] = data[n-1];
			data[n-1] = x;
			//	 lasse data[0] in die Heap-Struktur einsickern
			n--;
			downheap(data, 0, n);
		} while (n > 1);
	}

	static void downheap(int[] data, int k, int right)
	{ 
		//versickere zahlen[k] in den Heap zahlen[k+1..rechts]
		int x = data[k];
		while (k+1 <= right/2) // zahlen[k+1] hat linken Sohn
		{
			int j = 2 * k + 1;
			if ((j+1 < right) && (data[j] > data[j+1]))
				j++;
			if (x <= data[j])
				break; // Halte an, Heap-Bedingung erfüllt!
			else
			{
				data[k] = data[j];
				k = j;
			}
		}
		data[k] = x;
	}

	public static void main(String[] args) 
	{
		long start, ende;
		HashSet <Integer> erstellen = new HashSet <Integer>();
		System.out.println("Ich erstelle das Feld, das dauert ein wenig....");
		int [] zahlen = Hilfsfunktionen.feldErstellen (erstellen, 55555);			
		
		Hilfsfunktionen.ausgabe(zahlen, "HeapSort absteigend");
		start = System.currentTimeMillis();
		heapSortDescending (zahlen);
		ende = System.currentTimeMillis();			
		Hilfsfunktionen.ausgabe (start, ende, zahlen);
	}
}
