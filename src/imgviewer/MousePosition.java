/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kamra
 */
public class MousePosition implements MouseListener {

    private JFrame frame;

    public MousePosition(JFrame frame) {
        this.frame = frame;
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + ", " + e.getY());
        String annotation = (String) JOptionPane.showInputDialog(this.frame, "Enter annotation text", "Input", JOptionPane.QUESTION_MESSAGE);
        if (annotation != null) {
            System.out.println(annotation);
        }
    }
}
