import java.util.*;
class candyshop{
    public static void main(String args[])
    {
        int k=2;
        int min_cost=0;
        ArrayList<Integer> candy= new ArrayList<>(Arrays.asList(1,3,6,7,2,4,8));
        Collections.sort(candy);
        while(candy.size()!=0)
        {
            min_cost=min_cost+candy.get(0);
            candy.remove(0);
            int x=2;
            while(x!=0&&candy.size()!=0)
            {
                candy.remove(candy.size()-1);
                x--;
            }
        }
        System.out.println(min_cost);
    }
}