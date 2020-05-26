package Inf.Home_5;

import java.util.Comparator;

public class MyComp<T> implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}