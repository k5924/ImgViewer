/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.Graphics;

/**
 *
 * @author childm
 */
public interface Drawable {

    void draw(Graphics g);

    void erase(Graphics g);
}
