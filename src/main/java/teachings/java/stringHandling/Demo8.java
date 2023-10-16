package teachings.java.stringHandling;

public class Demo8 {
    public static void main(String[] args) {
        String s1="Core Java learning is easy";

        String s2[]=s1.split(" ");

        for(int i=0;i<s2.length;++i){
            System.out.println(s2[i]);
        }



    }
}
