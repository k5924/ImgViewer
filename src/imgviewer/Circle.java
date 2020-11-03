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

    public Circle(int x, int y, Color color, double radius) {
        super(x, y, color, radius);
    }

    protected void paint(Graphics g) {
        g.drawOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
    }
}
