import java.io.*;
import java.util.*;

public class Editor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 문자열 입력
        String initial = br.readLine();
        int m = Integer.parseInt(br.readLine()); // 명령어 개수

        // LinkedList 대신 Stack 2개를 사용
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (char ch : initial.toCharArray()) {
            left.addLast(ch); // 초기에는 모두 왼쪽에 위치
        }

        for (int i = 0; i < m; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "L":
                    if (!left.isEmpty()) right.addFirst(left.removeLast());
                    break;
                case "D":
                    if (!right.isEmpty()) left.addLast(right.removeFirst());
                    break;
                case "B":
                    if (!left.isEmpty()) left.removeLast();
                    break;
                case "P":
                    char c = cmd[1].charAt(0);
                    left.addLast(c);
                    break;
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (char ch : left) sb.append(ch);
        for (char ch : right) sb.append(ch);

        System.out.println(sb);
    }
}
