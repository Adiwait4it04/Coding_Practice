import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class colorgraph {
    static class edge{
        int src,dest;
        public edge(int a,int b)
        {
            this.src=a;
            this.dest=b;
        }
    }
    public static boolean isbipartite(ArrayList<edge>[] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        edge e = graph[curr].get(j);
                        if (color[e.dest] == -1) {
                            int nextcolor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextcolor;
                            q.add(e.dest);
                        } else if (color[e.dest] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    @SuppressWarnings("unchecked")
public static void main(String[] args) {
    ArrayList<edge>[] graphs = new ArrayList[5];
    for (int i = 0; i < 5; i++) {
        graphs[i] = new ArrayList<>();
    }

    graphs[0].add(new edge(0, 1));
    graphs[0].add(new edge(0, 2));
    graphs[1].add(new edge(1, 0));
    graphs[1].add(new edge(1, 3));
    graphs[2].add(new edge(2, 0));
    graphs[2].add(new edge(2, 4));
    graphs[3].add(new edge(3, 1));
    graphs[3].add(new edge(3, 4));
    graphs[4].add(new edge(4, 2));
    graphs[4].add(new edge(4, 3));

    System.out.println(isbipartite(graphs));
}
}