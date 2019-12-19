package semester3.practice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.Spliterator.OfLong;
import java.util.function.BiConsumer;
import java.util.function.LongConsumer;
import java.util.stream.*;

public class EvenNumbers {
	
    public static void main(String ... args) {  
    	int start = 2;
    	int anzahl = 100_000;
    	EvenChecker.iterations = 1_000; // sonst Ausführungszeiten zu kurz
    	    
    	System.out.println("Summe " + addEvenNumbers_01(start, anzahl));
    	System.out.println("Summe " + addEvenNumbers_02(start, anzahl));
    	System.out.println("Summe " + addEvenNumbers_03(start, anzahl));
    	System.out.println("Summe " + addEvenNumbers_04(start, anzahl));
    	System.out.println("Summe " + addEvenNumbers_05(start, anzahl));    	
    	
    	// benötigte Zeit mit measurePerf ausgeben
    }

    static long addEvenNumbers_01(Integer start, Integer limit){
        // sequentiellen Stream verwenden

        LongStream evenNumbers = LongStream.iterate(start, number -> {
            return number + 1;
        }).filter(number -> {
            return new EvenChecker().isEven(number);
        });

    	return evenNumbers.limit(limit).sum();
    }

    static long addEvenNumbers_02(Integer start, Integer anzahl){
    	long result = 0;
    	int ind = 0;
		int i = start;
		
    	do {
    		if (new EvenChecker().isEven(i)) {
    			result= result + i;
    			ind++;
            }
            
    		i++;
		} while(ind < anzahl);
		
    	return result;
    }

    static long addEvenNumbers_03(Integer start, Integer limit){
        //parallelen Stream verwenden
        
        LongStream evenNumbers = LongStream.iterate(start, number -> {
            return number + 1;
        }).filter(number -> {
            return new EvenChecker().isEven(number);
        }).parallel();

    	return evenNumbers.limit(limit).sum();
    }

    static long addEvenNumbers_04(Integer start, Integer anzahl) {
    	long[] numbers = new long[2 * anzahl]; 
        numbers[0] = start;
        
    	for (int i = 1; i < numbers.length; i++) {
    		numbers[i]=numbers[i-1]+1;
        }
        
    	OfLong spliterator = new MySpliterator(numbers);
    	LongStream evenNumbers = StreamSupport.longStream(spliterator, true);
    	
    	return evenNumbers.filter(i -> {
            return new EvenChecker().isEven(i);
        }).filter(i-> {
            return i >= start;
        }).limit(anzahl).sum();
    }

    static long addEvenNumbers_05(Integer start, Integer anzahl) {
    	return ForkJoinAddEvenNumbersCalculator.forkJoinSum(start, anzahl);
    }

    public static <T> long measurePerf(BiConsumer<T, T> f, T input1, T input2) {
        long duration = 0;

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            f.accept(input1,input2);
            if (i > 4) duration = duration + (System.nanoTime() - start) / 1_000_000;
        }

        return duration / 5;
    }
}

class EvenChecker{
	static int iterations;
	double dummy = 0;
    
	boolean isEven(long n) {
        increaseProcessingTime();
        
    	//sonst eliminiert JIT-Compiler increaseProcessingTime()
        if (dummy == 1.1) return false;
        
        if (n % 2 == 0) return true;

        return false;
    }

	private void increaseProcessingTime() {
		for (int j = 0; j < iterations; j++) {
        	dummy=dummy+j;
        }
    }
}

class MySpliterator implements OfLong {
	public static final long THRESHOLD = 50_000L;
	private final long[] numbers;
    private int ind;
    
	public MySpliterator(long[] s) {
		numbers = s;
	}

	@Override
	public long estimateSize() {
		return  numbers.length - ind;
	}
	
	@Override
	public Comparator<Long> getComparator() {
		return new Comparator<Long>() {
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
		};     
	 }

	@Override
	public int characteristics() {
		return IMMUTABLE | NONNULL | SORTED | ORDERED;
	}

	@Override
	public Spliterator.OfLong trySplit() {
		int currentLength = numbers.length - ind;

		if (currentLength <= THRESHOLD) return null;

		int splitPos = currentLength / 2 + ind;
		Spliterator.OfLong spliterator = new MySpliterator(Arrays.copyOfRange(numbers, ind, splitPos));
		ind = splitPos;

		return spliterator;
	}

	@Override
	public boolean tryAdvance(LongConsumer action) {
		if (ind < numbers.length) {
			action.accept(numbers[ind]);
			ind++;
			return true;
		}
		return false;
	}
}