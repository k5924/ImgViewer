/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgviewer;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author childm
 */
public abstract class Shape implements Drawable {
  
  protected int x;
  protected int y;
  protected Color color;
  protected Color backgroundColor = Color.WHITE;
  
  public Shape( int x, int y, Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  public void draw(Graphics g) {
    g.setColor( this.color);
    paint( g);
  }

  public void erase(Graphics g) {
    g.setColor( this.backgroundColor);
    paint( g);
  }

  protected abstract void paint(Graphics g);
}
