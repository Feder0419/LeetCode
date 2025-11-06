import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        //Create a row in each loop.
        for (int i = 1; i <= numRows; i++){
            // j indicates the index in current row.
            List<Integer> row = new ArrayList<>(i);
            int temp = 1;
            for (int j = 1; j <= i; j++){
                //Elements before the center mirror.
                if (j == 1) row.add(temp);
                else if (j <= (i + 1)/2){
                    temp = (temp * (i - j + 1)) / (j - 1);
                    row.add(temp);
                }else{
                    row.add(row.get(i - j));
                }
            }
            result.add(row);
        }
        return result;
    }
}
