package teachings.java.fundamentals;

public class IfElseIfDemo4 {
    public static void main(String[] args) {
        int a=99, b=87, c=121;
        System.out.println("AutomationCatalogue");

        if(a<=b || a==c){//99<=87 || 99==121
            System.out.println("Core Java");
        }else if(a!=b && c<a){//99!=87 && 121<99
            System.out.println("Advanced Java");
        }else if(a>=25 && (a<=99 || c>=500)){
            System.out.println("Python");
        }else{
            System.out.println("Batch42..!!!");
        }
    }
}
