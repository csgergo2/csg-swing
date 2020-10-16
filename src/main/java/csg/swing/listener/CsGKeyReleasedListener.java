package csg.swing.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface CsGKeyReleasedListener extends KeyListener {
    @Override
    default void keyTyped(KeyEvent e) {

    }

    @Override
    default void keyPressed(KeyEvent e) {

    }
}
