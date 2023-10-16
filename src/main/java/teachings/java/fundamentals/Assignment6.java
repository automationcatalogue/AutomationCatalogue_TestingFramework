package teachings.java.fundamentals;

public class Assignment6 {
    public static void main(String[] args) {
        int year=2020;

        if(year%2==0){
            System.out.println("Given Year is Even number!!!");
            if(year%4==0){
                System.out.println("Given Year is Leap year!!!");
            }else{
                System.out.println("Given Year is Non-Leap year!!!");
            }
        }else{
            System.out.println("Given Year is Odd number!!! and Non-Leap year!!!");
        }
    }
}
