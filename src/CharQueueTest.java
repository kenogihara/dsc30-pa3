import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.NoSuchElementException;

class CharQueueTest {

    CharQueue queue;
    CharQueue line;

    @BeforeEach
    void setUp() {
        queue = new CharQueue();
        line = new CharQueue(10);
    }


    @org.junit.jupiter.api.Test
    void constructorOneTest() {

        CharQueue trafficManagement = new CharQueue();
        assertEquals(5, trafficManagement.circularArray.length);
        assertEquals(5, queue.circularArray.length);
        assertFalse(queue.circularArray.length > 5);
    }

    @org.junit.jupiter.api.Test
    void constructorTwoTest() {
        assertEquals(10, line.circularArray.length);
        assertThrows(IllegalArgumentException.class, () ->
        {
            CharQueue resultInError = new CharQueue(0);
        });

        CharQueue random = new CharQueue(1);
        assertEquals(1, random.circularArray.length);
    }


    @org.junit.jupiter.api.Test
    void isEmpty() {

        assertTrue(queue.isEmpty());
        queue.enqueue('a');
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());

    }

    @org.junit.jupiter.api.Test
    void isFull() {

        char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e'};
        for (char elem: alphabet) {
            queue.enqueue((char) elem);
        }
        assertTrue(queue.isFull());
        assertEquals(5, queue.size());

        queue.dequeue();
        assertFalse(queue.isFull());
    }

    @org.junit.jupiter.api.Test
    void size() {

        char[] alphabet = new char[] {'f', 'g', 'h', 'i'};
        for (char elem: alphabet) {
            queue.enqueue((char) elem);
        }

        assertEquals(4, queue.size());
        queue.dequeue();
        assertEquals(3, queue.size());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertEquals(0, queue.size());

        queue.enqueue('j');
    }

    @org.junit.jupiter.api.Test
    void clear() {
        char[] alphabet = new char[] {'f', 'g', 'h', 'i', 'j', 'k'};
        for (int elem: alphabet) {
            line.enqueue((char) elem);
        }

        assertEquals(6, line.size());
        assertEquals(10, line.circularArray.length);
        line.clear();

        assertTrue(line.isEmpty());
        assertEquals(0, line.size());
    }

    @org.junit.jupiter.api.Test
    void enqueue() {
        queue.enqueue('k');
        assertEquals('k', queue.circularArray[0]);
        queue.enqueue('e');
        assertEquals('e', queue.circularArray[1]);
        assertEquals(2, queue.size());

        queue.enqueue('n');
        queue.enqueue('o');
        queue.enqueue('g');
        queue.enqueue('i');
        assertEquals('i', queue.circularArray[5]);

        queue.enqueue('h');
        queue.enqueue('a');
        queue.enqueue('r');
        queue.enqueue('a');
        assertEquals(10, queue.size());

        queue.enqueue('a');
        assertEquals(20, queue.circularArray.length);

    }

    @org.junit.jupiter.api.Test
    void peek() {

        assertThrows(NoSuchElementException.class, () -> queue.peek());
        queue.enqueue('a');

        assertEquals('a', queue.peek());
        queue.dequeue();
        assertThrows(NoSuchElementException.class, () -> queue.peek());

        char[] alphabet = new char[] {'f', 'g', 'h', 'i', 'j', 'k'};
        for (int elem: alphabet) {
            queue.enqueue((char) elem);
        }
        assertEquals('f', queue.peek());

    }

    @org.junit.jupiter.api.Test
    void dequeue() {

        assertThrows(NoSuchElementException.class, () -> line.dequeue());
        char[] alphabet = new char[] {'f', 'g', 'h', 'i', 'j'};
        for (int elem: alphabet) {
            line.enqueue((char) elem);
        }
        assertEquals('f', line.dequeue());
        assertEquals('g', line.dequeue());
        assertEquals('h', line.dequeue());

        char[] newAlphabet = new char[] {'a', 'n', 'd', 'r', 'e'};
        for (int elem: newAlphabet) {
            queue.enqueue((char) elem);
        }
        queue.enqueue('w');

        assertEquals('a', queue.dequeue());
        assertEquals(5, queue.size());
        assertEquals('n', queue.dequeue());
        assertEquals(4, queue.size());

    }


}
