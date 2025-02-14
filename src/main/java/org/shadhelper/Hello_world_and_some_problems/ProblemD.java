package org.shadhelper.Hello_world_and_some_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemD {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            bufferedReader.readLine();
            long[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            System.out.println(processArr(arr));
        }
    }

    static long processArr(long[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        long maxVal = sumOfArr(arr);
        int shift = 1;
        long[] tempArr = getNextArr(arr);
        while (shift < arr.length){
            long tempSum = sumOfArr(tempArr);
            maxVal = Math.max(maxVal, Math.abs(tempSum));
            tempArr = getNextArr(tempArr);
            shift ++;
        }
        return maxVal;
    }

    static long[] getNextArr(long[] arr) {
        long[] arr1 = new long[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            arr1[i] = arr[i + 1] - arr[i];
        }
        return arr1;
    }

    static long sumOfArr(long[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
