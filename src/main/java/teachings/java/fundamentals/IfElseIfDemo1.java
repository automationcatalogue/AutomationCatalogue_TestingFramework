package teachings.java.fundamentals;

public class IfElseIfDemo1 {
    public static void main(String[] args) {
        double maths = 90, science = 76, social =63, Hindi=55, English=47;
        double total = maths+science+social+Hindi+English;
        System.out.println("Total of 5 Subjects is :"+total);

        double avg = total/5;
        System.out.println("Avg of 5 subject marks is :"+avg);

        if(avg>=70){
            System.out.println("Distinction!!!");
        }else if(avg>=60 && avg<70){
            System.out.println("First Class!!!");
        }else if(avg>=50 && avg<60){
            System.out.println("Second Class!!!");
        }else if(avg>=40 && avg<50){
            System.out.println("Third Class!!!");
        }else if(avg<40){
            System.out.println("Failed!!!");
        }
        System.out.println("AutomationCatalogue");

    }
}
