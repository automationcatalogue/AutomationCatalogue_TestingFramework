package teachings.java.stringHandling;

public class Demo11 {

    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");

        boolean b = s1.equals(s2);
        System.out.println("b value is "+b);

        boolean c = s1==s2;
        System.out.println("c value is "+c);

    }
}
