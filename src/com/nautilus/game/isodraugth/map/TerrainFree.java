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
public class TerrainFree extends Terrain {
    
    public TerrainFree(){
    super("freecasella.png");
    ISO_H_UP=107;
    ISO_SUB_H=img.getHeight()-ISO_H_UP;
    offsx = 107;
    offsy = 50;
    
    }
    
    public Image getImg(){
    return img;
    }
    
}
