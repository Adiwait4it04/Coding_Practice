import java.util.ArrayList;

class Solution {
    static class Edge{
        int src;
        int dest;
        Edge(int a, int b)
        {
            this.src=a;
            this.dest=b;
        }
    }
    public boolean validPath(int n, int[][] edge, int source, int destination) 
    {
        ArrayList<Edge> []graphs = new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graphs[i]=new ArrayList<Edge>();
            graphs[i].add(new Edge(edge[i][0],edge[i][1]));
        }
        boolean visited[]= new boolean[n];
        return haspath(n,graphs,source,destination,visited);
    }
    public boolean haspath(int n,ArrayList<Edge>[]graphs,int source, int destination,boolean visited[])
    {
        if(source == destination)
        {
            return true;
        }

        visited[source]=true;
        for(int i=0;i<n;i++)
        {
            if(!visited[source] && haspath(n,graphs,graphs[source].get(i).dest,destination, visited))
            {
                return true;
            }
        }
        return false;
    }
}