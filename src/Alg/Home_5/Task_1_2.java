package Alg.Home_5;

import java.util.Arrays;

public class Task_1_2 {
    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##############################\n");

        int[] testRec = {7, 12, 33, 14, 17, 88, 104, 376, 3, 1, 40, 5};
        int[] testNoRec = {7, 12, 33, 14, 17, 88, 104, 376, 3, 40, 5};

        //Recursion
        sortMerge(testRec);
        System.out.println(Arrays.toString(testRec));

    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k] = l[i];
                k++;
                i++;
            }
            else {
                a[k] = r[j];
                k++;
                j++;
            }
        }

        while (i < left) {
            a[k] = l[i];
            k++;
            i++;
        }

        while (j < right) {
            a[k] = r[j];
            k++;
            j++;
        }

    }

    public static void sortMerge(int[] a) {
        int n = a.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        sortMerge(l);
        sortMerge(r);

        merge(a, l, r, mid, n - mid);
    }

}
