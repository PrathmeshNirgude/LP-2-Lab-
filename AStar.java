import java.util.*;

class Node implements Comparable<Node>{
    int x,y;
    int f,g,h;
    Node parent;
    Node(int x,int y, int g, int h, Node parent){
        this.x = x;
        this.y = y;
        this.f = g+h;
        this.g = g;
        this.h = h;
        this.parent = parent;
    }

    public int compareTo(Node other){
        return this.f-other.f;
    }
}

class temp{

    static final int row = 5;
    static final int col = 5;
    
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    int heuristic(int x,int y , int goalx, int goaly){
        return Math.abs(goalx-x)+Math.abs(goaly-y);
    }

    boolean isValid(int x, int y, boolean[][] visited,int[][] grid){
        return (
            x >= 0 &&
            y >= 0 &&
            x < row &&
            y < col &&
            !visited[x][y] &&
            grid[x][y] == 0
        ) ;
    }

    void printPath(Node goal){
        List<Node> path = new ArrayList<>();

        Node cur = goal;
        while( cur != null){
            path.add(cur);
            cur = cur.parent;
        }

        Collections.reverse(path);

        System.out.println("Path is :");
        for(Node n : path){
            System.out.println("("+n.x+","+n.y+")");
        }
    }

    void solve(int startx , int starty, int goalx, int goaly , int[][] grid){
        
        PriorityQueue<Node> openList = new PriorityQueue<>();
        boolean visited[][] = new boolean[row][col];

        Node start = new Node(startx,starty,0,heuristic(startx,starty,goalx,goaly),null);

        openList.add(start);

        while(!openList.isEmpty()){

            Node cur = openList.poll();

            int x = cur.x;
            int y = cur.y;

            if(x == goalx && y == goaly){
                System.out.println("**path found**");
                printPath(cur);
                return;
            }

            visited[x][y] = true;

            for(int i = 0 ; i < 4; i++){
                int newx = x+dx[i];
                int newy = y+dy[i];

                if(isValid(newx,newy,visited,grid)){
                    int newg = cur.g+1;
                    int newh = heuristic(newx,newy,goalx,goaly);

                    Node next = new Node(newx,newy,newg,newh,cur);

                    openList.add(next);
                }
            }

        }
        System.out.println("no path exist!!!");
    }

    public static void main(String[] args){
        int x =0 ,y=0,goalx = 4,goaly = 2;
        int[][] grid = {
            {0,0,0,0,0},
            {1,1,0,1,0},
            {0,0,0,1,0},
            {0,1,1,1,0},
            {0,0,0,0,0}
        };

        temp t = new temp();
        t.solve(x,y,goalx,goaly,grid);
    }
    
}