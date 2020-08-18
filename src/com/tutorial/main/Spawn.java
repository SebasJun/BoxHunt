/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.util.Random;

/**
 *
 * @author Sebas
 */
public class Spawn{
    private Handler handler;
      private int level = 1;
    
    private HUD hud;
    private double scoreKeep = 0;
    private Random r = new Random();
    


    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }
    public void tick()  {
        scoreKeep = scoreKeep + 0.02;
        if(scoreKeep >= 10) {
            scoreKeep = 0;
            level++;
        
          
        
            
//                if(level == 2 ){
//                 handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
//                }
                 if(level == 4){
                      handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemey, handler));
                 }
                 if(level == 5){
                      handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                 }
                 if(level == 10){
                     handler.cleanEnemys();
                     handler.addObject(new BossEnemy((Game.WIDTH/2)-48, -60, ID.BossEnemy, handler));
                 }
                 
        }
    }
}
