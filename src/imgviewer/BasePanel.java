/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kamra
 */
public class BasePanel extends JPanel implements MouseListener{
    
    private JLabel myLabel = new JLabel("Space for picture");
    private JButton openBtn = new JButton("Open");
    private JButton saveBtn = new JButton("Save");

    public BasePanel(LayoutManager layout) {
        super(layout);
        this.openBtn.addActionListener((ev) -> openAction());
        this.saveBtn.addActionListener((ev) -> saveAction());
        add(this.myLabel, BorderLayout.CENTER);
        JPanel BtnPanel = new JPanel(new GridLayout(1,2));
        BtnPanel.add(this.openBtn);
        BtnPanel.add(this.saveBtn);
        add(BtnPanel, BorderLayout.SOUTH);
        addMouseListener(this);
    }
    
    public void openAction(){
        System.out.println(this.openBtn.getText());
    }
    
    public void saveAction(){
        System.out.println(this.saveBtn.getText());
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
    }

    void saySomething(String eventDescription, MouseEvent e) {
    }
}
