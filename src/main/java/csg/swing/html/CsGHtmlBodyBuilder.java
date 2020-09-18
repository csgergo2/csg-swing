package csg.swing.html;

import java.util.ArrayList;
import java.util.List;

public class CsGHtmlBodyBuilder {

    private final StringBuilder body = new StringBuilder("<body>");
    private final List<Text> texts = new ArrayList<>();

    public void addText(String clazz, String text) {
        texts.add(new Text(clazz, text));
    }

    public String build() {
        texts.forEach(text -> body.append(text.build()));
        body.append("</body>");
        return body.toString();
    }

    private static class Text {
        private final String clazz;
        private final String text;

        public Text(final String clazz, final String text) {
            this.clazz = clazz;
            this.text = text;
        }

        private String build() {
            return '<' + clazz + '>' + text + "</" + clazz + '>';
        }
    }
}
