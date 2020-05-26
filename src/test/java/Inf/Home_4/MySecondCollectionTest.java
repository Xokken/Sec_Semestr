package Inf.Home_4;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Iterator;


public class MySecondCollectionTest {

    @Test
    public void add() {
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(5);
        Iterator it = col.iterator();
        Assert.assertEquals(5, it.next());
    }

    @Test
    void checkAddSome() {
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(5);
        col.add(50);
        Assert.assertEquals(2, col.size());
    }

    @Test
    void checkAddAndDelete(){
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(5);
        col.add(50);
        Iterator it = col.iterator();
        it.remove();
        it.next();
        Assert.assertEquals(null, it.next());
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
    public void checkIndexEx(){
        MySecondCollection<Integer> col = new MySecondCollection<>();
        Iterator it = col.iterator();
        try{
            it.remove();
        }
        catch (ArrayIndexOutOfBoundsException e){
            Assert.assertEquals("-1", e.getMessage());
        }
    }

    @Test
    public void checkSize() {
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(5);
        col.add(5);
        col.add(5);
        col.add(5);
        Assert.assertEquals(4, col.size());
    }

    @Test
    public void hardCheckSize() {
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(5);
        col.add(5);
        col.add(50);
        col.add(343);
        col.add(40);
        col.add(311);
        col.add(47);
        Iterator it = col.iterator();
        it.remove();
        it.remove();
        it.remove();
        Assert.assertEquals(4, col.size());
    }

    @Test
    void checkNullEl(){
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(5);
        col.add(50);
        col.add(343);
        col.add(40);
        col.add(311);
        col.add(47);
        Iterator it = col.iterator();
        it.remove();
        for(int i = 0; i < 10; i++){
            it.next();
        }
        Assert.assertEquals(null, it.next());
    }

    @Test
    public void checkHasNextIt() {
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(5);
        col.add(311);
        col.add(47);
        Iterator it = col.iterator();
        Assert.assertTrue(it.hasNext());
    }


    @Test
    public void checkNotHasNextIt() {
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(311);
        Iterator it = col.iterator();
        it.hasNext();
        it.remove();
        it.hasNext();
        Assert.assertFalse(it.hasNext());
    }


}