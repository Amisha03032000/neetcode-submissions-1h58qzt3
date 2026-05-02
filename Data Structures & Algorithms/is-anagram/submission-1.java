class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapt = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(maps.containsKey(s.charAt(i))){
                maps.put(s.charAt(i), maps.get(s.charAt(i)+1));
            }else{
                maps.put(s.charAt(i),1);
            }
        }

        for(int j=0;j<t.length();j++){
            if(mapt.containsKey(t.charAt(j))){
                mapt.put(t.charAt(j), mapt.get(t.charAt(j)+1));
            }else{
                mapt.put(t.charAt(j),1);
            }
        }
        if(maps.equals(mapt)){
            return true;
        }

    return false;

    }
}
