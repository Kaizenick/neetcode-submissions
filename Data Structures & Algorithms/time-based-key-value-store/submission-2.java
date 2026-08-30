
//leetcode submit region begin(Prohibit modification and deletion)
class TimeMap {

    public static int getMaxTimeStamp(List<Integer> arr, int currentTimeStamp) {
        int i = 0;
        int j = arr.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr.get(mid) > currentTimeStamp) {
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        if(j<0){
            return -1;
        }else{
            return arr.get(j);
        }
    }

    HashMap<String, HashMap<Integer, String>> namesMap;
    HashMap<String, List<Integer>> timeStampsMap;

    public TimeMap() {
        namesMap = new HashMap<>();
        timeStampsMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (namesMap.containsKey(key)) {
            // Updating the namesMap
            HashMap<Integer, String> h1 = namesMap.get(key);
            h1.put(timestamp, value);
            namesMap.put(key, h1);

            // Updating the timeStampMap
            List<Integer> timestampList = timeStampsMap.get(key);
            timestampList.add(timestamp);
            timeStampsMap.put(key, timestampList);
        } else {
            HashMap<Integer, String> h1 = new HashMap<>();
            h1.put(timestamp, value);
            namesMap.put(key, h1);

            List<Integer> timestampList = new ArrayList<>();
            timestampList.add(timestamp);
            timeStampsMap.put(key, timestampList);
        }
//        System.out.println(namesMap);
//        System.out.println(timeStampsMap);
    }

    public String get(String key, int timestamp) {
        if(!namesMap.containsKey(key)){
            return "";
        }
        if (namesMap.containsKey(key) && namesMap.get(key).containsKey(timestamp)) {
            return namesMap.get(key).get(timestamp);
        } else {
            int BestTimeStamp = getMaxTimeStamp(timeStampsMap.get(key), timestamp);
            if(BestTimeStamp==-1){
                return "";
            }else{
                return namesMap.get(key).get(BestTimeStamp);
            }
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)
