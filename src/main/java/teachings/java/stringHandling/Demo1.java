package teachings.java.stringHandling;

public class Demo1 {
    public static void main(String[] args) {
        String s1= new String("Automation Catalogue");
        int l=s1.length();
        System.out.println(l);

        String s2= s1.toUpperCase();
        System.out.println(s2);

        String s3= s1.toLowerCase();
        System.out.println(s3);

        char ch= s1.charAt(12);
        System.out.println(ch);


    }
}
