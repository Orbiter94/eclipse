// Vereinfachte Form einer Schnittstelle (engl. interface)
// f�r einen Iterator zum sequentiellen Zugriff auf die 
// Elemente einer SimpleCollection
//
// Die Schnittstelle legt fest, welche Operationen ein
// Iterator, d.h. eine Klasse, welche die Eigenschaften
// eines Iterators besitzen soll, zur Verf�gung stellen muss.
//
// Gegen�ber der Schnittstelle Iterator.java in der Java-
// Klassenbibliothek ist die Operation remove entfallen.

public interface SimpleListIterator<E> extends SimpleIterator<E>
{
	public boolean hasPrevious();
	
	public E previous();
	
	public void set(E o);
	
	public void add(E o);	
}