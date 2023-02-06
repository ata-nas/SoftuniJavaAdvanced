package dsa;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Custom implementation of a Stack Data Structure, using Nodes, chained together.
 * The Iterator implemented, does not pop the stack, so using a for-each loop over the stack
 * and exhausting the iterator, will not change the stack.
 */
public class CustomStackImpl<T> implements Iterable<T>{
    private Node<T> top;
    private int size;

    /**
     * Use push to insert an item on top of the stack.
     * @param e - the item to be pushed
     */
    public void push(T e) {
        Node<T> curr = new Node<>(e);
        curr.prev = top;
        top = curr;
        size++;
    }

    /**
     * This method removes the top element from the stack and returns it.
     * @return the top element of the stack, if it is empty, then throws an exception.
     */
    public T pop() {
        validateNotEmpty();
        T toPop = top.element;
        top = top.prev;
        size--;
        return toPop;
    }

    /**
     * This method is used to check the element at the top of the stack.
     *
     * @return {@code null} if the stack is empty, otherwise return the element at the top of the stack
     */
    public T peek() {
        if (top == null) {
            return null;
        }
        return top.element;
    }

    /**
     * This method returns the size of the stack (how many elements are currently in it).
     * @return {@code size} - int size of the stack.
     */
    public int size() {
        return size;
    }

    /**
     * A private method to check if the stack is empty, used internally for validation.
     */
    private void validateNotEmpty() {
        if (top == null) {
            throw new NoSuchElementException("CustomStackImpl is empty!");
        }
    }

    private static class Node<T> {
        final private T element;
        private Node<T> prev;

        public Node(T element) {
            this.element = element;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomStackImplIterator();
    }

    private class CustomStackImplIterator implements Iterator<T> {
        private Node<T> currNode = top;
        @Override
        public boolean hasNext() {
            return currNode != null;
        }

        @Override
        public T next() {
            T e = currNode.element;
            currNode = currNode.prev;
            return e;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
