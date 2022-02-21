import structures.Graph;
import structures.GraphNode;
import structures.Queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BidirectionalSearch {

    public static void main(String[] args) {

        Graph acyclicGraph = new Graph();
        acyclicGraph.nodes = toGraph(new Integer[]{0, /**/1, 2, /**/3, 4, 5});

        acyclicGraph.nodes[1].nodes = toGraph(new Integer[]{6, 7,  /**/8,  /**/9, 10}, acyclicGraph.nodes[1]);
        acyclicGraph.nodes[3].nodes = toGraph(new Integer[]{16, 17, 18, 19, 20}, acyclicGraph.nodes[3]);

        acyclicGraph.nodes[1].nodes[2].nodes = toGraph(new Integer[]{11, 12, 13, 14, 15}, acyclicGraph.nodes[1].nodes[2]);
        acyclicGraph.nodes[1].nodes[3].nodes = toGraph(new Integer[]{21, 22, 23, 24, 25}, acyclicGraph.nodes[1].nodes[3]);

        acyclicGraph.nodes[1].nodes[3].nodes[1].nodes = toGraph(new Integer[]{26}, acyclicGraph.nodes[1].nodes[3].nodes[1], acyclicGraph.nodes[1].nodes[3]);
        acyclicGraph.print();

        acyclicGraph.demarkGraph();

        boolean isThereAnyPath = breadthFirstSearch(
                acyclicGraph.nodes[1],
                acyclicGraph.nodes[1].nodes[3].nodes[1]);
        System.out.println(isThereAnyPath);

        acyclicGraph.demarkGraph();

        isThereAnyPath = bidirectionalSearch(acyclicGraph.nodes[1],
                acyclicGraph.nodes[1].nodes[3].nodes[1]);
        System.out.println(isThereAnyPath);
    }

    private static boolean bidirectionalSearch(GraphNode sourceNode, GraphNode targetNode) {
        HashSet<GraphNode> sourceSet = new HashSet<>();
        sourceSet.add(sourceNode);

        HashSet<GraphNode> targetSet = new HashSet<>();
        targetSet.add(targetNode);

        return bidirectionalSearch(sourceSet, targetSet, sourceNode, targetNode);
    }

    private static boolean bidirectionalSearch(Set<GraphNode> sourceSet, Set<GraphNode> targetSet, GraphNode sourceNode, GraphNode targetNode) {

        Set<GraphNode> intersection = sourceSet.stream().filter(targetSet::contains).collect(Collectors.toSet());
        if (!intersection.isEmpty()) {
            System.out.println("intersection found at: " + intersection.iterator().next().value);
            return true;
        } else if (sourceSet.contains(targetNode) || targetSet.contains(sourceNode)) {
            return true;
        } else if (sourceSet.isEmpty() && targetSet.isEmpty()) {
            return false;
        }

        sourceSet = sourceSet.stream().flatMap(BidirectionalSearch::getGraphNodeStreamSource)
                .collect(Collectors.toSet());

        targetSet = targetSet.stream().flatMap(
                BidirectionalSearch::getGraphNodeStreamTarget).collect(Collectors.toSet());

        return bidirectionalSearch(sourceSet, targetSet, sourceNode, targetNode);
    }

    private static Stream<GraphNode> getGraphNodeStreamSource(GraphNode n) {
        if (n.nodes != null)
            return Arrays.stream(n.nodes).filter(b -> {
                if (!b.markedsource) {
                    b.markedsource = true;
                    return true;
                } else {
                    return false;
                }
            });
        else {
            return null;
        }
    }

    private static Stream<GraphNode> getGraphNodeStreamTarget(GraphNode n) {
        if (n.nodes != null)
            return Arrays.stream(n.nodes).filter(b -> {
                if (!b.markedtarget) {
                    b.markedtarget = true;
                    return true;
                } else {
                    return false;
                }
            });
        else {
            return null;
        }
    }

    private static boolean breadthFirstSearch(GraphNode source, GraphNode target) {

        if (source == target) {
            return true;
        }

        Queue<GraphNode> queue = new Queue<>();
        source.marked = true;
        queue.add(source);

        while (!queue.isEmpty()) {

            GraphNode element = queue.remove();

            if (element.equals(target)) {
                return true;
            }

            if (element.nodes != null && element.nodes.length > 0) {
                for (GraphNode children : element.nodes) {
                    if (!children.marked) {
                        children.marked = true;
                        queue.add(children);
                    }
                }
            }

        }

        return false;
    }

    public static GraphNode[] toGraph(Integer[] array, GraphNode... others) {
        GraphNode[] a = new GraphNode[array.length + others.length];
        int i = 0;
        for (; i < array.length; i++) {
            a[i] = new GraphNode(array[i]);
        }
        for (GraphNode other : others) {
            a[i] = other;
            i++;
        }

        return a;
    }
}
