package softuni.advanced.setsandmaps.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    final private static String COMMAND_END = "END";
    final private static String COMMAND_IN = "IN";
    final private static String COMMAND_OUT = "OUT";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> set = new LinkedHashSet<>();

        while (true) {
            String command = sc.nextLine();

            if (command.equals(COMMAND_END)) {
                break;
            }

            String[] commandArr = command.split(",\\s+");

            String direction = commandArr[0];
            String carNumberPlate = commandArr[1];

            if (direction.equals(COMMAND_IN)) {
                set.add(carNumberPlate);
            } else if (direction.equals(COMMAND_OUT)) {
                set.remove(carNumberPlate);
            }
        }

        if (set.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String item : set) {
                System.out.println(item);
            }
        }
    }
}
