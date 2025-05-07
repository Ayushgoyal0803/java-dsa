/*
https://www.hackerrank.com/challenges/count-triplets-1/problem
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {
    static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        Map<Long,Long> leftMap = new HashMap<>();
        Map<Long,Long> rightMap = new HashMap<>();

        for(long n : arr){
            rightMap.put(n,rightMap.getOrDefault(n,0L)+1);
        }

        for(long num : arr){
            rightMap.put(num, rightMap.get(num)-1);

            if(num % r==0){
                long left = num / r;
                long right = num * r;

                long leftCount = leftMap.getOrDefault(left, 0L);
                long rightCount = rightMap.getOrDefault(right, 0L);

                count += leftCount * rightCount;
            }

            // Add current number to leftMap
            leftMap.put(num, leftMap.getOrDefault(num, 0L) + 1);
        }

        return count;

    }
}
