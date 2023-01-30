package softuni.advanced.generics.lab.jaroft;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> stack;

    public Jar() {
        stack = new ArrayDeque<>();
    }

    public void add(T e) {
        stack.push(e);
    }

    public T remove() {
        return stack.pop();
    }
}
