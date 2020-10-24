/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.application;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author AlessioADM
 */
public class MouseSelection implements EventHandler<MouseEvent>{

    ISODraugth app;
    public MouseSelection(ISODraugth app){
        this.app=app;
    
    }
    
    @Override
    public void handle(MouseEvent event) {
        if(event.getClickCount()==1 && event.getButton()==MouseButton.SECONDARY){

        app.cursor.setVisible(false);
        app.aim.setVisible(false);
        app.playAnim();
        app.playerA.setSelected(null);        
        
        }
    }
    
}
