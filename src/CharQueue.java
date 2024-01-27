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

    public CharQueue() {
        circularArray = new char[5];
    }

    public CharQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity out of valid range");
        }
        circularArray = new char[capacity];
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    public int size() {
        // TODO
        return 0;
    }

    public void clear() {
        // TODO
    }

    public void enqueue(char elem) {
        // TODO
    }

    public char peek() {
        // TODO
        return 0;
    }

    public char dequeue() {
        // TODO
        return 0;
    }
}
