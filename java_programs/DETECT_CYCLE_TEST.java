package java_programs;
import java.util.*;

public class DETECT_CYCLE_TEST {
    public static void main(String[] args) throws Exception {
        Node node1 = new Node("1");
        Node node2 = new Node("2", node1);
        Node node3 = new Node("3", node2);
        Node node4 = new Node("4", node3);
        Node node5 = new Node("5", node4);

        node1.setSuccessor(node2);

        DETECT_CYCLE dc = new DETECT_CYCLE();

        if (dc.detect_cycle(node5)) {
            System.out.println("Cycle detected!");
        } else {
            System.out.println("Cycle not detected!");
        }
    }
}