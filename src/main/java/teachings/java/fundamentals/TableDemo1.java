package teachings.java.fundamentals;

public class TableDemo1 {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){//Outer loop

            for(int j=1;j<=10;j++){//Inner loop
                System.out.println(i+" * "+j+" = "+(i*j));
            }
            System.out.println("============================");
        }
    }
}
