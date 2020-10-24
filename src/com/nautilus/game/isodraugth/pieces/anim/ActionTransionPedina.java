/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.pieces.anim;
import com.nautilus.game.isodraugth.pieces.Pedina;
import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.util.Duration;
/**
 *
 * @author AlessioADM
 */
public class ActionTransionPedina  extends Transition{

    Pedina p;
    public ActionTransionPedina(Pedina p,Duration d) {
        super();
        this.p=p;
        this.setCycleDuration(d);
        
    }
    boolean oneTime=false;
    
    //TODO for special event of the pedina and use with parallel tranistion ......
    @Override
    protected void interpolate(double frac) {
        if (frac>0.0 && !oneTime ) {
            p.playSoundFire();
            oneTime=true;
        }else if(frac>0.9 && oneTime) p.stopSound();
    }
    
}
