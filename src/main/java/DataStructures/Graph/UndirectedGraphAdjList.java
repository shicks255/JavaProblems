package DataStructures.Graph;

import java.util.*;

public class UndirectedGraphAdjList
{
    private int V; //number of vertices
    private int E; //number of edges
    private Set<Integer>[] adj;

    public UndirectedGraphAdjList(int V)
    {
        this.V = V;
        this.E = 0;
        adj = new TreeSet[V];
        for (int v = 0; v < V; v++)
            adj[v] = new TreeSet<>();
    }

    public void addEdge(int src, int dest)
    {
        E++;
        adj[src].add(dest);
        adj[dest].add(src);
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for (int v = 0; v < this.V; v++)
        {
            str.append("\r\nList of vertexes for vertex " + v + ": ");
            str.append(v + " -> ");
            for (Integer e : this.adj[v])
                str.append(e + " -> ");
        }

        return str.toString();
    }

//    public int breadthFirstSet(int v)
//    {
//        Deque<Integer> queue = new ArrayDeque<>();
//
//        for (int i = 0; i < V; i++)
//            queue.add(i);
//
//        while (!queue.isEmpty())
//        {
//
//
//        }
//    }


    public static void main(String[] args)
    {
        UndirectedGraphAdjList graph = new UndirectedGraphAdjList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(3,2);
        graph.addEdge(3,4);
        graph.addEdge(4,0);
        graph.addEdge(4,1);
        graph.addEdge(4,3);

        System.out.println(graph);
    }

}
