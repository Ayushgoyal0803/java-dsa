/*
https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
 */

public class MergeSortedLists {



    // Complete the mergeLists function below.

    /*
     * For your reference:

     */
      static class SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;
          SinglyLinkedListNode(int data){
              this.data = data;
          }
      }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        SinglyLinkedListNode newNode ;
        if(head1.data < head2.data){
            newNode = new SinglyLinkedListNode(head1.data);
            head1 = head1.next;
        }
        else{
            newNode = new SinglyLinkedListNode(head2.data);
            head2 = head2.next;
        }

        SinglyLinkedListNode head = newNode;

        while(head1 != null && head2 !=null){

            if(head1.data < head2.data){
                newNode.next = head1;
                head1 = head1.next;
            }
            else{
                newNode.next = head2;
                head2 = head2.next;
            }
            newNode  = newNode.next;
        }

        if(head1 != null){
            newNode.next = head1;
        }
        else{
            newNode.next = head2;
        }

        return head;
    }


}
