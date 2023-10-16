package teachings.java.fundamentals;

public class Assignment7 {
    public static void main(String[] args) {
        int n=5;

        int i=1;
        int fact=1;
        while(i<=n){
            fact = fact *i;//24*5=12
            ++i;
        }

        System.out.println("Factorial of a given number is :"+fact);

    }
}
