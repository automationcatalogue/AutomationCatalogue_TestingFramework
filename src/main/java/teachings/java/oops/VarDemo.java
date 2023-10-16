package teachings.java.oops;

public class VarDemo {
    int a=10;//instance variable

    public static void main(String[] args) {
        int b=20;//local variable
        System.out.println(b);

        VarDemo ob1 = new VarDemo();
        System.out.println(ob1.a);//By using ObjectReference

        System.out.println(new VarDemo().a);//By Using Object
    }
}
