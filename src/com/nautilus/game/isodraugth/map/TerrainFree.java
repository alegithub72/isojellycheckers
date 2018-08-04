/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.map;

import javafx.scene.image.Image;

/**
 *
 * @author AlessioADM
 */
public class TerrainFree {
    
    Image img;
    public int offsx=107;
    public int offsy=50;
    public TerrainFree(){
    img=new Image("freecasella.png");
    }
    
    public Image getImg(){
    return img;
    }
    
}
