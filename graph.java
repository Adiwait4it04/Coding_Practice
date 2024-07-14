import java.util.*;

public class graph{
    static class edge{
        int src,dest,weight;
        public edge(int a,int b, int c)
        {
            this.src=a;
            this.dest=b;
            this.weight=c;
        }
    }
    public static boolean isbipartite(ArrayList<edge>[] graphs)
    {
        int colors[]=new int[graphs.length];
        for(int i=0;i<graphs.length;i++)
        {
            colors[i]=-1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < colors.length; i++) {
            if (colors[i]==-1) {
                queue.add(i);
                colors[i]=0;
                while (!queue.isEmpty()) {
                    int remove= queue.remove();
                    for(int j=0;j<graphs[remove].size();j++)                    
                    {
                        edge e = graphs[remove].get(j);
                        if (e.dest==-1) {
                            int nextcolor=colors[remove]==1 ? 0 : 1;
                            colors[remove]=nextcolor;
                        }
                        else if (colors[e.dest]== colors[remove]) {
                            return false;//not bipartite
                            
                        }
                    }
                    
                }
            }
        }
        return true;
    }
    public static boolean isbipartiteutil(ArrayList<edge> graphs[],int start) {
        return false;
    }
    public static void dfs(ArrayList<edge>[]graphs)
    {
        boolean visited[]=new boolean[graphs.length];
        for(int i=0;i<visited.length;i++)
        {
            dfsUtil(graphs, i, visited);  
        }
        

    }
    public static void dfsUtil(ArrayList<edge>[] graphs, int curr, boolean[] visited) {
        // Mark the current node as visited
        visited[curr] = true;
        System.out.println(curr);
      
        // Iterate over the neighbors of the current node
        for (edge neighbor : graphs[curr]) {
          if (!visited[neighbor.dest]) {
            dfsUtil(graphs, curr, visited);
          }
        }
      }
        
    public static boolean haspath(ArrayList<edge>[] graphs,int src, int dest, boolean[] visited) {
        if (src==dest) {
            return true;
        }
        visited[src]=true;
        for(int i=0;i<graphs[src].size();i++)
        {
            if (!visited[graphs[src].get(i).dest] && haspath(graphs, graphs[src].get(i).dest, dest, visited)) {
                return true;
            }
        }

        return false;
    }
    public static boolean cycle(ArrayList<edge>[]graphs)
    {
        boolean visited[]=new boolean[graphs.length];
        for(int i=0;i<graphs.length;i++)
        {
            if (!visited[i]) {
                cycleUtil(graphs, i,-1, visited);
            }
        }
        return false;
    }
    public static boolean cycleUtil(ArrayList<edge>[]graphs,int curr,int parent,boolean visited[])
    {
        visited[curr]=true;
        for(int i=0;i<graphs[curr].size();i++)
        {
            //case 3: neighbour visited nhi. dfs kar.
            if (!visited[graphs[curr].get(i).dest]) {
                if (cycleUtil(graphs, graphs[curr].get(i).dest, curr, visited)) {
                    return true;
                }
                
            }
            //case1: neighbour visited hai but neighbour!=parent. cycle found
            else if (visited[graphs[curr].get(i).dest] && graphs[curr].get(i).dest!=parent) {
                return true;
            }
        }
         //case 2: neighbour visited. neighbour==parent. continue.

        return false;
    }
    public static void main(String[] args)
    {
        ArrayList<edge>[] graphs = new ArrayList[5];
        for(int i=0;i<graphs.length;i++)
        {
            graphs[i]=new ArrayList<>();
        }
        graphs[0].add(new edge(0,1,5));
        graphs[1].add(new edge(1,0,5));
        graphs[1].add(new edge(1,3,3));
        graphs[1].add(new edge(1,2,1));
        graphs[2].add(new edge(2,1,1));
        graphs[2].add(new edge(2,3,1));
        graphs[2].add(new edge(2,4,2));
        graphs[3].add(new edge(3,1,3));
        graphs[3].add(new edge(3,2,1));
        graphs[4].add(new edge(4,2,2));
        
        //2 ka neighbours

        // for(int i=0;i<graphs[2].size();i++)
        // {
        //     System.out.println(graphs[2].get(i).dest);
        // }

        boolean visited[] = new boolean[graphs.length];

        //BFS
        // Queue<Integer> queue = new LinkedList<>(); 
        // queue.add(0);
        // while (!queue.isEmpty()) {
        //     int curr= queue.remove();
        //     if (!visited[curr]) 
        //     {
        //         System.out.println(curr+" ");
        //         visited[curr]=true;
        //         for(int i=0;i<graphs[curr].size();i++)
        //         {
        //         queue.add(graphs[curr].get(i).dest);
        //         }
        //     }
        // }

        //DFS

        // dfs(graphs, 0,visited);

        //path exists
        // System.out.println(haspath(graphs, 0, 5, visited));

        //cycle exists
        System.out.println(isbipartite(graphs));
         
    }
}
