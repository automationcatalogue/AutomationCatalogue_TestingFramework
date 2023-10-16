package teachings.java.oops.abstraction;

public class B implements A{
    public void show(){
        int x=5;
        int y=x*x*x;
        System.out.println("Cube of the given number is :"+y);
    }
}
