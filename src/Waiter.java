/*
https://www.hackerrank.com/challenges/waiter/problem
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static List<Integer> generatePrimes(int q) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        while (primes.size() < q) {
            boolean isPrime = true;
            for (int p : primes) {
                if (num % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.add(num);
            num++;
        }
        return primes;
    }

    public static List<Integer> waiter(List<Integer> num, int q) {
        // Write your code here
        Stack<Integer> A = new Stack<>();
        for (int i = 0; i < num.size(); i++) {
            A.push(num.get(i));
        }

        List<Integer> primes = generatePrimes(q);

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            Stack<Integer> B = new Stack<>();
            Stack<Integer> nextA = new Stack<>();

            int prime = primes.get(i);

            while (!A.isEmpty()) {
                int plate = A.pop();

                if (plate % prime == 0) {
                    B.push(plate);
                } else {
                    nextA.push(plate);
                }
            }

            while (!B.isEmpty()) {
                answer.add(B.pop());
            }

            A = nextA;
        }

        while (!A.isEmpty()) {
            answer.add(A.pop());
        }

        return answer;
    }
}

public class Waiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
