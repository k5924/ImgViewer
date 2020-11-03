/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.Color;

/**
 *
 * @author kamra
 */
public abstract class AbstractCircle extends Shape{
    
    protected double radius;
    
    public AbstractCircle(int x, int y, Color color, double radius){
        super(x, y, color);
        this.radius = radius;
    }
}
