package teachings.java.oops;

public class VarDemo1 {
    static int z=99;

    public static void main(String[] args) {
        System.out.println(z);
        System.out.println(VarDemo1.z);
        System.out.println(new VarDemo1().z);

        VarDemo1 ob1 = new VarDemo1();
        System.out.println(ob1.z);
    }
}
