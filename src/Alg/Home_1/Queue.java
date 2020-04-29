package Alg.Home_1;

public class Queue {
    private final int M = 100;
    private int count;
    private int end;
    private int n = 0;
    private int[] arr;

    public Queue(){
        this.n = M*2;
        this.count = this.n - 1;
        this.end = this.n - 1;
        arr = new int[n];
    }

    public void add(int num){
        arr[count] = num;
        count--;
    }

    public int pop(){
        end--;
        return arr[end-1];
    }

    public int peek(){
        return arr[end];
    }

    public int size(){
        return (end - count);
    }

    public static void main(String[] args) {
        Queue one = new Queue();
        one.add(4);
        System.out.println(one.peek());
        System.out.println(one.size());
        one.pop();
        System.out.println(one.size());
    }
}
