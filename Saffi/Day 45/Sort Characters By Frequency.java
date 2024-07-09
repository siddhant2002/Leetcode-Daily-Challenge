class Pair{
    int first;
    char second;

    Pair(int f, char s) {
        first = f;
        second = s;
    }
}

class Solution {
    public String frequencySort(String s) {

        int[] hasha = new int[26];
        int[] hashA = new int[26];
        int[] hashD = new int[10];

        for(char c : s.toCharArray()) {
            if(c >= 65 && c <= 90) {
                hashA[c - 'A']++;
            }
            else if(c >= 97) {
                hasha[c - 'a']++;
            }
            else {
                hashD[c - '0']++;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.first - a.first);

        for(int i = 0; i < 26; i++) {
            if(hasha[i] != 0) {
                pq.offer(new Pair(hasha[i], (char)('a' + i)));
            }
        }
        for(int i = 0; i < 26; i++) {
            if(hashA[i] != 0) {
                pq.offer(new Pair(hashA[i], (char)('A' + i)));
            }
        }
        for(int i = 0; i < 10; i++) {
            if(hashD[i] != 0) {
                pq.offer(new Pair(hashD[i], (char)('0' + i)));
            }
        }
        StringBuilder str = new StringBuilder();

        while(!pq.isEmpty()) {
            int freq = pq.peek().first;
            char c = pq.peek().second;

            pq.poll();

            while(freq-- > 0) {
                str.append(c);
            }
        }

        return str.toString();
    }
}