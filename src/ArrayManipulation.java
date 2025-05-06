/*
* https://www.hackerrank.com/challenges/crush/problem
*/

import java.util.List;

public class ArrayManipulation {
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        long max = -1;
        long[] arr = new long[n+2];
        for(List<Integer> q : queries ){
            arr[q.get(0)] += q.get(2);
            arr[q.get(1)+1] -= q.get(2);
        }


        long sum = arr[0];
        for(int i=1;i<n+2;i++){
            sum += arr[i];
            max = Math.max(sum, max);
        }

        return max;
    }
}
