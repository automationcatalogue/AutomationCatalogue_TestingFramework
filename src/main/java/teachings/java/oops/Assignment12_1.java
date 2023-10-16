package teachings.java.oops;

public class Assignment12_1 {
    int a[]={4,8,7,6,5,3,9,2};//instance variable

    public static void main(String[] args) {

        Assignment12_1 ob1 = new Assignment12_1();

        int evenSum=0, oddSum=0;
        for(int b:ob1.a){
            if(b%2==0){
                evenSum=evenSum+b;
            }else {
                oddSum=oddSum+b;
            }
        }
        System.out.println("Sum of Even numbers is :"+evenSum);
        System.out.println("Sum of Odd numbers is :"+oddSum);
    }
}
