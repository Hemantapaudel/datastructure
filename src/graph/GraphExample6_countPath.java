package graph;

public class GraphExample6_countPath {

    public static void main(String[] args) {

        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 0);

        int s = 0, d = 3;
        System.out.println(g.countPaths(s, d));
    }
}
