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
import java.util.Random;

/**
 *
 * @author Sebas
 */
public class Player extends GameObject{

    Random r = new Random();
    Handler handler;
    private BufferedImage playerImage;
    
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        SpriteSheet ss = new SpriteSheet(Game.spriteSheet);
        playerImage = ss.grabImage(1,2,64,64);
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int) y, 32, 32);
    }
   
    public void tick() {
        x += velX;
        y += velY;
    
        x = Game.clamp(x, 0, Game.WIDTH - 38);
        y = Game.clamp(y, 0, Game.HEIGHT - 61);
        collision();
       //   handler.addObject(new Trail((int)x,(int) y, ID.Trail,Color.white, 32, 32, 0.025, handler));
    }
    
    public void collision(){
        for ( int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemey || tempObject.getId() == ID.SmartEnemy
                   || tempObject.getId() == ID.BossBulletEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }
             if(tempObject.getId() == ID.BossEnemy){
                 if(getBounds().intersects(tempObject.getBounds())){
                     HUD.HEALTH -= 1000;
                 }
             } 
        }
    }
   
    public void render(Graphics g) {

          g.drawImage(playerImage,(int)x,(int)y,null);
    }
    
    
}
