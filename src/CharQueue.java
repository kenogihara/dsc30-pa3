/*
    Name: Ken Ogihara
    PID:  A16969236
 */

import java.util.NoSuchElementException;

/**
 * TODO
 *
 * @author Ken Ogihara
 * @since ${1/27/2024}
 */

public class CharQueue {
    /* instance variables, feel free to add more if you need */
    private char[] circularArray;
    private int length;
    private int front;
    private int rear;
    public static final int DEFAULT_CAPACITY = 5;

    public CharQueue() {
        circularArray = new char[DEFAULT_CAPACITY];
    }

    public CharQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity out of valid range");
        }
        circularArray = new char[capacity];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public void clear() {
        circularArray = new char[circularArray.length];
        length = 0;
        front = 0;
        rear = 0;
    }

    public void enqueue(char elem) {
        if (rear == front + circularArray.length) {

        }
        circularArray[rear] = elem;
        rear++;
        length++;
    }

    public char peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return circularArray[front];
    }

    public char dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        char elem = circularArray[front];
        front++;
        length--;
        return elem;
    }
}
