package csg.swing.html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsGHtmlHeadBuilder {

    private final StringBuilder head = new StringBuilder("<head>");

    private final Map<String, Map<String, List<String>>> styles = new HashMap<>();

    public void addStyle(String clazz, String style, String value) {
        if (styles.containsKey(clazz)) {
            final Map<String, List<String>> clazzStyles = styles.get(clazz);
            if (clazzStyles.containsKey(style)) {
                clazzStyles.get(style).add(value);
            } else {
                final List<String> values = new ArrayList<>();
                values.add(value);
                clazzStyles.put(style, values);
            }
        } else {
            final Map<String, List<String>> clazzStyles = new HashMap<>();
            final List<String> values = new ArrayList<>();
            values.add(value);
            clazzStyles.put(style, values);
            styles.put(clazz, clazzStyles);
        }
    }

    public String build() {
        if (!styles.isEmpty()) {
            head.append("<style>");
            for (Map.Entry<String, Map<String, List<String>>> clazz : styles.entrySet()) {
                head.append(clazz.getKey()).append('{');
                for (Map.Entry<String, List<String>> style : clazz.getValue().entrySet()) {
                    head.append(style.getKey()).append(':');
                    for (String value : style.getValue()) {
                        head.append(' ').append(value);
                    }
                    head.append(';');
                }
                head.append('}');
            }
            head.append("</style>");
        }
        head.append("</head>");
        return head.toString();
    }
}
