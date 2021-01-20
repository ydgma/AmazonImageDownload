package com.ydprojects.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    public static String extractSrcFromElement(String html) {
            String regex = "src=\"(.*?)\"";
            String string = null;
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(html);
            if (m.find()) {
                string = m.group();
            }
            string = string.replaceAll("\"","").replaceAll("src=","");

            return string;
    }
}
