package org.shadhelper.Heap_Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemC {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            bufferedReader.readLine();
            int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(countSameDiff(arr));
        }
    }

    static long countSameDiff(int[] arr) {
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            int diffVal = arr[0] - arr[i];
            int diffPoints = diffVal + (i);
            if (map.containsKey(diffPoints)) {
                map.put(diffPoints, map.get(diffPoints) + 1);
            } else {
                map.put(diffPoints, 1L);
                if (diffPoints == 0) {
                    map.put(diffPoints, map.get(diffPoints) + 1);
                }
            }
        }
        long count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > 1) {
                count += (map.get(key) * (map.get(key) - 1)) / 2;
            }
        }
        return count;
    }
}
