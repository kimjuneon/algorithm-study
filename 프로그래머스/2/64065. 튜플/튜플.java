import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length()-2);
        String[] sArr = s.split("\\},\\{");
        ArrayList<Integer> list[] = new ArrayList[sArr.length];
        for(int i = 0; i < sArr.length; i++) {
            list[i] = new ArrayList<Integer>();
            String tmpArr[] = sArr[i].split(",");
            for(int j = 0; j < tmpArr.length; j++) {
                list[i].add(Integer.parseInt(tmpArr[j]));
            }
        }
        
        HashSet<Integer> seen = new HashSet<>();
        int[] answer = new int[sArr.length];
        
        Arrays.sort(list, Comparator.comparingInt(l -> l.size()));
        for(int i = 0; i < list.length; i++) {
            for(int j = 0; j < list[i].size(); j++) {
                if(seen.add(list[i].get(j))){
                    answer[i] = list[i].get(j);
                    break;
                }
            }
            // System.out.println(answer[i]);
            
        }
        
        return answer;
    }
}