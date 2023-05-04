package ex00;

public class RecLion {

    public static void main(String[] args){
        HelloLion(0);
    }

    public static void HelloLion(int n){
        String s = String.format("Hello Baby Lion %02d",n);
        System.out.println(s);
        n+=1;
        if (n>10){
            return;
        }
        HelloLion(n);

    }

}
