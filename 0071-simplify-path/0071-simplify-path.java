import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        // Split path by '/' and process each part
        for (String part : path.split("/")) {
            if (part.equals("") || part.equals(".")) {
                continue; // Ignore empty or current directory
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop(); // Go up
            } else {
                stack.push(part); // Valid directory
            }
        }

        // Build result from stack
        return "/" + String.join("/", stack);
    }
}
