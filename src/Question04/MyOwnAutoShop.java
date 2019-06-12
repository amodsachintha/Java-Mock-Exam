package Question04;

import java.util.Date;

public class MyOwnAutoShop {
    public static void main(String[] args) {

        Truck truck = new Truck(40, 340000, "white", 4500.3);
        Bus bus = new Bus(60, 430000, "yellow", "2006", 4563.54);

        System.out.println("Truck sales price: LKR " + truck.getSalePrice() + "\n");
        System.out.println("Bus sales price: LKR " + bus.getSalePrice());
    }
}


abstract class Vehicle {
    private double speed;
    private double regularPrice;
    private String color;

    public Vehicle(double speed, double regularPrice, String color) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    public Vehicle(double speed, String color) {
        this.speed = speed;
        this.color = color;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public double getSalePrice() {
        return 0d;
    }
}

class Truck extends Vehicle {
    private double weight;

    public Truck(double speed, double regularPrice, String color, double weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    @Override
    public double getSalePrice() {
        if (this.weight >= 2000) {
            System.out.println("Discount of LKR 10%");
            return this.getRegularPrice() - (this.getRegularPrice() * 10 / 100);
        } else {
            System.out.println("Discount of LKR 20%");
            return this.getRegularPrice() - (this.getRegularPrice() * 20 / 100);
        }
    }
}

class Bus extends Vehicle {
    private String year;
    private double manufacturerDiscount;

    public Bus(double speed, double regularPrice, String color, String date, double manufacturerDiscount) {
        super(speed, regularPrice, color);
        this.year = date;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    @Override
    public double getSalePrice() {
        System.out.println("Manufacturer discount deducted: LKR " + this.manufacturerDiscount);
        return this.getRegularPrice() - this.manufacturerDiscount;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getManufacturerDiscount() {
        return manufacturerDiscount;
    }

    public void setManufacturerDiscount(double manufacturerDiscount) {
        this.manufacturerDiscount = manufacturerDiscount;
    }
}


