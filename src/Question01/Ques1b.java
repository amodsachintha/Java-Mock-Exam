package Question01;

public class Ques1b {   //ThreadBase class
    public static void main(String[] args) {
        NumbersThread red = new NumbersThread("Red");
        NumbersThread blue = new NumbersThread("Blue");
        NumbersThread green = new NumbersThread("Green");

        red.start();
        blue.start();
        green.start();

        for (int i = 1; i <= 10; i++) {
            System.out.println("SLIIT");
        }

        System.out.println("Red - getState(): " + red.getState().toString());
        System.out.println("Red - isAlive(): " + red.isAlive());
    }
}


class NumbersThread extends Thread{

    public NumbersThread(String name) {
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
