/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.*;
import javax.swing.JFrame;

/**
 *
 * @author Sebas
 */
public class Window extends Canvas {
        private static final long serialVersionUID = 1L;
        
        public Window(int width, int height, String title, Game game){
            JFrame frame = new JFrame(title);


                frame.setPreferredSize(new Dimension(width, height));
                frame.setMaximumSize(new Dimension(width, height));
                frame.setMinimumSize(new Dimension(width, height));

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.add(game);
                frame.setVisible(true);
                game.start();

            


        }


        
        
        
        
}
