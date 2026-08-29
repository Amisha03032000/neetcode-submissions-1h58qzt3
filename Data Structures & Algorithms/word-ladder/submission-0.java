class Pair{
    String word;
    int level;

    public Pair(String word, int level){
        this.word= word;
        this.level=level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        // beginword = "hit"
        // endWord = "cog"

        //we will try to change every character of the word to a to z and check if its available in the list
        // ait , bit, cit, dit ... zit
        // hat, hbt, hct, .. HIT ... hzt
        // hia, hib, hic, hid 

        //hit,1 -> hot,2 -> dot,3 lot,3 -> dog,4 log,4 -> cog,5 
        //aot, bot, cot, DOT
        //hat, hbt, hct .. hzt
        //hoa, hob, hoc.. hoz

        //BFS -> 
        //we can store this in a SET and whenever we see a word we will remove it from set
        // why? -> coz we dont want to elongate out path


        HashSet<String> set= new HashSet<>();
        
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i)); 
        }

        if (!set.contains(endWord)) {
            return 0;
        }

        //BFS
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1)); // hit

        while(!q.isEmpty()){
            Pair poppedWord = q.poll();  //(hit,1)
            String w = poppedWord.word; // hit
            int level = poppedWord.level; //1

            char[] word = w.toCharArray(); // ['h','i','t']
            
            for(int i=0;i<word.length;i++){ //hit.size() = 3
                char original = word[i];
                for(char ch='a'; ch<='z'; ch++){
                    word[i] = ch;
                    String nextword = new String(word);
                    if(endWord.equals(nextword)){
                        return level+1;
                    }
                    if(set.contains(nextword)){                            // ait, hot
                        q.add(new Pair(nextword, level+1));
                        set.remove(nextword);
                    }
                }
                word[i]=original;
            }

        }

    return 0;
    }
}