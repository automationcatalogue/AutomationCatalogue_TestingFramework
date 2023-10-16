package teachings.java.fundamentals;

public class ArrayDemo1 {
    public static void main(String[] args) {
        int a[]={10, 12, 15, 17, 19,21,67,98,150};

        for(int i=0;i<a.length;i++){
            if(a[i]%2==0){
                System.out.println(a[i]);
            }
        }

    }
}
