import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        
        int menu = -1;
        
        if(ext.equals("code"))
            menu = 0;
        else if(ext.equals("date"))
            menu = 1;
        else if(ext.equals("maximum"))
            menu = 2;
        else
            menu = 3;
        
        for(int i = 0; i < data.length; i++){
            if(data[i][menu] < val_ext){
                list.add(data[i]);
            }
        }
        
        if(sort_by.equals("code"))
            menu = 0;
        else if(sort_by.equals("date"))
            menu = 1;
        else if(sort_by.equals("maximum"))
            menu = 2;
        else
            menu = 3;
        
        int tmp = menu;
        list.sort(Comparator.comparingInt(a -> a[tmp]));
        
        int[][] answer = new int[list.size()][4];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }

}