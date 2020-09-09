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

                //play button 360, 150

           if(mouseOver(mx,my, 360, 150,200, 64 )){
               AudioPlayer.getSound("click").play();



               game.gameState = STATE.Select;
               return;


        }
        
        //quit button
          
        if(mouseOver(mx,my,360, 450,200,64)){
            System.exit(1);
        }
        
        //help button 
        if(mouseOver(mx,my,360, 300, 200, 64)){
            AudioPlayer.getSound("click").play();
            game.gameState = STATE.Help;


        }
               
           }

        if(game.gameState == STATE.Select){
            //Normal button
            if(mouseOver(mx,my, 360, 150,200, 64 )){
                AudioPlayer.getSound("click").play();
                game.gameState = STATE.Game;
                handler.cleanEnemys();
                handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 30 ), r.nextInt(Game.HEIGHT - 30 ), ID.BasicEnemy, handler));
                game.diff = 0;


                AudioPlayer.getMusic("music").loop();

            }

            //Hard button

            if(mouseOver(mx,my,360, 300,200,64)){
                game.gameState = STATE.Game;
                handler.cleanEnemys();
                handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
                handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 30 ), r.nextInt(Game.HEIGHT - 30 ), ID.BasicEnemy, handler));
                handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 30 ), r.nextInt(Game.HEIGHT - 30 ), ID.BasicEnemy, handler));

                game.diff = 1;

                AudioPlayer.getMusic("music").loop();

            }

            //Back button
            if(mouseOver(mx,my,360, 450, 200, 64)){
                AudioPlayer.getSound("click").play();
                game.gameState = STATE.Menu;


            }

        }
      
          
        
        //back
        if(game.gameState == STATE.Help){
        if(mouseOver(mx,my,730, 560, 120, 64)){
            AudioPlayer.getSound("click").play();
            game.gameState = STATE.Menu;
        }
        }
        
        //Try again
        if(game.gameState == STATE.End){
            if(mouseOver(mx,my,715, 565, 120, 64)){
                AudioPlayer.getSound("click").play();
                for(int i = 0; i < 15; i++){
                    handler.addObject(new MenuPartical(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuPartical, handler));
                }
                game.gameState = STATE.Menu;

                hud.setLevel(1);
                game.spawner.setLevel(1);
                game.spawner.setScoreKeep(0);
                hud.setScore(0);
                handler.clearAll();
            }

           
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
        Font font2 = new Font("Arial", 10,55);

        
        g.setFont(font);
        g.setColor(Color.darkGray);
        g.drawString("Menu", 370, 100);
        
       
       
        g.setColor(Color.white);
        g.drawRect(360, 150, 200, 64);
        g.setFont(font2);
            g.setColor(Color.darkGray);
        g.drawString("Play", 410, 200);
        
        g.setColor(Color.white);
        g.drawRect(360, 300, 200, 64);
        g.setColor(Color.darkGray);
        g.drawString("Help", 410, 350);
        
        g.setColor(Color.white);
        g.drawRect(360, 450, 200, 64);
        g.setColor(Color.darkGray);
        g.drawString("Quit", 410, 500);
        } else if(game.gameState == STATE.Help){

            Font font = new Font("ZapfDingbats", 10,70);
            Font font2 = new Font("Arial", 10,45);
            Font font3 = new Font("arial",1,20);
             g.setFont(font);
             g.setColor(Color.darkGray);
             g.drawString("Help", 370, 100);
             
             g.setFont(font3);
             g.drawString("Use WASD keys to move "
                     + "player and dodge enemies", 220, 225);
             g.drawString("Spend your score to upgrade the player in the " +
                     "shop",220,325);
             
             g.setFont(font2);
             g.drawRect(730, 560, 120, 64);
             g.drawString("Back", 740, 610);
        } else if(game.gameState == STATE.End){
            
            Font font = new Font("ZapfDingbats", 10,70);
            Font font2 = new Font("Arial", 10,45);
            Font font3 = new Font("arial",1,20);
             g.setFont(font);
             g.setColor(Color.darkGray);
             g.drawString("Game over", 280, 120);
             
             g.setFont(font3);
             g.drawString("You lost with a score of " + (int)hud.getScore() , 330, 250);
             
             g.setFont(font3);
             g.drawRect(715, 565, 170, 64);
             g.setFont(new Font("arial",1,30));

             g.drawString("Try again", 730, 610);
    } else if(game.gameState == STATE.Select){

            Font font = new Font("ZapfDingbats", 10,70);
            Font font2 = new Font("Arial", 10,45);


            g.setFont(font);
            g.setColor(Color.darkGray);
            g.drawString(" DIFFICULTY", 250, 120);



            g.setColor(Color.white);
            g.drawRect(360, 150, 200, 64);
            g.setFont(font2);
            g.setColor(Color.darkGray);
            g.drawString("Normal", 390, 200);

            g.setColor(Color.white);
            g.drawRect(360, 300, 200, 64);
            g.setColor(Color.darkGray);
            g.drawString("Hard", 400, 350);

            g.setColor(Color.white);
            g.drawRect(360, 450, 200, 64);
            g.setColor(Color.darkGray);
            g.drawString("Back", 400, 500);
        }
}
}
    
