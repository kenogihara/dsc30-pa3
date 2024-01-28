import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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
        for (int elem: alphabet) {
            queue.enqueue((char) elem);
        }
        assertTrue(queue.isFull());
        assertEquals(5, queue.size());

        queue.dequeue();
        assertFalse(queue.isFull());
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void enqueue() {
    }

    @org.junit.jupiter.api.Test
    void peek() {
    }

    @org.junit.jupiter.api.Test
    void dequeue() {
    }

}
