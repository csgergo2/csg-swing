package csg.swing.html;

public class CsGHtmlBuilder {

    private StringBuilder html = new StringBuilder();
    private final CsGHtmlHeadBuilder headBuilder;
    private final CsGHtmlBodyBuilder bodyBuilder;

    public CsGHtmlBuilder() {
        this(new CsGHtmlHeadBuilder(), new CsGHtmlBodyBuilder());
    }

    public CsGHtmlBuilder(final CsGHtmlHeadBuilder headBuilder) {
        this(headBuilder, new CsGHtmlBodyBuilder());
    }

    public CsGHtmlBuilder(final CsGHtmlBodyBuilder bodyBuilder) {
        this(new CsGHtmlHeadBuilder(), bodyBuilder);
    }

    public CsGHtmlBuilder(final CsGHtmlHeadBuilder headBuilder, final CsGHtmlBodyBuilder bodyBuilder) {
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;
        html.append("<html>");
    }

    public String build() {
        html.append(headBuilder.build());
        html.append(bodyBuilder.build());
        html.append("</html>");
        return html.toString();
    }
}
