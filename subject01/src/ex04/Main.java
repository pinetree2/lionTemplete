package ex04;

public class Main {
    public static void main(String[] args) {
        LikeList numbers = new LikeList();
        numbers.insert(0,1);
        numbers.insert(1,2);
        numbers.insert(2,3);
        numbers.insert(3,5);
        numbers.insert(4,10);
        numbers.delete(2);
        numbers.print();

    }
}
