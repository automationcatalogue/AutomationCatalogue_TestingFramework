package teachings.java.fundamentals;

public class PrimeDemo {
    public static void main(String[] args) {
        int n=9;
        int i=1;
        int count=0;

        while(i<=n){
            if(n%i==0){
                count=count+1;
            }
            ++i;
        }

        if(count==2){
            System.out.println("Given number is Prime number");
        }else{
            System.out.println("Given number is Not Prime number");
        }
    }
}
