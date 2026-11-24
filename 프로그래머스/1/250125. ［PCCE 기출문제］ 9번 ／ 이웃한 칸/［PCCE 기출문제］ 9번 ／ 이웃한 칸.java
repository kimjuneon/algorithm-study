class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int hight = board.length;
        int width = board[0].length;
        
        String color = board[h][w];
        
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                if(i == 0 && j == 0)
                    continue;
                if(i != 0 && j != 0)
                    continue;
                if(h+i < 0 || w+j < 0 || h+i >= hight || w+j >= width)
                    continue;
                
                if(board[h+i][w+j].equals(color))
                    answer++;
            }
        }
        
        return answer;
    }
}