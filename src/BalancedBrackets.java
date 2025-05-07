/*
http://hackerrank.com/challenges/balanced-brackets/problem
 */

import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{' ){
                st.push(c);
            }
            else if(c == ')'){
                if(!st.isEmpty()&& st.peek()=='('){
                    st.pop();
                }
                else{
                    return "NO";
                }
            }
            else if(c == ']'){
                if(!st.isEmpty()&& st.peek()=='['){
                    st.pop();
                }
                else{
                    return "NO";
                }
            }
            else if(c == '}'){
                if(!st.isEmpty()&& st.peek()=='{'){
                    st.pop();
                }
                else{
                    return "NO";
                }
            }
        }

        if(!st.isEmpty()) return "NO";
        return "YES";


    }
}
