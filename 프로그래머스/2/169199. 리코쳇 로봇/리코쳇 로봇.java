import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        int[] arr = new int[2];
        boolean[][] visited = new boolean[board.length][board[0].length()];
        LinkedList<int[]> list = new LinkedList<>();
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if(board[i].charAt(j) == 'R') {
                    int[] tmp = new int[2];
                    tmp[0] = i;
                    tmp[1] = j;
                    list.add(tmp);
                }else if (board[i].charAt(j) == 'D') {
                    visited[i][j] = true;
                }
            }
        }
        
        while(true) {
            boolean success = false;
            int size = list.size();
            if(list.size() == 0)
                break;
            for(int i = 0; i < size; i++) {
                int[] tmp = list.poll();
                
                int tmpX = tmp[0];
                int tmpY = tmp[1];
                
                if(visited[tmpX][tmpY])
                    continue;
                else
                    visited[tmpX][tmpY] = true;
                
                if(board[tmpX].charAt(tmpY) == 'G') {
                    success = true;
                    break;
                }
                
                while(tmpX > 0 && board[tmpX-1].charAt(tmpY) != 'D') {
                    tmpX--;
                }
                int[] tmpArr = new int[2];
                tmpArr[0] = tmpX;
                tmpArr[1] = tmpY;
                list.add(tmpArr);
                
                tmpX = tmp[0];
                tmpY = tmp[1];
                while(tmpX < board.length-1 && board[tmpX+1].charAt(tmpY) != 'D') {
                    tmpX++;
                }
                
                int[] tmpArr2 = new int[2];
                tmpArr2[0] = tmpX;
                tmpArr2[1] = tmpY;
                list.add(tmpArr2);
                
                tmpX = tmp[0];
                tmpY = tmp[1];
                while(tmpY > 0 && board[tmpX].charAt(tmpY-1) != 'D') {
                    tmpY--;
                }
                int[] tmpArr3 = new int[2];
                tmpArr3[0] = tmpX;
                tmpArr3[1] = tmpY;
                list.add(tmpArr3);
                
                int[] tmpArr4 = new int[2];
                tmpX = tmp[0];
                tmpY = tmp[1];
                while(tmpY < board[0].length()-1 && board[tmpX].charAt(tmpY+1) != 'D') {
                    tmpY++;
                }
                tmpArr4[0] = tmpX;
                tmpArr4[1] = tmpY;
                list.add(tmpArr4);
                
                
                System.out.print(tmp[0] + ", " + tmp[1] + "   ");
            }
            System.out.println();
            if(success)
                return answer;
            answer++;
        }
        return -1;
    }
}