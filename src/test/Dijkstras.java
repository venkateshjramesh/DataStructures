package test;


import java.util.*;

public class Dijkstras {
    
    int v;
    PriorityQueue<Node> pq;
    Set<Integer> settled;
    int[] dist;
    LinkedList<LinkedList<Node>> adj;
    
    
    Dijkstras(int v){
        this.v = v;
        pq = new PriorityQueue<Node>(v, new Node());
        adj = new LinkedList<LinkedList<Node>>();
        dist = new int[v];
        settled = new HashSet<Integer>();
        
        for(int i=0;i < v ;i++){
            dist[i] = Integer.MAX_VALUE;
            adj.add(new LinkedList<Node>());
        }
    }
    
    void dijkstra(LinkedList<LinkedList<Node>> adj, int src) {
        pq.add(new Node(src,0));
        dist[src] = 0;
        
        while(settled.size() != v){
            int u = pq.remove().node;
            settled.add(u);

            e_neighbours(u);
        
        }
    }
    
    void e_neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;
        
        for(int i=0;i< adj.get(u).size(); i++){

            Node v = adj.get(u).get(i);
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }
    
    
    public static void main(String args[]){
        int V = 5;
        int source = 0;
        
        // Inputs for the DPQ graph
        Dijkstras dpq = new Dijkstras(V);
        dpq.adj.get(0).add(new Node(1, 9));
        dpq.adj.get(0).add(new Node(2, 6));
        dpq.adj.get(0).add(new Node(3, 5));
        dpq.adj.get(0).add(new Node(4, 3));

        dpq.adj.get(2).add(new Node(1, 2));
        dpq.adj.get(2).add(new Node(3, 4));

        dpq.dijkstra(dpq.adj, source);
        
        System.out.println("The shorted path from node :");
        for(int i=0; i< dpq.dist.length ; i++){
            System.out.println(i + " :" + dpq.dist[i]);
        }
        
    }
    
    static class Node implements Comparator<Node>{
        int node;
        int cost;
        
        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        public Node(){

        }
        public int compare(Node node1, Node node2){
            if(node1.cost > node2.cost){
                return -1;
            }
            else if(node1.cost < node2.cost){
                return 1;
            }
            return 0;
        }
    }
}
