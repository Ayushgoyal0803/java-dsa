/*
https://leetcode.com/problems/design-browser-history/?envType=problem-list-v2&envId=design
 */

import java.util.Stack;

public class DesignBrowserHistory {
    // firstly done wit stacks
    class BrowserHistory {
        Stack<String> fwd = new Stack<>();
        Stack<String> back = new Stack<>();

        public BrowserHistory(String homepage) {
            back.push(homepage);
        }

        public void visit(String url) {
            back.push(url);
            fwd.clear();
        }

        public String back(int steps) {
            while(back.size() > 1 && steps-- > 0){
                fwd.push(back.pop());
            }

            return back.peek();
        }

        public String forward(int steps) {
            while(!fwd.isEmpty() && steps--> 0){
                back.push(fwd.pop());
            }

            return back.peek();
        }
    }

    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */

    // secondly done wit LinkedList
    /*
    class BrowserHistory {
        private class Node {
            String url;
            Node prev, next;

            Node(String url) {
                this.url = url;
            }
        }

        private Node curr;

        public BrowserHistory(String homepage) {
            curr = new Node(homepage);
        }

        public void visit(String url) {
            Node newNode = new Node(url);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }

        public String back(int steps) {
            while (curr.prev != null && steps-- > 0) {
                curr = curr.prev;
            }
            return curr.url;
        }

        public String forward(int steps) {
            while (curr.next != null && steps-- > 0) {
                curr = curr.next;
            }
            return curr.url;
        }
    }

     */

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
}
