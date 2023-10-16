package teachings.java.stringHandling;

public class Demo4 {
    public static void main(String[] args) {
        String s1 = new String();
        System.out.println(s1);

        String s2= new String("Automation Catalogue");
        System.out.println(s2);

        String s3= s2.toUpperCase();
        System.out.println(s3);

        s3=s2.replace('o','x');
        System.out.println(s3);

        int x= s2.length();
        System.out.println("length of the String is :"+x);

        boolean b=s2.startsWith("Auto",1);
        System.out.println(b);

        b=s2.endsWith("logue");
        System.out.println(b);
    }
}
