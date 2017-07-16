package java_programs;
import java.util.*;

public class SHORTEST_PATH_LENGTHS_TEST {
    Map<List<Integer>, Integer> graph3 = new HashMap<>();
        graph3.put(new ArrayList<Integer>(Arrays.asList(1,3)),3);
        graph3.put(new ArrayList<Integer>(Arrays.asList(1,6)),5);
        graph3.put(new ArrayList<Integer>(Arrays.asList(3,2)),-2);
        graph3.put(new ArrayList<Integer>(Arrays.asList(3,4)),7);
        graph3.put(new ArrayList<Integer>(Arrays.asList(3,5)),4);
        graph3.put(new ArrayList<Integer>(Arrays.asList(4,5)),-5);
        graph3.put(new ArrayList<Integer>(Arrays.asList(5,6)),-1);

    SHORTEST_PATH_LENGTHS path2 = new SHORTEST_PATH_LENGTHS();
    Map<List<Integer>, Integer> length_by_path = new HashMap<>();
    length_by_path =path2.shortest_path_lengths(6,graph3);
    for(List<Integer> edge :length_by_path.keySet())
    {
        for (Integer i : edge) {
            System.out.printf(" Node: %d ", i);
        }
        System.out.printf(" %d\n", length_by_path.get(edge));
    }
}