package java_programs;
import java.util.*;

public class REVERSED_LINKED_LIST_TEST {
    public static void main(String[] args) throws Exception {
        Node node1 = new Node("1");
        Node node2 = new Node("2", node1);
        Node node3 = new Node("3", node2);
        Node node4 = new Node("4", node3);
        Node node5 = new Node("5", node4);

        REVERSE_LINKED_LIST rll = new REVERSE_LINKED_LIST();

        Node result = rll.reverse_linked_list(node5);

        if (result.getValue() == node1.getValue()) {
            System.out.println("Reversed!");
        }

        while (result != null) {
            System.out.printf("%s ", result.getValue());
            result = result.getSuccessor();
        }
        System.out.println();
    }
}