/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.pieces.players.input;

import com.nautilus.game.isodraugth.application.ISODraugth;
import com.nautilus.game.isodraugth.map.ISOCoverter;
import com.nautilus.game.isodraugth.pieces.Pedina;
import com.nautilus.game.isodraugth.players.PlayerSideA;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author AlessioADM
 */
public class PedinaMousePointer implements EventHandler<MouseEvent> {

    ISODraugth app;
    
    Pedina p;
    public PedinaMousePointer(ISODraugth app,Pedina p){
        this.app=app;
        this.p=p;
    
    }
    
    @Override
    public void handle(MouseEvent event) {
        app.playerA.setSelected(p);
        Pedina pedina = app.playerA.getSelected();
        double vx = pedina.getCasella().x * ISOCoverter.SQ_WD;
        double vy = pedina.getCasella().y * ISOCoverter.SQ_HG;
      //  System.out.println("xi=" + pedina.getCasella().x);
       /// System.out.println("yj=" + pedina.getCasella().y);
        double xs = ISOCoverter.covertToISOX(vx, vy);
        double ys = ISOCoverter.covertToISOY(vx, vy);
        app.cursor.setLayoutX(xs + app.center.getX());
        app.cursor.setLayoutY(ys + app.center.getY());
        app.cursor.setVisible(true);       
    }
    
}
