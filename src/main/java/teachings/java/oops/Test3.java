package teachings.java.oops;

public class Test3 {
    //instance method -PrimeNumber
    //method with arguments and without return type
    void primeLogic(int n){
        int count=0;
        for(int i=1;i<=n;++i){
            if(n%i==0){
                ++count;
            }
        }
        if(count==2){
            System.out.println("Given number is Prime"+n);
        }else{
            System.out.println("Given number is not Prime"+n);
        }
    }

    //Class method - Avg student marks
    //method with arguments and without return type
    static void avgLogic(int s1, int s2, int s3, int s4, int s5){
        int total = s1+s2+s3+s4+s5;
        int avg = total/5;
        System.out.println("Avg of 5 subject marks are :"+avg);
    }

    //instance method - factorial
    //method without arguments and with return type
    int factLogic(){
        int n=5;
        int fact=1;
        for(int i=n;i>=1;--i){
            fact=fact*i;
        }

        return fact;
    }

    //Class method - sum of the even numbers between 1 to 100
    //method without arguments and with return type
    static int evenSumLogic(){
        int evenSum=0;
        for(int i=1;i<=100;++i){
            if(i%2==0){
                evenSum=evenSum+i;
            }
        }
        return evenSum;
    }

}
