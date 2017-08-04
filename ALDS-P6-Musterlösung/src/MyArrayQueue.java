
/*****************************************************************************
 * Dies ist die Implementierung eines zyklisch indizierten Array als
 * Ringspeicher, bei dem die Werte nach dem FIFO (FirstIn-FirstOut) -
 * Prinzip verwaltet werden
 * @author Thomas Müller im Juni 2015
 *****************************************************************************/

public class MyArrayQueue
{
	// Attribute der Queue
	/**
	 * Attribute der Queue, es muss ein Startindex mitgeführt werden, da das erste Element
	 * nicht zwangsläufig immer beim Index 0 zu finden ist. Alle Attribute wurden
	 * "private" deklariert, damit sie nicht direkt von außen verändert werden können.
	 */
	private Object [] elementData;  // Feld zur Speicherung der Nutzdaten (Objekte)
	private int size;				// Anzahl der Elemente in der Liste
	private int startIndex;			// Index des Elementes mit der höchsten Verweildauer
	
		// Konstruktor
		/**
		 * Erzeugung einer leeren Queue mit Platz für n Einträge und den erforderlichen
		 * Attributen
		 * @param n Länge der Queue
		 */	
		public MyArrayQueue(int n)
		{
			this.elementData = new Object [n];	// Erzeugung eines Feldes mit der Startgröße n
			this.size = 0;						// Zunächst sind keine Elemente im Feld
			this.startIndex=0;					// Das leere Feld hat bei Index 0 den ersten Wert
		}		
		
		// Operationen
		
		/**
		 * Überprüfung, ob die Queue leer ist
		 * @return true wenn die Queue leer ist und false wenn Elemente enthalten sind
		 */	 
		public boolean isEmpty()
		{
			return this.size==0;
		}
		
		/**
		 * Überprüfung, ob die Queue bereits voll ist
		 * @return true wenn die Queue voll ist und false wenn noch Platz für neue Elemente vorhanden ist
		 */	 
		public boolean isFull()
		{
			return this.size == this.elementData.length;
		}
		
		/**
		 * Bestimmung der Anzahl der Elemente in der Queue
		 * @return die Anzahl der Elemente, die aktuell in der Queue enthalten sind
		 */
		public int getSize()
		{
			return this.size;
		}		
		
		/**
		 * Einfügen eines Elements am virtuellen Ende der Queue.
		 * Sofern es keine freien Plätze in der Queue mehr gibt, wird eine entsprechende
		 * Meldung ausgegeben.
		 * Elemente ohne Inhalt werden nicht eingefügt.
		 * @param data Object, das in die Queue eingefügt werden soll
		 * @return true, wenn der Wert eingefügt wurde, false, wenn nicht
		 */
		public boolean enqueue(Object data)
		{
			// Prüfen, ob noch ein Eintrag möglich ist
			
			if(this.isFull()) 
	        {
	            System.out.println("Einfügen nicht möglich, es ist kein Platz mehr in der Queue!"); 
	            return false;
	        }
			else
			{
				if (data!=null)
				{	
					this.elementData[this.getNextFreePos()] = data;	// an der nächsten freien Stelle wird der Wert eingefügt
					this.size++;									// Anzahl der Elemente um 1 erhöhen
					return true;
				}
				System.out.println("Elemente ohne Inhalt (\"null\") werden nicht eingefügt!");
				return false;
			}			
		}
		
		/**
		 * Sucht die nächste freie Stelle in der Queue
		 * Über die modulo - Komponente wird sichergestellt, dass ringförmig gesucht wird
		 * @return die nächste freie Position in der Queue
		 */		
		private int getNextFreePos() 
		{
			return (this.getLastFilledPos() + 1) % this.elementData.length; 
		}
		 
		/**
		 * Bestimmt die Position an der zuletzt ein Wert eingefügt wurde
		 * Über die modulo - Komponente wird sichergestellt, dass ringförmig gesucht wird
		 * @return die letzte Position in der Queue, an der ein Element eingefügt wurde
		 */
		private int getLastFilledPos() 
		{
		    return (this.startIndex + this.size - 1) % this.elementData.length; 
		}		
		 
		/**
		  * Rückgabe des virtuellen Queuekopfes (Element mit der höchsten Verweildauer)
		  * und löschen des Elements.
		  * Falls kein Element in der Queue enthalten ist, wird "null" zurückgeliefert.
		  * @return das Element am Kopf der Queue
		  */	
		 public Object getHeadAndRemove() 
		 {	
			 if (this.isEmpty())
				return null;
			 else			 
			 {
				 Object head = this.elementData[this.startIndex];
				 this.elementData[this.startIndex] = null;
				 this.startIndex = (this.startIndex + 1) % this.elementData.length;
				 this.size--;
				 return head;
			 }
		 }
		 
		 /**
		  * Rückgabe des virtuellen Queuekopfes (Element mit der höchsten Verweildauer)
		  * ohne löschen des Elements.
		  * Falls kein Element in der Queue enthalten ist, wird "null" zurückgeliefert.
		  * @return das Element am Kopf der Queue
		  */
		 public Object getVirtualHead() 
		 {	
			 return this.elementData[this.startIndex];
		 }
		 
