package teachings.java.oops.polymorphim;

public class Demo {
    //instance method - method definition
    void print(int a, int b){
        int c=a+b;
        System.out.println("Addition of a,b is :"+c);
    }

    void print(float a, float b){
        float c=b-a;
        System.out.println("Subtraction of a, b is :"+c);
    }

    void add(int a, float b){
        System.out.println("Advanced Java!!!");
    }

    void add(float a, int b){
        System.out.println("Python!!!");
    }

    public static void main(String[] args) {
        Demo ob1 = new Demo();
        ob1.print(10,20);
        ob1.print(10.5f, 20.7f);

        ob1.add(10.5f,20);
        ob1.add(20,10.5f);
    }
}
