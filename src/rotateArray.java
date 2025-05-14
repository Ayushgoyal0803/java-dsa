/**
 * https://www.hackerrank.com/challenges/array-left-rotation/problem?isFullScreen=true
**/

import java.util.List;

public class rotateArray {
    private static List<Integer> reverse(List<Integer> arr, int start, int end){
        while(start < end){
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }

        return arr;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here

        arr = reverse(arr,0,d-1);
        arr = reverse(arr, d, arr.size()-1);
        arr = reverse(arr, 0, arr.size()-1);

        return arr;
    }
}
