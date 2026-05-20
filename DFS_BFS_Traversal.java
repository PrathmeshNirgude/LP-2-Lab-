import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

class prac1{
    int vertices;
    List<List<Integer>> graph = new ArrayList<>();

    prac1(int v ){
        vertices = v;
        for(int i = 0 ; i < v ; i++){
            graph.add(new ArrayList<>());
        }
    }

    void addEdge(int source,int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    void DFS(int source,boolean[] visited){
        visited[source] = true;
        System.out.print(source+" ");

        for(int child : graph.get(source)){
            if(!visited[child]){
                DFS(child,visited);
            }
        }
    }
     public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices :");
        int v = sc.nextInt();
        prac1 t = new prac1(v);
        String ch;
        do{
            System.out.println("Enter the v1 of Edges :");
            int s = sc.nextInt();
            System.out.println("Enter the v2 of Edges :");
            int d = sc.nextInt();
            t.addEdge(s,d);
            
            sc.nextLine();
            System.out.println("Do you want to add more Edges(y/n) :");
            ch = sc.nextLine();
            
        }while("y".equalsIgnoreCase(ch));

        sc.close();

        System.out.println("\nDFS :");
        boolean visited[] = new boolean[v];
        t.DFS(0,visited);
    }

}
