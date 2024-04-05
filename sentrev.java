import java.util.*;
class sentrev{
    public static void main(String args[])
    {
        String s= "i.am.additya";
        String answer="";
        String word ="";
        for(int i = s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='.')
            {
                answer=answer+" "+word;
                word="";
            }
            else
            {
                word=s.charAt(i)+word;
            }
        }
        System.out.println(answer);
    }
    for(int i=0;i<=S.length)
}
