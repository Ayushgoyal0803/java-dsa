/*
https://www.hackerrank.com/challenges/tree-top-view/problem
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TreeTopView {


    class Node
    {
        int data;
        Node left;
        Node right;
    }

    static class Pair{
        Node node;
        int dis;

        Pair(Node node,int dis){
            this.node = node;
            this.dis = dis;
        }
    }

    public static void topView(Node root) {
        if(root == null){
            return;
        }

        Queue<Pair> level = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();

        level.add(new Pair(root,0));

        while(!level.isEmpty()){
            Pair current = level.poll();
            Node currNode = current.node;
            int dis = current.dis;

            // Add the first node encountered at this HD
            if (!map.containsKey(dis)) {
                map.put(dis, currNode.data);
            }

            if (currNode.left != null) {
                level.add(new Pair(currNode.left, dis - 1));
            }

            if (currNode.right != null) {
                level.add(new Pair(currNode.right, dis + 1));
            }
        }

        for (int val : map.values()) {
            System.out.print(val + " ");
        }

    }
}
