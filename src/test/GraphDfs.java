package test;

import graph.GraphDFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphDfs {
    
    int v;
    LinkedList<Integer>[] adj;
    boolean[] visited ;

    GraphDfs(int v){
        this.v = v;
        visited = new boolean[v];
        adj = new LinkedList[v];
        
        for(int i=0;i<adj.length;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    
    public void addEdge(int source,int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }
    
    
    void dfs(int i){

        visited[i] = true;
        System.out.print(i + " ");

        Iterator itr = adj[i].listIterator();
        while(itr.hasNext()){
            int temp = (int)itr.next();
            if(!visited[temp]){
                dfs(temp);
            }
        }
    }

    void dfsRecursive(int i){
        
        visited[i] = true;
        System.out.print(i + " ");
        
        for(int item : adj[i]){
            if(!visited[item])
                dfsRecursive(item);
        }
        
    }

    public static void main(String args[]){
        GraphDfs g = new GraphDfs(40);

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

        g.dfs(3);

        System.out.println();
        //g.DFSRecursive(0);
        
        g = new GraphDfs(40);

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

        g.dfsRecursive(3);
    }
    
 }
