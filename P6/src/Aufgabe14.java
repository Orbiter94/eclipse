public class Aufgabe14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyLinkedList<String> mll = new MyLinkedList<String>();
		
		mll.add("Dies");
		mll.add("ist");
		mll.add("eine");
		mll.add("schöne");
		mll.add("Aufgabe");
		mll.add("zum");
		mll.add("warm");
		mll.add("werden");
		
		String zk = String.join(" ",mll.get(0),mll.get(1),mll.get(2),mll.get(3),mll.get(4),mll.get(5),mll.get(6),mll.get(7));
	
		System.out.println(zk);
		
		
		
	}
	
}
