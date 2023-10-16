package teachings.java.fundamentals;

public class IfElseIfDemo2 {
    public static void main(String[] args) {
        int x=90, y=75;
        int z=x+y;//165

        if(x>=80 && z<=50){
            y=4;
            int a=y*y;
            System.out.println("Square of the number is :"+a);
        }else if(x!=90 || z>=50){
            x=8;
            z=x+y;
            System.out.println("Addition of x, y is :"+z);
        }else if(x==90 && y==75){
            z=y-x;
            System.out.println("Subtraction of x,y is  :"+z);
        }else{
            System.out.println("I am learing Ifelse if Demo");
        }

        System.out.println("Value of x is :"+x+" Value of y is :"+y+" value of z is :"+z);


    }
}
