/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.map;

import com.nautilus.game.isodraugth.application.ISODraugth;
import com.nautilus.game.isodraugth.pieces.Pedina;
import com.nautilus.game.isodraugth.players.PlayerSideA;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.Node;

/**
 *
 * @author AlessioADM
 */
public class BoardGroup extends Group {
PlayerSideA playerA;    
    public BoardGroup(PlayerSideA playerA){
    this.playerA=playerA;
    ArrayList<Node> list=new ArrayList<>(64);
        for (int k=0;k<64;k++) {
            list.add(k, new Group());
        }
    this.getChildren().setAll(list);
    
    placePieces();
    }
    public void moveNodeDepth(int depth, Node n) {
        this.getChildren().remove(n);
        this.getChildren().add(depth, n);

    }
   
      void placePieces() {
        for (int n = 0; n < playerA.sizeList(); n++) {
            Pedina pedina = playerA.getPedina(n);
            int y = pedina.getCasella().y;
            int x = pedina.getCasella().x;
            double vx = (ISOCoverter.SQ_WD * x), vy = (ISOCoverter.SQ_HG * y);
            double convXC = ISOCoverter.covertToISOX(vx + ISOCoverter.SQ_WD / 2, vy + ISOCoverter.SQ_HG / 2);
            double convYC = ISOCoverter.covertToISOY(vx + ISOCoverter.SQ_WD / 2, vy + ISOCoverter.SQ_HG / 2);
            double xs = convXC +  ISODraugth.center.getX();
            double ys = convYC + ISODraugth.center.getY();
            //pedina.setLayoutX(xs - pedina.getOffsx());
          //  pedina.setLayoutY(ys - pedina.getOffsy());
            pedina.setX(xs - pedina.getOffsx());
            pedina.setY(ys - pedina.getOffsy());            
         // pedina.relocate(xs - pedina.getOffsx(), ys - pedina.getOffsy());
            moveNodeDepth(x+(y*8),pedina);
        }

    }  
}
