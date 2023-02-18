package softuni.advanced.regularexam.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (registry.size() >= capacity) {
            return false;
        }

        registry.add(child);
        return true;
    }

    public boolean removeChild(String firstName) {
        Optional<Child> optionalChild = registry.stream()
                .filter(child -> child.getFirstName().equals(firstName))
                .findFirst();

        if (optionalChild.isEmpty()) {
            return false;
        }

        registry.remove(optionalChild.get());
        return true;
    }

    public int getChildrenCount() {
        return registry.size();
    }

    public Child getChild(String firstName) {
        Optional<Child> optionalChild = registry.stream()
                .filter(child -> child.getFirstName().equals(firstName))
                .findFirst();

        return optionalChild.get();
    }

    public String registryReport() {
        StringBuilder sb = new StringBuilder("Registered children in " + name + ":").append(System.lineSeparator());

        List<Child> sorted = registry.stream()
                .sorted(Comparator.comparing(Child::getAge).thenComparing(Child::getLastName).thenComparing(Child::getFirstName))
                .collect(Collectors.toList());

        for (Child child : sorted) {
            sb.append(child.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

}
