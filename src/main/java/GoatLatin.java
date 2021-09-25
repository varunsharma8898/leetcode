import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;

public class GoatLatin {

    private Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String toGoatLatin(String S) {

        if (S == null || S.length() == 0) {
            return S;
        }

        List<String> res = new ArrayList<>();
        int aa = 1;
        for (String word : S.split(" ")) {
            StringBuilder sb = new StringBuilder();
            if (vowels.contains(word.charAt(0))) {
                sb.append(word);
            } else {
                sb.append(word.substring(1)).append(word.charAt(0));
            }
            sb.append("ma");
            for (int i = 0; i < aa; i++) {
                sb.append("a");
            }
            res.add(sb.toString());
            aa++;
        }

        return res.stream().collect(Collectors.joining(" "));
    }

    public String toGoatLatin2(String S) {

        if (S == null || S.length() == 0) {
            return S;
        }

        StringBuilder result = new StringBuilder();
        int aa = 1;
        for (String word : S.split(" ")) {
            result.append(" " + (vowels.contains(word.charAt(0)) ? word : word.substring(1) + word.charAt(0)) + "ma");
            for (int i = 0; i < aa; i++) {
                result.append("a");
            }
            aa++;
        }

        return result.substring(1);
    }

    public static void main(String[] args) {
        GoatLatin gl = new GoatLatin();
        Assert.assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", gl.toGoatLatin("I speak Goat Latin"));
        Assert.assertEquals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa",
                gl.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
