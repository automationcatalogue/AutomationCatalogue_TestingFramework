package teachings.java.stringHandling;

public class Demo9 {
    public static void main(String[] args) {
        String s1 = new String();
        System.out.println(s1);

        String s2 = new String("Hello India!!!");
        System.out.println(s2);

        char ch[]={'h','S','p','e','l','l','o'};
        String s3 = new String(ch);
        System.out.println(s3);

        byte b[]={100,99,65,81,104};
        String s4 = new String(b);
        System.out.println(s4);
    }
}
