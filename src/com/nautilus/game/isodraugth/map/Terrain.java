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
public abstract class Terrain {
    Image img;
    public int offsx;
    public int offsy;
    public double ISO_W;
    public double ISO_H;
    public double ISO_SUB_H;
    public double ISO_H_UP;

    public Terrain(String file_img) {
    img=new Image(file_img);
    ISO_W=img.getWidth();
    ISO_H=img.getHeight();;
    }

    
}
