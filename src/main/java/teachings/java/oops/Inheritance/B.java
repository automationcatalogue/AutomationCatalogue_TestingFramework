package teachings.java.oops.Inheritance;

public class B extends A{   //B --> Sub class, A--> super class

    int y=20; //instance variable

    void evenOdd(){
        int x=18;
        if(x%2==0){
            System.out.println("Given number is Even!!!");
        }else{
            System.out.println("Given number is Odd!!!");
        }
    }

}
