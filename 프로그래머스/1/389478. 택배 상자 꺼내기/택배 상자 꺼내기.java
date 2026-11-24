class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int height = n / w + 1;
        int[][] arr = new int[height][w];
        
        int row = -1, col = -1;
        
        for(int i = 0; i < height; i++){
            
            for(int j = 0; j < w; j++){
                
                if(height-1 == i && j >= n%w){
                    continue;
                }
                
                if(i % 2 == 0){
                    arr[i][j] = i*w + j + 1;
                    if(num == i*w + j + 1){
                        row = i;
                        col = j;
                    }
                }else{
                    arr[i][w-j-1] = i*w + j + 1;
                    if(num == i*w + j + 1){
                        row = i;
                        col = w-j-1;
                    }
                }
            }
            
        }
        
        int i = 0;
        while(row+i < height){
            if(arr[row+i][col] != 0)
                answer++;                
            i++;
        }
        
        return answer;
    }
}