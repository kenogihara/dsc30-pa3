/*
    Name: Ken Ogihara
    PID:  A16969236
 */

import java.util.NoSuchElementException;

/**
 * Implementation of CharQueue class.
 *
 * @author Ken Ogihara
 * @since ${1/27/2024}
 */

public class CharQueue {
    /* instance variables*/
    public char[] circularArray;
    private int length;
    private int front;
    private int rear;

    /* magic numbers*/
    public static final int DEFAULT_CAPACITY = 5;
    public static final int DOUBLED_IN_SIZE = 2;

    /**
     * Constructor that creates a queue with a default capacity of 5.
     **/
    public CharQueue() {
        circularArray = new char[DEFAULT_CAPACITY];
    }

    /**
     * Constructor that creates a queue with a given capacity.
     *
     * @param capacity an integer.
     * @throws IllegalArgumentException if capacity is less than 1.
     **/
    public CharQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity out of valid range");
        }
        circularArray = new char[capacity];
    }

    /**
     * Method that checks if the queue is empty.
     *
     * @return a boolean.
     **/
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Method that checks if the queue is full.
     *
     * @return a boolean.
     **/
    public boolean isFull() {
        return circularArray.length == length;
    }

    /**
     * Getter method that returns front index.
     *
     * @return an integer.
     **/
    public int getFront() {
        return front;
    }

    /**
     * Method that returns the size of the queue.
     *
     * @return an integer.
     **/
    public int size() {
        return length;
    }

    /**
     * Method that clears all elements in the queue.
     **/
    public void clear() {
        circularArray = new char[circularArray.length];
        length = 0;
        front = 0;
        rear = 0;
    }

    /**
     * Method that enqueues an element into the queue.
     *
     * @param elem a single character.
     **/
    public void enqueue(char elem) {
        if (this.isFull()) {
            char[] updatedArray = new char[circularArray.length * DOUBLED_IN_SIZE];
            for (int i = 0; i < circularArray.length; i++) {
                updatedArray[i] = circularArray[i];
            }
            rear = rear + circularArray.length;
            updatedArray[rear] = elem;
            circularArray = updatedArray;
        }
        circularArray[rear] = elem;
        rear = (rear + 1) % circularArray.length;
        length++;
    }

    /**
     * Method that returns the first element in the queue.
     *
     * @return a single character.
     * @throws NoSuchElementException if the queue is empty.
     **/
    public char peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return circularArray[front];
    }

    /**
     * Method that removes and returns the first element in the queue.
     *
     * @return a single character.
     * @throws NoSuchElementException if the queue is empty.
     **/
    public char dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        char elem = circularArray[front];
        front = (front + 1) % circularArray.length;
        length--;
        return elem;
    }


    /**
     * Method that removes and returns the first element in the queue.
     *
     * @return a single character.
     * @throws NoSuchElementException if the queue is empty.
     **/
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < circularArray.length; i++) {
            int index = (front + i) % circularArray.length;
            char elem = circularArray[index];
            if (elem != '\0') {
                output.append(elem);
            }
        }
        return output.toString();
    }

}
