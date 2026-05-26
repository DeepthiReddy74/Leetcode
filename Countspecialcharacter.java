class Countspecialcharacter {
    public int numberOfSpecialChars(String word) {
        boolean[] hasLower = new boolean[26];
        boolean[] hasUpper = new boolean[26];
        int specialCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                hasLower[ch - 'a'] = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                hasUpper[ch - 'A'] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (hasLower[i] && hasUpper[i]) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}