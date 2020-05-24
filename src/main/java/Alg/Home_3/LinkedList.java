package Alg.Home_3;

public class LinkedList<T> {
    private Node head = null;
    private int size = 0;

    public LinkedList(){
    }

    public boolean add(T o){
        Node one = new Node(o, null);
        if (head == null){
            head = one;
            return true;
        }
        Node two = head;
        while (two.getNext() != null){
            two = two.getNext();
        }
        two.setNext(one);
        size++;
        return true;
    }

    public boolean addFirst(T o){
        if (head == null){
            head = new Node(o, null);
            size++;
            return true;
        }
        Node one = new Node(o, head);
        head = one;
        return true;
    }

    public boolean addAfter(T o, int index){
        index = index - 2;
        Node one = new Node((T) o, null);
        Node two = head;
        for (int i = 0; i < index; i++){
            two = two.getNext();
        }
        one.setNext(two.getNext());
        two.setNext(one);
        size++;
        return true;
    }

    public T get(int index){
        index--;
        Node one = head;
        for (int i = 0; i < index; i++){
            one = one.getNext();
        }
        return (T) one.getData();
    }




    public int size() {
        return size;
    }

    public void remove(int index){
        index--;
        Node one = head;
        for (int i = 0; i < index - 1; i++){
            one = one.getNext();
        }
        Node two = one.getNext();
        one.setNext(two.getNext());
    }

    public boolean remove (T o){
        Node one = head;
        Node two = head.getNext();
        boolean a = false;
        while (two.getNext() != null) {
            if (two.getData().equals(o)){
                one.setNext(two.getNext());
                a = true;
                break;
            }
            one = one.getNext();
            two = two.getNext();
        }
        return a;
    }

    public LinkedList merge(LinkedList o){
        Node one = o.head;
        while (one.getNext() != null){
            one = one.getNext();
        }
        one.setNext(this.head);
        return o;
    }


    private class Node<T> {
        private T data;
        private Node next;

        private Node (T data, Node next){
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println("Я компилируюсь!");
        LinkedList one = new LinkedList();
        one.add(5);
        one.add(6);
        one.add(4);
        one.add(5);
        one.add(6);
        one.add(4);
        Object a = 4;
        one.remove(a);
        System.out.println(one.get(3));
    }
}
