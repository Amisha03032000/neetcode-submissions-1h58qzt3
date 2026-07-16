class Solution {
    public int leastInterval(char[] tasks, int n) {
    
    
        HashMap<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int maxFreq = 0;

        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int maxCount = 0;
        for (int freq : map.values()) {
            if (freq == maxFreq) {
                maxCount++;
            }
        }

        int partCount = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * Math.max(0, partLength);

        int availableTasks = tasks.length - (maxFreq * maxCount);

        int idle = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idle;
    }
}
