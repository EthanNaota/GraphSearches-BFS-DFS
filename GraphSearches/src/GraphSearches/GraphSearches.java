package GraphSearches;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

import java.util.ArrayList;
import java.util.Stack;

public class GraphSearches {

    public static void main(String[] args) {
        Graph<Integer, String> g = new UndirectedSparseGraph<>();

        g.addVertex(10);
        g.addEdge("A", 10, 15);
        g.addEdge("B", 10, 12);
        g.addEdge("C", 15, 7);
        g.addEdge("D", 15, 3);
        g.addEdge("E", 3, 1);
        g.addEdge("F", 12, 9);

        System.out.println("\nBFS: " + BFS(10, g).toString());
        System.out.println("\nGraph: ");
        System.out.println(g);

        System.out.println("-----------------------------------------------");
        System.out.println();
        System.out.println("\nDFS: " + DFS(10, g).toString());
        System.out.println("\nGraph: ");
        System.out.println(g);

    }
    public static ArrayList<Integer> DFS(int v, Graph g){
        ArrayList<Integer> visited = new ArrayList<>();
        Stack<Integer> toVisit = new Stack<>();

        return DFS(v, g, visited, toVisit);
    }

    public static ArrayList<Integer> DFS(int v, Graph g, ArrayList<Integer> visited, Stack<Integer> toVisit){
        if(visited.contains(v)){
            return visited;
        }

        visited.add(v);

        toVisit.addAll(g.getNeighbors(v));
        System.out.println("To visit: " + toVisit.toString());

        while(!toVisit.isEmpty()){
            if(!visited.contains(toVisit.peek())){ ;

                System.out.println("Visiting: " + toVisit.peek());
                DFS(toVisit.pop(), g, visited, toVisit);
            } else{
                System.out.println("Already visited: " + toVisit.peek());
                toVisit.pop();
            }
        }

        return visited;
    }

    public static ArrayList<Integer> BFS(int v, Graph g){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        return BFS(v, g, a, b);
    }
    public static ArrayList<Integer> BFS(int v, Graph g, ArrayList<Integer> visited, ArrayList<Integer> toVisit){
        if(visited.contains(v)){
            return visited;
        }

        visited.add(v);

        toVisit.addAll(g.getNeighbors(v));
        System.out.println("To visit: " + toVisit.toString());

        while(!toVisit.isEmpty()) {
            if(visited.contains(toVisit.get(0))) {
                System.out.println("Already Visited and Remove: " + toVisit.get(0));
                toVisit.remove(0);
            } else {
                System.out.println("Visit: " + toVisit.get(0));
                BFS(toVisit.get(0), g, visited, toVisit);
            }
        }

        return visited;
    }
}
