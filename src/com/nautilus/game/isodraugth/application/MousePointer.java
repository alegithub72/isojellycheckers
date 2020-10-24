/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.application;

import com.nautilus.game.isodraugth.map.ISOCoverter;
import com.nautilus.game.isodraugth.map.Point2DAndMap;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


/**
 *
 * @author AlessioADM
 */
public class MousePointer implements EventHandler<MouseEvent>{

    ISODraugth app;
    Polygon poly;
    public MousePointer(ISODraugth app) {
        this.app=app;
    }

    @Override
    public void handle(MouseEvent event) {
       /** System.out.println("obj--->"+ event.getSource().toString());
        System.out.println("-screen x-->"+ event.getSceneX());
        System.out.println("-screen y-->"+ event.getSceneY());*/
       

        double x=event.getSceneX();
        double y =event.getSceneY();
        Point2D proot=app.root.sceneToLocal(x, y);
        System.out.println("-->"+app.root.sceneToLocal(x, y));
        double x0=proot.getX()-app.center.getX();
        double y0=proot.getY()-app.center.getY();
        Point2DAndMap p=ISOCoverter.isoToIJMAPXY(x0, y0);
        System.out.println(p);
        if(p!=null && app.playerA.getSelected()!=null){
            app.scene.setFill(Color.AQUAMARINE);
            double x1=p.getX()+app.center.getX();
            double y1=p.getY()+app.center.getY();
            Point2D plocal=app.root.sceneToLocal(x1,y1);
            System.out.println("-plocalÒ->"+plocal);
            app.aim.setLayoutX(x1);
            app.aim.setLayoutY(y1);
            System.out.println("-aim x->"+app.aim.getLayoutX());
            System.out.println("-aim y->"+app.aim.getLayoutY());
            app.aim.setVisible(true);
            app.move=p;

            
        }else if(app.playerA.getSelected()!=null) {
            //TODO mettere una scritta
            app.scene.setFill(Color.AQUAMARINE.darker());
            
        }
        

    
   
        
 
        
    }



    
    
}
