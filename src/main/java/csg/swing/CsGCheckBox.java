package csg.swing;

import static csg.swing.CsGPanel.DEFAULT_PANEL_COLOR;

import javax.swing.JCheckBox;

public class CsGCheckBox extends JCheckBox {
    public CsGCheckBox(Enum<?> name) {
        setName(name.name());
        setBackground(DEFAULT_PANEL_COLOR);
    }
}
