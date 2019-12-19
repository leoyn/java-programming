package semester3.practice.streams;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinAddEvenNumbersCalculator extends RecursiveTask<Long> {
	public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
    public static long threshold = 250_000L;
    static int iterations = 0; //zur Steuerung der Zeit für joins
    static int anzForks;

    private final int start;
    private final int anzahl;
    double dummy = 0;

    
    public ForkJoinAddEvenNumbersCalculator(int start, int anzahl) {
        this.start = start;
        this.anzahl = anzahl;  
    }

    @Override
    protected Long compute() {
        if (anzahl <= threshold) {
            return computeSequentially();
        }

        anzForks++;

        ForkJoinAddEvenNumbersCalculator leftTask = new ForkJoinAddEvenNumbersCalculator(start, anzahl / 2);
        leftTask.fork();
        
        /*
         * Hier wird das Wissen ausgenutzt, dass jede zweite Zahl gerade ist
         * Die letzte gerade Zahl von leftTask hängt von start ab: 
         * start gerade => start + 2*[(anzahl/2)-1] = start + anzahl - 2
         * start ungerade => (start + 1) + 2*[(anzahl/2)-1] = start + anzahl - 1 
         * allgemein: start + anzahl - 2 + start%2
         * anzahl = anzahl/2 + [anzahl/2 + anzahl%2] => rightTask muss [anzahl/2 + anzahl%2] gerade Zahlen addieren
         */

        ForkJoinAddEvenNumbersCalculator rightTask = new ForkJoinAddEvenNumbersCalculator(start + anzahl - 2 + start % 2 + 1, anzahl / 2 + anzahl % 2);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();

        increaseProcessingTime();

        if (dummy == 1.1) return 0L;
        return leftResult + rightResult;
    }

    private long computeSequentially() {
    	long result = 0;
    	int ind = 0;
        int i = start;
        
    	do {
    		if (new EvenChecker().isEven(i)){
    			result = result+i;
    			ind++;
    		}	
    		i++;
        } while(ind < anzahl);
        
    	return result;
    }
    
    public static long forkJoinSum(int start, int anzahl) {
        ForkJoinTask<Long> task = new ForkJoinAddEvenNumbersCalculator(start, anzahl);
        return FORK_JOIN_POOL.invoke(task);
    }
    private void increaseProcessingTime() {
		for (int j = 0; j < iterations; j++) {
        	dummy = dummy + j;
        }
    }
}