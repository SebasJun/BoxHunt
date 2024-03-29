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
public class BossEnemy extends GameObject {
    private int timer = 30;
    private int timer2 = 50;
    Random r = new Random();
    private Handler handler;
    public BossEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        velY = 2;
    
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y, 64, 64); 
    }
    
    public void tick() {
        x += velX;
        y += velY;    
        
        if(timer<= 0) velY = 0;
        else{
            timer--;
        }
        if(timer<= 0) timer2--;
        if(timer2<=0) {
            if(velX == 0) velX=2;
           velX += 0.01f*Math.signum(velX);
          // velX = Game.clamp(velX, -5, 5);
            int spawn = r.nextInt(10);
            if(spawn==0) handler.addObject(new BossBulletEnemy((int)x+48,(int)y+48, ID.BossBulletEnemy, handler ));
        }
////        if(y <= 0 || y > Game.HEIGHT - 32) velY *= -1;
       if(x <= 0 || x > Game.WIDTH -70) velX *= -1;

         handler.addObject(new Trail((int)x,(int) y, ID.Trail,Color.red, 64, 64, 0.025, handler));
    
    
    
    }

    
    public void render(Graphics g) {
      g.setColor(Color.red);
      g.fillRect((int)x,(int)y, 64, 64);
    }
    
}
