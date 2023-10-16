package teachings.java.fundamentals;

public class IfElseIfDemo3 {
    public static void main(String[] args) {
        int x='F';
        if(x>=80){
            x+=100;
        }else if(x%2==0){
            x=x-10;
        }else if(x>=50){
            x-=90;
        }else if(x<=0){
            x=x*x;
        }else{
            x++;
        }
        System.out.println("Value of x is :"+x);
    }
}
