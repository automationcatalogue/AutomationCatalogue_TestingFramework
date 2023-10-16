package teachings.selenium.Dummy;

public class Demo1 {
    int x=10;
    static int y=20;

    public static void main(String[] args) {
        Demo1 ob1 = new Demo1();
        Demo1 ob2 = new Demo1();

        ob1.x=ob1.x+2;
        ob1.y=ob1.y+2;

        System.out.println(ob1.x);//12
        System.out.println(ob1.y);//22
        System.out.println(ob2.x);//10
        System.out.println(ob2.y);//22
    }
}