		 /**
		  * Rückgabe des virtuellen Queueendes (Element mit der kürzesten Verweildauer)
		  * und löschen des Elements.
		  * Falls kein Element in der Queue enthalten ist, wird "null" zurückgeliefert.
		  * @return das Element am Ende der Queue
		  */	
		 public Object getTailAndRemove() 
		 {			 
			 {
				 Object tail = this.elementData[getLastFilledPos()];
				 this.elementData[getLastFilledPos()] = null;
				 this.size--;
				 return tail;
			 }
		 }
		 
		 /**
		  * Rückgabe des virtuellen Queueendes (Element mit der kürzesten Verweildauer)
		  * ohne löschen des Elements.
		  * Falls kein Element in der Queue enthalten ist, wird "null" zurückgeliefert.
		  * @return das Element am Ende der Queue
		  */
		 public Object getVirtualTail() 
		 {	
			 if (this.isEmpty())
				return null;
			 else
			 {
				 return this.elementData[getLastFilledPos()];
			 }
		 }
		 
		 /**
		  * Überprüfung ob ein bestimmtes Objekt in der Queue vorhanden ist und Rückgabe
		  * des Abstandes zum virtuellen Queuekopf
		  * Wenn das gesuchte Objekt "null" ist, wird Integer.MAX_VALUE zurückgegeben
		  * Wenn das gesuchte Objekt nicht in der Queue enthalten ist, so wird -1 zurückgegeben
		  * @param contained Element nach dem gesucht werden soll
		  * @return Abstand des gesuchten Objekes vom Queuekopf bzw. Integer.MAX_VALUE wenn ein
		  * leeres Objekt gesucht werden soll und -1 wenn das Objekt nicht in der Queue vorhanden ist
		  */		 
		 public int search(Object contained)
		 {				
			if (contained == null)
				return Integer.MAX_VALUE;	// Rückgabewert nur zur Unterscheidung des Ergebnisses vom
											// Ergebnis bei der erfolglosen Suche eines Elementes != Null
			else
			{	            
				for (int compare = 0; compare < this.elementData.length; compare++)
				{
		           	int index = (compare + this.startIndex + this.elementData.length) % this.elementData.length;	            	
		           	if (this.elementData[index].equals (contained)) 
		            {
		            	return compare;
		            }
				}
				return -1;
			}
		 }
		 
		/**
		 * Ausgabe des aktuellen Queuekopfes und des Queueendes
		 */	
		public void printHeadAndTail()
		{
			Object vHead = this.getVirtualHead();
			Object vTail = this.getVirtualTail();
			
			if (this.getSize()==0)
			{
				System.out.println("Queue ist leer, kein Queuekopf bzw. Queueende vorhanden!");
			}
			else
			{
				System.out.println("Virtueller Kopf der Queue: " + vHead);
				System.out.println("Virtuelles Ende der Queue: " + vTail);
			}
			System.out.println();
		}

		/**
		 * Gibt die Queue aus. Dabei erscheint das Element mit der höchsten Verweildauer
		 * (gleich das Element, das die Queue als Nächstes verlassen wird) in der ersten
		 * Zeile, also an Position 1.
		 * Der dazugehörige Index innerhalb des Array wird in der Spalte "Index" ausgegeben.
		 * Elemente ohne Inhalt werden nicht ausgegeben. 
		 */		
		public void printQueue()
		{
			String b;
			String w;
			
			if (this.isEmpty())
	        {
	            System.out.println("Kein Ausdruck möglich, es befinden sich keine Werte in der Queue!\n");
	        }
	        else
	        {
	        	if (this.size==1)
	        	{
	        		b = "befindet"; w = "Wert";
	        	}
	        	else
	        	{
	        		b = "befinden"; w = "Werte";
	        	}
	        	
	        	System.out.println("In der Queue " + b + " sich somit " + this.getSize() + " " + w + "!");
	        	System.out.println("==========================================");
	        	System.out.println("Position" + "\t" + "Index" + "\t\t" + "Element");
	        	System.out.println("==========================================");
	        	
	        	for (int i = 0; i < this.elementData.length; i++)
	        	{
	        		//Index bestimmen
	        		int index = (i + this.startIndex + this.elementData.length) % this.elementData.length;
	        		
	        		//Queue ohne "null-Elemente" ausgeben
	        		if (this.get(index)!=null)
	        		System.out.println(	i+1 + "\t\t"		//Position
	        							+ index  + "\t\t"	//Index 
	        							+ this.get(index));	//Inhalt
	        	}
	        	
	        	System.out.println("==========================================");
			}
		}
		
		/**
		 * Rückgabe des an der Position index gespeicherten Objektes im Array 
		 * ohne löschen des Elements.
		 * Falls kein Element in der Queue enthalten ist, wird "null" zurückgeliefert.
		 * Diese Funktion wird nur bei der Ausgabe der Queue verwendet
		 * @param index Position des Elementes, das geliefert werden soll
		 * @return Element an der Position index
		 */ 
		private Object get(int index)
		{			
			return this.elementData[index];
		}
}
	
