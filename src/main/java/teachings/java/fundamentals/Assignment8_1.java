package teachings.java.fundamentals;

public class Assignment8_1 {
    public static void main(String[] args) {
        int n=6;

        int factorial=1;

        for(int i=1;i<=n;i++){
            factorial = factorial*i;
        }
        System.out.println("Factorial of a given number is :"+factorial);
    }
}
