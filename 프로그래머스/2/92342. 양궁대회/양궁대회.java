class Solution {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        
        answer = dfs(0, answer, n, info);
        
        if(getTotalScore(answer, info) <= getTotalScoreForApeach(info, answer)){
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
    
    // idx는 10 -> 0 으로 줄어들기
    private int[] dfs(int idx, int[] rionScore, int remains, int[] info){
        if(remains <= 0)
            return rionScore;
        if(idx == 10) {
            rionScore[10] = remains;
            return rionScore;
        }
        
        int[] tmp1 = dfs(idx+1, rionScore.clone(), remains, info); // 해당 점수 취득 안함
        int[] tmp2 = new int[11];
        if(info[idx]+1 <= remains){
            rionScore[idx] = info[idx] + 1;
            remains -= info[idx] + 1;
            tmp2 = dfs(idx+1, rionScore.clone(), remains, info);
        }
        
        if((getTotalScore(tmp1, info) - getTotalScoreForApeach(info, tmp1)) 
            > (getTotalScore(tmp2, info) - getTotalScoreForApeach(info, tmp2))){
            return tmp1;
        }else if ((getTotalScore(tmp1, info) - getTotalScoreForApeach(info, tmp1)) 
            < (getTotalScore(tmp2, info) - getTotalScoreForApeach(info, tmp2))){
            return tmp2;
        }
        else{
             for(int i = 10; i >= 0; i--){
                 if(tmp1[i] > tmp2[i])
                     return tmp1;
                 else if(tmp1[i] < tmp2[i])
                     return tmp2;
             }
            return tmp1;
        }
            
    }
    
    private int getTotalScore(int[] arr, int[] info){ // 라이언 점수
        int total = 0;
        for(int i = 0; i < 10; i++){
            if(arr[i] > info[i])
                total += 10-i;
        }
        return total;
    }
    
    private int getTotalScoreForApeach(int[] arr, int[] rion){ // 어피치 점수
        int total = 0;
        for(int i = 0; i < 10; i++){
            if(arr[i] >= rion[i] && arr[i] > 0)
                total += 10-i;
        }
        return total;
    }
}