package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> response = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String s : delimiters) {
            sb.append(s);
        }
        String d = sb.toString();
        StringTokenizer st = new StringTokenizer(source, d);
        while (st.hasMoreTokens()) {
            response.add(st.nextToken());
        }
        return response;
    }
}
