package org.shadhelper.Sorts_and_other_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemA {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            bufferedReader.readLine();
            int result = countSteps(bufferedReader.readLine());
            System.out.println(result);
        }
    }

    static int countSteps(String s) {
        int steps = 0;
        char startChar = '0';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != startChar) {
                steps++;
                startChar = s.charAt(i);
            }
        }
        return steps;
    }
}
