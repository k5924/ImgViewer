/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author kamra
 */
public class ImgViewer extends JFrame {

    /**
     * @param args the command line arguments
     */
    public ImgViewer() throws HeadlessException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Image annotator");

        LayoutManager layout = new BorderLayout();
        BasePanel myPanel = new BasePanel(layout, this);
        getContentPane().add(myPanel);

        pack();
        setVisible(true);
    }

    public static void launch() {
        new ImgViewer();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(() -> launch());
    }

}
