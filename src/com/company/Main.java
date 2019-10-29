package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, 3, sb, false);
        return res;
    }

    private void dfs(String s, int st, int dots, StringBuilder sb, boolean isDot) {
        if (dots < 0)
            return;

        if (st >= s.length()) {
            if (dots == 0) {
                res.add(sb.toString());
                return;
            } else
                return;
        }

        if (isDot) {
            sb.append(".");
            dfs(s, st, dots - 1, sb, false);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            for (int len = 1; len <= 3; len++) {
                if (st + len > s.length()) {
                    continue;
                }
                String newS = s.substring(st, st + len);
                if ((newS.length() > 1 && newS.charAt(0) == '0') ||
                        Integer.parseInt(newS) > 255 ||
                        Integer.parseInt(newS) < 0)
                    continue;

                sb.append(newS);
                dfs(s, st + len, dots, sb, true);
                sb.delete(sb.length() - len, sb.length());

            }
        }
    }
}