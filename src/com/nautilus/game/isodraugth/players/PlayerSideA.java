/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.players;

import com.nautilus.game.isodraugth.application.ISODraugth;
import com.nautilus.game.isodraugth.map.Casella;
import com.nautilus.game.isodraugth.pieces.Pedina;
import com.nautilus.game.isodraugth.pieces.Soldier;
import com.nautilus.game.isodraugth.pieces.players.input.PedinaMousePointer;
import sa.boardgame.core.moves.Move;
import sa.boardgame.core.players.HumanPlayer;
import sa.boardgame.core.players.Player;
import sa.gameboard.core.Checker;
import sa.gameboard.core.Piece;

/**
 *
 * @author AlessioADM
 */
public class PlayerSideA extends HumanPlayer{
    public static final char BLACK='b';
    public static final char WHITE='w';
    Pedina[] list;
    String name;
    int type;
    int sizeList=12;
    ISODraugth app;

    public Pedina getSelected() {
        return selected;
    }

    public void setSelected(Pedina selected) {
        this.selected = selected;
    }

    public void setSelected(int x ,int y) {
        for (Pedina p : list) {
            if(p.getCasella().equals(x, y))selected=p; 
            else p=null;
        }
        
    }    
    Pedina selected;
    public PlayerSideA(ISODraugth app ,String name,char type,Casella  map[][]) {
        super(Checker.BLACK);
        this.name = name;
        list=new Pedina[sizeList];
        this.type=type;
        int n=0;
        this.app=app;
        for(int y=0;y<ISODraugth.MAP_WIDTH;y++){
            for(int x=0;x<ISODraugth.MAP_HIGHT;x++){
              if( map[y][x].type==Casella.PEDINA_B && type==WHITE) {
                  list[n]=new Soldier();
                  list[n].setCasella(map[y][x]);
                  list[n].setOnMouseClicked(new PedinaMousePointer(app, list[n]));
                  n++;
              }else{
                  //TODO
              }                            
            }
        }
    }
    public Pedina getPedina(int n){
        return list[n];
    }
    public int sizeList(){
        return sizeList;
    }

    @Override
    public String getCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Move chooseMoveList(int n, int n1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void possibleMove(String c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void drawMoveChoose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void deleteMoveChoose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	protected void possibleFilottoMove(Move m, String c) {
		 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		
	}
}
