class Solution {
    static List<Boolean> bol = new ArrayList<>();
    public static boolean palindromeCheck(StringBuilder sb){
        // System.out.println(sb);
        int i = 0;
        int j = sb.length()-1;
        while(i<j){
            if(sb.charAt(i)!=sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.toLowerCase().charAt(i));
            }
        }
        int index = 0;
        for(int i = 0; i<sb.length(); i++){
            StringBuilder a = new StringBuilder(sb.substring(0,i));
            // System.out.println(a);
            StringBuilder b = new StringBuilder(sb.substring(i+1,sb.length()));
            // System.out.println(b);
            boolean k = palindromeCheck(a.append(b));
            if(k == true){
                return true;
            }
        }
        return false;
    }
}
