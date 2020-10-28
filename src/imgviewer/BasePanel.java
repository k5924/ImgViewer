/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
        MousePosition position = new MousePosition();
        this.addMouseListener(position);
        this.openBtn.addActionListener((ev) -> {
            try {
                openAction();
                frame.pack();
            } catch (IOException ex) {
                Logger.getLogger(BasePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.saveBtn.addActionListener((ev) -> saveAction());
        JPanel BtnPanel = new JPanel(new GridLayout(1, 2));
        BtnPanel.add(this.openBtn);
        BtnPanel.add(this.saveBtn);
        add(BtnPanel, BorderLayout.SOUTH);
    }

    public void openAction() throws IOException {
        int returnVal = this.chooseFile.showDialog(BasePanel.this, "Select an image");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.chooseFile.getSelectedFile();
            // System.out.println(file.getAbsolutePath());
            this.img.showImage(file);
            add(this.img, BorderLayout.CENTER);
        }
        this.chooseFile.setSelectedFile(null);
        // resets the selected file so that the file chooser variable can be reused
    }

    public void saveAction() {
        int returnVal = this.chooseFile.showSaveDialog(BasePanel.this);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            System.out.println("Saved file");
        }
        this.chooseFile.setSelectedFile(null);
    }
}
