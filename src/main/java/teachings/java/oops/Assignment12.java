package teachings.java.oops;

public class Assignment12 {
    public static void main(String[] args) {
        int a[]={4,8,7,6,5,3,9,2};

        int evenSum=0, oddSum=0;

        for(int i=0;i<a.length;i++){
            if(a[i]%2==0){
               evenSum=evenSum+a[i];
            }else{
                oddSum=oddSum+a[i];
            }
        }
        System.out.println("Sum of Even numbers is :"+evenSum);
        System.out.println("Sum of Odd numbers is :"+oddSum);
    }
}
