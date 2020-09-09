/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sebas
 */
public class FastEnemy extends GameObject {

    private Handler handler;
    private BufferedImage fastEnemyImage;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 2;
        velY = 9;

        SpriteSheet ss = new SpriteSheet(Game.spriteSheet);
        fastEnemyImage = ss.grabImage(1,1,32,32);
    
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int) y, 32, 32);
    }
    
    public void tick() {
        x += velX;
        y += velY;            
        if(y <= 0 || y > Game.HEIGHT - 32) velY *= -1;
         if(x <= 0 || x > Game.WIDTH - 20) velX *= -1;

         //handler.addObject(new Trail((int)x,(int) y, ID.Trail,Color.cyan, 16, 16, 0.025, handler));
    
    
    
    }

    
    public void render(Graphics g) {

        g.drawImage(fastEnemyImage,(int)x,(int)y,null);
    }
    
}
