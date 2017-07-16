package java_programs;
import java.util.*;

public class JavaTest {
    public static void main(String[] args) throws Exception {
        WeightedEdge edge1 = new WeightedEdge(node1, node2, 10);
        WeightedEdge edge2 = new WeightedEdge(node2, node3, 15);
        WeightedEdge edge3 = new WeightedEdge(node3, node4, 10);
        WeightedEdge edge4 = new WeightedEdge(node1, node4, 10);

        List<WeightedEdge> graph = new ArrayList<>(Arrays.asList(edge1, edge2, edge3, edge4));
        MINIMUM_SPANNING_TREE mst = new MINIMUM_SPANNING_TREE();

        Set<WeightedEdge> minspantree = new HashSet<>();
        minspantree.addAll(mst.minimum_spanning_tree(graph));

        for (WeightedEdge edge : minspantree) {
            System.out.printf("u: %s, v: %s, weight: %d\n", edge.node1.getValue(), edge.node2.getValue(), edge.weight);
        }
    }
}