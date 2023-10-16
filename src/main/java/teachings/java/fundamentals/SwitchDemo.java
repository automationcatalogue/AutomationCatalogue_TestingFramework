package teachings.java.fundamentals;

public class SwitchDemo {
    public static void main(String[] args) {
        char ch='f';

        switch(ch){
            case 'z':
                System.out.println("Sunday");

            case 'm':
                System.out.println("Monday");

            case 'f':
                System.out.println("Tuesday");

            case 'k':
                System.out.println("Wednesday");

            case 't':
                System.out.println("Thursday");
                break;
            case 'r':
                System.out.println("Friday");

            case 'h':
                System.out.println("Saturday");


        }
    }
}
