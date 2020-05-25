package Inf.Home_4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;


public class MySecondCollectionTest {

    @Test
    public void add() {
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(5);
        col.add(5);
        Assert.assertEquals(2, col.size());
    }

    @Test
    public void iterator() {
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(5);
        col.add(5);
        Iterator it = col.iterator();
        Assert.assertTrue(it instanceof Iterator);
    }

    @Test
    public void size() {
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(5);
        col.add(5);
        col.add(5);
        col.add(5);
        Assert.assertEquals(4, col.size());
    }
}