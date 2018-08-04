/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author AlessioADM
 */
public class Score extends Canvas{

    public Score() {
        super(400,200);
        GraphicsContext  gc=this.getGraphicsContext2D();
        gc.setFill(Color.ALICEBLUE);
        gc.fillOval(150,50,200,120);
        gc.setFill(Color.ALICEBLUE);
        gc.fillOval(120,60,100,95);
        gc.fillOval(170,30,100,95);
        gc.fillOval(160,90,100,95);
        gc.setFill(Color.ALICEBLUE);
        gc.fillOval(300,60,100,95);
        gc.fillOval(250,30,100,95);
        gc.fillOval(250,90,100,95);
        //gc.fillRect(0, 0, 400,200);
        //gc.fillOval(100,10,200,150);
        //gc.fillOval(0,200,200,100);

    }
    
    
    
}
