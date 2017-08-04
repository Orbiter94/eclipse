public class Aufgabe14
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		MyLinkedList warmwerden = new MyLinkedList();
		
		warmwerden.add("Dies ");
		warmwerden.add("ist ");
		warmwerden.add("eine ");
		warmwerden.add("schöne ");
		warmwerden.add("Aufgabe ");
		warmwerden.add("zum ");
		warmwerden.add("warmwerden!");
		
		for (int zugriff=0; zugriff < warmwerden.size(); zugriff ++ )
		{
			System.out.println ("Der " + (zugriff+1) + ". Wert in der Liste ist: " + warmwerden.get(zugriff));
		}
	}

}
