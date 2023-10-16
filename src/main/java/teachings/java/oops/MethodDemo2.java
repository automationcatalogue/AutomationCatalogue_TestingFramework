package teachings.java.oops;

public class MethodDemo2 {
    int cube(){
        int n=8;
        int m = n*n*n;
        System.out.println("Cube of the given number is :"+m);
        return m;
    }

    void evenOdd(int y){
        if(y%2==0){
            System.out.println("Given number is Even!!!");
        }else{
            System.out.println("Given number is Odd!!!");
        }

    }

    public static void main(String[] args) {
        MethodDemo2 ob1 = new MethodDemo2();
        int z=ob1.cube();

        ob1.evenOdd(z);
    }
}
