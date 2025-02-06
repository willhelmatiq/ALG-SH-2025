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
        System.out.println("rqweq");
    }

    static void processList(List<int[]> list) {
        
    }
}
