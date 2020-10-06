package csg.swing;

import javax.swing.JScrollPane;

public class CsGScrollableTextArea extends JScrollPane {

    public CsGScrollableTextArea(Enum<?> name) {
        this(name, false);
    }

    public CsGScrollableTextArea(Enum<?> name, boolean onlyDigits) {
        setName(name.name());
        final CsGTextArea area = new CsGTextArea(name, onlyDigits);

        setViewportView(area);
    }

    public void setText(String text) {
        checkViewport();
        ((CsGTextArea) getViewport().getView()).setText(text);
    }

    public String getText() {
        checkViewport();
        return ((CsGTextArea) getViewport().getView()).getText();
    }

    private void checkViewport() {
        if (!(getViewport().getView() instanceof CsGTextArea)) {
            throw new RuntimeException("CsGScrollableTextArea only accepts CsGTextArea as viewport. It's viewport class: " +
                    getViewport().getView().getClass().getName());
        }
    }
}
