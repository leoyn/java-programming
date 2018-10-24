package chapter2;
import java.util.Scanner;

public class Task11 {
	
	final static int BASIC_INCOME = 100_000;
	final static int SECRETARY_WAGE = 200;
	final static int SPEECH_WAGE = 500;
	final static int SPEECH_WAGE_BONUS_AFTER_5TH_SPEACH = 200;
	final static int SPEECH_BONUS_THRESHOLD = 5;
	
	public static void main(String[] args) {
		Scanner ioScanner = new Scanner(System.in);
		
		// Read speech amount
		System.out.print("Anzahl der Reden: ");
		int speechCounter = ioScanner.nextInt();
		
		// Read secretary work hours
		System.out.print("Sekretariatsarbeitsstunden: ");
		int secretaryWork = ioScanner.nextInt();
		
		// bonus after 5th speech
		int extraSpeechMoney = 0;
		
		// add bonus after 5th speech
		if(speechCounter > SPEECH_BONUS_THRESHOLD) extraSpeechMoney = (speechCounter - SPEECH_BONUS_THRESHOLD) * SPEECH_WAGE_BONUS_AFTER_5TH_SPEACH;
		
		// Sum up all values
		int incomePerPerson = BASIC_INCOME + secretaryWork * SECRETARY_WAGE + speechCounter * SPEECH_WAGE + extraSpeechMoney;
	
		// Print total
		System.out.println("Das Einkommen von Herrn und Frau Clever beträgt: " + incomePerPerson * 2);
	}
}
