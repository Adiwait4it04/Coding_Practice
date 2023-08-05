import java.util.*;

public class GCD {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int ans= calc_GCD(n1,n2);
        System.out.println(ans);
    }
    public static int calc_GCD(int n1,int n2){
        int gcd=1;
        for(int i=1;i<=n1 && i<=n2;i++){
            if(n1%i==0 && n2%i==0){
                gcd=i;
            }
        }
        return gcd;
    }
    
}
