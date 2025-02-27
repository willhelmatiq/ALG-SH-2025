package org.shadhelper.Sorts_and_other_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            bufferedReader.readLine();
            int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            getResult(arr);
        }
    }

    static void getResult(int[] arr) {
        int[] numberFrequency = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numberFrequency[arr[i] - 1]++;
        }
        int startMax = 0;
        int maxLengthOfUniqueElements = 0;
        int startCurr = 0;
        int currLengthOfUniqueElements = 0;
        for (int i = 0; i < arr.length; i++) {
            if (numberFrequency[arr[i] - 1] == 1) {
                currLengthOfUniqueElements++;
            } else {
                if (currLengthOfUniqueElements > maxLengthOfUniqueElements) {
                    maxLengthOfUniqueElements = currLengthOfUniqueElements;
                    startMax = startCurr;
                }
                currLengthOfUniqueElements = 0;
                startCurr = i + 1;
            }
        }
        if (currLengthOfUniqueElements > maxLengthOfUniqueElements) {
            maxLengthOfUniqueElements = currLengthOfUniqueElements;
            startMax = startCurr;
        }
        if (maxLengthOfUniqueElements == 0) {
            System.out.println(maxLengthOfUniqueElements);
        } else {
            System.out.println(startMax + 1 + " " + (startMax + maxLengthOfUniqueElements));
        }
    }
}
