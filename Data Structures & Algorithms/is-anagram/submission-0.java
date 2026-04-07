class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<String,Integer> s1 = new HashMap<>();
        HashMap<String,Integer> t1 = new HashMap<>();

        for(int i = 0; i<=s.length()-1;i++){
            s1.put(String.valueOf(s.charAt(i)),s1.getOrDefault(String.valueOf(s.charAt(i)),0)+1);
        }
        for(int i = 0; i<=t.length()-1;i++){
            t1.put(String.valueOf(t.charAt(i)),t1.getOrDefault(String.valueOf(t.charAt(i)),0)+1);
        }
        
        return s1.equals(t1);
    }
}
