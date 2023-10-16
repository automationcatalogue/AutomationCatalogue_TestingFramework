package teachings.java.stringHandling;

public class Demo7 {
    public static void main(String[] args) {
        String s1="      Hello India       Core Java      python";
        System.out.println(s1);

        String s2=s1.trim();
        System.out.println(s2);

        int x=s2.indexOf('Z');
        System.out.println(x);

        x=s2.lastIndexOf('a');
        System.out.println(x);

        x=s2.indexOf("Java");
        System.out.println(x);

        x=s2.indexOf("Java",25);
        System.out.println(x);
    }
}
