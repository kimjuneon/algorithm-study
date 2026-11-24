class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int height = wallpaper.length;
        int width = wallpaper[0].length();
        
        int rMin = height-1;
        int cMin = width-1;
        int rMax = 0;
        int cMax = 0;
        
        for(int r = 0; r < height; r++){
            for(int c = 0; c < width; c++){
                if(wallpaper[r].charAt(c) == '#'){
                    if(r > rMax)
                        rMax = r;
                    if(c > cMax)
                        cMax = c;
                    if(r < rMin)
                        rMin = r;
                    if(c < cMin)
                        cMin = c;
                }
            }
        }
        
        answer[0] = rMin;
        answer[1] = cMin;
        answer[2] = rMax+1;
        answer[3] = cMax+1;
        
        return answer;
    }
}