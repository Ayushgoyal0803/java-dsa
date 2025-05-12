/*
https://www.hackerrank.com/challenges/tree-huffman-decoding
 */
public class HuffmanDecoding {

	class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }

    void decode(String s, Node root) {
        StringBuilder ans = new StringBuilder();

        Node curr = root;

        for(int i=0;i<s.length();i++){
            curr = s.charAt(i) == '0'?curr.left:curr.right;
            if(curr.left == null && curr.right == null){
                ans.append(curr.data);
                curr = root;
            }
        }
        System.out.println(ans.toString());
    }


}
