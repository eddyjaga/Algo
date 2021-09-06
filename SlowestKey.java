// https://leetcode.com/problems/slowest-key/
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        TreeMap<Character, Integer> durationList = new TreeMap<>();
        char result= ' ';
        int longestDuration=0;
        durationList.put(keysPressed.charAt(0),releaseTimes[0]); // n always 2<=n<=1000
        for(int i=1; i<releaseTimes.length; i++){
            int longest = releaseTimes[i]-releaseTimes[i-1];
            char currentKey = keysPressed.charAt(i);
            durationList.put(currentKey,Math.max(durationList.getOrDefault(currentKey, 0),longest));
        }
        for (var element : durationList.entrySet()) {
            int duration = (int) element.getValue();
            char key = (char) element.getKey();
            if(duration >=longestDuration){
                longestDuration = duration;
                result = key;
            }
        }
        return result;
    }
}