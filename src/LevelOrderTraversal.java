/*
https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
 */

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    class Node {
        int data;
        Node left;
        Node right;
    }

    public static void levelOrder(Node root) {

        Queue<Node> level = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            int size = level.size();

            for(int i=0;i<size;i++){
                Node temp = level.poll();
                System.out.print(temp.data + " " );
                if(temp.left != null) level.add(temp.left);
                if(temp.right != null) level.add(temp.right);
            }
        }


    }


}
