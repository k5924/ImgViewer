/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author childm
 */
public class Circle extends AbstractCircle {

    private String annotation;

    public Circle(int x, int y, Color color, double radius, String text) {
        super(x, y, color, radius);
        this.annotation = text;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected void paint(Graphics g) {
        g.drawOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
        g.setColor(Color.YELLOW);
        g.drawString(this.annotation, x + 20, y + 20);
    }
}
