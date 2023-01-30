package softuni.advanced.definingclasses.lab.carconstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int iterations = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < iterations; i++) {
            String[] carBuilder = sc.nextLine().split(" ");

            Car car;
            if (carBuilder.length < 3) {
                car = new Car(carBuilder[0]);
            } else {
                car = new Car(carBuilder[0], carBuilder[1], Integer.parseInt(carBuilder[2]));
            }
            System.out.println(car.carInfo());

        }
    }
}
