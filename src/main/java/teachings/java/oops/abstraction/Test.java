package teachings.java.oops.abstraction;

//Subclass
public class Test extends Demo{

    void prime(){
        int n=11, count=0;
        for(int i=1;i<=n;++i){
            if(n%i==0){
                ++count;
            }
        }
        if(count==2){
            System.out.println("Given Number is Prime!!");
        }else{
            System.out.println("Given Number is Odd");
        }
    }

    void show(){
        int n=11;
        if(n%2==0){
            System.out.println("Given number is Even!!!");
        }else{
            System.out.println("Given number is Odd!!!");
        }
    }

    void display(){
        System.out.println("Advanced Java!!!");
    }
}
