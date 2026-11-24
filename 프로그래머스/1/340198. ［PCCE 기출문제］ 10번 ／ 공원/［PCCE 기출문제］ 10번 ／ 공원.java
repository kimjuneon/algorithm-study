import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        for(int i = mats.length-1; i >= 0; i--){
            int mat = mats[i];
            
            for(int j = 0; j < park.length-mat+1; j++){
                for(int p = 0; p < park[j].length-mat+1; p++){
                    if(check(mat, j, p, park))
                        return mat;
                }
            }
        }
        
        return -1;
    }

    private boolean check(int num, int n1, int n2, String[][] park){
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                if(!park[n1+i][n2+j].equals("-1"))
                    return false;
            }
        }
        return true;
    }
}