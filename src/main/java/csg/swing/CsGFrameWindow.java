package csg.swing;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public abstract class CsGFrameWindow extends JFrame {
    public static final int PREFERRED_WIDTH = 1800;
    public static final int PREFERRED_HEIGHT = 800;

    /**
     * Child should let the visibility true at the end of the constructor!
     * Uses for sizing: {@link CsGFrameWindow#PREFERRED_WIDTH} and {@link CsGFrameWindow#PREFERRED_HEIGHT}
     *
     * @param title
     * @throws HeadlessException
     */
    public CsGFrameWindow(final String title) throws HeadlessException {
        this(title, PREFERRED_WIDTH, PREFERRED_HEIGHT);
    }

    /**
     * Child should let the visibility true at the end of the constructor!
     * Uses for sizing: {@link CsGFrameWindow#PREFERRED_WIDTH} and {@link CsGFrameWindow#PREFERRED_HEIGHT}
     *
     * @param title
     * @param components
     * @throws HeadlessException
     */
    public CsGFrameWindow(final String title, final Component... components) throws HeadlessException {
        this(title, PREFERRED_WIDTH, PREFERRED_HEIGHT, components);
    }

    /**
     * Child should let the visibility true at the end of the constructor!
     *
     * @param title
     * @param width
     * @param height
     * @param components
     * @throws HeadlessException
     */
    public CsGFrameWindow(final String title, final int width, final int height, final Component... components) throws HeadlessException {
        this(title, width, height);
        Arrays.stream(components).forEach(this::add);
    }

    /**
     * Child should let the visibility true at the end of the constructor!
     *
     * @param title
     * @param width
     * @param height
     * @throws HeadlessException
     */
    public CsGFrameWindow(final String title, final int width, final int height) throws HeadlessException {
        setTitle(title);
        setResizable(false);
        setLocationRelativeTo(null);//for unknown reason, this does not put it in the center. this line should be put in the implementation too
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
    }
}
