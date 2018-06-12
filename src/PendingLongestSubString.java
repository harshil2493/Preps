import java.util.HashSet;
import java.util.Set;

class PendingLongestSubString {
//    public static void main(String[] args) {
//        String a = "abcabcbb";
//        System.out.println(a + " " + new Solution().lengthOfLongestSubstring(a));
//        String b = "bbbbb";
//        System.out.println(b + " " + new Solution().lengthOfLongestSubstring(b));
//        String c = "pwwkew";
//        System.out.println(c + " " + new Solution().lengthOfLongestSubstring(c));
//    }
}

//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        Set<String> allCheckedStrings = new HashSet<>();
//
//        int lenghtOfS = s.length();
//        int maxSize = 0;
//        for (int outter = 0; outter < lenghtOfS; outter++) {
//            for (int inner = outter; inner < lenghtOfS; inner++) {
//                String subS = s.substring(outter, inner + 1);
//                if (!allCheckedStrings.contains(subS)) {
//                    allCheckedStrings.add(subS);
//
//                    System.out.println(subS);
//                    if (allUnique(subS) && subS.length() > maxSize) {
//                        maxSize = subS.length();
//                    }
//                }
//            }
//        }
//
//        return maxSize;
//    }
//
//    boolean allUnique(String subS) {
//        Set<Character> uniqueChars = new HashSet<Character>();
//        boolean allUnique = true;
//
//        for (char eachCh : subS.toCharArray()) {
//            if (!uniqueChars.contains(eachCh)) {
//                uniqueChars.add(eachCh);
//            } else {
//                allUnique = false;
//                break;
//            }
//        }
//
//        return allUnique;
//    }
//}
