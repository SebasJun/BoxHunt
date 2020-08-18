/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import static com.tutorial.main.Game.HEIGHT;
import static com.tutorial.main.Game.WIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 *
 * @author Sebas
 */
public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private Random r = new Random();
    private HUD hud;
    
    
    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }
    
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        
           if(game.gameState == STATE.Menu){
                //play button
           if(mouseOver(mx,my, 210, 150,200, 64 )){
            game.gameState = STATE.Game;
            handler.cleanEnemys();
              handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
              handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 30 ), r.nextInt(Game.HEIGHT - 30 ), ID.BasicEnemy, handler));
        
        }
        
        //quit button
          
        if(mouseOver(mx,my,210,350,200,64)){
            System.exit(1);
        }
        
        //help button 
        if(mouseOver(mx,my,210, 250, 200, 64)){
            game.gameState = STATE.Help;
        }
               
           }
      
          
        
        //back
        if(game.gameState == STATE.Help){
        if(mouseOver(mx,my,500, 360, 120, 64)){
            game.gameState = STATE.Menu;
        }
        }
        
        //Try again
        if(game.gameState == STATE.End){
            if(mouseOver(mx,my,480, 370, 120, 64));
              hud.setLevel(1);
                 hud.setScore(0);
            game.gameState = STATE.Game;
           
            handler.clearAll();
          
             handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player,handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
           
        }
    }
    public void MouseReleased(MouseEvent e){
        
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x+width){
            if(my > y && my < y + height){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
   
    public void tick(){
        
    }
    public void render(Graphics g){
        if(game.gameState == STATE.Menu  ){
        Font font = new Font("ZapfDingbats", 10,70);
        Font font2 = new Font("Arial", 10,45);

        
        g.setFont(font);
        g.setColor(Color.darkGray);
        g.drawString("Menu", 220, 100);
        
       
       
        g.setColor(Color.white);
        g.drawRect(210, 150, 200, 64);
        g.setFont(font2);
            g.setColor(Color.darkGray);
        g.drawString("Play", 260, 200);
        
        g.setColor(Color.white);
        g.drawRect(210, 250, 200, 64);
        g.setColor(Color.darkGray);
        g.drawString("Help", 260, 300);
        
        g.setColor(Color.white);
        g.drawRect(210, 350, 200, 64);
        g.setColor(Color.darkGray);
        g.drawString("Quit", 260, 400);
        } else if(game.gameState == STATE.Help){
            
            Font font = new Font("ZapfDingbats", 10,70);
            Font font2 = new Font("Arial", 10,45);
            Font font3 = new Font("arial",1,20);
             g.setFont(font);
             g.setColor(Color.darkGray);
             g.drawString("Help", 220, 100);
             
             g.setFont(font3);
             g.drawString("Use WASD keys to move "
                     + "player and dodge enemies", 70, 225);
             
             g.setFont(font2);
             g.drawRect(500, 360, 120, 64);
             g.drawString("Back", 510, 410);
        } else if(game.gameState == STATE.End){
            
            Font font = new Font("ZapfDingbats", 10,70);
            Font font2 = new Font("Arial", 10,45);
            Font font3 = new Font("arial",1,20);
             g.setFont(font);
             g.setColor(Color.darkGray);
             g.drawString("Game over", 130, 100);
             
             g.setFont(font3);
             g.drawString("You lost with a score of " + (int)hud.getScore() , 175, 225);
             
             g.setFont(font3);
             g.drawRect(480, 370, 120, 64);
             
             g.drawString("Try again", 490, 410);
    }
}
}
    
