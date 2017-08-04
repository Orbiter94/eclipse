
public class MyLinkedQueue
{
	class Entry
	{
		Entry next;
		Object data;
		
		private Entry()
		{
			this.next=null;
			this.data=null;
		}
	}
	
	Entry head;
	Entry tail;
	int size;
	
	public MyLinkedQueue()
	{
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	
	public boolean empty()
	{
		return this.size == 0;  
	}
	
	public boolean enqueue (Object neuesElement)
	{
		if (neuesElement!=null)
		{
			addEndOfQueue(neuesElement);
			return true;
		}
		else
			return false;
	}
	
	private void addEndOfQueue(Object einfügen) 
	{
		Entry neuesElement = new Entry();
		
		neuesElement.data=einfügen;
		
		if (this.size > 0)
			this.tail.next = neuesElement;
		
		if (this.head == null)
			this.head = neuesElement;	
		
		this.tail = neuesElement; 
		
		this.size++;
    }
	
	 public void kompletteQueueAusgeben()
	    {
	        if (this.head == null)
	        {
	            System.out.println("Noch keine Personen in der Warteschlange!\n");
	        }
	        else
	        {	            
	            Entry aktuellerWert = this.head;
	            System.out.println("\nIn der Schlange stehen jetzt folgende Personen:");
	            
	            while (aktuellerWert != null)
	            {
	                System.out.print(aktuellerWert.data + "\t");
	                aktuellerWert = aktuellerWert.next;
	            }
	            System.out.println("\n");
	        }
	    }
	 
	 public Object dequeue()
	 {
		 Object ersterWert;
		 
		 if (this.size == 0)
			 return null;
		 else
		 {
			 ersterWert = head.data;
			 remove (head);
		 }
			 return ersterWert;
	 }
	 
	private void remove (Entry entfernen)
	{
		this.head = entfernen.next;
	}
	
	public Object first()
	{		 
		if (this.size == 0)
			return null;
		else
			return this.head.data;
	}
	
	public int search(Object o)
	{
		int position=-1;
		
		if (o == null)
			return position;
		else
        {	            
            Entry vergleichsWert = this.head;
                        
            while (vergleichsWert != null)
            {
            	position++;
                if (vergleichsWert.data.equals(o))
                {
                	return position;
                }                	
                vergleichsWert = vergleichsWert.next;
            }
        }		
		return -1;
	}

	public Entry getHead() {
		return head;
	}

	public void setHead(Entry head) {
		this.head = head;
	}

	public Entry getTail() {
		return tail;
	}

	public void setTail(Entry tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
	
	