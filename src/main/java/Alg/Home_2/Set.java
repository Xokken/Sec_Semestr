package Alg.Home_2;

public class Set {
    private Object[] arr = new Object[1000];
    private int count = 0;

    public Set() {
    }

    public Set(Object[] arr, int count) {
        this.arr = arr;
        this.count = count;
    }

    public boolean add(Object o){
        for (int i = 0; i < count + 1; i++){
            if (o.equals(arr[i])){
                return false;
            }
        }
        arr[count] = o;
        count++;
        return true;
    }

    public boolean hasContains(Object o){
        for (int i = 0; i < count; i++){
            if (o.equals(arr[i])){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return count;
    }

    public boolean delete(Object o){
        if (!hasContains(o)){
            return false;
        }
        int i = 0;
        while (!o.equals(arr[i])) {
            i++;
        }
        for (int j = i; j < count; j++){
            arr[j] = arr[j+1];
        }
        count--;
        return true;
    }

    public Object[] getArr() {
        return arr;
    }

    public int getCount() {
        return count;
    }

    public void print(){
        for(int i= 0; i < this.getCount(); i++){
            System.out.print(this.arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Set one = new Set();
        Set two = new Set();
        System.out.println(one.add(4));
        System.out.println(one.add(7));
        System.out.println(one.add(8));
        System.out.println(one.add(5));
        System.out.println(one.add(8));
        System.out.println(one.delete(8));
        one.print();
        System.out.println();
        System.out.println();
        two.print();
    }
}
