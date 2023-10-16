package teachings.java.fundamentals;

public class WhileLoopDemo2 {
    public static void main(String[] args) {
        int x=9;

        while(x<=18){//9<=18, 12<=18, 15<=18, 18<=18, 21<=18
            System.out.println("Core Java!!!");//1,2, 3, 4
            x=x+3;//12, 15, 18, 21
        }
        System.out.println("Value of X is :"+x);
    }
}
