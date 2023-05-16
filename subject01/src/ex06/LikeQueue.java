package ex06;

public class LikeQueue {

    //FIFO

    // ex04에서 만든 LikeList 사용
    private LikeList list;
    LikeList.Node node;
    LikeList.Node head;
    LikeList.Node front;
    LikeList.Node rear;
    private int size;

    public LikeQueue() {
        this.head = null;
        this.rear= null;
        this.front =null;
        this.size = 0;
    }
    // 추가
    public void enqueue(int value) {
        // 비어있을 경우
        LikeList.Node newNode = new LikeList.Node(value);

        if(isEmpty()){
                this.head = newNode;
                this.front = this.head;
                this.rear = this.head;
            size++;
        }else{
            /**
             * rear이 가리키는 노드를 새 노드로 바꿔준다.
             */
            this.rear = newNode;
        }

    }
    // 삭제
    public void dequeue() {

        // 삭제할 요소가 없을 경우 null 반환
        if(isEmpty()) {
            System.out.println("null");
        }

        // 삭제될 요소의 데이터를 반환하기 위한 임시 변수
        int element = head.data;
        // head 노드의 다음노드
        LikeList.Node nextNode = head.next;

        // head의 모든 데이터들을 삭제
        head.data = 0;
        head.next = null;

        // head 가 가리키는 노드를 삭제된 head노드의 다음노드를 가리키도록 변경
        head = nextNode;
        size--;

    }
    // 큐의 첫번쨰 값 조회
    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return 0;
        } else {
            System.out.println(front.data);
            return front.data;
        }

    }
    // 큐가 비었는지 확인
    // 큐가 비어있는 상태인지 확인
    public boolean isEmpty(){
        return (front == null && rear == null);
    }