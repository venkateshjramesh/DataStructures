package graph;

import java.util.Iterator;
import java.util.LinkedList;


public class GraphDFS {

    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    // Graph creation
    GraphDFS(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    // Add edges
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
        adjLists[dest].add(src);
    }

    // DFS algorithm
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }
    
    void DFSRecursive(int vertex) {
        visited = new boolean[visited.length];
        DFSRecursive(vertex, visited);
        System.out.println();
    }
    
    void DFSRecursive(int vertex, boolean[] isVisited) {
        isVisited[vertex] = true;
        System.out.print(vertex + " ");
        
        for ( int dest : adjLists[vertex]) {
            if (!isVisited[dest]) {
                DFSRecursive(dest, visited);
            }
        }
    }

    // Print the graph
    static void printGraph(LinkedList<Integer>[] am) {
        for (int i = 0; i < am.length; i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < am[i].size(); j++) {
                System.out.print(" -> " + am[i].get(j));
            }
            System.out.println();
        }
    }

    String toMatrixView() {
        StringBuilder s = new StringBuilder("   ");
        for (int i = 0; i < adjLists.length; i++) {
            s.append(i).append(" ");
        }
        s.append(System.lineSeparator());
        for (int i = 0; i < adjLists.length; i++) {
            s.append(i + ": ");
            LinkedList<Integer> a = adjLists[i];

            s.append(a);
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String args[]) {

        GraphDFS g = new GraphDFS(40);

        /**
         * 
         * 
         * 
         * 
         */
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        
        g.addEdge(20, 21);
        g.addEdge(22, 21);
        g.addEdge(3, 20);
        //g.addEdge(2, 2);

        System.out.println();
        System.out.println("=======");
        printGraph(g.adjLists);
        System.out.println();
        System.out.println("=======");
        System.out.println(g.toMatrixView());
        System.out.println("=======^^^^^^=======");
        System.out.println();
        System.out.println("Following is Depth First Traversal");

        g.DFS(3);
        
        System.out.println();
        g.DFSRecursive(0);

    }

}
