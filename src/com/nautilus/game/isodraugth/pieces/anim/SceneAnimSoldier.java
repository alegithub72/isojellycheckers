/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.pieces.anim;

import com.nautilus.game.isodraugth.application.ISODraugth;
import com.nautilus.game.isodraugth.map.Casella;
import com.nautilus.game.isodraugth.map.ISOCoverter;
import com.nautilus.game.isodraugth.pieces.Pedina;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.shape.QuadCurve;
import javafx.util.Duration;

/**
 *
 * @author AlessioADM
 */
public class SceneAnimSoldier extends SceneAnim{

    public SceneAnimSoldier(ISODraugth app) {
        super(app);
    }

    public void playSceneWalkNO(Pedina p, Point2D startXY, Point2D endXY) {
        p.stopSound();
        p.walkNOplay();
        playStraightMove(p, startXY, endXY);
    }
    
    
    
    public void playSceneJumpNO(Pedina p, Point2D startXY, Point2D endXY) {
        p.stopSound();
        p.loadCustomAnimation("jump_NO.png");
        Timeline anim = new Timeline();

  
        anim.getKeyFrames().add(new KeyFrame(Duration.millis(1000), new KeyValue(p, 10)));
        anim.getKeyFrames().add(new KeyFrame(Duration.millis(1000),"fire", new KeyValue(p, 29)));              

        //p.playSoundFire();
       // anim.play();
        
        ParallelTransition parallel=new ParallelTransition();
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
        PathTransition pathTransition = new PathTransition(Duration.millis(200 * dist), curve, p);
        pathTransition.setCycleCount(1);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                p.stopSound();
                    //todo to depth order ...... 
                //app.board.getChildren().sort(null);
               
                p.setCasella(new Casella(app.move.getMapx(),
                        app.move.getMapy(), Casella.EMPTY));
                app.board.moveNodeDepth(p.getCasella().x + (p.getCasella().y * 8), p);
            }
        });
        ActionTransionPedina fireAction=new ActionTransionPedina(p,Duration.millis(1000));
        
        parallel.getChildren().add(pathTransition);
        parallel.getChildren().add(anim);
        parallel.getChildren().add(fireAction);
        parallel.play();
        parallel.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              p.loadCustomAnimation("walk_north_Ovest.png");
            }
        });
    }
    public void playSceneWalkNE(Pedina p, Point2D startXY, Point2D endXY) {
        p.walkNEplay();
        playStraightMove(p, startXY, endXY);
    }

    @Override
    public void playAnim() {
        if (p != null && m != null && m.getMapy() < c.y) {
            Point2D startXY=convertISOCoordinateStart();
            Point2D endXY=convertISOCoordinateEnd();

            if (m.getMapx() > c.x) {
               // p.deathPlay();
                playSceneJumpNO(p, startXY, endXY);
            } else if (m.getMapx() < c.x) {
                playSceneFireNE(p, startXY, endXY);
            }
        } else {
            System.out.println("no anim");
        }
    }
    
    public void playSceneFireNO(Pedina p, Point2D startXY, Point2D endXY) {
        p.fireNOplay().setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playSceneWalkNO(p, startXY, endXY);
       
            }
        });
    }
    public void playSceneFireNE(Pedina p, Point2D startXY, Point2D endXY) {
        p.fireNEplay().setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playSceneWalkNE(p, startXY, endXY);

            }
        });
    }    
    
}
