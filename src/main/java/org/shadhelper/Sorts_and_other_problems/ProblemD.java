package org.shadhelper.Sorts_and_other_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemD {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            String[] params = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int[][] map = new int[n][m];
            for (int j = 0; j < n; j++) {
                map[j] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            System.out.println(countStepNumber(map));
        }
    }

    static int countStepNumber(int[][] map) {
        Map<Integer, Integer> minStepMap = new HashMap<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int currElement = map[i][j];
                if (currElement != -1) {
                    minStepMap.putIfAbsent(currElement, 1);
                    List<int[]> straightMoves = generateStraightMoves(map, i, j, currElement);
                    if (!straightMoves.isEmpty()) {
                        minStepMap.put(currElement, 2);
                    }
                }

            }
        }
        List<Integer> list = minStepMap.keySet().stream().sorted(Comparator.comparingInt(minStepMap::get)).toList();
        int steps = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            steps += minStepMap.get(list.get(i));
        }
        return steps;
    }

    static List<int[]> generateStraightMoves(int[][] map, int i, int j, int currElement) {
        List<int[]> straightMoves = new ArrayList<>();
        if (i < map.length - 1 && map[i + 1][j] == currElement) {
            straightMoves.add(new int[]{i + 1, j});
        }
        if (j < map[0].length - 1 && map[i][j + 1] == currElement) {
            straightMoves.add(new int[]{i, j + 1});
        }
        return straightMoves;
    }

}
