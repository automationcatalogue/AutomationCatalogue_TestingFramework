package teachings.java.stringHandling;

public class Demo3 {
    public static void main(String[] args) {
        String s1 = new String("TajMahal");
        System.out.println(s1);

        String s2 = new String("Redfort");
        System.out.println(s2);

        boolean b = s1.equals(s2);
        System.out.println(b);

        String s3 = new String("tajmahal");
        b = s1.equalsIgnoreCase(s3);
        System.out.println(b);
    }
}
