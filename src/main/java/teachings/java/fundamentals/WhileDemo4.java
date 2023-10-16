package teachings.java.fundamentals;

public class WhileDemo4 {
    public static void main(String[] args) {
        int x=5;
        while (x<=13){//5<=13, 9<=13, 13<=13, 17<=13
            System.out.println("This is While Demo");//1,2,3
            x=x+4;//5+4, 9+4, 13+4
        }
        System.out.println("Value of x is :"+x);//17
    }
}
