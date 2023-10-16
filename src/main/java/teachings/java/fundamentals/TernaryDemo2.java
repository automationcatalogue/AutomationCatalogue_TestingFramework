package teachings.java.fundamentals;

public class TernaryDemo2 {
    public static void main(String args[]){
        char ch='G';
        char x1=(ch==99)?100:'G';
            //71==99 --> G
        int x2=(ch==99)?100:'G';
           //71==99 --> G
        System.out.println("x1 value is :"+x1+" x2 value is :"+x2);//G, 71

        int x=89, y=100,z;
        z=(x>y)?x:y;
        System.out.println("z value is :"+z);//100

        z=(x<y)?300:500;
        System.out.println("z value is :"+z);//300
    }
}
