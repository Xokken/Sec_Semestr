package Inf.Home_5;

import java.util.*;

/**
 * It's my Navigable Set!
 * @author Xokken
 * @param <T> type of data;
 */

public class MyNavigableSet<T> extends AbstractSet<T> implements SortedSet<T> {
    private ArrayList<T> arrList;
    private Comparator compar;

    public MyNavigableSet(Comparator<? extends T> compar){
        this.arrList = new ArrayList<T>();
        this.compar = compar;
    }

    public MyNavigableSet(Collection<? extends T> arrList, Comparator<? extends T> compar) {
        this.arrList = (ArrayList<T>) arrList;
        this.compar = compar;
    }

    /**
     * Returns the least element in this set greater than or equal to the given element, or null if there is no such element
     * @param el entering element
     * @return element greater than or equal el or null
     */

    public T ceiling(T el){
        int a = 0;
        if (compar.compare(el, arrList.get(arrList.size() - 1)) < 0) {
            return null;
        }
        else {
            for (int i = 0; i < arrList.size() - 1; i++){
                if (compar.compare(el, arrList.get(i)) >= 0) {
                    a = i;
                    break;
                }
            }
        }
        return arrList.get(a);
    }

    /**
     * Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
     * @param el entering element
     * @return element less than or equal el or null
     */

    public T floor(T el){
        int a = 0;
        if (compar.compare(el, arrList.get(0)) > 0) {
            return null;
        }
        else {
            for (int i = arrList.size() - 1; i > -1; i--){
                if (compar.compare(el, arrList.get(i)) <= 0) {
                    a = i;
                    break;
                }
            }
        }
        return arrList.get(a);
    }

    /**
     * Returns the least element in this set strictly greater than the given element, or null if there is no such element.
     * @param el entering element
     * @return least element strictly greater or null
     */

    public  T higher(T el){
        int a = 0;
        if (compar.compare(el, arrList.get(0)) > 0) {
            return null;
        }
        else {
            for (int i = 1; i < arrList.size(); i++){
                if (compar.compare(el, arrList.get(i)) > 0)
                    a = i;
            }
        }
        return arrList.get(a);
    }

    /**
     * Returns the least element in this set strictly less than the given element, or null if there is no such element.
     * @param el entering element
     * @return least element strictly less or null
     */

    public T lower(T el){
        int a = 0;
        if (compar.compare(el, arrList.get(arrList.size() - 1)) < 0) {
            return null;
        }
        else {
            for (int i = arrList.size() - 2; i < - 1; i--){
                if (compar.compare(el, arrList.get(i)) < 0)
                    a = i;
            }
        }
        return arrList.get(a);

    }

    /**
     * Returns a reverse order view of the elements contained in this set.
     * @return reverse navigable set
     */

    public MyNavigableSet<T> descendingSet(){
        ArrayList<T> a = new ArrayList<>();
        for (int i = arrList.size() - 1; i > -1; i--){
            a.add(arrList.get(i));
        }
        MyNavigableSet two = new MyNavigableSet(a, compar);
        return two;
    }

    /**
     * Returns an iterator over the elements in this set, in descending order.
     * @return reverse iterator
     */

    public Iterator<T> descendingIterator(){
        return new MyNavigableSetIterator(-1);
    }

    /**
     * Returns an iterator over the elements in this set, in ascending order.
     * @return iterator
     */

    @Override
    public Iterator<T> iterator() {
        return new MyNavigableSetIterator(1);
    }


    /**
     * Returns a view of the portion of this set whose elements are less than and equal to toElement
     * @param toElement which element counts
     * @return navigable set
     */

    @Override
    public MyNavigableSet<T> headSet(T toElement){
        int to = 0;
        MyNavigableSet<T> one = new MyNavigableSet<>(compar);

        for (T el: arrList){
            if (compar.compare(el, toElement) < 0){
                to = arrList.indexOf(el);
                break;
            }
        }

        for (int i = 0 ; i < to; i++){
            one.add(arrList.get(i));
        }

        return one;
    }

    /**
     * Return size of navigable set
     * @return size of navigable set
     */
    @Override
    public int size() {
        return arrList.size();
    }

    /**
     *
     * @return comparator
     */

    @Override
    public Comparator<? super T> comparator() {
        return compar;
    }


    /**
     *
     * @param fromElement which element counts
     * @param toElement from which element
     * @return
     */
    @Override
    public MyNavigableSet<T> subSet(T fromElement, T toElement) {
        MyNavigableSet<T> one = new MyNavigableSet<>(compar);
        int from = 0;
        int to = 0;

        for (T el: arrList){
            if (compar.compare(el, fromElement) > 0){
                from = arrList.indexOf(el);
                break;
            }
        }

        for (T el: arrList){
            if (compar.compare(el, toElement) < 0){
                to = arrList.indexOf(el);
                break;
            }
        }

        for (int i = to ; i < from; i++){
            one.add(arrList.get(i));
        }
        return one;
    }


