public class Solution {
    public static void main(String[] args) {
        // edge list
        int[][] edgeList = new int[][] { { 0, 2 }, { 2, 3 }, { 2, 1 }, { 1, 3 } };

        // adjacent list
        int[][] adjacentList = new int[][] { { 2 }, { 2, 3 }, { 0, 1, 3 }, { 1, 2 } };

        // adjacent matrix
        int[][] adjacentMatrix = new int[][] {
                { 0, 0, 1, 0 },
                { 0, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 0 }
        };

        MyGraph myGraph = new MyGraph();
        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addVertex(6);
        myGraph.addEdge(3, 1); 
        myGraph.addEdge(3, 4); 
        myGraph.addEdge(4, 2); 
        myGraph.addEdge(4, 5); 
        myGraph.addEdge(1, 2); 
        myGraph.addEdge(1, 0); 
        myGraph.addEdge(0, 2); 
        myGraph.addEdge(6, 5);

        myGraph.showConnections(); 
    }
}