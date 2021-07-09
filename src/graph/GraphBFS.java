package graph;

import java.util.Iterator;
import java.util.LinkedList;


public class GraphBFS {

    private int V;
    private LinkedList<Integer> adj[];

    // Create a graph
    GraphBFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Add edges to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    /*
    void bfsMatrix(int s) {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while(queue.size() > 0){
            int u = queue.poll();
            System.out.print(u + " ");

            loop1:for(int i=0;i<adjMatrix.length;i++){
                for(int j=0;j<adjMatrix[i].length;j++){
                    if(adjMatrix[u][j] && !visited[j]){
                        visited[j] = true;
                        queue.add(j);
                        continue loop1;
                    }
                }

            }

        }
    }
    */

    // BFS algorithm
    void BFS(int s) {

        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    String toMatrixView() {
        StringBuilder s = new StringBuilder("   ");
        for (int i = 0; i < adj.length; i++) {
            s.append(i).append(" ");
        }
        s.append(System.lineSeparator());
        for (int i = 0; i < adj.length; i++) {
            s.append(i + ": ");
            LinkedList<Integer> a = adj[i];

            s.append(a);
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String args[]) {
        GraphBFS g = new GraphBFS(40);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        
        g.addEdge(20, 21);
        g.addEdge(22, 21);
        g.addEdge(3, 20);

        System.out.println(g.toMatrixView());
        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        //3 2 0 1 
        //DFS - 3 2 0 1 20 21 22  

        g.BFS(3);
        //BFS - 3 2 20 0 1 21 22 
        
        //                      3
        //                  /       \
        //                 2        20
        //                 /        \
        //              0, 1        21
        //              /               \
        //             x                22
    }
}
