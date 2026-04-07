class Solution {

    public String encode(List<String> strs) {
        StringBuilder TheString = new StringBuilder();
        StringBuilder buffer = new StringBuilder("-#-#-");
        int bufferLen = buffer.length();
        for(String s: strs){
            TheString.append(new StringBuilder(s));
            TheString.append(new StringBuilder(buffer));
        }
        System.out.println(TheString);
        return TheString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder TheString = new StringBuilder(str);
        StringBuilder buffer = new StringBuilder("-#-#-");
        int bufferLen = buffer.length();
        int index = 0;
        int start = 0;
        int end = 0;
        while(end<str.length()){
            StringBuilder stringnow = new StringBuilder();
            if(!TheString.substring(end,end+bufferLen).equals(buffer.toString())){
                end +=1;
            }
            else{
                stringnow = new StringBuilder(TheString.substring(start,end));
                result.add(stringnow.toString());
                stringnow = new StringBuilder();
                end +=5;
                start = end;
                
            }
        }
        return result;
    }
}
