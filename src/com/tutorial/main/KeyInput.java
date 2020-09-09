 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import javax.swing.plaf.nimbus.State;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Sebas
 */
public class KeyInput extends KeyAdapter{
   
    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    
    public KeyInput(Handler handler){
        this.handler = handler;
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
        
    }
    
    
    public void keyPressed(KeyEvent e) {
  int key = e.getKeyCode();
  
  for(int i = 0; i < handler.object.size(); i++) {
   GameObject tempObject = handler.object.get(i);
   
   if(tempObject.getId() == ID.Player) {
    //key events for player
    
    if(key == KeyEvent.VK_W) { tempObject.setVelY(-handler.speed); keyDown[0] = true;}
    if(key == KeyEvent.VK_A) { tempObject.setVelX(-handler.speed); keyDown[3] = true;}
    if(key == KeyEvent.VK_S) { tempObject.setVelY(handler.speed); keyDown[1] = true;}
    if(key == KeyEvent.VK_D) { tempObject.setVelX(handler.speed); keyDown[2] = true;}
    
//    tempObject.setVelY(Game.clamp(tempObject.getVelY(),-5,5));
//    tempObject.setVelX(Game.clamp(tempObject.getVelX(),-5,5));
   }
  }
        if(key == KeyEvent.VK_P && Game.gameState == STATE.Game){
            if(Game.paused) Game.paused = false;
            else Game.paused = true;
        }
  if(key == KeyEvent.VK_ESCAPE) System.exit(1);
        if(key == KeyEvent.VK_SPACE) {
            if(Game.gameState == STATE.Game) Game.gameState = STATE.Shop;
            else if(Game.gameState == STATE.Shop) Game.gameState = STATE.Game;
        }
 }
 
 public void keyReleased(KeyEvent e){
  int key = e.getKeyCode();
  
  for(int i = 0; i < handler.object.size(); i++) {
   GameObject tempObject = handler.object.get(i);
   
   if(tempObject.getId() == ID.Player) {
    //key events for player
    
    if(key == KeyEvent.VK_W) keyDown[0] = false; //tempObject.setVelY(tempObject.getVelY()+5);
    if(key == KeyEvent.VK_A) keyDown[3] = false; //tempObject.setVelX(tempObject.getVelX()+5);
    if(key == KeyEvent.VK_S) keyDown[1] = false; //tempObject.setVelY(tempObject.getVelY()-5);
    if(key == KeyEvent.VK_D) keyDown[2] = false; //tempObject.setVelX(tempObject.getVelX()-5);
    
//  tempObject.setVelY(Game.clamp(tempObject.getVelY(),-5,5));
//    tempObject.setVelX(Game.clamp(tempObject.getVelX(),-5,5));
    
    //vertikel movement
    if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
    // horisontal
     if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
   }
  }
  
 }
}