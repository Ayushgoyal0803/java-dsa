/*
https://www.hackerrank.com/challenges/two-strings/problem
 */

/*
---> we can solve this question will list also,but it will give TLE because searching in list take O(n) operations making TC O(n*m)
     but in set searching in a set take TC of O(1) on avg
 */

import java.util.HashSet;
import java.util.Set;

public class CommonSubstring {
    public static String twoStrings(String s1, String s2) {
        // Write your code here
        Set<Character> s = new HashSet<>();

        for(char c : s1.toCharArray()){
            s.add(c);
        }
        for(char c : s2.toCharArray()){
            if(s.contains(c)){
                return "YES";
            }
        }

        return "NO";

        /*
        by frequency array

            int[] freq = new int[26];

            for(char c: s1.toCharArray()){
                freq[c -'a']++;
            }

            for(char c: s2.toCharArray()){
                if(freq[c] >0){
                    return "YES";
                }
            }

            return "NO";

         */


    }
}
