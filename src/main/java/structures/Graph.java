package structures;

public class Graph {

    public GraphNode[] nodes;

    public void print() {
        for (GraphNode node : nodes) {
            System.out.println("node: ");
            node.printNode();
        }
    }

    public void demarkGraph() {
        for (GraphNode node : nodes) {
            node.demark();
        }
    }
}
