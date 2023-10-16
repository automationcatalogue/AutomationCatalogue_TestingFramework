package teachings.java.fundamentals;

public class DoWhileDemo2 {
    public static void main(String[] args) {
        int n=11;

        int i=1;
        int count=0;

        do{
            if(n%i==0){
                count=count+1;
            }
            ++i;
        }while(i<=n);

        if(count==2){
            System.out.println("Given number is Prime number!!!");
        }else{
            System.out.println("Given number is not a Prime number!!!");
        }
    }
}
