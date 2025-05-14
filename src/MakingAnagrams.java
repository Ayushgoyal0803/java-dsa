/*
* https://www.hackerrank.com/challenges/making-anagrams/problem
*/

public class MakingAnagrams {
    public static int makingAnagrams(String s1, String s2) {
        // Write your code here
        int d = 0;

        int[] freq = new int[26];

        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i) - 'a']++;
        }

        for(int i=0;i<s2.length();i++){
            freq[s2.charAt(i) - 'a']--;
        }

        for(int i=0;i<26;i++){
            d += Math.abs(freq[i]);
        }

        return d;

    }
}

