package java_programs;
import java.util.*;

class TOPOLOGICAL_ORDERING {
    public static SortedSet<Node> topological_ordering (List<Node> directedGraph) {
        SortedSet<Node> orderedNodes = new TreeSet<>();
        for (Node node : directedGraph) {
            if (node.getPredecessor().isEmpty()) {
                orderedNodes.add(node);
            }
        }

        for (Node node : orderedNodes) {
            for (Node nextNodes : node.getSuccessors()) {
                if (orderedNodes.containsAll(nextNodes.getSuccessors())) {
                    orderedNodes.add(nextNodes);
                }
            }
        }
        return orderedNodes;
    }
}
