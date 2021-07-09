package test;

import java.util.LinkedList;

public class PathUnweighted {
    
    int v;
    LinkedList<LinkedList<Integer>> adj;
    
    PathUnweighted(int v){
        this.v = v;
        adj = new LinkedList<LinkedList<Integer>>();
        
        for(int i=0;i<v;i++){
            adj.add(new LinkedList<Integer>());
        }
    }
    
    public static void addEdge( LinkedList<LinkedList<Integer>> adj,int source, int destination){
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }
    
    
    public static void printShortestDistance(LinkedList<LinkedList<Integer>> adj,int source,int dest,int v){
        int[] dist = new int[v];
        int[] pred = new int[v];

        boolean[] visited = new boolean[v];
        
        if(bfs(adj, source, dest, v, dist, pred) == false){
            System.out.println("not a connected graph");
            return;
        }
        
         LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);
        
        
        while(pred[crawl] != -1){
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }
        
        for(int i=path.size()-1; i > 0; i--){
            System.out.print( path.get(i) + " ");
        }
                          
         
        
        System.out.println("distance calculated is:" + dist[dest]);
                          
    }

    private static boolean bfs(LinkedList<LinkedList<Integer>> adj, int source, int dest, int v, int[] dist, int[] pred) {

        LinkedList<Integer> queue = new LinkedList<>();
        
        boolean[] visited = new boolean[v];
        
        
        
        for (int i = 0; i < v; i++) {
            pred[i] = -1;
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        
        visited[source] = true;
        dist[source] = 0;
        queue.add(source);
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for(int i=0; i< adj.get(u).size() ; i++){
                
                if(visited[adj.get(u).get(i)] == false){
                    visited[adj.get(u).get(i)] = true;
                    pred[adj.get(u).get(i)] = u;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    
                    queue.add(adj.get(u).get(i));
                    
                    if(adj.get(u).get(i) == dest)
                        return true;
                }
                
            }
            
        }
        
        return false;
    }

    public static void main(String args[]){
         int v = 8;
        LinkedList<LinkedList<Integer>> adj;

        adj = new LinkedList<LinkedList<Integer>>();

        for(int i=0;i<v;i++){
            adj.add(new LinkedList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 7);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        int source = 2, dest = 6;
        printShortestDistance(adj, source, dest, v);
        
        //Shortest path length is: 5
        //Path is ::
        //2 1 0 3 7 6
    }

    
}
