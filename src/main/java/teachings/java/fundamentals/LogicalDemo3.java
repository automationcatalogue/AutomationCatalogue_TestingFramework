package teachings.java.fundamentals;

public class LogicalDemo3 {
    public static void main(String[] args) {
        int a=10, b=45, c=22;

        boolean e=((a<c) || (a>b));
                //true || false --> true
        System.out.println(e);//true

        boolean d=((a<c) && (a>b)) && (b>c);
                //(true && false) && true
                //false && true --> false
        System.out.println(d);//false
    }
}
