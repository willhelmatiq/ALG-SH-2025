package org.shadhelper.Hello_world_and_some_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemF {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            String[] params = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            List<int[]> cadsList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                cadsList.add(Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
            }
            getSequence(cadsList).forEach(element -> System.out.print(element + " "));
            System.out.println();
        }
    }

    static List<Integer> getSequence(List<int[]> cadsList) {
        int n = cadsList.size();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }

        indices.sort(Comparator.comparingInt(i -> cadsList.get(i)[0] % n));

        if (!checkCardsList(cadsList, indices)) {
            return Collections.singletonList(-1);
        }
        for (int i = 0; i < n; i++) {
            indices.set(i, indices.get(i) + 1);
        }
        return indices;
    }

    static boolean checkCardsList(List<int[]> cadsList, List<Integer> indices) {
        int n = cadsList.size();
        int m = cadsList.getFirst().length;
        for (int i = 0; i < n; i++) {
            int[] cards = cadsList.get(indices.get(i));
            for (int j = 0; j < m; j++) {
                if (cards[j] % n != i) {
                    return false;
                }
            }
        }
        return true;
    }

}
