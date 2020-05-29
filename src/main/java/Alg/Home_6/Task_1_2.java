package Alg.Home_6;

import java.util.Arrays;

public class Task_1_2 {
    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##############################\n");

        int[] testRec = {7, 12, 33, 14, 17, 88, 104, 376, 3, 1, 40, 5};
        int[] testNotRec = {7, 12, 33, 14, 17, 88, 104, 376, 3, 1, 40, 5};


        mergeSortRec(testRec);
        System.out.println(Arrays.toString(testRec));
        //[1, 3, 5, 7, 12, 14, 17, 33, 40, 88, 104, 376]

        mergeSortNotRec(testNotRec);
        System.out.println(Arrays.toString(testNotRec));
        //[1, 3, 5, 7, 12, 14, 17, 33, 40, 88, 104, 376]

    }

    public static void mergeSortRec(int[] arr) {
        if (arr.length < 2){
            return;
        }
        int arrLength = arr.length;
        int middle = arrLength / 2;
        int[] l = Arrays.copyOfRange(arr, 0, middle);
        int[] r = Arrays.copyOfRange(arr, middle, arrLength);
        mergeSortRec(l);
        mergeSortRec(r);
        merge(arr, l, r);
    }

    public static void merge(int[] arr, int[] l, int[] r) {
        int left = l.length;
        int right = r.length;
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            }
            else {
                arr[k++] = r[j++];
            }
        }
        while (i < left) {
            arr[k++] = l[i++];
        }
        while (j < right) {
            arr[k++] = r[j++];
        }
    }

    public static void mergeSortNotRec(int[] arr) {
        int len = arr.length;
        int n = 1;
        int sizeBuf;
        int sizeTwo;
        int[] arr2 = new int[arr.length];
        while (n < len) {
            sizeBuf = 0;
            while (sizeBuf < len) {
                if (sizeBuf + n >= len){
                    break;
                }
                sizeTwo = (sizeBuf + n * 2 > len) ? (len - (sizeBuf + n)) : n;
                merge(arr2, Arrays.copyOfRange(arr, sizeBuf, sizeBuf + n), Arrays.copyOfRange(arr, sizeBuf + n, sizeBuf + n + sizeTwo));
                for (int i = 0; i < n + sizeTwo; i++){
                    arr[sizeBuf + i] = arr2[i];
                }
                sizeBuf = sizeBuf + n * 2;
            }
            n = n * 2;
        }
    }

}
