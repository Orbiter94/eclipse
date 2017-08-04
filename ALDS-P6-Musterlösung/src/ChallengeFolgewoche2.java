import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*****************************************************************************
 * main-Klasse, hier werden die Funktionalitäten der Klasse MyArrayQueue
 * systematisch getestet.
 *****************************************************************************/

public class ChallengeFolgewoche2 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
					
		// Variablendeklaration
		int successInsert;		//Anzahl der erfolgreich durchgeführten Einfügungen
		int successRemove;		//Anzahl der erfolgreich durchgeführen Löschungen
		int newStart = 100;		//Startwert für die Einfügeelemente
		Object suchwert = null;	//Variable für die Suche in der Queue
		int durchlauf = 0; 		//Variable für die Anzahl der Such- bzw. Lösch- und Einfügezyklen
		int ergebnis=0;
		
		//Programmfunktionen		
		/*
		 * Länge der Queue (von 5 bis 25) soll über die Konsole eingegeben werden
		 */		
		int length = wert("Bitte geben Sie die Länge der Queue als Zahl von 5 bis 25 ein:",5,25);
		MyArrayQueue arrayQueue = new MyArrayQueue (length);
				
		/*
		 * Durchführung erster Tests: 
		 * - Überprüfung der Funktionen is Empty, isFull, getSize mit einer leeren Queue
		 * - Überprüfung der Funktionen get VirtualHead, get VirtualTail mit einer leeren Queue
		 * - vollständig Befüllen
		 * - Versuch die Queue zu überfüllen - muss scheitern
		 * - einen Wert entnehmen
		 * - Versuch ein "null" - Element einzufügen - muss scheitern
		 * - Queue wieder komplett füllen
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
		
		System.out.println("\nQueue komplett füllen!");
		
		successInsert = insertValue (arrayQueue, newStart, newStart+length-1);
		System.out.println(successInsert + " Element(e) erfolgreich eingefügt!");
		newStart += successInsert;
		
		arrayQueue.printHeadAndTail();	// Head und Tail der Queue zu Kontrollzwecken ausgeben
		
		System.out.println("Versuche noch einen weiteren Wert einzufügen!");
		insertValue (arrayQueue, newStart, newStart);
		
		System.out.println("Ich entferne den Queuekopf, also die \""  + arrayQueue.getHeadAndRemove() + "\"!");
		arrayQueue.printQueue();
		
		arrayQueue.printHeadAndTail();	// Head und Tail der Queue zu Kontrollzwecken ausgeben
		
		System.out.println("Versuche einen Wert ohne Inhalt, also \"null\" einzufügen!");
		arrayQueue.enqueue(null);
		
		System.out.println("Versuche wieder einen Wert einzufügen!");
		newStart += insertValue (arrayQueue, newStart, newStart);
		
		arrayQueue.printHeadAndTail();	// Head und Tail der Queue zu Kontrollzwecken ausgeben
		
		System.out.println("Ich entferne das Queueende, also die \""  + arrayQueue.getTailAndRemove() + "\"!");
		arrayQueue.printQueue();
		
		arrayQueue.printHeadAndTail();	// Head und Tail der Queue zu Kontrollzwecken ausgeben
		
		System.out.println("Versuche wieder einen Wert einzufügen!");
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
		 * Anzahl der Suchzyklen (von 1 bis 5) soll über die Konsole eingegeben werden
		 */	
		durchlauf = wert("Wieviele Suchen in der Queue mit zufällig bestimmten Werten sollen nun durchlaufen werden?\n"
				+ "Bitte geben Sie eine Zahl von 2 bis 5 ein!", 2, 5);		
		
		// Ein zufälliger Suchwert in Abhängigkeit von der Länge der Queue wird ermittelt
		// und anschließend gesucht
		
		for (int d = 1; d <= durchlauf; d++)
		{			
			suchwert = (int) (Math.random()*(2*length)+100);		
			System.out.println("Suche den Wert " + suchwert + ":");
			
			ergebnis = arrayQueue.search(suchwert);
			
			if (ergebnis == -1)
				System.out.println("Das Element " + suchwert + " ist nicht in der Queue enthalten!");
			else
				System.out.println("Das Element " + suchwert + " ist in der Queue enthalten, der Abstand zum Queuekopf beträgt " + ergebnis + " Position(en)!");
		}
		
		/*
		 * Anzahl der Lösch- und Einfügezyklen (von 5 bis 15) soll über die Konsole eingegeben werden
		 */	
		durchlauf = wert("\nWieviele Lösch- und Einfügezyklen sollen nun durchlaufen werden?\n"
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
		
			System.out.println((anzahl) + " Element(e) wieder einfügen!");
			successInsert = insertValue (arrayQueue, newStart, (newStart + (anzahl)-1));
			System.out.println(successInsert + " Element(e) erfolgreich eingefügt!");
			
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
	  * Funktion zum Befüllen der Queue mit Zahlen ausgehend von einem Startwert
	  * bis zu einem Endwert
	  * Am Ende wird die Queue sortiert ausgegeben
	  * Hilfsfunktion für den Test und die Kontrolle der Queue
	  * @param	arrayQueue	Queue, die befüllt werden soll
	  * @param	start		Erster Wert, der eingefügt werden soll
	  * @param	end			Letzter Wert, der eingefügt werden soll 
	  * @return Anzahl der erfolgreich in die Queue eingefügten Objekte
	  */	
	public static int insertValue (MyArrayQueue arrayQueue, int start, int end)
	{
		int success=0;
		for (int i = start; i <= end; i ++)
		{
			System.out.println("Ich möchte die \"" + i + "\" hinzufügen!");
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
	  * Hilfsfunktion für den Test und die Kontrolle der Queue
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
				System.out.println("Wert anzeigen und Löschen nicht möglich, es befinden sich keine Werte in der Queue!\n");
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
	  * Hilfsfunktion für den Test und die Kontrolle der Queue
	  * @param	text			Text zur Information des Benutzers
	  * @param	untergrenze		Kleinster Wert, der eingegeben werden darf
	  * @param	obergrenze		Größter Wert, der eingegeben werden darf
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
	  * Übernommen aus der BasicIO 
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
