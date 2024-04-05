import java.util.ArrayList;

class activityselection {
    public static int maxmeeting(ArrayList<Integer> a, ArrayList<Integer> b) {
        int count = 1;
        for (int i = 0; i < a.size() - 1; i++) {
            if (b.get(i) < a.get(i + 1))
            {
                count++;
                System.out.println(i);
            }   
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        a.add(1);
        a.add(3);
        a.add(0);
        a.add(5);
        a.add(8);
        a.add(5);
        b.add(2);
        b.add(4);
        b.add(6);
        b.add(7);
        b.add(9);
        b.add(9);
        int answer = maxmeeting(a, b);
        System.out.println(answer);
    }
}
