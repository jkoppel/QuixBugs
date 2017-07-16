package java_programs;
import java.util.*;

public class DEPTH_FIRST_SEARCH_TEST {
    public static void main(String[] args) throws Exception {
        Node station1 = new Node("Westminster", new ArrayList<Node>());
        Node station2 = new Node("Waterloo", new ArrayList<Node>(Arrays.asList(station1)));
        Node station3 = new Node("Trafalgar Square", new ArrayList<Node>(Arrays.asList(station1, station2)));
        Node station4 = new Node("Canary Wharf", new ArrayList<Node>(Arrays.asList(station2, station3)));
        Node station5 = new Node("London Bridge", new ArrayList<Node>(Arrays.asList(station4, station3)));
        Node station6 = new Node("Tottenham Court Road", new ArrayList<Node>(Arrays.asList(station5, station4)));

        DEPTH_FIRST_SEARCH dfs = new DEPTH_FIRST_SEARCH();

        if (dfs.depth_first_search(station6, station1))
            System.out.println("Path Found!");
        else
            System.out.println("Path Not Found!");
    }
}