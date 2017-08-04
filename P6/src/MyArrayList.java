/**
 * Implementierung der Schnittstelle SimpleList<E> mit Hilfe
 * eines Feldes, das bei Bedarf vergrößert wird.
 *
 * Die gespeicherten Objektreferenzen dürfen im Gegensatz zur 
 * Klasse java.util.ArrayList<E> in der Java-Klassenbibliothek 
 * nicht gleich null sein.
 */
/**
 * @author Manfred Meyer
 *
 * @param <E>
 */
public class MyArrayList<E>
implements SimpleList<E>
{
	/**
	 * Feld zur Speicherung der Nutzdaten (Elemente)
	 */
	private E[] data;  	 
	
	/**
	 * aktuelle Anzahl der Elemente in der Liste
	 */
	private int size;	
	
	/**
	 * Erzeugung einer leeren Liste
	 */
	public MyArrayList()			  
	{
		this(10);
	}

	/**
	 * Erzeugung einer leeren Liste
	 */
	@SuppressWarnings("unchecked")    
	public MyArrayList(int initialCapacity)			  
	{
		this.data = (E[]) new Object[initialCapacity];	
		this.size = 0;
	}
	
	/**
	 * Sicherstellen, dass das Feld gross genug ist, um mind.
	 * minCapacity Objekte speichern zu können.
	 * Ist das nicht der Fall, wird ein größeres Feld erzeugt,
	 * und die Elemente werden in das neue Feld umkopiert.
	 * 
	 * @param minCapacity sicherzustellende Mindestkapazität
	 */
	@SuppressWarnings("unchecked")
	protected void ensureCapacity(int minCapacity)
	{
		int oldCapacity = this.data.length;
	
		if (minCapacity>oldCapacity) 
		{
	    	E[] oldData = this.data;
	    	
	    	// Hier erfolgt die Erzeugung des neuen Feldes.
	    	// Für die Größe des neuen Feldes sind verschiedene
	    	// Strategien denkbar.	
	    	int newCapacity = (2 * oldCapacity <= oldCapacity + 500)
	    	        ? (2 * oldCapacity) : (oldCapacity + 500);
    	    if (newCapacity < minCapacity) newCapacity = minCapacity;
	    	this.data = (E[]) new Object[newCapacity];
	    
	    	// Kopieren der Daten aus dem alten in das neue Feld
	    	for (int i=0; i<oldCapacity; i++)
	    		this.data[i] = oldData[i];
		}
    }

	/**
	 * Sicherstellen, dass das Feld verkleinert wird, wenn sehr
	 * viele Elemente wieder entfernt wurden.
	 */
	@SuppressWarnings("unchecked")
	protected void shrinkCapacity()
	{
		int oldCapacity = this.data.length;
		int newCapacity = oldCapacity;
		
		// Hier erfolgt die Berechnung der neuen Feldgröße. 
		// Dafür sind verschiedene Strategien denkbar.
		if (oldCapacity - this.size > 500) newCapacity = oldCapacity - 500;
		if (this.size < oldCapacity/2) newCapacity = oldCapacity / 2;
		
		if (newCapacity < oldCapacity) 
		{
	    	E[] oldData = this.data;
	    	// Erzeugen des neuen Feldes
	    	this.data = (E[]) new Object[newCapacity];
	    
	    	// Kopieren der Daten aus dem alten in das neue Feld
	    	for (int i=0; i<newCapacity; i++)
	    		this.data[i] = oldData[i];
		}
    }
	
	/**
	 * Überprüfung, ob ein Index im gültigen Bereich liegt
	 * 
	 * @param minIndex die Untergrenze für den Index	
	 * @param index der zu überprüfende Index
	 * @param maxIndex die Obergrenze für den Index
	 */
	private static void rangeCheck(int minIndex, int index, int maxIndex)
	{
		if (index<minIndex || index>maxIndex)
			throw new IndexOutOfBoundsException();
	}
	
	/**
	 * Elemente ab der Position index+1 um 1 nach links schieben
	 * Das Element an der Position index wird überschrieben.
	 * 	
	 * @param index die Position, ab der verschoben werden soll
	 */
	private void shiftLeft(int index)
	{
		for (int i=index; i<this.size-1; i++)
			this.data[i] = this.data[i+1];
		this.data[this.size-1] = null;  // Referenz entfernen
	}	
	 
	/**
	 * Elemente ab der Position index um 1 nach rechts schieben.
	 * Das Element an der Position index wird überschrieben.
	 * 	
	 * @param index die Position, ab der verschoben werden soll
	 */
	private void shiftRight(int index)
	{
		for (int i=this.size; i>index; i--)
			this.data[i] = this.data[i-1];
	}	
	
	/**
	 * Überprüfung, ob die Liste leer ist
	 * 
	 * @see de.profmeyer.java.datastructures.SimpleCollection#isEmpty()
	 */
	public boolean isEmpty()
	{
		return this.size==0;
	}
	
	/**
	 * Bestimmung der Anzahl der Elemente in der Liste
	 * 
	 * @see de.profmeyer.java.datastructures.SimpleCollection#size()
	 */
	public int size()
	{
		return this.size;
	}
	
	/**
	 * Einfügen eines Elements am Ende der Liste 
	 * 
	 * @see de.profmeyer.java.datastructures.SimpleCollection#add(java.lang.Object)
	 */
	public boolean add(E o)
	{
		if (o!=null)
		{
			// Ausreichende Größe des Feldes sicherstellen
			ensureCapacity(this.size+1);
			// Objekt speichern
			this.data[this.size] = o;
			// Anzahl Elemente erhöhen
			this.size++;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Entfernen des ersten Elements der Liste, das zu element 
	 * inhaltsgleich ist 
	 *
	 * @see de.profmeyer.java.datastructures.SimpleCollection#remove(java.lang.Object)
	 */
	public boolean remove(E element)
	{
		// Bestimmung des Elements mit dem kleinsten Index, das
		// zu o inhaltsgleich ist
		int index = this.indexOf(element);
		
		if (index>=0)
		{
			// Elemente ab der Position index+1 um 1 nach links schieben
			shiftLeft(index);
			// Anzahl der Elemente reduzieren
			this.size--;
			// Pürfen, ob Feld verkleinert werden kann
			shrinkCapacity();
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Überprüfung, ob ein zu o inhaltsleiches Objekt in der
	 * Liste enthalten ist
	 *
	 * @see de.profmeyer.java.datastructures.SimpleCollection#contains(java.lang.Object)
	 */
	public boolean contains(E o)
	{
		return (this.indexOf(o) >= 0);
	}
	
	/**
	 * Erzeugung eines Iterators zum sequentiellen Durchlauf durch
	 * die Liste
	 * 
	 * @see de.profmeyer.java.datastructures.SimpleCollection#iterator()
	 */
	public SimpleIterator<E> iterator()
	{
		return new SimpleArrayListIterator();
	}

	/**
	 * Erzeugung eines List-Iterators zum sequentiellen Durchlauf 
	 * durch die Liste
	 * 
	 * @see de.profmeyer.java.datastructures.SimpleList#listIterator()
	 *
	 * @return ein neuer Listen-Iterator beginnend am Anfang der 
	 * Liste
	 */
	public SimpleListIterator<E> listIterator()
	{
		return new ExtendedSimpleArrayListIterator();
	}
	
	/**
	 * Erzeugung eines List-Iterators zum sequentiellen Durchlauf 
	 * durch die Liste
	 * 
	 * @see de.profmeyer.java.datastructures.SimpleList#listIterator()
	 *
	 * @return ein neuer Listen-Iterator beginnend an der Position 
	 * index
	 */
	public SimpleListIterator<E> listIterator(int index)
	{
		return new ExtendedSimpleArrayListIterator(index);
	}
	
    /**
     * Einfügen eines Elements an der Position index
     *
	 * @see de.profmeyer.java.datastructures.SimpleList#add(int, java.lang.Object)
	 */
	public void add(int index, E element)
	{
		if (element!=null)
		{
			rangeCheck(0, index, this.size);

			// Ausreichende Größe des Feldes sicherstellen		
			ensureCapacity(this.size+1);
		
			// Elemente ab der Position index um 1 nach rechts schieben
			shiftRight(index);
						
			// Objekt an der Position index speichern
			this.data[index] = element;
			this.size++;
		}
	}
	
	/**
	 * Entfernen des Elements an der Position index und Rückgabe 
	 * des entfernten Elements
	 *
	 * @see de.profmeyer.java.datastructures.SimpleList#remove(int)
	 */
	public E remove(int index)
    {

		//  Hier sind Sie gefragt!
    	
    }
		
	/**
	 * Rückgabe des an der Position index gespeicherten Elements
	 *
	 * @see de.profmeyer.java.datastructures.SimpleList#get(int)
	 */
	public E get(int index)
	{
		rangeCheck(0, index, this.size-1);
		return this.data[index];
	}

	/**
	 * Bestimmung des Index des ersten Elements der Liste, das zu element 
	 * inhaltsgleich ist
	 *
	 * @see de.profmeyer.java.datastructures.SimpleList#indexOf(java.lang.Object)
	 */
	public int indexOf(E element)
	{
		//Hier fehlt noch etwas
	}	
	
	
	/**
	 * Innere Klasse für einen Iterator zum sequentiellen Durchlauf 
	 * durch die Liste
	 * 
	 * @author Manfred Meyer
	 *
	 */
	class SimpleArrayListIterator
	implements SimpleIterator<E>
	{
		/**
		 * aktuelle Position des Iterators
		 */
		int pos;	
		
		/**
		 * Konstruktor mit Anfangsposition vor dem 1. Element 
		 */
		SimpleArrayListIterator()
		{
			pos = -1;
		}
		
		/** 
		 * Überprüfung, ob der Iterator noch ein weiteres Element
		 * besuchen kann
		 * 
		 * @see de.profmeyer.java.datastructures.SimpleIterator#hasNext()
		 */
		public boolean hasNext()
		{
			return pos<size-1;
		}
		
		/**
		 * Schritt zum nächsten Element und Rückgabe des aktuellen
		 * Elements als Ergebnis 
		 * 
		 * @see de.profmeyer.java.datastructures.SimpleIterator#next()
		 */
		public E next()
		{
			pos++;
			if (pos<size)
				return data[pos];
			else	
			    return null;
		}
		
		/**
		 * Das zuletzt mit next() gelieferte Element wird gelöscht
		 * 
		 * @see SimpleIterator#remove()
		 */
		public void remove()
		{
			shiftLeft(pos);
			// Anzahl der Elemente reduzieren
			size--;	
			// Pürfen, ob Feld verkleinert werden kann
			shrinkCapacity();
		}
	}
	
	class ExtendedSimpleArrayListIterator
	implements SimpleListIterator<E>
	{
		/**
		 * aktuelle Position des Iterators
		 */
		int pos;	
		
		/**
		 * Konstruktor mit Anfangsposition vor dem 1. Element 
		 */
		ExtendedSimpleArrayListIterator()
		{
			this.pos = -1;
		}

		/**
		 * Konstruktor mit beliebiger Anfangsposition 
		 */
		ExtendedSimpleArrayListIterator(int pos)
		{
			this.pos = pos;
		}
		
		/** 
		 * Überprüfung, ob der Iterator noch ein weiteres Element
		 * rückwärts besuchen kann
		 * 
		 * @see de.profmeyer.java.datastructures.SimpleListIterator#hasPrevious()
		 */
		public boolean hasPrevious()
		{
			return pos>0;
		}
		
		/**
		 * Schritt zum letzten Element und Rückgabe des aktuellen
		 * Elements als Ergebnis 
		 * 
		 * @see de.profmeyer.java.datastructures.SimpleListIterator#previous()
		 */
		public E previous()
		{
			pos--;
			if (pos>=0)
				return data[pos];
			else	
			    return null;
		}
		
		/** 
		 * Überprüfung, ob der Iterator noch ein weiteres Element
		 * besuchen kann
		 * 
		 * @see de.profmeyer.java.datastructures.SimpleIterator#hasNext()
		 */
		public boolean hasNext()
		{
			return pos<size-1;
		}
		
		/**
		 * Schritt zum nächsten Element und Rückgabe des aktuellen
		 * Elements als Ergebnis 
		 * 
		 * @see de.profmeyer.java.datastructures.SimpleIterator#next()
		 */
		public E next()
		{
			pos++;
			if (pos<size)
				return data[pos];
			else	
			    return null;
		}
		
		/**
		 * Das zuletzt mit next() gelieferte Element wird gelöscht
		 * 
		 * @see de.profmeyer.java.datastructures.SimpleIterator#remove()
		 */
		public void remove()
		{
			shiftLeft(pos);
			// Anzahl der Elemente reduzieren
			size--;	
			// Pürfen, ob Feld verkleinert werden kann
			shrinkCapacity();
		}
		
		/**
		 * Das zuletzt mit next() gelieferte Element wird ersetzt
		 * 
		 * @see de.profmeyer.java.datastructures.SimpleListIterator#set()
		 */
		public void set(E o)
		{
			data[pos] = o;
		}
		
		/**
		 * Nach dem zuletzt mit next() gelieferten Element wird ein
		 * neues Element eingefügt
		 * 
		 * @see de.profmeyer.java.datastructures.SimpleListIterator#add()
		 */
		public void add(E o)
		{
			if (o!=null)
			{
				// Ausreichende Größe des Feldes sicherstellen		
				ensureCapacity(size+1);
				// Elemente ab der Position pos um 1 nach rechts schieben
				shiftRight(pos);		
				// Neues Element an der Position pos speichern
				data[pos] = o;
				size++;
			}
		}
	}
}
