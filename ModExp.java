import java.util.*;
import java.io.*;
class ModExp {
public static void main(String[] args) {
    int i=2,y=3,z=5;
    int ans=1;
    while(y>0)
    {
        if(y%2!=0)
        {
            ans = ans*i;
        }
        y= y >> 1;
        i=i*i;
    }
    System.out.println(ans%z);
}
}