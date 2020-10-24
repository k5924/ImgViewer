/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kamra
 */
public class BasePanel extends JPanel{
    
    private JLabel myLabel = new JLabel("Space for picture");
    private JButton openBtn = new JButton("Open");
    private JButton saveBtn = new JButton("Save");

    public BasePanel(LayoutManager layout) {
        super(layout);
        MousePosition position = new MousePosition();
        this.addMouseListener(position);
        this.openBtn.addActionListener((ev) -> openAction());
        this.saveBtn.addActionListener((ev) -> saveAction());
        add(this.myLabel, BorderLayout.CENTER);
        JPanel BtnPanel = new JPanel(new GridLayout(1,2));
        BtnPanel.add(this.openBtn);
        BtnPanel.add(this.saveBtn);
        add(BtnPanel, BorderLayout.SOUTH);
    }
    
    public void openAction(){
        System.out.println(this.openBtn.getText());
    }
    
    public void saveAction(){
        System.out.println(this.saveBtn.getText());
    }
}
