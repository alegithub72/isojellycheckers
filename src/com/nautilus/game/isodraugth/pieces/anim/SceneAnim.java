/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.pieces.anim;

import com.nautilus.game.isodraugth.application.ISODraugth;
import com.nautilus.game.isodraugth.map.Casella;
import com.nautilus.game.isodraugth.map.ISOCoverter;
import com.nautilus.game.isodraugth.map.Point2DAndMap;
import com.nautilus.game.isodraugth.pieces.Pedina;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.util.Duration;

/**
 *
 * @author AlessioADM
 */
public abstract class SceneAnim  {

    ISODraugth app;
    Casella c;
    Pedina p;    
    Point2DAndMap m;    
    public SceneAnim(ISODraugth app) {
        this.app = app;
        
        p = app.playerA.getSelected();
        m = app.move;
        if (p != null) {
            c = p.getCasella();
        }        
    }
   public abstract void playAnim();
    public Point2D convertISOCoordinateStart() {

        double xstart = c.x * ISOCoverter.SQ_WD;
        double ystart = c.y * ISOCoverter.SQ_HG;
        double isoXstart = ISOCoverter.covertPlaneXToScreenISOX(xstart, ystart) + app.center.getX();
        double isoYstart = ISOCoverter.convertPlaneYToScreenISOY(xstart, ystart) + app.center.getY();
        return new Point2D(isoXstart, isoYstart);
    }

    public Point2D convertISOCoordinateEnd() {
        double xend = m.getMapx() * ISOCoverter.SQ_WD;
        double yend = m.getMapy() * ISOCoverter.SQ_HG;
        double isoXend = ISOCoverter.covertPlaneXToScreenISOX(xend, yend) + app.center.getX();
        double isoYend = ISOCoverter.convertPlaneYToScreenISOY(xend, yend) + app.center.getY();        
        return new Point2D(isoXend, isoYend);

   }   
    public void playStraightMove(Pedina p,Point2D startXY, Point2D endXY){
            Line line = new Line();
            line.setStrokeWidth(10);
            line.setStartX(startXY.getX());

            line.setStartY(startXY.getY());
            line.setEndX(endXY.getX());
            line.setEndY(endXY.getY());
            int dist = (int) (startXY.distance(endXY) / ISOCoverter.SQ_WD);
            // appD.board.getChildren().add(line);
            PathTransition pathTransition = new PathTransition(Duration.millis(700 * dist), line, p);
            pathTransition.setCycleCount(1);
            pathTransition.setOrientation(PathTransition.OrientationType.NONE);
            pathTransition.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    p.stopAnim();
                    //todo to depth order ...... 
                    //app.board.getChildren().sort(null);
                    p.set(0);
                    p.setCasella(new Casella(app.move.getMapx() ,
                    app.move.getMapy(), Casella.EMPTY));
                app.board.moveNodeDepth(p.getCasella().x+(p.getCasella().y*8), p);                             
                }
            });
            pathTransition.play();
    
    
    
    }
    public void playCurvetMove(Pedina p, Point2D startXY, Point2D endXY) {
        QuadCurve curve = new QuadCurve();
        curve.setStrokeWidth(10);
        curve.setStartX(startXY.getX());

        curve.setStartY(startXY.getY());
        curve.setEndX(endXY.getX());
        curve.setEndY(endXY.getY());
        curve.setControlX(startXY.getX()+300);
        curve.setControlY(startXY.getY()-300);
        int dist = (int) (startXY.distance(endXY) / ISOCoverter.SQ_WD);
       //  app.board.getChildren().add(curve);
        PathTransition pathTransition = new PathTransition(Duration.millis(250 * dist), curve, p);
        pathTransition.setCycleCount(1);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
             //   p.stopAnim();
                    //todo to depth order ...... 
                //app.board.getChildren().sort(null);
                p.set(0);
                p.setCasella(new Casella(app.move.getMapx(),
                        app.move.getMapy(), Casella.EMPTY));
                app.board.moveNodeDepth(p.getCasella().x + (p.getCasella().y * 8), p);
            }
        });
                pathTransition.play();

    }
}
