package Alg.Home_1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void add() {
        Queue one = new Queue();
        one.add(5);
        one.add(10);
        Assert.assertEquals(2, one.size());
    }

    @Test
    void pop() {
        Queue one = new Queue();
        one.add(5);
        one.add(10);
        one.pop();
        Assert.assertEquals(1, one.size());
    }

    @Test
    void peek() {
        Queue one = new Queue();
        one.add(5);
        one.add(10);
        one.peek();
        Assert.assertEquals(2, one.size());
    }

    @Test
    void size() {
        Queue one = new Queue();
        one.add(5);
        one.add(10);
        one.pop();
        one.add(522);
        one.add(103);
        one.add(53);
        one.add(1043);
        Assert.assertEquals(5, one.size());
    }
}