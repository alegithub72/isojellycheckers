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
public class TerrainOccupy extends Terrain{
    

    public TerrainOccupy(){
    img=new Image("occupycasella.png");
    ISO_W=img.getWidth();
    ISO_H=107;
    ISO_SUB_H=img.getHeight()-ISO_H;
    offsx = 107;
    offsy = 50;
    }
    
    public Image getImg(){
    return img;
    }
    
}
