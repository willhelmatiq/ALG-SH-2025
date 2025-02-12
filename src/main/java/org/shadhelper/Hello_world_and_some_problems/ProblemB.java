package org.shadhelper.Hello_world_and_some_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            processInput(bufferedReader.readLine(), result);
        }
        System.out.println(result);
    }

    static void processInput(String s, StringBuilder result) {
        int countOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOnes++;
            }
        }
        result.append(countOnes).append("\n");
    }
}
