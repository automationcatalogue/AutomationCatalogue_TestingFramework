package teachings.java.oops;

public class AvgMarks {
    int m=82,e=78, h=65,sc=92, so=41;//instance variable
    int sum;
    float avg;

    public static void main(String[] args) {
        AvgMarks ob1 = new AvgMarks();

        ob1.sum = ob1.m+ob1.e+ob1.h+ob1.sc+ob1.so;
        System.out.println("Sum of all subject marks is :"+ob1.sum);

        new AvgMarks().avg=ob1.sum/5;
        System.out.println("avg of all 5 subjects is :"+ob1.avg);

        if(new AvgMarks().avg>=70){
            System.out.println("Distinction!!!");
        }else if(ob1.avg>=60 && ob1.avg<70){
            System.out.println("First class!!!");
        }else if(ob1.avg>=50 && ob1.avg<60){
            System.out.println("Second Class!!!");
        }else if(ob1.avg>=40 && ob1.avg<50){
            System.out.println("Third Class!!!");
        }else{
            System.out.println("Failed!!!");
        }
    }
}
