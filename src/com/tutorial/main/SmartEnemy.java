/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Sebas
 */
public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;
   
    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
      
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player) 
                player = handler.object.get(i);
        }
     
    
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int) y, 16, 16); 
    }
    
    public void tick() {
        x += velX;
        y += velY;   
        // controlls the diffrencce
        float diffX = x-player.getX() -8;
        float diffY = y-player.getY() - 8;
      float distance = (float) Math.hypot((double)(x - player.getX()), (double)(y - player.getY()));
            velX = (float) ((-1.0/distance) * diffX);
      velY = (float) ((-1.0/distance) * diffY);
             if( Float.isNaN(velX) ) { 
 velX = 0;
 velY = 0; 
 } 
       
             if(y <= 0 || y > Game.HEIGHT - 32) velY *= -1;
         if(x <= 0 || x > Game.WIDTH - 20) velX *= -1;

         handler.addObject(new Trail((int)x,(int) y, ID.Trail,Color.MAGENTA, 16, 16, 0.025, handler));
    
    
    
    }

    
    public void render(Graphics g) {
      g.setColor(Color.MAGENTA);
      g.fillRect((int)x,(int) y, 16, 16);
    }
    
}
