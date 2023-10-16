package teachings.java.stringHandling;

public class Demo5 {
    public static void main(String[] args) {
        String s1 = "I am learning Core Java and String Handling";
        System.out.println(s1);

        String s2 = s1.substring(6);
        System.out.println(s2);

        s2=s1.substring(6,15);
        System.out.println(s2);

        String s3 ="Hyderabad";
        String s4 =" is a Capital City";

        s3=s3.concat(s4);
        System.out.println(s3);

        boolean b=s3.contains("java");
        System.out.println(b);

    }
}
