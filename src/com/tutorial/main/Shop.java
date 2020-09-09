package com.tutorial.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {

    private Handler handler;
    private HUD hud;
    private double B1 = 0;
    private double B2 = 0;
    private double B3 = 0;


    public Shop(Handler handler, HUD hud){
        this.hud = hud;
    this.handler = handler;
    }
    public void render(Graphics g){

    g.setColor(Color.white);
    g.setFont(new Font("arial",0,48));
    g.drawString("SHOP",400,70);

    //box 1
    g.setFont(new Font("arial",0,20));
    g.setColor(Color.blue);
    g.drawString("Upgrade health",250,190);
    g.drawString("Cost " + (int)B1 + " --->",250,210);
    g.drawRect(400,150,150,100);
    g.setColor(Color.blue);
    g.fillRect(400,150,150,100);

        //box 2
        g.setColor(Color.black);
        g.drawString("Upgrade speed",250,340);
        g.drawString("Cost " + (int)B2  + " --->",250,360);
        g.drawRect(400,300,150,100);
        g.setColor(Color.black);
        g.fillRect(400,300,150,100);

        //box 3
        g.setColor(Color.green);
        g.drawString("Refill health",250,490);
        g.drawString("Cost " + (int)B3 + "--->",250,510);
        g.drawRect(400,450,150,100);
        g.setColor(Color.green);
        g.fillRect(400,450,150,100);

        int score = (int)hud.getScore();
       g.setColor(Color.DARK_GRAY);
        g.drawString("SCORE: " + score, 650, 600);
        g.drawString("Press spacebar to go back", 650, 630);
    }

    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();
        //box1 400,150

        if (Game.gameState == STATE.Shop) {
            if (mx >= 400 && mx <= 550) {
                if (my >= 150 && my <= 250) {

                    if (hud.getScore() >= B1) {
                        hud.setScore(hud.getScore() - B1);
                        // B1 += 100;

                        if (hud.HEALTH < 200) {
                            hud.bounds += 20;
                            hud.HEALTH = (100 + (hud.bounds / 2));
                            hud.maxhealth += 20;
                        }


                    }
                }
            }

            //box2 400,300,
            if (mx >= 400 && mx <= 550) {
                if (my >= 300 && my <= 400) {
                    if (hud.getScore() >= B2) {
                        hud.setScore(hud.getScore() - B2);
                        // B2 += 100;
                        handler.speed++;

                    }
                }
            }

            //box3 400,450
            if (mx >= 400 && mx <= 550) {
                if (my >= 450 && my <= 550) {
                    if (hud.getScore() >= B3) {
                        hud.setScore(hud.getScore() - B3);
                        hud.HEALTH = (100 + (hud.bounds / 2));

                    }

                }
            }

        }
    }
}
