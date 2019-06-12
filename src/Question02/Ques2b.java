package Question02;

public class Ques2b {
    public static void main(String[] args) {
        AbstractFactory mobilePhoneFactory = FactoryProvider.getFactory("MobilePhone");
        MobilePhone phone1 = (MobilePhone) mobilePhoneFactory.create("A10");
        MobilePhone phone2 = (MobilePhone) mobilePhoneFactory.create("X25");
        MobilePhone phone3 = (MobilePhone) mobilePhoneFactory.create("TPlus");

        phone1.display();
        phone2.display();
        phone3.display();

        System.out.println();

        AbstractFactory tvFactory = FactoryProvider.getFactory("TV");
        TV tv1 = (TV) tvFactory.create("Alpha40");
        TV tv2 = (TV) tvFactory.create("Gamma50");
        TV tv3 = (TV) tvFactory.create("Theta65");

        tv1.display();
        tv2.display();
        tv3.display();
    }
}


abstract class MobilePhone {
    private String model;
    private double price;

    abstract void display();
}

class A10 extends MobilePhone {
    @Override
    void display() {
        System.out.println("Inside: " + this.getClass().getSimpleName() + " - display()");
    }
}

class X25 extends MobilePhone {
    @Override
    void display() {
        System.out.println("Inside: " + this.getClass().getSimpleName() + " - display()");
    }
}

class TPlus extends MobilePhone {
    @Override
    void display() {
        System.out.println("Inside: " + this.getClass().getSimpleName() + " - display()");
    }
}


abstract class TV {
    private String model;
    private String size;

    abstract void display();
}

class Alpha40 extends TV {
    @Override
    void display() {
        System.out.println("Inside: " + this.getClass().getSimpleName() + " - display()");
    }
}

class Gamma50 extends TV {
    @Override
    void display() {
        System.out.println("Inside: " + this.getClass().getSimpleName() + " - display()");
    }
}

class Theta65 extends TV {
    @Override
    void display() {
        System.out.println("Inside: " + this.getClass().getSimpleName() + " - display()");
    }
}

interface AbstractFactory<T> {
    default T create(String objectType) {
        return null;
    }
}

class MobileFactory implements AbstractFactory<MobilePhone> {
    @Override
    public MobilePhone create(String objectType) {
        if ("A10".equalsIgnoreCase(objectType))
            return new A10();
        else if ("X25".equalsIgnoreCase(objectType))
            return new X25();
        else if ("TPlus".equalsIgnoreCase(objectType))
            return new TPlus();

        return null;
    }
}

class TVFactory implements AbstractFactory<TV> {
    @Override
    public TV create(String objectType) {
        if ("Alpha40".equalsIgnoreCase(objectType))
            return new Alpha40();
        else if ("Gamma50".equalsIgnoreCase(objectType))
            return new Gamma50();
        else if ("Theta65".equalsIgnoreCase(objectType))
            return new Theta65();

        return null;
    }
}

class FactoryProvider {
    static AbstractFactory getFactory(String factoryType) {
        if ("MobilePhone".equalsIgnoreCase(factoryType))
            return new MobileFactory();
        else if ("TV".equalsIgnoreCase(factoryType))
            return new TVFactory();
        return null;
    }
}