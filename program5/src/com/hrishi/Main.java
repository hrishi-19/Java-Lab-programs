package com.hrishi;

import java.util.Random;
import java.util.Scanner;
class MergeSort {
    static int comparisons = 0;
    static int[] arr;

    static void mergeSort(int low, int high) {
        if (low < high) {
            comparisons += 1;
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    static void merge(int low, int mid, int high) {
        int n = high - low + 1;
        int[] t_arr = new int[n];
        int i = low, j = mid + 1, k = 0;
        while ((i <= mid) && (j <= high)) {
            comparisons += 2;
            if (arr[i] <= arr[j]) {
                comparisons += 1;
                t_arr[k] = arr[i];
                i++;
            } else {
                comparisons += 1;
                t_arr[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            comparisons += 1;
            t_arr[k] = arr[i];
            i++;
            k++;
        }
        while (j <= high) {
            comparisons += 1;
            t_arr[k] = arr[j];
            j++;
            k++;
        }
        for (k = 0; k < n; k++) {
            comparisons += 1;
            arr[low + k] = t_arr[k];
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n value");
        n = scanner.nextInt();
        arr = new int[n];
        int ch;
        System.out.println("Merge Sort");
        System.out.println("1. Best Case");
        System.out.println("2. Average Case");
        System.out.println("3. Worst Case");
        ch = scanner.nextInt();
        switch (ch) {
            case 1:
                for (int i = 0; i < n; i++) {
                    arr[i] = i + 1;
                }
                break;
            case 2:
                Random random = new Random();
                for (int i = 0; i < n; i++) {
                    arr[i] = random.nextInt();
                }
                break;
            case 3:
                for (int i = 0; i < n; i++) {
                    arr[i] = n - i;
                }

                break;
        }
        long start = System.nanoTime();
        mergeSort(0, n - 1);
        long end = System.nanoTime();
        System.out.println("Sorted Array");
        System.out.println("Time Taken:" + (end - start));
        System.out.println("Comparisons: " + comparisons);
    }
}
