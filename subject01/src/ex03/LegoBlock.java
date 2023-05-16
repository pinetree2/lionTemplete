package ex03;

import java.util.Scanner;

public class LegoBlock {

/*
* 하노이의 탑 알고리즘...이 거의 초면이라서
* 참고해서 풀었다.
* 다음번에는 알고리즘 제대로 공부해서 파이썬으로.. ^^
* */
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N= in.nextInt();
        int i = in.nextInt();
        int j = in.nextInt();

        sb.append((int) (Math.pow(2, N) - 1)).append('\n');

        Hanoi(N, i, i+j/2 ,j);
        System.out.println(sb);

    }


    /*
	N : 원판의 개수
	start : 출발지
	mid : 옮기기 위해 이동해야 장소
	to : 목적지
*/

    static void Hanoi(int N, int start, int mid, int to) {

        // 이동할 원반의 수가 1개라면?
        if (N == 1) {
            System.out.println(start + " " + to + "\n");
            return;
        }

        // A -> C로 옮긴다고 가정할 떄,
        // STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
        Hanoi(N - 1, start, to, mid);

        // STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
        System.out.println(start + "번 레고를 " + to + "로 옮깁니다\n");

        // STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
        Hanoi(N - 1, mid, start, to);

    }
}