    /**
     *
     * @param el add this element
     * @return true or false
     */
    public boolean add(T el){

        if (arrList.size() == 0){
            arrList.add(0, el);
            return true;
        }

        for (int i = 0; i < arrList.size(); i++){

            if (compar.compare(el, arrList.get(i)) == 0){
                return false;
            }

            if (compar.compare(el, arrList.get(i)) > 0){
                arrList.add(i, el);
                break;
            }
        }
        return true;
    }

    /**
     * Retrieves and removes the first (lowest) element, or returns null if this set is empty.
     * @return first element
     */
    public T pollFirst(){
        T a = arrList.get(0);
        arrList.remove(0);
        return a;
    }

    /**
     * Retrieves and removes the last (highest) element, or returns null if this set is empty.
     * @return last element
     */

    public T pollLast(){
        T a = arrList.get(arrList.size() - 1);
        arrList.remove(arrList.size() - 1);
        return a;
    }

    /**
     * Returns a view of the portion of this set whose elements are greater than or equal to fromElement.
     * @param fromElement which element counts
     * @return
     */

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        int from = 0;
        MyNavigableSet<T> one = new MyNavigableSet<>(compar);
        for (T el: arrList){
            if (compar.compare(el, fromElement) > 0){
                from = arrList.indexOf(el);
                break;
            }
        }

        for (int i = from ; i < arrList.size() - 1; i++){
            one.add(arrList.get(i));
        }
        return one;
    }

    /**
     *
     * @return first element
     */

    @Override
    public T first() {
        return arrList.get(0);
    }


    /**
     *
     * @return last element
     */
    @Override
    public T last() {
        return arrList.get(arrList.size() - 1);
    }


    /**
     *Removes from this set all of its elements that are contained
     * in the specified collection (optional operation).
     * If the specified collection is also a set, this operation effectively modifies
     * this set so that its value is the asymmetric set difference of the two sets.
     * @param
     * @return true or false
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean a = false;
        Iterator<? extends T> iter = (Iterator<? extends T>) c.iterator();
        while (iter.hasNext()){
            if(this.add(iter.next())){
                a = true;
            }
        }
        return a;
    }


    /**
     * Returns true if this set contains no elements.
     * @return
     */

    @Override
    public boolean isEmpty() {
        if (arrList.size() > 0){
            return true;
        }
        return false;
    }

    /**
     * Returns true if this set contains the specified element. More formally,
     * returns true if and only if this set contains an element
     * e such that (o==null ? e==null : o.equals(e)).
     * @param el
     * @return
     */

    @Override
    public boolean contains(Object el) {
        return arrList.contains(el);
    }

    /**
     * Returns an array containing all of the elements in this set.
     * If this set makes any guarantees as to what order its elements are returned
     * by its iterator, this method must return the elements in the same order.
     * @return
     */

    @Override
    public Object[] toArray() {
        return this.arrList.toArray();
    }

    /**
     * Returns an array containing all of the elements in this set;
     * the runtime type of the returned array is that of the specified array.
     * If the set fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this set.
     * @param arr
     * @param <T>
     * @return
     */

    @Override
    public <T> T[] toArray(T[] arr) {
        if (arr.length < arrList.size()){
            arr = (T[]) new Object[this.size()];
        }

        for (int i = 0; i < arrList.size() - 1; i++){
            arr[i] = (T) arrList.get(i);
        }

        return arr;
    }

    /**
     * Removes the specified element.
     * @param o
     * @return
     */

    @Override
    public boolean remove(Object o) {
        return arrList.remove(o);
    }

    /**
     * Returns true if this set contains all of the elements of the specified collection.
     * @param c
     * @return
     */

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> iter = c.iterator();

        while(iter.hasNext()){
            if (!this.contains(iter.next())){
                return false;
            }
        }

        return true;
    }

    /**
     * Add all elements
     * @param c
     * @return
     */

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Iterator<? extends T> iter = c.iterator();
        boolean a = false;
        while(iter.hasNext()){
            if (this.add(iter.next())){
                a = true;
            }
        }
        return a;
    }

    /**
     * Retains only the elements in this navigable set that are contained in the specified collection.
     * @param c
     * @return
     */

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean a = false;
        for (int i = 0;i < this.size(); i++){
            if (!c.contains(this.arrList.get(i))){
                this.remove(this.arrList.get(i));
                a = true;
            }
        }
        return a;
    }

    /**
     * Clear this navigable set
     */

    @Override
    public void clear() {
        arrList.clear();
    }



    private class MyNavigableSetIterator<T> implements Iterator<T>{
        private int cursor;
        private boolean notReverse = true;

        public MyNavigableSetIterator (int a){
            if (a > 0){
                this.cursor = 0;
            }
            else{
                this.cursor = arrList.size() - 1;
                notReverse = false;
            }
        }

        @Override
        public boolean hasNext() {
            if (notReverse){
                return (arrList.size() - cursor > 0);
            }
            else{
                return (cursor > 0);
            }
        }

        @Override
        public T next() {
            if (notReverse){
                cursor++;
                return (T) arrList.get(cursor - 1);
            }
            else{
                cursor--;
                return (T) arrList.get(cursor + 1);
            }
        }
    }
}