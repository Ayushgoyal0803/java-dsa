/*
https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
 */

public class InsertAtPosition {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data){
            this.data = data;
        }
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (position == 0) {
            newNode.next = llist;
            return newNode;
        }
        int cnt = 0;

        SinglyLinkedListNode temp = llist;

        while(temp.next != null && cnt < position-1){
            temp = temp.next;
            cnt++;
        }

        if(temp != null){
            newNode.next = temp.next;
            temp.next = newNode;
        }

        return llist;

    }
}
