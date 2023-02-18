package softuni.advanced.regularexam;

import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation {

    private static final int PATCH_RESOURCES_NEEDED = 30;
    private static final int BANDAGE_RESOURCES_NEEDED = 40;
    private static final int MEDKIT_RESOURCES_NEEDED = 100;
    private static final Scanner sc = new Scanner(System.in);
    private static final Deque<Integer> textilesQueue = new ArrayDeque<>();
    private static final Deque<Integer> medicamentStack = new ArrayDeque<>();
    private static final Map<String, Integer> inventoryMap = new HashMap<>();

    public static void main(String[] args) {

        fillTextilesAndMedicamets();
        initializeInventory();

        while (bothContain()) {
            int textile = textilesQueue.peek();
            int medicament = medicamentStack.peek();

            if (sumEqualsPatchResources(textile, medicament)) {
                inventoryMap.replace("Patch", inventoryMap.get("Patch") + 1);
                textilesQueue.poll();
                medicamentStack.pop();

            } else if (sumEqualsBandageResources(textile, medicament)) {
                inventoryMap.replace("Bandage", inventoryMap.get("Bandage") + 1);
                textilesQueue.poll();
                medicamentStack.pop();

            } else if (sumEqualsMedkitResources(textile, medicament)) {
                inventoryMap.replace("MedKit", inventoryMap.get("MedKit") + 1);
                textilesQueue.poll();
                medicamentStack.pop();

            } else if (sumGreaterThanMedkitResources(textile, medicament)) {
                inventoryMap.replace("MedKit", inventoryMap.get("MedKit") + 1);
                int toIncrease = textilesQueue.poll() + medicamentStack.pop();
                medicamentStack.push(medicamentStack.pop() + (toIncrease - 100));
            } else {
                textilesQueue.poll();
                medicamentStack.push(medicamentStack.pop() + 10);
            }
        }

        LinkedHashMap<String, Integer> sortedInventoryMap = inventoryMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        if (textilesQueue.isEmpty() && medicamentStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");

            for (var entry: sortedInventoryMap.entrySet()) {
                if (entry.getValue() > 0) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }

        } else if (textilesQueue.isEmpty()) {
            System.out.println("Textiles are empty.");

            for (var entry: sortedInventoryMap.entrySet()) {
                if (entry.getValue() > 0) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }

            StringBuilder sb = new StringBuilder("Medicaments left: ");

            while (!medicamentStack.isEmpty()) {
                sb.append(medicamentStack.pop()).append(", ");
            }

            String sbResult = sb.substring(0 ,sb.length() - 2);

            System.out.println(sbResult);

        } else if (medicamentStack.isEmpty()) {
            System.out.println("Medicaments are empty.");

            for (var entry: sortedInventoryMap.entrySet()) {
                if (entry.getValue() > 0) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }

            StringBuilder sb = new StringBuilder("Textiles left: ");

            while (!textilesQueue.isEmpty()) {
                sb.append(textilesQueue.poll()).append(", ");
            }

            String sbResult = sb.substring(0 ,sb.length() - 2);

            System.out.println(sbResult);
        }

    }

    private static void initializeInventory() {
        inventoryMap.put("MedKit", 0);
        inventoryMap.put("Bandage", 0);
        inventoryMap.put("Patch", 0);
    }

    private static boolean sumGreaterThanMedkitResources(int textile, int medicament) {
        return textile + medicament > MEDKIT_RESOURCES_NEEDED;
    }

    private static boolean sumEqualsMedkitResources(int textile, int medicament) {
        return textile + medicament == MEDKIT_RESOURCES_NEEDED;
    }

    private static boolean sumEqualsBandageResources(int textile, int medicament) {
        return textile + medicament == BANDAGE_RESOURCES_NEEDED;
    }

    private static boolean sumEqualsPatchResources(int textile, int medicament) {
        return textile + medicament == PATCH_RESOURCES_NEEDED;
    }

    private static boolean bothContain() {
        return textilesQueue.size() > 0 && medicamentStack.size() > 0;
    }

    private static void fillTextilesAndMedicamets() {
        List<Integer> inputTextile = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> inputMedicament = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(inputMedicament);

        textilesQueue.addAll(inputTextile);
        medicamentStack.addAll(inputMedicament);
    }

}
