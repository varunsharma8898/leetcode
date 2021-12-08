public class DivideStringInKGroups {

    public String[] divideString(String s, int k, char fill) {
        int n = s.length() / k;
        if (s.length() % k > 0) {
            n++;
        }
        String[] res = new String[n];

        for (int i = 0; i < n; i++) {
            int start = i * k;
            String s1;
            if (start + k > s.length()) {
                s1 = s.substring(start);
                int repeat = start + k - s.length();
                for (int j = 0; j < repeat; j++) {
                    s1 += fill;
                }
            } else {
                s1 = s.substring(start, start + k);
            }
            res[i] = s1;
        }
        return res;
    }

    public static void main(String[] args) {
        DivideStringInKGroups obj = new DivideStringInKGroups();
        String[] res = obj.divideString("abcdefghij", 3, 'x');
        System.out.println(res);
    }
}
