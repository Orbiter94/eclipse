
public class Aufgabe13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void heapSortDescending(int[] zahlen){
		
		//in heap form bringen
		
		
		
	}
	
	private static int[] heapForm(int[] zahlen){
		
		for(int i = 1 ; i<(zahlen.length/2); i++){ 			//index der Zahl die auf Heap form geprüft wird
			
			int j = 2*i;			//index der zur Prüfung zugehörigen Zahl
			
			while(zahlen[i] < zahlen [j] || zahlen[i] < zahlen[j+1]){
			
				if(zahlen[i]<zahlen[j]){
					
					int temp = zahlen[i];
					zahlen[i]=zahlen[j];
					zahlen[j]=temp;
					
				}
				
				if(zahlen[i]<zahlen[j+1]){
					int temp = zahlen[i];
					zahlen[i]= zahlen[j];
					zahlen[j]= temp;
				}
			}
		}
		
		
		return zahlen;
		
	}

	
}
