package pl.sda.zdjavapol4.jav_demo.di;

public class Main {
    public static void main(String[] args) {
        Engine small = new Engine(800);
        String color = "pink";

        Car myFavouriteCar = new Car(small, color);

        Car defaultCar = new Car();
    }
}
