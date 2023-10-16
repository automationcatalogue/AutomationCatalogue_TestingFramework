package teachings.java.stringHandling;

public class Demo2 {
    public static void main(String[] args) {
        String s1 = new String("Java is a Programming language and it is divided into Core Java and Advanced Java");
        String s2 = s1.replaceFirst("Java","Python");
        System.out.println(s2);

        String s3 = s1.replaceAll("Java","Python");
        System.out.println(s3);

        String s4= s1.replace('a','z');
        System.out.println(s4);

        boolean found = s1.isEmpty();
        System.out.println(found);

        String s5 = new String();
        boolean found1 = s5.isEmpty();
        System.out.println(found1);

    }

}
