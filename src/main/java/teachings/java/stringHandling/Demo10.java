package teachings.java.stringHandling;

import java.nio.charset.StandardCharsets;

public class Demo10 {
    public static void main(String[] args) {
        String s1="Automation";

        byte b[]= s1.getBytes();
        for(int i=0;i<b.length;++i){
            System.out.println(b[i]);
        }

        char ch[]=s1.toCharArray();
        for(char ch1:ch){
            System.out.println(ch1);
        }
    }
}
