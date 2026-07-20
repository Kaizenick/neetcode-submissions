class Solution {

    public String encode(List<String> strs) {
        String cut = "#-#-#-#-#-#";
        String encoded = "";
        if(strs.size() == 0){
            return "";
        }
        for(int i = 0; i< strs.size(); i++){
            if(strs.get(i)==""){
                encoded += "emptyString";
            }
            encoded += strs.get(i);
            if(i==strs.size() - 1){
                break;
            }
            encoded+=cut;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        if(str==""){
            return new ArrayList<String>();
        }
        ArrayList<String> ans = new ArrayList<>((Arrays.stream(str.split("#-#-#-#-#-#")).toList()));
        for(int i = 0; i<ans.size(); i++){
            if(ans.get(i).equals("emptyString")){
                ans.set(i,"");
            }
        }
        return ans;
    }
}
