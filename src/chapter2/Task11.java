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
		
		System.out.println("Frau Clever:");
		
		// Read speech amount
		System.out.print("Anzahl der Reden: ");
		int speechCounterF = ioScanner.nextInt();
		
		// Read secretary work hours
		System.out.print("Sekretariatsarbeitsstunden: ");
		int secretaryWorkF = ioScanner.nextInt();
		
		System.out.println("––––––––––––––––––––––");
		System.out.println("Herr Clever:");
		
		System.out.print("Anzahl der Reden: ");
		int speechCounterM = ioScanner.nextInt();
		
		// Read secretary work hours
		System.out.print("Sekretariatsarbeitsstunden: ");
		int secretaryWorkM = ioScanner.nextInt();
		
		System.out.println("––––––––––––––––––––––");
		
		int sum = calculateIncomeForPerson(speechCounterF, secretaryWorkF) + calculateIncomeForPerson(speechCounterM, secretaryWorkM);
		System.out.println("Das Einkommen von Herrn und Frau Clever beträgt: " + sum);
		
		ioScanner.close();
	}
	
	public static int calculateIncomeForPerson(int speechCounter, int secretaryWork) {
		// bonus after 5th speech
		int extraSpeechMoney = 0;
				
		// add bonus after 5th speech
		if(speechCounter > SPEECH_BONUS_THRESHOLD) extraSpeechMoney = (speechCounter - SPEECH_BONUS_THRESHOLD) * SPEECH_WAGE_BONUS_AFTER_5TH_SPEACH;
				
		// Sum up all values
		int incomePerPerson = BASIC_INCOME + secretaryWork * SECRETARY_WAGE + speechCounter * SPEECH_WAGE + extraSpeechMoney;
			
		// return total of person
		return incomePerPerson;
	}
}
