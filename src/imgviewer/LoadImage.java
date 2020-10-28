/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author kamra
 */
public class LoadImage extends JPanel{
    
    private Image img;

    public LoadImage(String path) throws IOException{
        this.img = ImageIO.read(new File(path));
        this.setPreferredSize(new Dimension(this.img.getWidth(this), this.img.getHeight(this)));
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g = g.create();
        g.drawImage(this.img, 0, 0, null);
    }
}
