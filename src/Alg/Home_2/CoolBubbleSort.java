package Alg.Home_2;

public class CoolBubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean a = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] - arr[j+1] > 0) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    a = true;
                }
            }
            if (!a){
                break;
            }
        }
    }
}
