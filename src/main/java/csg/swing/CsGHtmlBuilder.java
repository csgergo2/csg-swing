package csg.swing;

import java.util.Objects;

public class CsGHtmlBuilder {

    private final StringBuilder html = new StringBuilder();
    private final StringBuilder bodyStyle = new StringBuilder();
    private final boolean withHtmlTag;
    private final boolean withBodyTag;

    public CsGHtmlBuilder() {
        this(false);
    }

    public CsGHtmlBuilder(final boolean withBodyTag) {
        this(withBodyTag, withBodyTag);
    }

    public CsGHtmlBuilder(final boolean withHtmlTag, final boolean withBodyTag) {
        this.withHtmlTag = withHtmlTag;
        this.withBodyTag = withBodyTag;
    }

    public CsGHtmlBuilder addBodyStyle(String style, String value) {
        bodyStyle.append(style).append(':').append(value).append(';');
        return this;
    }

    public CsGHtmlBuilder addBodyStyle(String style, int value) {
        bodyStyle.append(style).append(':').append(value).append(';');
        return this;
    }

    public CsGHtmlBuilder addBodyStyle(String style, double value) {
        bodyStyle.append(style).append(':').append(value).append(';');
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

    public String build() {
        StringBuilder result = new StringBuilder();
        if (withHtmlTag) {
            result.append("<html>");
        }
        if (withBodyTag) {
            result.append("<body style=\"").append(bodyStyle.toString()).append("\">");
        }
        result.append(html.toString());
        if (withBodyTag) {
            result.append("</body>");
        }
        if (withHtmlTag) {
            result.append("</html>");
        }
        return result.toString();
    }

}
