import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*****************************************************************************
 * main-Klasse, hier werden die Funktionalit�ten der Klasse MyArrayQueue
 * systematisch getestet.
 *****************************************************************************/

public class ChallengeFolgewoche2 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
					
		// Variablendeklaration
		int successInsert;		//Anzahl der erfolgreich durchgef�hrten Einf�gungen
		int successRemove;		//Anzahl der erfolgreich durchgef�hren L�schungen
		int newStart = 100;		//Startwert f�r die Einf�geelemente
		Object suchwert = null;	//Variable f�r die Suche in der Queue
		int durchlauf = 0; 		//Variable f�r die Anzahl der Such- bzw. L�sch- und Einf�gezyklen
		int ergebnis=0;
		
		//Programmfunktionen		
		/*
		 * L�nge der Queue (von 5 bis 25) soll �ber die Konsole eingegeben werden
		 */		
		int length = wert("Bitte geben Sie die L�nge der Queue als Zahl von 5 bis 25 ein:",5,25);
		MyArrayQueue arrayQueue = new MyArrayQueue (length);
				
		/*
		 * Durchf�hrung erster Tests: 
		 * - �berpr�fung der Funktionen is Empty, isFull, getSize mit einer leeren Queue
		 * - �berpr�fung der Funktionen get VirtualHead, get VirtualTail mit einer leeren Queue
		 * - vollst�ndig Bef�llen
		 * - Versuch die Queue zu �berf�llen - muss scheitern
		 * - einen Wert entnehmen
		 * - Versuch ein "null" - Element einzuf�gen - muss scheitern
		 * - Queue wieder komplett f�llen
		 * - Virtuellen Kopf der Queue ausgeben
		 */		
		System.out.println(	"Starte die ersten Tests.....\n"
						+ 	"==========================================");
		
		System.out.println("Ist die Queue leer?");
		if (arrayQueue.isEmpty())
			{
				System.out.println("JA");
			}
		else
			{
				System.out.println("NEIN");
			}
		
		System.out.println("Ist die Queue voll?");
		if (arrayQueue.isFull())
			{
				System.out.println("JA");
			}
		else
			{
				System.out.println("NEIN");
			}
		
		System.out.println("Anzahl der Elemente in der Queue: " + arrayQueue.getSize());
		
		System.out.println("Virtueller Kopf der Queue: " + arrayQueue.getVirtualHead());
		System.out.println("Virtuelles Ende der Queue: " + arrayQueue.getVirtualTail());
		
		System.out.println("\nQueue komplett f�llen!");
		
		successInsert = insertValue (arrayQueue, newStart, newStart+length-1);
		System.out.println(successInsert + " Element(e) erfolgreich eingef�gt!");
		newStart += successInsert;
		
		arrayQueue.printHeadAndTail();	// Head und Tail der Queue zu Kontrollzwecken ausgeben
		
		System.out.println("Versuche noch einen weiteren Wert einzuf�gen!");
		insertValue (arrayQueue, newStart, newStart);
		
		System.out.println("Ich entferne den Queuekopf, also die \""  + arrayQueue.getHeadAndRemove() + "\"!");
		arrayQueue.printQueue();
		
		arrayQueue.printHeadAndTail();	// Head und Tail der Queue zu Kontrollzwecken ausgeben
		
		System.out.println("Versuche einen Wert ohne Inhalt, also \"null\" einzuf�gen!");
		arrayQueue.enqueue(null);
		
		System.out.println("Versuche wieder einen Wert einzuf�gen!");
		newStart += insertValue (arrayQueue, newStart, newStart);
		
		arrayQueue.printHeadAndTail();	// Head und Tail der Queue zu Kontrollzwecken ausgeben
		
		System.out.println("Ich entferne das Queueende, also die \""  + arrayQueue.getTailAndRemove() + "\"!");
		arrayQueue.printQueue();
		
		arrayQueue.printHeadAndTail();	// Head und Tail der Queue zu Kontrollzwecken ausgeben
		
		System.out.println("Versuche wieder einen Wert einzuf�gen!");
		newStart += insertValue (arrayQueue, newStart, newStart);
		
		arrayQueue.printHeadAndTail();	// Head und Tail der Queue zu Kontrollzwecken ausgeben
		
		/* 
		 * Einmaliger Test der Suche nach einem "Null" - Element
		 */
		System.out.println("Teste die Suche nach einem \"Null\" - Element:");
		ergebnis = arrayQueue.search(suchwert);
		if (ergebnis == Integer.MAX_VALUE)
			System.out.println("Ergebnis: Das Suchelelement ist \"Null\"!\n");
		
		/*
		 * Mehrfacher Test der Suche nach Elementen in der Queue
		 * Anzahl der Suchzyklen (von 1 bis 5) soll �ber die Konsole eingegeben werden
		 */	
		durchlauf = wert("Wieviele Suchen in der Queue mit zuf�llig bestimmten Werten sollen nun durchlaufen werden?\n"
				+ "Bitte geben Sie eine Zahl von 2 bis 5 ein!", 2, 5);		
		
		// Ein zuf�lliger Suchwert in Abh�ngigkeit von der L�nge der Queue wird ermittelt
		// und anschlie�end gesucht
		
		for (int d = 1; d <= durchlauf; d++)
		{			
			suchwert = (int) (Math.random()*(2*length)+100);		
			System.out.println("Suche den Wert " + suchwert + ":");
			
			ergebnis = arrayQueue.search(suchwert);
			
			if (ergebnis == -1)
				System.out.println("Das Element " + suchwert + " ist nicht in der Queue enthalten!");
			else
				System.out.println("Das Element " + suchwert + " ist in der Queue enthalten, der Abstand zum Queuekopf betr�gt " + ergebnis + " Position(en)!");
		}
		
		/*
		 * Anzahl der L�sch- und Einf�gezyklen (von 5 bis 15) soll �ber die Konsole eingegeben werden
		 */	
		durchlauf = wert("\nWieviele L�sch- und Einf�gezyklen sollen nun durchlaufen werden?\n"
				+ "Bitte geben Sie eine Zahl von 5 bis 15 ein!", 5, 15);
		
		for (int d = 1; d <= durchlauf; d++)
		{
			int a = arrayQueue.getSize();
			int b = (int) (Math.random()*a);
			int anzahl = a - b;
			
			System.out.println((anzahl) + " Element(e) entfernen!");
			successRemove = removeValue (arrayQueue, anzahl);
			System.out.println(successRemove + " Element(e) erfolgreich entfernt!");
			
			arrayQueue.printHeadAndTail();
		
			System.out.println((anzahl) + " Element(e) wieder einf�gen!");
			successInsert = insertValue (arrayQueue, newStart, (newStart + (anzahl)-1));
			System.out.println(successInsert + " Element(e) erfolgreich eingef�gt!");
			
			arrayQueue.printHeadAndTail();
			
			newStart += successInsert;
		}
		
		System.out.println("Queue komplett leeren!");
		successRemove = removeValue (arrayQueue, arrayQueue.getSize());
		System.out.println(successRemove + " Element(e) erfolgreich entfernt!\n");
		
		System.out.println("Versuche noch einen weiteren Wert zu entfernen!");
		removeValue (arrayQueue, 1);
		
		arrayQueue.printHeadAndTail();
	}
		
	 /**
	  * Funktion zum Bef�llen der Queue mit Zahlen ausgehend von einem Startwert
	  * bis zu einem Endwert
	  * Am Ende wird die Queue sortiert ausgegeben
	  * Hilfsfunktion f�r den Test und die Kontrolle der Queue
	  * @param	arrayQueue	Queue, die bef�llt werden soll
	  * @param	start		Erster Wert, der eingef�gt werden soll
	  * @param	end			Letzter Wert, der eingef�gt werden soll 
	  * @return Anzahl der erfolgreich in die Queue eingef�gten Objekte
	  */	
	public static int insertValue (MyArrayQueue arrayQueue, int start, int end)
	{
		int success=0;
		for (int i = start; i <= end; i ++)
		{
			System.out.println("Ich m�chte die \"" + i + "\" hinzuf�gen!");
			if(arrayQueue.enqueue(i))
			{
				success++;
			}
			else
				break;
		}
		arrayQueue.printQueue();
		return success;
	}
	
	/**
	  * Funktion zum Enfernen einer bestimmten Anzahl von Elementen aus der Queue
	  * Am Ende wird die Queue sortiert ausgegeben
	  * Hilfsfunktion f�r den Test und die Kontrolle der Queue
	  * @param	arrayQueue	Queue aus der Elemente entfernt werden sollen
	  * @param	anzahl		Anzahl der zu entfernenden Elemente
	  * @return Anzahl der erfolgreich aus der Queue entfernten Objekte
	  */
	public static int removeValue (MyArrayQueue arrayQueue, int anzahl)
	{
		int success=0;
		for (int r = 0; r < anzahl; r ++)
		{
			if (arrayQueue.getSize()==0)
				System.out.println("Wert anzeigen und L�schen nicht m�glich, es befinden sich keine Werte in der Queue!\n");
			else
			{
				System.out.println("Ich entferne die \""  + arrayQueue.getHeadAndRemove() + "\"!");
				success++;
			}
		}
		arrayQueue.printQueue();
		return success;
	}
	
	/**
	  * Funktion zur Eingabe eines Zahlenwertes, der zwischen einer Untergrenze und
	  * einer Obergrenze liegt 
	  * Hilfsfunktion f�r den Test und die Kontrolle der Queue
	  * @param	text			Text zur Information des Benutzers
	  * @param	untergrenze		Kleinster Wert, der eingegeben werden darf
	  * @param	obergrenze		Gr��ter Wert, der eingegeben werden darf
	  * @return Eingegebener Wert
	  */
	static int wert (String text, int untergrenze, int obergrenze)
	{
		int eing;			
		do
		{
		System.out.println(text);
		eing = read_int();
		}
		while (eing < untergrenze || eing > obergrenze);
		return eing;
	}
	
	/**
	  * Funktion zum Einlesen eines Zahlenwertes von der Tastatur
	  * �bernommen aus der BasicIO 
	  * @return Eingelesener Zahlenwert
	  */
	static int read_int()
	{
		try 
		{
			BufferedReader din = new BufferedReader( 
					new InputStreamReader(System.in));
			return Integer.parseInt(din.readLine());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Falscheingabe! Bitte nochmal eingeben: ");
			return read_int();
		}
		catch (IOException e)
		{
			return -1;
		}
	}
}
