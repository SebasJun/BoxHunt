/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author Sebas
 */
public class HUD {
    
    
    
    public static float HEALTH = 100;
    
    private float greenValue = 255;
    private double score = 0;
    private int level = 1;
    
    public void tick(){
      
        
        HEALTH = (int)Game.clamp(HEALTH, 0 , 100);
        greenValue = (int) Game.clamp(greenValue, 0, 255);
        greenValue = HEALTH*2;
        score = score +  0.02;
        level = (int)score / 10;
    }

public void render(Graphics g){
    g.setColor(Color.GRAY);
    g.fillRect(15, 15, 200, 32 );
    
   g.setColor(Color.getHSBColor( (1f * HEALTH) / 360, 1f, 1f));
    g.fillRect(15, 15,(int) HEALTH * 2, 32 );

     g.setColor(Color.WHITE);
     g.drawRect(15, 15, (int)HEALTH * 2, 32 );

     g.drawString(HEALTH+"%", 15, 15);
    
     g.drawString("Score " + (int)score, 15, 64);
        g.drawString("Level " + (level + 1), 15, 80);
}

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
   



}
