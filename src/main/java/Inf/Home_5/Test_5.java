package Inf.Home_5;


import java.util.Comparator;

public class Test_5 {
    public static void main(String[] args){
        System.out.println("Wawawa");

        MyComp com = new MyComp();
        MyNavigableSet<Integer> one = new MyNavigableSet<>((Comparator) com);
        for (int i = 2; i < 10; i++){
            System.out.print(one.add(i) + " ");
            System.out.println();
        }
        System.out.println();
        System.out.println(one.ceiling(-10));
        System.out.println(one.higher(16));
        System.out.println(one.add(15));
    }
}
