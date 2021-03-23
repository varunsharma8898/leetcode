import java.util.LinkedList;

import org.junit.Assert;

public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }

        LinkedList<String> stack = new LinkedList<>();
        for (String str : path.split("/")) {

            if ("".equals(str) || ".".equals(str)) {
                continue;
            }
            if ("..".equals(str)) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.removeLast();
                    continue;
                }
            }

            stack.addLast(str);
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append("/").append(stack.poll());
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        Assert.assertEquals("/home", sp.simplifyPath("/home/"));
        Assert.assertEquals("/", sp.simplifyPath("/../"));
        Assert.assertEquals("/home/foo", sp.simplifyPath("/home//foo/"));
        Assert.assertEquals("/c", sp.simplifyPath("/a/./b/../../c/"));
    }

}
