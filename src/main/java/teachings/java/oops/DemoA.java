package teachings.java.oops;

public class DemoA {
    int x=5;
    static int y=10;

    public static void main(String[] args) {
        DemoA ob1 = new DemoA();
        DemoA ob2 = new DemoA();
        ob1.x = ob1.x+2;
        ob1.y = ob1.y+2;

        System.out.println(ob1.x);//7
        System.out.println(ob1.y);//12
        System.out.println(ob2.x);//5
        System.out.println(ob2.y);//12
    }
}
