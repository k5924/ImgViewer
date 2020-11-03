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
    private String annotation;
    private int x, y;

    public void showImage(File file) throws IOException {
        this.drawables.clear();
        this.img = ImageIO.read(file);
        this.setPreferredSize(new Dimension(this.img.getWidth(this), this.img.getHeight(this)));
        this.repaint();
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
            if (this.annotation!=null){
                g.setColor(Color.YELLOW);
                g.setFont( getFont().deriveFont( 12f));
                g.drawString(this.annotation, this.x+20, this.y+20);
                for (Drawable d : this.drawables) {
                    d.draw(g);
                }
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
        System.out.println(e.getX() + ", " + e.getY());
        this.annotation = (String) JOptionPane.showInputDialog(this, "Enter annotation text", "Input", JOptionPane.QUESTION_MESSAGE);
        if (!(this.annotation.equals(""))) {
            this.x = e.getX();
            this.y = e.getY();
            this.addDrawable(new Circle(this.x, this.y, Color.YELLOW, 10));
        }
    }
}
