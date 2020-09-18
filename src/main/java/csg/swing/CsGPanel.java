package csg.swing;

import java.awt.*;

import javax.swing.*;

public abstract class CsGPanel extends JPanel {

    public CsGPanel(Enum<?> name, LayoutManager layout) {
        this(name, 0, 0, CsGFrameWindow.PREFERRED_WIDTH, CsGFrameWindow.PREFERRED_HEIGHT, layout);
    }

    public CsGPanel(Enum<?> name, int x, int y, int width, int height, LayoutManager layout) {
        setName(name.name());
        setSize(width, height);
        setLocation(x, y);
        setLayout(layout);
        setBackground(Color.decode("#e3d8b3"));
        setVisible(false);
    }

}
