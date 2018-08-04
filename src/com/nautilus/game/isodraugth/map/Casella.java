/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.map;

/**
 *
 * @author AlessioADM
 */
public class Casella {
    public static final int PEDINA_B=5;
    public static final int DAMA_B=7;
    public static final int PEDINA_W=4;
    public static final int DAMA_W=6;    
    public static final int EMPTY=0;    
    
   public int x,y;
   public  int type;

    public Casella(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

  
    public boolean equals(int xe,int ye) {

        return (x ==xe && y==ye);
    }
    
    
}
