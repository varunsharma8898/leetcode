public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int[] map = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            // int s = Character.getNumericValue(secret.charAt(i));
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (map[s] > 0) {
                    cows++;
                }
                if (map[g] < 0) {
                    cows++;
                }
                map[s]--;
                map[g]++;
            }
        }
        return String.format("%dA%dB", bulls, cows);
    }

}
