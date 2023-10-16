package teachings.java.oops;

public class MethodDemo4 {

    //instance method - cube number
    //method with arguments and with return type
    int cubeLogic(int x){
        int y=x*x*x;
        return y;
    }

    //class method - odd sum logic from 1 to 100
    //method with arguments and with return type
    static int oddSumLogic(int min, int max){
        int oddSum =0;

        for(;min<=max;min++){
            if(min%2!=0){
                oddSum=oddSum+min;
            }
        }
        return oddSum;
    }


    public static void main(String[] args) {
        MethodDemo4 ob1 = new MethodDemo4();
        int c=ob1.cubeLogic(6);
        System.out.println("Cube of the given number is :"+c);

        int o=oddSumLogic(1,100);
        System.out.println("Odd numbers from 1 to 100 is :"+o);

    }
}
