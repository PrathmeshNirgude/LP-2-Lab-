import java.util.*;

class Edge{
    int destination;
    int weight;
    Edge(int d , int w){
        destination = d;
        weight = w;
    }
}
class Pair implements Comparable<Pair>{
    int vertex;
    int weight;
    int source;
    Pair(int v , int w,int s){
        vertex = v;
        weight = w;
        source  =s;
    }

    public int compareTo(Pair other){
        return this.weight - other.weight;
    }
}



class prac3 {

    void addEdge(List<List<Edge>> graph,int source,int destination,int weight){
        graph.get(source).add(new Edge(destination,weight));
        graph.get(destination).add(new Edge(source,weight));
    }
}
