package structures;

import java.util.Objects;

public class GraphNode {

    public Integer value;
    public GraphNode[] nodes;

    public boolean marked = false;
    public boolean markedsource = false;
    public boolean markedtarget = false;

    public GraphNode(Integer value) {
        this.value = value;
    }

    public GraphNode(Integer value, GraphNode[] nodes) {
        this.value = value;
        this.nodes = nodes;
    }

    private void printNode(String spaces) {
        if (marked) {
            return;
        }
        marked = true;

        System.out.println(spaces + value);
        final String finalSpaces = spaces + " ";
        if (nodes != null && nodes.length > 0) {
            for (GraphNode node : nodes) {
                node.printNode(finalSpaces);
            }
        }
    }

    public void printNode() {
        this.printNode("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return Objects.equals(value, graphNode.value);
    }

    public void demark() {
        if (marked) {
            marked = false;
            if (nodes != null && nodes.length > 0) {
                for (GraphNode node : nodes) {
                    node.demark();
                }
            }
        }

        if (markedsource) {
            markedsource = false;
            if (nodes != null && nodes.length > 0) {
                for (GraphNode node : nodes) {
                    node.demark();
                }
            }
        }

        if (markedtarget) {
            markedtarget = false;
            if (nodes != null && nodes.length > 0) {
                for (GraphNode node : nodes) {
                    node.demark();
                }
            }
        }
    }

}
