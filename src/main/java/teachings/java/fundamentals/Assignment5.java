package teachings.java.fundamentals;

public class Assignment5 {
    public static void main(String[] args) {
        int a=50, b=60, c=50;

        if(a==b && b==c){
            //50==60 && 60==50
            //false && false --> false
            System.out.println("Equilateral Triangle");
        }else if(a==b || b==c || c==a){
            //50==60 || 60==50 || 50==50
            //false || false || true --> true
            System.out.println("Bilateral triangle");
        }else{
            System.out.println("Scalen triangle");
        }
    }
}
