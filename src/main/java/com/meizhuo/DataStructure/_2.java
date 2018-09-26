package com.meizhuo.DataStructure;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class _2 {

    public int[] and(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] > B[j]) {
                C[k] = B[j];
                k++;
                j++;
            } else {
                C[k] = A[i];
                k++;
                i++;
            }
        }
        if (A.length < B.length) {
            while (j < B.length) {
                C[k] = B[j];
                k++;
                j++;
            }
        } else {
            while (i < A.length) {
                C[k] = A[i];
                k++;
                i++;
            }
        }
        return C;
    }


    @Test
    public void test() {
        int A[] = {5, 7, 9, 11, 17, 20, 55, 66, 78, 88, 99};
        int B[] = {1, 4, 8, 10, 13, 21, 33, 44,88};
        int C[] = and(A, B);
        System.out.println(Arrays.toString(C));
    }

}
