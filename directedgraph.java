import java.util.ArrayList;

public class directedgraph {
    static class edge{
        int src,dest;
        public edge(int a,int b)
        {
            this.src=a;
            this.dest=b;
        }
    }

    public static boolean isCycle(ArrayList<edge>[] graphs){
        boolean vis[]=new boolean[graphs.length];
        boolean stack[]= new boolean[graphs.length];
        for(int i=0;i<vis.length;i++)
        {
            if (!vis[i]) {
                if(isCycleUtil(graphs,i,vis,stack))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<edge>[] graphs,int curr,boolean vis[],boolean stack[])
    {
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graphs[curr].size();i++)
        {
            if (stack[graphs[curr].get(i).dest]) {
                return true;
            }
            if (!vis[graphs[curr].get(i).dest] && isCycleUtil(graphs, graphs[curr].get(i).dest, vis, stack)) {
                return true;
            }
        }
        stack[curr]=false;
        return false;

    }
    @SuppressWarnings("unchecked")
    public static void main(String args[])
    {
        ArrayList<edge>[] graphs = new ArrayList[5];
    for (int i = 0; i < 5; i++) {
        graphs[i] = new ArrayList<>();
    }

    // graphs[0].add(new edge(0, 1));
    graphs[0].add(new edge(0, 2));
    graphs[1].add(new edge(1, 0));
    // graphs[1].add(new edge(1, 3));
    // graphs[2].add(new edge(2, 0));
    graphs[2].add(new edge(2, 3));
    // graphs[3].add(new edge(3, 1));
    graphs[3].add(new edge(3, 0));
    // graphs[4].add(new edge(4, 2));
    // graphs[4].add(new edge(4, 3));
    System.out.println(isCycle(graphs));

    }
}
