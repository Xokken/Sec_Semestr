package Alg.Home_1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class QueueTest {

    @Test
    void checkAdd() {
        Queue one = new Queue();
        one.add(5);
        Assert.assertEquals(5, one.pop());
    }

    @Test
    void checkAddSome() {
        Queue one = new Queue();
        one.add(5);
        one.add(50);
        Assert.assertEquals(5, one.pop());
    }

    @Test
    void checkAddAndPop() {
        Queue one = new Queue();
        one.add(5);
        one.pop();
        Assert.assertEquals(0, one.size());
    }

    @Test
    void checkSomePop() {
        Queue one = new Queue();
        one.add(5);
        one.add(3);
        one.add(7);
        one.add(4);
        one.add(1);
        one.add(5);
        one.pop();
        one.pop();
        one.pop();
        Assert.assertEquals(4, one.pop());
    }

    @Test
    void checkPeek() {
        Queue one = new Queue();
        one.add(5);
        one.add(7);
        one.add(4);
        one.add(1);
        one.add(5);
        one.add(10);
        one.peek();
        one.pop();
        Assert.assertEquals(7, one.peek());
    }

    @Test
    void checkPeekAndPop() {
        Queue one = new Queue();
        one.add(5);
        one.add(10);
        one.peek();
        Assert.assertEquals(2, one.size());
    }

    @Test
    void checkPeekSome() {
        Queue one = new Queue();
        one.add(5);
        one.add(10);
        for(int i = 0; i < 50; i++){
            one.peek();
        }
        Assert.assertEquals(5, one.peek());
    }


    @Test
    void checkSize() {
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

    @Test
    void hardCheckSize() {
        Queue one = new Queue();
        one.add(5);
        one.add(10);
        one.pop();
        one.add(522);
        one.add(103);
        one.add(53);
        one.add(1043);
        one.add(5);
        one.add(10);
        one.pop();
        one.add(522);
        one.add(103);
        one.add(53);
        one.add(1043);
        one.peek();
        one.pop();
        Assert.assertEquals(9, one.size());
    }

    @Test
    void checkZeroEl(){
        Queue one = new Queue();
        Assert.assertEquals(0, one.pop());
    }
}