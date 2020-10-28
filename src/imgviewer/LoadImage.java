/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author kamra
 */
public class LoadImage extends JPanel{
    
    private BufferedImage img;

    public LoadImage(File file) throws IOException{
        this.img = ImageIO.read(file);
        this.setPreferredSize(new Dimension(this.img.getWidth(this), this.img.getHeight(this)));
        this.repaint();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g = g.create();
        g.drawImage(this.img, 0, 0, this);
    }
}
