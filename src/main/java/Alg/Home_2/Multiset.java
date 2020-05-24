package Alg.Home_2;

public class Multiset {
    private Object[] data = new Object[1000];
    private int[] counter = new int[1000];
    private int count = 0;
    private int siz = 0;

    public boolean add (Object o){
        for (int i = 0; i < count; i++){
            if (o.equals(data[i])){
                counter[i]++;
                siz++;
                count++;
                return true;
            }
        }
        data[count] = o;
        counter[count]++;
        count++;
        siz++;
        return true;
    }

    public int countOf(Object o){
        for (int i = 0; i < count; i++){
            if (o.equals(data[i])){
                return counter[i];
            }
        }
        return 0;
    }

    public int size(){
        return siz;
    }

    public boolean delete(Object o){
        for (int i = 0; i < count; i++){
            if (o.equals(data[i])){
                counter[i]--;
                siz--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Multiset one = new Multiset();
        Multiset two = new Multiset();
        one.add(5);
        one.add(5);
        one.add(6);
        one.add(6);
        one.delete(6);
        System.out.println(one.countOf(6));
        System.out.println(one.size());
    }
}
