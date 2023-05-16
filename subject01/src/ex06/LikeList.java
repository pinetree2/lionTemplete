package ex06;

public class LikeList {


    private Node head;

    public static class Node {
        int data; // 데이터
        Node next; //다음 노드를 가리키는 필드

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    //index에 도달할때까지 x를 기점으로 옆으로 넘기는..
    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    // 삽입 메서드, index 위치에 노드 추가
    public void insert(int index, int data) {
        if(index == 0){
// 노드를 생성합니다.
            Node newNode = new Node(data);
            // 새로운 노드의 다음 노드로 해드를 지정합니다.
            newNode.next = head;
            // 헤드로 새로운 노드를 지정합니다.
            head = newNode;
        }
        else{

            Node x1 = node(index-1);
            //index번째 노드를 x2 로 지정
            Node x2 = x1.next;
            // 새로운 값을가진 노드 생성
            Node newNode = new Node(data);

            //x1 노드의 다음노드로 새 노드 지정
            x1.next = newNode;

            //새 노드의 다음 노드로 x2 지정
            newNode.next = x2;


        }

    }



    // 삭제 메서드, index 위치에 노드 삭제
    public void delete(int index) {
        if (index ==0)
        {
            // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
            Node temp = head;
            head = temp.next;
            temp = null;

        }else{
            // k-1번째 노드를 temp의 값으로 지정합니다.
            Node temp = node(index-1);
            // 삭제 노드를 todoDeleted에 기록해 둡니다.
            // 삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없습니다.
            Node todoDeleted = temp.next;
            // 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정합니다.
            temp.next = temp.next.next;
            // cur.next를 삭제 합니다.
            todoDeleted = null;

        }

    }

    // 전체 노드 출력 메서드
    public void print() {
// 노드가 없다면 []를 리턴합니다.
        if(head == null){
            System.out.println("[]");
        }
        // 탐색을 시작합니다.
        Node temp = head;
        String str = "[";
        // 다음 노드가 없을 때까지 반복문을 실행합니다.
        // 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
        while(temp.next != null){
            str += temp.data + ",";
            temp = temp.next;
        }
        // 마지막 노드를 출력결과에 포함시킵니다.
        str += temp.data;
        System.out.println(str+"]");
    }
}
