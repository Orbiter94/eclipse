import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Aufgabe10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ifd = new int[]{4,2,3,1};
		
		selectionSort_rekursiv(ifd);
		selectionSort_it(ifd);
	}
	
	
	static void selectionSort_rekursiv(int[] zahlen){
		selectionSort_rec(zahlen, 0);
		
	}

	static void selectionSort_rec(int [] zahlen, int startindex){
		
		int minindex=startindex;
		if(startindex>=zahlen.length-1){
			//Daniels Remix 
			//System.out.println(Arrays.stream(zahlen).boxed().parallel().map(x -> String.valueOf(x)).collect(Collectors.joining(", ")));
			for(int i = 0; i <zahlen.length;i++){
				System.out.println(zahlen[i]);
				}
		} else {
		
		for(int index= startindex +1;index < zahlen.length; index++ ){
			if(zahlen[index]<zahlen[minindex]){
				minindex=index;
			}
		}
		
		int temp= zahlen[minindex];
		zahlen[minindex]= zahlen[startindex];
		zahlen[startindex]= temp;
		
		selectionSort_rec(zahlen, startindex+1);
		}
		}
	
	static void selectionSort_it(int [] zahlen){
		int min= 0;
		for(int x = 0; x < zahlen.length-1;x++){
			min = x;
			for(int i = x ; i < zahlen.length; i++){
				if(zahlen[i] < zahlen[min]){
					min = i;
				}
			}
			//swap
			int temp= zahlen[x];
			zahlen[x]= zahlen[min];
			zahlen[min]= temp;
		}
		
		System.out.println(Arrays.stream(zahlen).boxed().parallel().map(x -> String.valueOf(x)).collect(Collectors.joining(", ")));
		
		
	}
	
}
