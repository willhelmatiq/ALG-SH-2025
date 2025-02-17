package org.shadhelper.Hello_world_and_some_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProblemH {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(getMaxFibNum(arr));
        }

    }

    static int getMaxFibNum(int[] arr) {
        int s12 = arr[0] + arr[1];
        int s23 = arr[2] - arr[1];
        int s34 = arr[3] - arr[2];
        Set<Integer> set = new HashSet<>();
        set.add(s12);
        set.add(s23);
        set.add(s34);
        return 4 - set.size();
    }
}
