import java.util.*;

class MyGraph {
    private int numberOfNodes;
    private Map<Integer, List<Integer>> adjacentList;

    public MyGraph() {
        numberOfNodes = 0;
        adjacentList = new HashMap<>();
    }

    public void addVertex(int data) {
        if (adjacentList.get(data) == null) {
            adjacentList.put(data, new ArrayList<>());
            this.numberOfNodes++;
        }
    }

    public void addEdge(int node1, int node2) {
        List<Integer> list = adjacentList.get(node1);
        if (list != null) {
            list.add(node2);
            adjacentList.get(node2).add(node1);
        }
    }

    public void showConnections() {
        adjacentList.forEach((key, value) -> {
            System.out.print(key + " --> ");
            value.forEach(edge -> System.out.print(edge + " "));
            System.out.println();
        });
    }

}
