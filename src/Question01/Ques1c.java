package Question01;

import java.text.NumberFormat;

public class Ques1c {    // class ParallelTest
    public static void main(String[] args) throws InterruptedException {
        int globalEnd = 100000;
        int threads = 2;
        long total = 0;
        CalculationViaThread[] threadArray = new CalculationViaThread[threads];
        int size = globalEnd / threads;
        System.out.println("Block size: " + NumberFormat.getInstance().format(size));
        for (int i = 0; i < threads; i++) {
            System.out.println("Start: " + NumberFormat.getInstance().format(((i * size) + 1)) + "   End: " + NumberFormat.getInstance().format((i + 1) * size));
            threadArray[i] = new CalculationViaThread("Thread " + (i + 1), new Calculation(), (i * size) + 1, (i + 1) * size);
        }
        for (CalculationViaThread thread : threadArray) {
            thread.start();
            Thread.sleep(50);
        }
        try {
            for (CalculationViaThread thread : threadArray) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (CalculationViaThread thread : threadArray) {
            total += thread.getCalculation().getTotal();
        }
        System.out.println("Arithmetic Progression Sum: " + NumberFormat.getInstance().format(total));
    }
}


class Calculation {
    private long total = 0;

    void sum(long start, long end) {
        for (long i = start; i <= end; i++) {
            this.total += i;
        }
    }

    long getTotal() {
        return total;
    }
}

class CalculationViaThread extends Thread {
    private Calculation calculation;
    private int start;
    private int end;

    CalculationViaThread(String name, Calculation calculation, int start, int end) {
        super(name);
        this.calculation = calculation;
        this.start = start;
        this.end = end;
    }

    Calculation getCalculation() {
        return calculation;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + this.getName());
        this.calculation.sum(this.start, this.end);
    }
}



