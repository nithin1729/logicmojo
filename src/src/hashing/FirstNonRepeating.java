package hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
    class Node {
        char data;
        Node prev;
        Node next;

        Node(char data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node last;

    private void insertInDLL(char ch) {
        if(head==null) {
            head = last = new Node(ch);
            return;
        }
        last.next = new Node(ch);
        last.next.prev = last;
        last = last.next;
    }

    private void removeInDLL(Node node) {
        if(head == last && head == node) {
            head = last = null;
            return;
        }
        if(head == node) {
            head = head.next;
            head.prev = null;
            return;
        }

        if(last == node) {
            last = last.prev;
            last.next = null;
            return;
        }

        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public String solve(String A) {
        head = null;
        last = null;
        Map<Character, Integer> isPresent = new HashMap<>();
        Map<Character, Node> nodes = new HashMap<>();

        char[] ans = new char[A.length()];
        for(int i=0; i<A.length(); i++) {
            // insert A.get(i);
            if(!isPresent.containsKey(A.charAt(i))) {
                isPresent.put(A.charAt(i), 1);
                insertInDLL(A.charAt(i));
                nodes.put(A.charAt(i), last);
            }
            else if(isPresent.get(A.charAt(i)) == 1) {
                isPresent.put(A.charAt(i), 2);
                removeInDLL(nodes.get(A.charAt(i)));
                nodes.remove(A.charAt(i));
            }

            if(head==null) ans[i] = '#';
            else ans[i] = head.data;
        }
        return new String(ans);
    }
}
