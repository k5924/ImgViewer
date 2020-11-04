/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kamra
 */
public class LoadImage extends JPanel implements MouseListener {

    private BufferedImage img;
    private final Collection<Drawable> drawables = new LinkedHashSet<Drawable>();

    public void showImage(File file) throws IOException {
        this.drawables.clear();
        this.img = ImageIO.read(file);
        this.setPreferredSize(new Dimension(this.img.getWidth(this), this.img.getHeight(this)));
        addMouseListener(this);
    }

    public void addDrawable(Drawable d) {
        this.drawables.add(d);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g = g.create();
        if (this.img != null) {
            g.drawImage(this.img, 0, 0, this);
            g.setFont(getFont().deriveFont(12f));
            for (Drawable d : this.drawables) {
                d.draw(g);
            }
        }
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
        int count = 0;
        Drawable annotation = new Circle(0, 0, Color.WHITE, 0, "");
        for (Drawable d : this.drawables) {
            if ((((Circle) d).getX() - 10 < e.getX()) && (((Circle) d).getX() + 10 > e.getX()) && (((Circle) d).getY() - 10 < e.getY()) && (((Circle) d).getY() + 10 > e.getY())) {
                count = 1;
                annotation = d;
            }
        }
        if (count != 1) {
            String text = (String) JOptionPane.showInputDialog(this, "Enter annotation text", "Input", JOptionPane.QUESTION_MESSAGE);
            if (text != null && text.length() > 0) {
                this.addDrawable(new Circle(e.getX(), e.getY(), Color.YELLOW, 10, text));
            }
        } else {
            int returnVal = JOptionPane.showConfirmDialog(this, "Remove annotation?");
            if (returnVal == JOptionPane.YES_OPTION) {
                this.drawables.remove(annotation);
                repaint();
            }
        }
    }
}
