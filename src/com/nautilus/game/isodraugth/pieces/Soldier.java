/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.pieces;

import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author AlessioADM
 */
public class Soldier extends Pedina {



    public Soldier() {
        super("walk_north_Ovest.png",410,410);
        this.offsx = 188;
        this.offsy = 250 ;

        
 

    }
   
        void loadDeath(){


        Image newOne=createFrameNumber("death_soldier.png");
   
        initPedina(newOne);
 
    }
        
        
        
    void loadNOWalk(){


        Image newOne=createFrameNumber("walk_north_Ovest.png");
   
        initPedina(newOne);
 
    }    
    void loadNEWalk(){


        Image newOne=createFrameNumber("walk_NE.png");     
        initPedina(newOne);
    }
    void loadFireNO() {


        Image newOne = createFrameNumber("fire_NO.png");
        initPedina(newOne);

    }
        void loadFireNE(){


        Image newOne=createFrameNumber("fire_NE.png");
        initPedina(newOne);

    }    
    public void playSoundWalk()
    {
        try {
            String media_uri = Soldier.class.getResource("/Soldier.wav").toURI().toString();
            soundEffect = new AudioClip(media_uri);
            soundEffect.setCycleCount(MediaPlayer.INDEFINITE);
            soundEffect.play();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Soldier.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


    public void playSoundFire() {
        try {
            String media_uri = Soldier.class.getResource("/Machineburst.wav").toURI().toString();
            soundEffect = new AudioClip(media_uri);
            soundEffect.setCycleCount(1);
            soundEffect.setRate(1.5);
                    
            soundEffect.play();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Soldier.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public Animation walkNOplay(){
        loadNOWalk();
        anim = new Timeline();
        anim.getKeyFrames().add(new KeyFrame(Duration.millis(0),"start",new KeyValue (this, 1)));
        anim.getKeyFrames().add(new KeyFrame(Duration.millis(500),new KeyValue (this, 18)));        
        anim.setCycleCount(Animation.INDEFINITE);
        playSoundWalk();
        anim.playFrom("start");
        return anim;

    }
    
    
    
    public Animation deathPlay() {
        loadDeath();
        anim = new Timeline();
        anim.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(this, 19)));
        anim.setCycleCount(1);
        //playSoundWalk();
        anim.playFrom("start");
        return anim;

    }
    
    
    
    
    
    @Override
    public Animation walkNEplay(){
        loadNEWalk();
        anim = new Timeline();
        anim.getKeyFrames().add(new KeyFrame(Duration.millis(1),"start",new KeyValue (this, 1)));
        anim.getKeyFrames().add(new KeyFrame(Duration.millis(500),new KeyValue (this, 19)));
        
        anim.setCycleCount(Animation.INDEFINITE);
        
        playSoundWalk();
        anim.playFrom("start");
        return anim;
    }    


    @Override
    public Animation  fireNOplay() {
        loadFireNO();
        Timeline anim2=new Timeline();
        anim2.getKeyFrames().add(new KeyFrame(Duration.millis(100), new KeyValue(this, 10)));
        anim2.setCycleCount(1);
                    anim=new Timeline();
       Pedina ref=this;
        anim2.setOnFinished((ActionEvent event) -> {

            anim.getKeyFrames().add(new KeyFrame(Duration.millis(1),"start",new KeyValue (ref, 10)));
            anim.getKeyFrames().add(new KeyFrame(Duration.millis(350), new KeyValue(ref, 18)));
            //anim.getKeyFrames().add(new KeyFrame(Duration.millis(), new KeyValue(ref, 18)));
            anim.setCycleCount(4);
            anim.playFrom("start");
            playSoundFire();            
        });
                anim2.play();
                return anim;
        
    }

    public Animation  fireNEplay() {
        loadFireNE();
        Timeline anim2=new Timeline();
        anim2.getKeyFrames().add(new KeyFrame(Duration.millis(100), new KeyValue(this, 10)));
        anim2.setCycleCount(1);
                    anim=new Timeline();
       Pedina ref=this;
        anim2.setOnFinished((ActionEvent event) -> {

            anim.getKeyFrames().add(new KeyFrame(Duration.millis(1),"start",new KeyValue (ref, 10)));
            anim.getKeyFrames().add(new KeyFrame(Duration.millis(350), new KeyValue(ref, 18)));
            //anim.getKeyFrames().add(new KeyFrame(Duration.millis(), new KeyValue(ref, 18)));
            anim.setCycleCount(4);
            anim.playFrom("start");
            playSoundFire();            
        });
                anim2.play();
                return anim;
        
    }    
    
}
