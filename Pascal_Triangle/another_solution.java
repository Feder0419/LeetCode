import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        //Create a row in each loop.
        for (int i = 1; i <= numRows; i++){
            // j indicates the index in current row.
            List<Integer> row = new ArrayList<>(i);
            for (int j = 1; j <= i; j++){
                row.add(1);
            }
            int temp = 1;
            for (int j = 2; j < i; j++){
                //Elements before the center mirror.
                if (j <= (i + 1)/2){
                    temp = (temp * (i - j + 1)) / (j - 1);
                    row.set(j - 1, temp);
                    row.set(i - j, temp);
                }
            }
            result.add(row);
        }
        return result;
    }
}

/*
* These two solution have almost exactly the same time complexity. The first one read the value of index before the mirror, while this one set all initial value to 1 before all other process.
* This is because ArrayList cannot set value of index beyond its current size, so though each row is mirrored, we cannot set the value on the other side of mirror before we reached the mirror.
*/
