/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.pieces;

import com.nautilus.game.isodraugth.map.Casella;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.beans.value.WritableIntegerValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author AlessioADM
 */
public abstract class Pedina extends Parent implements WritableIntegerValue {

    ImageView imgView;
    Casella casella;
    Rectangle2D[] frames;
    int nframes = 0;
    int offsx = 260;
    int offsy = 260;
    double SPRITE_H;
    double SPRITE_W;
    AudioClip soundEffect;
    Timeline anim;
    String img_file;    

    public final Image createFrameNumber(String img_file) {
        //TODO caricare pirma l'immagine e poi rimuovvere il child
        this.img_file = img_file;        
        Image img2 = new Image(img_file);
        int n = (int) (img2.widthProperty().intValue() / SPRITE_W)+1;
        frames = new Rectangle2D[n];
        for (int i = 0; i < n; i++) {
            frames[i] = new Rectangle2D(i * SPRITE_W, 0, SPRITE_W, SPRITE_H);
        }
        nframes=0;
        return img2;
    }



    public Pedina(String file_img,double w,double h) {
        this.SPRITE_H = w;
        this.SPRITE_W = h;              

        Image newOne=createFrameNumber(file_img);
        initPedina(newOne);

    }

    final void initPedina(Image newOne) {
        double x=0;
        double y=0;
        ImageView old=imgView;
        if (imgView != null) {
             x=imgView.getX();
             y=imgView.getY();

            
        }

        ImageView imgViewNew = new ImageView(newOne);
        refreshFrameView(imgViewNew);
        imgViewNew.setX(x);
        imgViewNew.setY(y);
        getChildren().add(imgViewNew);
        getChildren().remove(old);
        imgView=imgViewNew;
        

    }

    public void refreshFrameView(ImageView imgViewNew) {
        imgViewNew.setViewport(frames[nframes]);
    }

    public void setX(double x) {
        imgView.setX(x);

    }

    public void setY(double y) {
        imgView.setY(y);

    }

    public Casella getCasella() {
        return casella;
    }

    public void setCasella(Casella casella) {
        this.casella = casella;
    }

    @Override
    public int get() {
        return nframes;
    }

    @Override
    public void set(int value) {
        nframes = value;
        imgView.setViewport(frames[nframes]);
    }

    @Override
    public void setValue(Number value) {
        this.nframes = value.intValue();

    }

    @Override
    public Number getValue() {
        return nframes;
    }

    public int getOffsx() {
        return offsx;
    }

    public int getOffsy() {
        return offsy;
    }

    abstract public Animation walkNEplay();

    abstract public Animation walkNOplay();
    abstract public Animation fireNOplay();
    abstract public Animation  fireNEplay ();

    public void stopSound() {
        if (soundEffect != null) {
            soundEffect.stop();
        }
    }

    public void stopAnim() {
        anim.stop();
        stopSound();


    }
    public void startAnim() {
        anim.play();
        
    }
    public void loadCustomAnimation(String file_name) {
        Image newOne = createFrameNumber(file_name);
        initPedina(newOne);
    }

    public void playSound(String sound_file) {
        try {
            String media_uri = Soldier.class.getResource(sound_file).toURI().toString();
            soundEffect = new AudioClip(media_uri);
            soundEffect.setCycleCount(MediaPlayer.INDEFINITE);
            soundEffect.play();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Soldier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract void playSoundFire();

    public abstract Animation deathPlay();
}
