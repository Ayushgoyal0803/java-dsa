/*
https://www.hackerrank.com/challenges/two-characters/problem
 */
import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static boolean isAlternating(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int alternate(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        int maxLength = 0;
        List<Character> charsList = new ArrayList<>(uniqueChars);

        for (int i = 0; i < charsList.size(); i++) {
            for (int j = i + 1; j < charsList.size(); j++) {
                char a = charsList.get(i);
                char b = charsList.get(j);
                StringBuilder filtered = new StringBuilder();

                for (char c : s.toCharArray()) {
                    if (c == a || c == b) {
                        filtered.append(c);
                    }
                }

                if (isAlternating(filtered.toString())) {
                    maxLength = Math.max(maxLength, filtered.length());
                }
            }
        }

        return maxLength;
    }

}

public class TwoCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
