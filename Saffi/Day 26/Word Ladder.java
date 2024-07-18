class Pair{
    String word;
    int count;

    Pair(String w, int c) {
        word = w;
        count = c;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();

        for(String s : wordList) {
            set.add(s);
        }

        Queue<Pair> q = new ArrayDeque<>();

        q.offer(new Pair(beginWord, 1));

        while(!q.isEmpty()) {
            String word = q.peek().word;
            int count = q.peek().count;

            q.poll();

            if(word.equals(endWord)) return count;

            for(int i = 0; i < word.length(); i++) {
                for(int j = 0; j < 26; j++) {
                    String s = word.substring(0, i) + (char)('a' + j) + word.substring(i + 1);

                    if(set.contains(s)) {
                        q.offer(new Pair(s, count + 1));

                        set.remove(s);
                    }
                }
            }
        }

        return 0;
    }
}