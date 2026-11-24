import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < moves.length; i++) {
            int c = moves[i]-1;
            for (int j = 0; j < board.length; j++) {
                if(board[j][c] != 0) {
                    if(deque.size() > 0 && board[j][c] == deque.peekLast()) {
                        answer+=2;
                        deque.pollLast();
                    } else
                        deque.addLast(board[j][c]);
                    board[j][c] = 0;
                    break;
                }
            }
            // for (int j = 0; j < board.length; j++) {
            //     for (int k = 0; k < board[0].length; k++)
            //         System.out.print(board[j][k]+" ");
            //     System.out.println();
            // }
            // for(int d : deque) {
            //     System.out.print(d+", ");
            // }
            // System.out.println("answer: " + answer);
        }
        
        return answer;
    }
}