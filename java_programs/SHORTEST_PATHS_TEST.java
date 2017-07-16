
package java_programs;
import java.util.*;

public class SHORTEST_PATHS_TEST {
    public static void main(String[] args) throws Exception {
        Map<List<String>, Integer> graph2 = new HashMap<>();
        graph2.put(new ArrayList<String>(Arrays.asList("A", "C")), 3);
        graph2.put(new ArrayList<String>(Arrays.asList("A", "F")), 5);
        graph2.put(new ArrayList<String>(Arrays.asList("C", "B")), -2);
        graph2.put(new ArrayList<String>(Arrays.asList("C", "D")), 7);
        graph2.put(new ArrayList<String>(Arrays.asList("C", "E")), 4);
        graph2.put(new ArrayList<String>(Arrays.asList("D", "E")), -5);
        graph2.put(new ArrayList<String>(Arrays.asList("E", "F")), -1);

        SHORTEST_PATHS path = new SHORTEST_PATHS();
        Map<String, Integer> weight_by_node = new HashMap<String, Integer>();
        weight_by_node = path.shortest_paths("A", graph2);
        for (String node : weight_by_node.keySet()) {
            System.out.printf("Node: %s, distance: %d\n", node, weight_by_node.get(node));
        }
    }
}