package Inf.Home_4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MySecondCollection <T> extends AbstractCollection<T> implements Iterable<T> {

    private Object[] arr = new Object[1000];
    private int count = 0;

    public MySecondCollection() {
    }

    public MySecondCollection(Collection<?extends T> col){
        int n = 0;
        this.count = col.size();
        this.arr = (T[]) new Object[1000];
        for (T el : col) {
            this.arr[n] = el;
            n++;
        }
    }

    public boolean add(T o){
        arr[count] = o;
        count++;
        return true;
    }


    @Override
    public Iterator<T> iterator() {
        return new NewIteratorForColl();
    }


    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySecondCollection<?> that = (MySecondCollection<?>) o;
        return that.containsAll(this);
    }


    private class NewIteratorForColl implements Iterator {
        private int cursor = 0;


        public void remove(){
            arr[size() - 1] = null;
            count--;
        }

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public T next() {
            T element = (T) arr[cursor];
            cursor++;
            return element;
        }

    }


    public static void main(String[] args) {
        System.out.println("WOWOWOWOWOWOWOWOWOWOWOWOWOW");
        ArrayList two = new ArrayList();
        two.add(3);
        two.add(90);
        two.add(60);
        System.out.println("Я компилируюсь!");
        MySecondCollection one = new MySecondCollection(two);
        Iterator itOne = one.iterator();
        System.out.println(itOne.next());
        System.out.println(itOne.next());
        System.out.println(itOne.next());
        itOne.remove();
        System.out.println(itOne.next());
        System.out.println(itOne.next());
        System.out.println(two.toString());
    }
}

