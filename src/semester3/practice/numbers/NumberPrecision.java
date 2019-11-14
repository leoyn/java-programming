package semester3.practice.numbers;

public class NumberPrecision {
	public static void main(String[] args) {
		float a = 0;
		float b = 0;
		
		// Die Ergebnisse sollten gleich sein
		a = 10f/3;
		b = (1f/3) * 10;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		// However precision is not always exact
		System.out.println("is a == b? " + (a == b ? "✅" : "❌"));
		System.out.println();
		
		// Passiert aufgrund limitierter Anzahl an Bits
		// [S CCCC CCCC MMMM MMMM MMMM MMMM MMMM MMM] 
		// C = Größenordnung / Charakteristik		(1 Bit)
		// M = Mantisse								(8 Bits)
		// S = Sign / Vorzeichen (+/-)				(23 Bits)
		// 										∑ = (32 Bits)

		// Interne Darstellung der Float
		
		printFloatAsInternalBinaryNumber(-1);
		System.out.println();
				
		// Genauigkeit:
		// 10^-6   für Floats
		// 10^-14  für Doubles
		
		
		// Beispiel für die Genauigkeit bei Floats:
		
		float precisionFloat = 1;
		while((1 + precisionFloat / 2) != 1) {
			printFloatAsInternalBinaryNumber(1 + precisionFloat / 2);
			precisionFloat /= 2;
		}
		
		System.out.println();
		System.out.println("precision = " + 1 / precisionFloat);
		System.out.println("2^23	  = " + Math.pow(2, 23));
		
		// 2^23 ist der maximale Zahlenraum der Mantisse (23 Bits)
		// Somit kann man ca. 10^-6 bis 10^-7 Ziffern vertrauen
	}
	
	public static void printFloatAsInternalBinaryNumber(float number) {
		System.out.println((number >= 0 ? "0" : "") + Integer.toBinaryString(Float.floatToIntBits(number)));
	}
}
