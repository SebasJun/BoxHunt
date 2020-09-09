package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Random;

public class HardEnemy extends GameObject {

    private Handler handler;
    private Random random = new Random();
    private BufferedImage hardEnemy;

    public HardEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 5;

        SpriteSheet ss = new SpriteSheet(Game.spriteSheet);
        hardEnemy = ss.grabImage(1,1,32,32);

    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;
        if(y <= 0 || y > Game.HEIGHT - 32){ if(velY < 0 ) velY = -(random.nextInt(7)+1)*-1; else  velY = (random.nextInt(7)+1)*-1; }

        if(x <= 0 || x > Game.WIDTH -20){ if(velX < 0 ) velX = -(random.nextInt(7)+1)*-1;else  velX = (random.nextInt(7)+1)*-1; }

       // handler.addObject(new Trail((int)x,(int) y, ID.Trail,Color.yellow, 16, 16, 0.025, handler));



    }


    public void render(Graphics g) {
        g.drawImage(hardEnemy,(int)x,(int)y,null);
    }
}
