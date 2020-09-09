/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Sebas
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 2L;
    
    public static final int WIDTH = 940, HEIGHT = WIDTH / 12*9;
    
    private Thread thread;
    private boolean running = false;

    public static boolean paused = false;
    public int diff = 0;

    //normal 0
    //hard 1

    private Random r;
    private Handler handler;
    private HUD hud;
    public Spawn spawner;
    public static STATE gameState = STATE.Menu;
   private Menu menu;
   public static BufferedImage spriteSheet;
   private Shop shop;
   
    
    public Game(){

        BufferedImageLoader loader = new BufferedImageLoader();
        spriteSheet = loader.loadImage("/spriteSheet.png");
        hud = new HUD();
        handler = new Handler();
        shop = new Shop(handler,hud);
        menu = new Menu(this, handler, hud);
        this.addKeyListener(new KeyInput(handler));
       this.addMouseListener(menu);
        this.addMouseListener(shop);

        AudioPlayer.load();


        new Window(WIDTH, HEIGHT, "BoxHunt", this);


        spawner = new Spawn(handler, hud, this);
        
        
        r = new Random();
        
        if(gameState == STATE.Game){
            handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player,handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
        } else{
            for(int i = 0; i < 15; i++){
                handler.addObject(new MenuPartical(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuPartical, handler));
            }
        }
        
            
        
        
    }
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start(); 
        running = true;
    }
   
     public synchronized void stop(){
        try {
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
    }
    
    private void tick(){

        
        if(gameState == STATE.Game){
             if(!paused){

                 hud.tick();
                 spawner.tick();
                 handler.tick();

                 if(HUD.HEALTH <= 0){

                     HUD.HEALTH = 100;
                     HUD.maxhealth  = HUD.HEALTH;

                     gameState = STATE.End;
                     handler.clearAll();

                     AudioPlayer.getMusic("coffin").loop();
                     for(int i = 0; i < 15; i++){
                         handler.addObject(new MenuPartical(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuPartical, handler));
                     }

                 }
             }

            

             
        } else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select || gameState == STATE.Help){
            handler.tick();
            menu.tick();

        }
        
            
        
        
       
    }
    
    
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        

       if(paused){
           g.setColor(Color.RED);

           g.drawString("PAUSED", 105, 75);
       }
        if(gameState == STATE.Game){
               hud.render(g);
            handler.render(g);
        }else if(gameState == STATE.Shop){
            shop.render(g);

        }else if(gameState == STATE.Menu || gameState == STATE.Help ||gameState == STATE.End || gameState == STATE.Select){
            menu.render(g);
            handler.render(g);
        } 
       
        g.dispose();
        bs.show();
    }
    
    public static float clamp(float var, float min, float max){
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else 
            return var;
    
    
    }
    
    public static void main(String[] arg){
        new Game();
    
}    
}
