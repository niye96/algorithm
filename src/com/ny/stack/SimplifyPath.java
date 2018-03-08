package com.ny.stack;

import java.util.Stack;

/**
 * @Author: ny
 * @Date: Created in 9:57 2018/3/8 0008
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            if (!"".equals(strs[i])) {
                if ("..".equals(strs[i])) {
                    if (!stack.empty()) stack.pop();
                } else if (".".equals(strs[i])) {
                    ;
                } else {
                    stack.push(strs[i]);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        if (stack.empty()) return "/";
        while (!stack.empty()) {
            builder.insert(0, "/" + stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/.."));
    }
}
