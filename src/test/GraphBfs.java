package test;

import java.util.LinkedList;
import java.util.Iterator;

public class GraphBfs {
    
    int v;
    LinkedList<Integer> adj[];
    boolean[][] adjMatrix;
    
    GraphBfs(int v){
        this.v = v;
        adj = new LinkedList[v];
        
        adjMatrix = new boolean[v][v];
        
        for(int i=0; i< adj.length ; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int source, int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }
    
    public void addEdgeMatrix(int source, int destination){
        adjMatrix[source][destination] = true;
        adjMatrix[destination][source] = true;
    }

    void Bfs(int s) {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);
        
        while(queue.size() > 0){
            int u = queue.poll();
            System.out.print(u + " ");

            /*for(int i=0;i<adj[u].size();i++){
                if(!visited[adj[u].get(i)]){
                    visited[adj[u].get(i)] = true;
                    queue.add(adj[u].get(i));
                }
            }*/
            Iterator itr = adj[u].listIterator();
            while(itr.hasNext()){
                int n =  (int) itr.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        
    }


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
    
    public static void main(String args[]){
        GraphBfs g = new GraphBfs(40);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.addEdge(20, 21);
        g.addEdge(22, 21);
        g.addEdge(3, 20);

        g.Bfs(3);

        System.out.println(" ");
        g = new GraphBfs(40);

        g.addEdgeMatrix(0, 1);
        g.addEdgeMatrix(0, 2);
        g.addEdgeMatrix(1, 2);
        g.addEdgeMatrix(2, 3);

        g.addEdgeMatrix(20, 21);
        g.addEdgeMatrix(22, 21);
        g.addEdgeMatrix(3, 20);

        g.bfsMatrix(3);

    }


}
