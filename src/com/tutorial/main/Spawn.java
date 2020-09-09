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
      public static int level = 1;
    
    private HUD hud;
    private double scoreKeep = 0;
    private Random r = new Random();
    private Game game;
    


    public Spawn(Handler handler, HUD hud, Game game) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
       this.game.diff = game.diff;
    }
    public void tick()  {
        scoreKeep = scoreKeep + 0.02;
        if(scoreKeep >= 10) {
            scoreKeep = 0;
            level++;
        


            // easy mode
    if(game.diff == 0){
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

    if(level == 15){
        handler.cleanEnemys();
        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
    }

    if(level == 17){
        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemey, handler));
        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemey, handler));
    }

    if(level == 19){
        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
    }

    if(level == 20){
        handler.cleanEnemys();
        handler.addObject(new BossEnemy((Game.WIDTH/2)-48, -60, ID.BossEnemy, handler));
        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
    }
}
    //Hard mode
    else if(game.diff == 1){
    if(level == 4){
        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemey, handler));
    }
    if(level == 5){
        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
    }
    if(level == 10){
        handler.cleanEnemys();
        handler.addObject(new BossEnemy((Game.WIDTH/2)-48, -60, ID.BossEnemy, handler));
        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemey, handler));
    }

    if(level == 15){
        handler.cleanEnemys();
        handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
    }

    if(level == 17){
        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemey, handler));
        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemey, handler));
    }

    if(level == 19){
        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
    }

    if(level == 20){
        handler.cleanEnemys();
        handler.addObject(new BossEnemy((Game.WIDTH/2)-48, -60, ID.BossEnemy, handler));
        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
    }
}



                 
        }
    }

    public void easyMode(){
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

        if(level == 15){
            handler.cleanEnemys();
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        }

        if(level == 17){
            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemey, handler));
            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemey, handler));
        }

        if(level == 19){
            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
        }

        if(level == 20){
            handler.cleanEnemys();
            handler.addObject(new BossEnemy((Game.WIDTH/2)-48, -60, ID.BossEnemy, handler));
            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
        }
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        Spawn.level = level;
    }

    public HUD getHud() {
        return hud;
    }

    public void setHud(HUD hud) {
        this.hud = hud;
    }

    public double getScoreKeep() {
        return scoreKeep;
    }

    public void setScoreKeep(double scoreKeep) {
        this.scoreKeep = scoreKeep;
    }

    public Random getR() {
        return r;
    }

    public void setR(Random r) {
        this.r = r;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
