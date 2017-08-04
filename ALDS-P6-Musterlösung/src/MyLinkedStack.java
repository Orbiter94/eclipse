
public class MyLinkedStack
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
	int size;
	
	public MyLinkedStack()
	{
		this.head=null;
		this.size=0;
	}
	
	public boolean empty()
	{
		return this.size == 0;  //liefert true wenn size=0 und false wenn size !=0
	}
	
	public boolean push (Object o)
	{
		boolean result;
		
		if (o!=null)
		{
			add (o);
			result = true;
		}
		else
			result = false;
			
		return result;
	}
	
	public void add (Object o)
	{
		Entry neuesElement = new Entry();
		neuesElement.next=this.head;
		neuesElement.data=o;
		this.head=neuesElement;
		this.size++;
	}
	
	public Object pop ()
	{
		Object oberstesElement;
		
		if (this.size!=0)
		{
			oberstesElement = this.getHead().data;
			remove (this.getHead());
		}
		else
			oberstesElement=null;
			
		return oberstesElement;
	}
	
	public void remove (Object o)
	{
		this.head=this.head.next;
		this.size--;		
	}
	
	public Object peek ()
	{
		Object oberstesElement;
		
		if (this.size!=0)
		{
			oberstesElement = this.getHead().data;
		}
		else
			oberstesElement=null;
			
		return oberstesElement;
	}
	
	public int search (Object o)
	{	
		int position = 0;
		int abstand=-1;
		boolean found=false;
		
		if (o!=null)
		{
			Entry vergleichsElement = this.head;
			Entry folgeElement 		= this.head.next;
			//System.out.println("Suchelement\tVergleichselement\tFolgeelement");
        	
			while (folgeElement!=null && !found)	        	
        	{	
        		position++;
        		        		        		
        		if (vergleichsElement.data.equals(o))
        		{
        			found = true;
        			abstand+=position;
        		}        		
        		else
        		{
        			vergleichsElement	= folgeElement;
        			folgeElement	 	= folgeElement.next;
        		} 
          	}
        	
        	if (!found)
        	{
        		if (vergleichsElement.data.equals(o))
        		{        		
        			return position;  
        		}
        	}
        }
		return abstand;
	}
	

	public Entry getHead() {
		return head;
	}

	public void setHead(Entry head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
