package csg.swing;

import java.util.Objects;

public class CsGHtmlBuilder {

    private final StringBuilder html = new StringBuilder();
    private final StringBuilder style = new StringBuilder();

    private final String mainTag;

    /**
     * Default mainTag: {@code <body></body>}
     */
    public CsGHtmlBuilder() {
        this("body");
    }

    /**
     * @param mainTag like "body" or "table" (they becomes html tags like {@code <body></body>} or {@code <table></table>})
     */
    public CsGHtmlBuilder(String mainTag) {
        this.mainTag = mainTag;
    }

    public CsGHtmlBuilder addStyle(String style, String value) {
        this.style.append(style).append(':').append(value).append(';');
        return this;
    }

    public CsGHtmlBuilder addStyle(String style, int value) {
        this.style.append(style).append(':').append(value).append(';');
        return this;
    }

    public CsGHtmlBuilder addStyle(String style, double value) {
        this.style.append(style).append(':').append(value).append(';');
        return this;
    }

    public CsGHtmlBuilder newLine() {
        html.append("</p>");
        return this;
    }

    public CsGHtmlBuilder newLine(String row) {
        html.append("<p>").append(row).append("</p>");
        return this;
    }

    public CsGHtmlBuilder listToLines(Iterable<?> list) {
        list.forEach(element -> newLine(Objects.toString(element)));
        return this;
    }

    public CsGHtmlBuilder text(String text) {
        html.append(text);
        return this;
    }

    public CsGHtmlBuilder text(String text, String tag) {
        html.append('<').append(tag).append('>').append(text).append("</").append(tag).append('>');
        return this;
    }

    /**
     * Use {@link CsGHtmlBuilder#toString()}, may not works
     *
     * @return
     */
    @Deprecated
    public String build() {
        StringBuilder result = new StringBuilder();
        result.append("<html>");
        result.append("<body style=\"").append(style.toString()).append("\">");
        result.append(html.toString());
        result.append("</body>");
        result.append("</html>");
        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("<html>");
        result.append('<').append(mainTag).append(" style=\"").append(style.toString()).append("\">");
        result.append(html.toString());
        result.append("</").append(mainTag).append('>');
        result.append("</html>");
        return result.toString();
    }

    public static String createHtmlTable(String[] headers, String[][] items) {
        final CsGHtmlBuilder table = new CsGHtmlBuilder("table");
        table.text("<tr>");
        for (String header : headers) {
            table.text(header, "th");
        }
        table.text("</tr>");
        for (final String[] item : items) {
            table.text("<tr>");
            for (final String aRow : item) {
                table.text("<td>");
                table.text(aRow);
                table.text("</td>");
            }
            table.text("</tr>");
        }

        return table.toString();
    }

}
