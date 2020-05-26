package Inf.Home_4;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

//NUMBER 4

public class MyFirstCollection<T> extends AbstractCollection<T> implements Iterable<T> {
    private Object[] arr = new Object[1000];
    private int count = 0;

    public MyFirstCollection() {
    }

    public MyFirstCollection(Collection<?extends T> col){
        int n = 0;
        this.count = col.size();
        this.arr = (T[]) new Object[1000];
        for (T el : col) {
            this.arr[n] = el;
            n++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorForColl();
    }


    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyFirstCollection<?> that = (MyFirstCollection<?>) o;
        return that.containsAll(this);
    }



    private class IteratorForColl implements Iterator{
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return arr.length > cursor;
        }

        @Override
        public Object next() {
            Object el = arr[cursor];
            cursor++;
            return el;
        }

    }

    public static void main(String[] args) {
        MySecondCollection<Integer> col = new MySecondCollection<>();
        col.add(5);
        MyFirstCollection<Integer> two = new MyFirstCollection<>(col);
        System.out.println("Я компилируюсь!");
        Iterator itOne = two.iterator();
        System.out.println(itOne.next());
        System.out.println(itOne.next());
    }

}