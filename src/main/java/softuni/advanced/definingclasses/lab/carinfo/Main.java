package softuni.advanced.definingclasses.lab.carinfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int iterations = Integer.parseInt(sc.nextLine());

        Car car = new Car();

        for (int i = 0; i < iterations; i++) {
            String[] carBuilder = sc.nextLine().split(" ");

            car.setBrand(carBuilder[0]);
            car.setModel(carBuilder[1]);
            car.setHorsePower(Integer.parseInt(carBuilder[2]));

            System.out.println(car.carInfo());
        }
    }
}
