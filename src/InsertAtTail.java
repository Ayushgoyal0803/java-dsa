/*
https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
 */

public class InsertAtTail {


    // Complete the insertNodeAtTail function below.

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data){
            this.data = data;
        }
    }

    static SinglyLinkedListNode temp;
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(head == null){
            head = newNode;
            temp = head;
            return head;
        }

        temp.next = newNode;
        temp = temp.next;

        return head;
    }


}
