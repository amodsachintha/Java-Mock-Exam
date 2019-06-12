package Question01;

public class Ques1a {

    public static void main(String[] args) {
        PrintThread printThread = new PrintThread("PrintThread");
        SLIITThread sliitThread = new SLIITThread("SLIITThread");

        printThread.start();
        sliitThread.start();
    }
}


class PrintThread extends Thread {

    PrintThread(String name) {
        super(name);
    }


    @Override
    public void run() {
        System.out.println("Running " + this.getName());
        for (int i = 1; i <= 10; i++) {
            System.out.println(this.getName() + ": " + i);
        }
    }
}

class SLIITThread extends Thread {
    SLIITThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Running " + this.getName());
        for (int i = 1; i <= 10; i++) {
            System.out.println(this.getName() + ": SLIIT");
        }
    }
}
