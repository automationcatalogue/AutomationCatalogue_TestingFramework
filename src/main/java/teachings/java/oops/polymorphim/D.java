package teachings.java.oops.polymorphim;

public class D extends C{//subclass
    int y=20;//instance variable

    public void print(int x){
        if(x>=0){
            System.out.println("Given number is Positive!!!");
        }else{
            System.out.println("Given number is Negative!!!");
        }
    }

    void show(){
        System.out.println("Advanced Java!!!");
    }
}
