/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

/**
 *
 * @author Sebas
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Sebas
 */
public class MenuPartical extends GameObject {

    private Handler handler;
   Random r = new Random();
     private int red = r.nextInt(255);
         private int green = r.nextInt(255);
         private int blue = r.nextInt(255);
         private Color color;
         
         
   
   public MenuPartical(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = (r.nextInt(5 - -5) + -5);
        velY = (r.nextInt(5 - -5) + -5);
        if(velX == 0){
            velX = 7;
        } if(velY == 0){
            velY = 7;
        }
        
        
        color = new Color(red,green,blue);
        
       
        
    
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int) y, 16, 16); 
    }
    
    public void tick() {
        x += velX;
        y += velY;            
        if(y <= 0 || y > Game.HEIGHT - 32) velY *= -1;
         if(x <= 0 || x > Game.WIDTH - 20) velX *= -1;

         handler.addObject(new Trail((int)x,(int) y, ID.Trail,color, 16, 16, 0.025, handler));
    
    
    
    }

    
    public void render(Graphics g) {
      g.setColor(color);
      g.fillRect((int)x,(int) y, 16, 16);
    }
    
}
