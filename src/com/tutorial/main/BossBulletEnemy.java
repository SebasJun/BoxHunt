/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Sebas
 */
public class BossBulletEnemy extends GameObject {
 
    private Handler handler;
    Random r = new Random();
    public BossBulletEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = (r.nextInt(5 - -5) + -5);
        velY = 5;
    
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y, 16, 16); 
    }
    
    public void tick() {
        x += velX;
        y += velY;    
        
       
       //if(y <= 0 || y > Game.HEIGHT - 32) velY *= -1;
       //if(x <= 0 || x > Game.WIDTH -70) velX *= -1;
        if(y >= Game.HEIGHT) handler.removeObject(this);

        handler.addObject(new Trail((int)x,(int) y, ID.Trail,Color.red, 16, 16, 0.025, handler));
    
    
    
    }

    
    public void render(Graphics g) {
      g.setColor(Color.red);
      g.fillRect((int)x,(int)y, 16, 16);
    }
    
}
