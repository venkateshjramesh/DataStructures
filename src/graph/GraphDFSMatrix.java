package graph;

import java.util.Iterator;
import java.util.LinkedList;
import com.sun.org.apache.xpath.internal.operations.Bool;


public class GraphDFSMatrix {

    private boolean adjMatrix[][];
    
    private boolean visited[];

    // Graph creation
    GraphDFSMatrix(int vertices) {
        adjMatrix = new boolean[vertices][vertices];
        
        visited = new boolean[vertices];

//        for (int i = 0; i < vertices; i++)
//            adjLists[i] = new LinkedList<Integer>();
    }

    // Add edges
    void addEdge(int src, int dest) {
        adjMatrix[src][dest] = Boolean.TRUE;
        adjMatrix[dest][src] = Boolean.TRUE;
    }

    // DFS algorithm
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        
        for (int j =0 ; j < adjMatrix.length; j ++) {
            
            if (adjMatrix[vertex][j] == Boolean.TRUE && !visited[j]) {
                DFS(j);
            }
            
        }

        /*
        for(int i=0;i<adjMatrix.length;i++){
            for(int j=0;j<adjMatrix[i].length;j++){
                if(adjMatrix[i][j] == true && !visited[j] && (i == vertex || j == vertex)){
                    DFS(j);
                }
            }
        }
        */

//        Iterator<Integer> ite = adjLists[vertex].listIterator();
//        while (ite.hasNext()) {
//            int adj = ite.next();
//            if (!visited[adj]) {
//                DFS(adj);
//            }
//        }
    }
    
//    void DFSRecursive(int vertex) {
//        visited = new boolean[visited.length];
//        DFSRecursive(vertex, visited);
//        System.out.println();
//    }
//    
//    void DFSRecursive(int vertex, boolean[] isVisited) {
//        isVisited[vertex] = true;
//        System.out.print(vertex + " ");
//        
//        for ( int dest : adjLists[vertex]) {
//            if (!isVisited[dest]) {
//                DFSRecursive(dest, visited);
//            }
//        }
//    }

    // Print the graph
    static void printGraph(boolean[][] G) {
        for (int i = 0; i < G.length; i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < G[i].length; j++) {
                if ( G[i][j] == Boolean.TRUE) {
                    System.out.print(" -> " + G[i][j]);    
                }
            }
            System.out.println();
        }
    }

//    String toMatrixView() {
//        StringBuilder s = new StringBuilder("   ");
//        for (int i = 0; i < adjLists.length; i++) {
//            s.append(i).append(" ");
//        }
//        s.append(System.lineSeparator());
//        for (int i = 0; i < adjLists.length; i++) {
//            s.append(i + ": ");
//            LinkedList<Integer> a = adjLists[i];
//
//            s.append(a);
//            s.append("\n");
//        }
//        return s.toString();
//    }

    public static void main(String args[]) {

        GraphDFSMatrix g = new GraphDFSMatrix(40);

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
        printGraph(g.adjMatrix);
        System.out.println();
        System.out.println("=======");
        //System.out.println(g.toMatrixView());
        System.out.println("=======^^^^^^=======");
        System.out.println();
        System.out.println("Following is Depth First Traversal");

        //3 2 0 1 20 21 22 

        g.DFS(3);
        
        System.out.println();
        g.visited = new boolean[40];
        g.DFS(0);
        
        
        //0 1 2 3 20 21 22 

       // g.DFSRecursive(0);

    }

}
