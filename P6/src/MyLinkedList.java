
/**
 * Implementierung der Schnittstelle SimpleList<E> durch eine
 * einfach verkettete Liste.
 *
 * Die gespeicherten Objektreferenzen dürfen im Gegensatz zur 
 * Klasse java.util.LinkedList in der Java-Klassenbibliothek 
 * nicht gleich null sein.
 *
 * Die einfach verkettete Liste enthält immer ein zusätzliches
 * Element am Anfang der Liste, in dem kein Objekt gespeichert 
 * ist. 
 * Dadurch können bei einigen Operationen Fallunterscheidungen
 * für die leere Liste vermieden werden.
 */
public class MyLinkedList<E>
implements SimpleList<E>
{
	/** 
	 * Innere Klasse für die einzelnen Elemente der einfach
	 * verketteten Liste
	 */
	class Entry 
	{
		// Attribute 
		E data;			// Verweis auf gespeichertes Objekt
		Entry next;		// Verweis auf Nachfolger in der Liste
		
		// Konstruktor
		Entry(E o, Entry next)
		{
	    	this.data = o;
	    	this.next = next;
	    }
    }

	// Attribute (Klasse MyLinkedList)
	protected Entry head;  // Anfang der einfach verketteten Liste
	protected Entry tail;  // Ende der einfach verketteten Liste
	protected int size;    // Anzahl der Elemente in der Liste
	
	/**
	 * Erzeugung einer leeren Liste (Konstruktor)
	 * 
	 */
	public MyLinkedList()
	{
		this.head = new Entry(null, null);
		this.tail = this.head;
		this.size = 0;
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
	 * Einfügen eines neuen Elements nach dem Element prev
	 * 
	 * @param o
	 * @param prev
	 */
	private void addAfter(E o, Entry prev) 
	{
		Entry e = new Entry(o, prev.next);
		prev.next = e;
		if (prev==this.tail)
			this.tail = e; // Listenende korrigieren
		this.size++;
    }
    
    /**
     * Entfernen des Elements nach dem Element prev
     * 
     *  @param prev	Entry-Objekt, hinter dem gelöscht werden soll
     */
    private E removeAfter(Entry prev)
    {
    	Entry e = prev.next;
    	E result = e.data;
    	
        prev.next = e.next;
        if (e==this.tail)
        	this.tail = prev; // Listenende korrigieren
        this.size--;
        
        return result;
    }

	/**
	 * Bestimmung des Elements zu einem vorgegebenen Index
	 */
    private Entry entry(int index) 
    {
		Entry e = this.head;

		for (int i=0; i<=index; i++)
			e = e.next;

        return e;
    }

	/**
	 * Überprüfung, ob die Liste leer ist
	 */	 
	public boolean isEmpty()
	{
		return this.size == 0;
	}
	
	/**
	 * Bestimmung der Anzahl der Elemente in der Liste
	 */
	public int size()
	{
		return this.size;
	}
	
	/**
	 * Einfügen eines Elements am Ende der Liste
	 */
	public boolean add(E o)
	{
		boolean result;
		
		if (o!=null)
		{
			addAfter(o, this.tail);
			result = true;
		}
		else
			result = false;
			
		return result;
	}

	/**
	 * Entfernen des ersten Elements der Liste, dessen gespeichertes
	 * Objekt zu o inhaltsgleich ist
	 */	
	public boolean remove(E o) 
	{
		boolean result = false;
		
        if (o!=null) 
        {
        	// Suche nach Element mit inhaltsgleichem Objekt
        	Entry e    = this.head.next;
        	Entry prev = this.head;
        	boolean found = false;
        	while (e!=null && !found)
        	{
        		if (o.equals(e.data))
        			found = true;
        		else
        		{
        			prev = e;
        			e = e.next;
        		}
        	}
        	
        	if (found)
        	{
        		removeAfter(prev);
        		result = true;
        	}
        }
        			
        return result;
    }

	/**
	 * Übrprüfung, ob ein zu o inhaltsleiches Objekt in der
	 * Liste gespeichert ist
	 */
	public boolean contains(E o)
	{
		return indexOf(o)>=0;
	}
	
	/**
	 * Erzeugung eines Iterators zum sequentiellen Durchlauf durch
	 * die Liste
	 */
	public SimpleIterator<E> iterator()
	{
		return new SimpleLinkedListIterator();
	}

    /**
     * Einfügen eines Elements an der Position index
     */
	public void add(int index, E o)
	{
		if (o!=null)
		{
			rangeCheck(0, index, this.size);
		
			Entry prev = entry(index-1);
			addAfter(o, prev);
			
		}
	}
	
    /**
     * Entfernen des Elements an der Position index und Rückgabe 
     * des entfernten Elements
     *
     * @see SimpleList#remove(int)
     *
     * @param index Position, an der gelöscht werden soll
     */ 
    public E remove(int index)
    {
    	Entry e = entry(index-1);
    	E result=this.removeAfter(e);
    	return result;
    }
    
	/**
	 * Rückgabe des an der Position index gespeicherten Objekts
	 * als Ergebnis
	 */ 
	public E get(int index)
	{
		rangeCheck(0, index, this.size-1);
		
		Entry e = entry(index);
		return e.data;
	}
	
    /**
     * Bestimmung des Index des ersten Elements der Liste, 
     * dessen gespeichertes Objekt zu o inhaltsgleich ist
     * oder -1, falls kein solches Element vorhanden
     * 
     * @param o gesuchtes Element
     */     
    public int indexOf(E o)
    {	
    	
    	
    	

		//  Hier sind Sie gefragt!
    	
    }
	
	
	// Innere Klasse für einen Iterator zum sequentiellen Durchlauf
	// durch die Liste
	class SimpleLinkedListIterator
	implements SimpleIterator<E>
	{
		// Attribut
		Entry e;	// Element an der aktuellen Position des Iterators
		
		// Konstruktor
		SimpleLinkedListIterator()
		{
			e = head;
		}
		
		// Operationen

		// Überprüfung, ob der Iterator noch ein weiteres Element
		// besuchen kann
		public boolean hasNext()
		{
			return e.next != null;
		}
		
		// Schritt zum nächsten Element und Rückgabe des gespeicherten
		// Objekts als Ergebnis
		public E next()
		{
			E result = null;
			
			if (e.next != null)
			{
				e = e.next;
				result = e.data;
			}
				
			return result;
		}
		
		// Entfernen des zuletzt zurückgelieferten Elements aus der
		// Liste
		public void remove()
		{
			Entry prev = head;
			while (prev.next != e)
				prev = prev.next;
			removeAfter(prev);
		}
	}
}
