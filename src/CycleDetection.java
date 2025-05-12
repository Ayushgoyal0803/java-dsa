/*
https://www.hackerrank.com/challenges/three-month-preparation-kit-detect-whether-a-linked-list-contains-a-cycle/problem
 */

public class CycleDetection {
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}
