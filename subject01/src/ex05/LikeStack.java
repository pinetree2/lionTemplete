package ex05;

public class LikeStack {
    // ex04에서 만든 LikeList 사용
    private LikeList list;
    LikeList.Node head;
    LikeList.Node top;


    //스택은 LIFO (후입선출)
    /***
     * // 스택 생성자
     *     public class ListStack {
     *         ListStack(int size){
     *             head = null; // head 초기화
     *             top = null;    // top 포인터 초기화
     *
     *         }
     *
     *     }
     *
     *
     * ***/


    // 추가
    public void push(int value) {
        LikeList.Node newNode = new LikeList.Node(value);
        if (!isEmpty()) {
            newNode.next = this.head;
        }
        top = newNode;
        this.head = newNode;
    }
    // 삭제
    public void pop() {
        //스택 맨 위에(맨처음꺼)
        if (isEmpty()){
            System.out.println("스택이 비어있습니다");
            throw new ArrayIndexOutOfBoundsException();
        }
        else{

            LikeList.Node popnode = this.head;
            int data = popnode.data; //담긴데이터 저장
            this.head = this.head.next; //헤드를 다음값으로 지정

            System.out.println(data);

        }

    }
    // 스택의 마지막 값 조회
    public void peek() {
        if(isEmpty()){
            System.out.println("비어있습니다");
            throw new ArrayIndexOutOfBoundsException();
        }
        else{
            System.out.println(top.data);
        }


    }
    // 스택이 비어있다면 true
    public boolean isEmpty() {
        System.out.println(top ==null);
        return (top ==null);
    }
}
