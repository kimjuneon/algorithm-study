class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String len[] = video_len.split(":");
        int lenMM = Integer.parseInt(len[0]);
        int lenSS = Integer.parseInt(len[1]);
        
        String[] tmp = op_start.split(":");
        int op_startMM = Integer.parseInt(tmp[0]);
        int op_startSS = Integer.parseInt(tmp[1]);
        
        String[] tmp1 = op_end.split(":");
        int op_endMM = Integer.parseInt(tmp1[0]);
        int op_endSS = Integer.parseInt(tmp1[1]);
        
        int posMM = 0;
        int posSS = 0;
        
        String[] tmp2 = pos.split(":");
        posMM = Integer.parseInt(tmp2[0]);
        posSS = Integer.parseInt(tmp2[1]);
        
        for(int i = 0; i < commands.length; i++){
            
            int start = op_startMM * 60 + op_startSS;
            int end = op_endMM * 60 + op_endSS;
            int poss = posMM * 60 + posSS;
            
            if(poss >= start && poss <= end){
                posMM = op_endMM;
                posSS = op_endSS;
            }
            
            if(commands[i].equals("prev")){
                if(posMM == 0 && posSS < 10)
                    posSS = 0;
                else if(posSS < 10){
                    posMM -= 1;
                    posSS += 50;
                }else{
                    posSS -= 10;
                }
            }else if(commands[i].equals("next")){
                if((posMM*60 + posSS + 10) > (lenMM*60 + lenSS)){
                    posMM = lenMM;
                    posSS = lenSS;
                }
                else if(posSS > 50){
                    posMM += 1;
                    posSS -= 50;
                }else{
                    posSS += 10;
                }
            }
            
            start = op_startMM * 60 + op_startSS;
            end = op_endMM * 60 + op_endSS;
            poss = posMM * 60 + posSS;
            if(poss >= start && poss <= end){
                posMM = op_endMM;
                posSS = op_endSS;
            }
            
        }
        
        String answerMM = Integer.toString(posMM);
        String answerSS = Integer.toString(posSS);
        
        if(posMM < 10){
            answerMM = "0" + Integer.toString(posMM);
        }
        if(posSS < 10){
            answerSS = "0" + Integer.toString(posSS);
        }
        
        answer = answerMM + ":" + answerSS;
        return answer;
    }
}
