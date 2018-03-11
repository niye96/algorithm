package com.ny.array;

/**
 * @Author: ny
 * @Date: Created in 14:42 2018/3/11 0011
 */
public class Searcha2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int i = 0, j = m * n - 1;
        int mid;
        while (i <= j) {
            mid = (i + j) / 2;
            int a = mid / n, b = mid % n;
            if (target < matrix[a][b]) j = mid - 1;
            else if (target > matrix[a][b]) i = mid + 1;
            else return true;
        }
        return false;
//
//        int i = 0, j = m - 1;
//        int mid = 0;
//        while(i <= j){
//            mid = (i + j) / 2;
//            if(target < matrix[mid][0]) j =  mid - 1;
//            else if(target > matrix[mid][0]) i = mid + 1;
//            else return true;
//        }
//        mid = i;i = 0; j = n - 1;
//        if(mid > 0) mid --;
//        int mid1;
//        while(i <= j){
//            mid1 = (i + j) / 2;
//            if(target < matrix[mid][mid1]) j = mid1 - 1;
//            else if(target > matrix[mid][mid1]) i = mid1 + 1;
//            else return true;
//        }
//        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 34));
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 11));
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 12));
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 51));
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, -1));
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 16));
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 6));
        System.out.println(searchMatrix(new int[][]{
                {1}
        }, 1));
        System.out.println(searchMatrix(new int[][]{
                {1}
        }, 2));
        System.out.println(searchMatrix(new int[][]{
                {1}
        }, -1));
        System.out.println(searchMatrix(new int[][]{

        }, -1));
        System.out.println(searchMatrix(new int[][]{
                {}
        }, -1));
    }
}
