/*
 * I use a sentinel to move from head to the tail of s
 */
class Solution {
    public String longestPalindrome(String s) {
        /*
         * longest is to record how long is the current longest palindrome substring.
         * maxLength is to record the length from current char to the head or tail of string.
         * current is to record the current position of sentinel
         */
        int i, longest = 1, current, length = s.length();
        String result = s.substring(0, 1);
        if (length > 1){
            //Odd length substring.
            for (current = 1; current < length - 1; current ++){
                for (i = 1; i <= Math.min(current, length - current - 1); i++){ //Loop until the maxium string length.
                    if (s.charAt(current - i) != s.charAt(current + i)){
                        break;
                    }   
                }
                //Compare current substring length with longest record. If longer, then replace.
                i--;
                if (longest < 2 * i + 1){
                    longest = 2 * i + 1;
                    result = s.substring(current - i, current + i + 1);
                }
            }
            //Even length substring.
            for (current = 0; current < length - 1; current++){
                for (i = 1; i <= Math.min(current + 1, length - current - 1); i++){
                    if (s.charAt(current - i + 1) != s.charAt(current + i)){
                        break;
                    }
                }
                i--;
                if (longest < 2 * i){
                    longest = 2 * i;
                    result = s.substring(current - i + 1, current + i + 1);
                }
            }
        }
        return result;
    }
}
