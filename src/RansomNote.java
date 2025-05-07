/*
* https://www.hackerrank.com/challenges/ctci-ransom-note/problem
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RansomNote {
    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        Map<String,Integer> mp = new HashMap<>();

        for(String s : magazine){
            mp.put(s, mp.getOrDefault(s, 0)+1);
        }

        for(String s : note){
            if(!mp.containsKey(s) || mp.get(s)==0){
                System.out.println("No");
                return;
            }
            mp.put(s, mp.get(s)-1);

        }

        System.out.println("Yes");
    }
}
