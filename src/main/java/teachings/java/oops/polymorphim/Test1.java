package teachings.java.oops.polymorphim;

public class Test1 {
    public static void main(String[] args) {
        C ob3 = new D();
        System.out.println(ob3.x);
        //System.out.println(ob3.y);
        ob3.show();
        //ob3.display();
        ob3.print(19);
    }
}
