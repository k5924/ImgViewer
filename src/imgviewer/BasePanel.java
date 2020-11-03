/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kamra
 */
public class BasePanel extends JPanel {

    private JButton openBtn = new JButton("Open");
    private JButton saveBtn = new JButton("Save");
    private JFileChooser chooseFile = new JFileChooser();
    private static LoadImage img = new LoadImage();

    public BasePanel(LayoutManager layout, JFrame frame) {
        super(layout);
        this.openBtn.addActionListener((ev) -> {
            try {
                openAction();
                frame.pack();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "File cannot be loaded as an image", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        this.saveBtn.addActionListener((ev) -> {
            try {
                saveAction();
            } catch (IOException ex) {
                Logger.getLogger(BasePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        JPanel BtnPanel = new JPanel(new GridLayout(1, 2));
        BtnPanel.add(this.openBtn);
        BtnPanel.add(this.saveBtn);
        add(BtnPanel, BorderLayout.SOUTH);
    }

    public void openAction() throws IOException {
        int returnVal = this.chooseFile.showDialog(BasePanel.this, "Select an image");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.chooseFile.getSelectedFile();
            this.img.showImage(file);
            add(this.img, BorderLayout.CENTER);
        }
        this.chooseFile.setSelectedFile(null);
        // resets the selected file so that the file chooser variable can be reused
    }

    public void saveAction() throws IOException {
        int returnVal = this.chooseFile.showSaveDialog(BasePanel.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.chooseFile.getSelectedFile();
            BufferedImage image = new BufferedImage(this.img.getWidth(), this.img.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            this.img.printAll(g);
            g.dispose();
            ImageIO.write(image, "jpg", file);
            JOptionPane.showMessageDialog(this, "Image saved", "Complete", JOptionPane.INFORMATION_MESSAGE);
        }
        this.chooseFile.setSelectedFile(null);
    }
}
