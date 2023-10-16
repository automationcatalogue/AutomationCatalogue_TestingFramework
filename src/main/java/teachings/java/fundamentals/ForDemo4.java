package teachings.java.fundamentals;

public class ForDemo4 {
    public static void main(String[] args) {

        int i=0;
        for(i=1;i<=20;i=i+3){

            if(i<=5){
                i=i+10;
                System.out.println("Core Java and i value is :"+i);
            }else{
                System.out.println("Advanced Java and i value is :"+i);
            }

        }
        System.out.println("Final value of i is :"+i);
    }
}
