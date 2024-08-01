import java.util.ArrayList;

public class Cyclegraph {
    static class edge{
        int src,dest,weight;
        public edge(int a,int b, int c)
        {
            this.src=a;
            this.dest=b;
            this.weight=c;
        }
    }
    public static void dfs(ArrayList<edge>[] graph)
    {
        boolean visited[]= new boolean[graph.length];
        for(int i=0;i<visited.length;i++)
        {
            dfsUtil(graph,i,visited);
        }
    }
    public static void dfsUtil(ArrayList<edge>[] graph,int curr,boolean visited[])
    {
        visited[curr]=true;

        for(edge e:graph[curr])
        {
            if (!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    public static void cycledetect(ArrayList<edge>[] graph)
    {
        boolean visited[]= new boolean[graph.length];
        for(int i=0;i<visited.length;i++)
        {
            if (!visited[i]) {
             cycledetectUtil(graph, i,-1, visited);   
            }
        }
    }

public static boolean cycledetectUtil(ArrayList<edge>[] graph,int curr,int par,boolean visited[])
{
    visited[curr]=true;
    for(edge e:graph[curr])
    {
        if (!visited[e.dest] && cycledetectUtil(graph, e.dest, curr, visited)) {
            return true;
        }
        else if (visited[e.dest]&&e.dest!=par) {
            return true;
        }

    }
    return false;
}

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graphs= new ArrayList[5];
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

    }
    
}
