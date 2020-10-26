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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kamra
 */
public class BasePanel extends JPanel {

    private JLabel myLabel = new JLabel("Space for picture");
    private JButton openBtn = new JButton("Open");
    private JButton saveBtn = new JButton("Save");
    private JFileChooser chooseFile = new JFileChooser();

    public BasePanel(LayoutManager layout, JFrame frame) {
        super(layout);
        MousePosition position = new MousePosition();
        this.addMouseListener(position);
        this.openBtn.addActionListener((ev) -> openAction());
        this.saveBtn.addActionListener((ev) -> saveAction());
        add(this.myLabel, BorderLayout.CENTER);
        JPanel BtnPanel = new JPanel(new GridLayout(1, 2));
        BtnPanel.add(this.openBtn);
        BtnPanel.add(this.saveBtn);
        add(BtnPanel, BorderLayout.SOUTH);
    }

    public void openAction() {
        int returnVal = this.chooseFile.showDialog(BasePanel.this, "Select an image");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.chooseFile.getSelectedFile();
            System.out.println(file.getAbsolutePath());
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
