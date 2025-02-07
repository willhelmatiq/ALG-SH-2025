package org.shadhelper.Hello_world_and_some_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimalInterdependentSimplicity {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        processList(list);
    }

    static void processList(List<int[]> list) {
        StringBuilder result = new StringBuilder();
        for (int[] params : list) {
            result.append(calc(params)).append("\n");
        }
        System.out.println(result);
    }

    static String calc(int[] params) {
        if (params[0] == params[1] && params[0] == 1) {
            return "1";
        }
        return String.valueOf(params[1] - params[0]);
    }
}
