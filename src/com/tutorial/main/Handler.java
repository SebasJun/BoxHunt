/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Sebas
 */
public class Handler {
 
    ArrayList<GameObject> object = new ArrayList<GameObject>();
    public int speed = 5;

    public void tick(){
    for(int i = 0; i < object.size(); i++){
        GameObject tempObject = object.get(i);
        tempObject.tick();
    }    
    
    }
    
    
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
        GameObject tempObject = object.get(i);
        tempObject.render(g);
    }
    
}
   public void cleanEnemys() {
 Iterator<GameObject> it = this.object.iterator();
 while(it.hasNext()) {
  GameObject tempObject = it.next();
  if (tempObject.getId() != ID.Player){
      it.remove();
     
  }
 }
}
   public void clearAll(){
      
           object.clear();
          
     
   }

    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object); 
    }

}