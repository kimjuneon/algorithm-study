class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        // 그냥 1차원 배열로하고 문자열에서 .get()을 통해 추출하는 방식
        int r = -1, c = -1;
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    r = i;
                    c = j;
                    break;
                }
            }
            if(r != -1 || c != -1)
                break;
        }
        
        for(String order : routes){
            String[] tmp = order.split(" ");
            String dir = tmp[0];
            int num = Integer.parseInt(tmp[1]);
            
            // 가는 방향에 장애물이 없는지 확인(+구역을 벋어나는지도)
            boolean ok = true;
            
            if(dir.equals("E")){
                for(int j = 1; j < num+1; j++){
                    if(c+j >= park[0].length() || park[r].charAt(c+j) == 'X'){
                        ok = false;
                        break;
                    }
                }
                if(ok)
                    c += num;
            }else if(dir.equals("W")){
                for(int j = 1; j < num+1; j++){
                    if(c-j < 0 || park[r].charAt(c-j) == 'X'){
                        ok = false;
                        break;
                    }
                }
                if(ok)
                    c -= num;
            }else if(dir.equals("S")){
                for(int j = 1; j < num+1; j++){
                    if(r+j >= park.length || park[r+j].charAt(c) == 'X'){
                        ok = false;
                        break;
                    }
                }
                if(ok)
                    r += num;
            }else{
                for(int j = 1; j < num+1; j++){
                    if(r-j < 0 || park[r-j].charAt(c) == 'X'){
                        ok = false;
                        break;
                    }
                }
                if(ok)
                    r -= num;
            }

        }
        
        answer[0] = r;
        answer[1] = c;
        return answer;
    }
}