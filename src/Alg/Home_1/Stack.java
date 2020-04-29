package Alg.Home_1;

public class Stack {
    private final int M = 100;
    private int count = 0;
    private int n = 0;
    private int[] arr;

    public Stack(){
        this.n = M*2;
        arr = new int[n];
    }

    public void add(int num){
        arr[count+1] = num;
        count++;
    }

    public int pop(){
        count--;
        return arr[count+1];
    }

    public int peek(){
        return arr[count];
    }

    public int size(){
        return count;
    }

    public int getCount() {
        return count;
    }

    public int getN() {
        return n;
    }

    public int[] getArr() {
        return arr;
    }

    public static void main(String[] args) {
        Stack one = new Stack();
        one.add(4);
        System.out.println(one.peek());
        System.out.println(one.size());
        one.pop();
        System.out.println(one.size());
    }
}
