package teachings.java.stringHandling;

public class Demo6 {
    public static void main(String[] args) {
        int x=123;
        double y=563.25;

        String s1=String.valueOf(x);
        System.out.println(s1);

        s1=s1.concat(" Java");
        System.out.println(s1);

        s1=String.valueOf(y);
        System.out.println(s1);
    }
}
