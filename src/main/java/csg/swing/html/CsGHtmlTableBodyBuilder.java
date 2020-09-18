package csg.swing.html;

public class CsGHtmlTableBodyBuilder extends CsGHtmlBodyBuilder {

    private final StringBuilder table = new StringBuilder();
    private final String[] headers;
    private final String[][] rows;

    public CsGHtmlTableBodyBuilder(final String[] headers, final String[][] rows) {
        this.headers = headers;
        this.rows = rows;
    }

    private void buildTable() {
        table.append("<tr>");
        for (String header : headers) {
            table.append("<th>").append(header).append("</th>");
        }
        table.append("</tr>");
        for (final String[] row : rows) {
            table.append("<tr>");
            for (final String data : row) {
                table.append("<td>").append(data).append("</td>");
            }
            table.append("</tr>");
        }
    }

    @Override
    public String build() {
        buildTable();
        super.addText("table", table.toString());
        return super.build();
    }
}
