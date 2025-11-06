/*
 * We do need to be careful of some details. The rest strings of the array might not be as long as the first one.
 * So there's possiblity of going out of boundary.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result;
        char temp;
        int i, length = strs.length;
        if (length == 1){
            result = strs[0];
        }else{
            int maxLength = strs[0].length();
            for (String s : strs){
                maxLength = Math.min(maxLength, s.length());
            }
            //Loop until the first non-common char.
            outerloop:
            for(i = 0; i < maxLength; i++){
                temp = strs[0].charAt(i);
                for (int j = 1; j < length; j++){
                    if (strs[j].charAt(i) != temp) break outerloop;
                }
            }
            result = strs[0].substring(0, i);   //Get the longest common prefix.
        }
        return result;
    }
}
