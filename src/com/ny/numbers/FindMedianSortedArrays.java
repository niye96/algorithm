package com.ny.numbers;


import java.util.Random;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length >= B.length) {
            int[] temp;
            temp = B;
            B = A;
            A = temp;
        }
        int iMin = 0;
        int iMax = A.length;
        int halflen = (A.length + B.length + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMax + iMin) / 2;
            int j = halflen - i;

//            //由于i会跳动，导致j可能超过
//            if (i > A.length) {
//                i = A.length;
//                j = halflen - i;
//            }
//            if (i < 0) {
//                i = 0;
//                j = halflen - i;
//            }
            if (i < A.length && A[i] < B[j - 1])
                iMin = i + 1;
            else if (i > 0 && B[j] < A[i - 1])
                iMax = i - 1;
            else {
                int left;
                if (i == 0) left = B[j - 1];
                else if (j == 0) left = A[i - 1];
                else left = Math.max(A[i - 1], B[j - 1]);
                if ((A.length + B.length) % 2 == 1) return left;

                int right;
                if (i == A.length) right = B[j];
                else if (j == B.length) right = A[i];
                else right = Math.min(A[i], B[j]);
                return (left + right) / 2.0;
            }
        }
        return 0;
    }

    private static int binarySearch(int[] a, int lo, int hi, int num) {
        if (a.length == 0) return -1;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (a[mid] > num) hi = mid - 1;
            else if (a[mid] < num) lo = mid + 1;
            else return mid;
        }
        return hi;
//        if(lo > hi) return hi;
//        int mid = (lo + hi) / 2;
//        if(a[mid] > num) return binarySearch(a, lo, mid - 1, num);
//        else if(a[mid] < num) return binarySearch(a, mid + 1, hi, num);
//        else return mid;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        int[] b = new int[]{4, 4, 4, 4, 4, 4, 7, 8};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
