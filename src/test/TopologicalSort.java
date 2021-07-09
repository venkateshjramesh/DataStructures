package test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    
    int v;
    LinkedList<LinkedList<Integer>> adj;
    
    TopologicalSort(int v){
        this.v = v;
        adj = new LinkedList<LinkedList<Integer>>();
        for(int i=0;i<v;i++){
            adj.add(new LinkedList<Integer>());
        }
        
    }
    
    public void addEdge(int source, int destination){
        adj.get(source).add(destination);
    }

    
    void topologicalSort(){
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[v];

        for(int i=0;i<v;i++){
            visited[i] = false;
        }

         for(int i=0;i<v;i++){
             if(!visited[i])
                 topologicalSortUtil(i,stack,visited);
         }

         while(stack.empty() == false){
             System.out.print( stack.pop() + " ");
         }
        
    }
    
    
    void topologicalSortUtil(int i, Stack stack, boolean[] visited){
        visited[i] = true;
                
        Iterator<Integer> itr = adj.get(i).listIterator();
        while(itr.hasNext()){
            int u = itr.next();
            if(!visited[u]){
                topologicalSortUtil(u,stack,visited);
            }
        }
        
        stack.push(i);
        
    }
    
    
    
    public static void main(String args[]){
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        
        g.topologicalSort();
    }

}
