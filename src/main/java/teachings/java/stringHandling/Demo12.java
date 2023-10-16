package teachings.java.stringHandling;

public class Demo12 {
    public static void main(String[] args) {
        String s1 = new String("Tajmahal");
        System.out.println(s1);

        String s2 = new String("Tajmahal");
        System.out.println(s2);

        boolean b = s1.equals(s2);
        System.out.println(b);


        boolean b1 = s1==s2;
        System.out.println("b1 value is :"+b1);

    }
}
