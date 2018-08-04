/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.application;

import com.nautilus.game.isodraugth.map.ISOCoverter;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineCap;

/**
 *
 * @author AlessioADM
 */
public class Cursor extends Polygon{

    public Cursor(Color c,boolean dash) {
        super(0,0,ISOCoverter.covertToISOX(100, 0),+ISOCoverter.covertToISOY(100, 0),
                ISOCoverter.covertToISOX(100, 100),ISOCoverter.covertToISOY(100, 100),
                ISOCoverter.covertToISOX(0, 100), ISOCoverter.covertToISOY(0, 100)
        );
        this.setFill(c);
        this.setOpacity(0.5);
        this.setStrokeWidth(10);
        if(dash){
            this.getStrokeDashArray().setAll(5d, 15d);
            this.setStrokeLineCap(StrokeLineCap.ROUND);
        }
        
        this.setStroke(c.darker());
    }
    
    
    
    
    
    
}
