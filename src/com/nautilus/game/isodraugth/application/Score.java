/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.application;

import static com.nautilus.game.isodraugth.application.ISODraugth.center;
import com.nautilus.game.isodraugth.map.ISOCoverter;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author AlessioADM
 */
public class Score {
    
    private double xA,yA;
    private double xB,yB;
    private int score=6546;
    public Score(GraphicsContext  gc ,double ISO_W,double ISO_H) {
        double convXA=ISOCoverter.covertPlaneXToScreenISOX((ISOCoverter.SQ_WD*2),(ISOCoverter.SQ_HG*8));
        double convYA=ISOCoverter.convertPlaneYToScreenISOY((ISOCoverter.SQ_WD*2),(ISOCoverter.SQ_HG*8));
         xA = convXA + center.getX()-(ISO_W/2);
         yA = convYA + center.getY()+ISO_H;
        //gc.setFill(Color.BLACK);
        //gc.fillOval(xA, yA, 200, 150);
        //gc.fillOval(xA-40, yA-30, 200, 150);
       // gc.fillOval(xA+40, yA-30, 200, 150);
        gc.setFont(Font.font("impact",FontWeight.EXTRA_BOLD,40));         
        gc.setFill(Color.BLACK);
        gc.fillText("UKF:"+score, xA-4, yA-2);
        gc.setFill(Color.GREENYELLOW);

        gc.fillText("UKF:"+score, xA, yA);
        //Image image2 = new Image("ukf_text.png",100,100,true,false);
        
        //gc.drawImage(image2, xA, yA);
        double convXB=ISOCoverter.covertPlaneXToScreenISOX((ISOCoverter.SQ_WD*8),(ISOCoverter.SQ_HG*2));
        double convYB=ISOCoverter.convertPlaneYToScreenISOY((ISOCoverter.SQ_WD*8),(ISOCoverter.SQ_HG*2));
         xB = convXB + center.getX()-(ISO_W/2);
         yB = convYB + center.getY()+ISO_H;
        //gc.setFill(Color.BLACK);
        //gc.fillOval(xB, yB, 200, 150);
        //gc.fillOval(xB-40, yB-30, 200, 150);
        //gc.fillOval(xB+40, yB-30, 200, 150);
        gc.setFont(Font.font("sanserif",FontWeight.EXTRA_BOLD,40));         
        gc.setFill(Color.BLACK);
        gc.fillText("ALIEN:"+score, xB-4, yB-2);
        gc.setFill(Color.DEEPPINK);

        gc.fillText("ALIEN:"+score, xB, yB);

   


    }
    
    public void updateScore(int score){
        
    
    }
    
}
