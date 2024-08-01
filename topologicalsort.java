import java.util.ArrayList;
import java.util.Stack;

public class topologicalsort {
    static class edge{
        int src,dest;
        public edge(int a,int b)
        {
            this.src=a;
            this.dest=b;
        }
    }
    @SuppressWarnings("unchecked")

    public static void topsort(ArrayList<edge>[] graphs)
    {
        boolean vis[]= new boolean[graphs.length];
        Stack<Integer> s= new Stack<>();
        for (int i=0;i<graphs.length;i++)
        {
            if (!vis[i]) {           
                topsortUtil(graphs,i,vis,s); 
            }
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop() + " ");
        }
    }

    public static void topsortUtil(ArrayList<edge>[] graphs,int curr, boolean vis[],Stack<Integer> s )
    {
        vis[curr]=true;
        for(int i=0;i<graphs[curr].size();i++)
        {
            if (!vis[graphs[curr].get(i).dest]) {
                topsortUtil(graphs,graphs[curr].get(i).dest , vis, s);
            }
        }
        s.push(curr);
    }
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
    topsort(graphs);

    }
}
