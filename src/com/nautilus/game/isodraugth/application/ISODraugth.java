/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.application;

import com.nautilus.game.isodraugth.map.BoardGroup;
import com.nautilus.game.isodraugth.map.Casella;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import com.nautilus.game.isodraugth.map.ISOCoverter;
import com.nautilus.game.isodraugth.map.Point2DAndMap;
import com.nautilus.game.isodraugth.map.TerrainFree;
import com.nautilus.game.isodraugth.map.TerrainOccupy;
import com.nautilus.game.isodraugth.pieces.Pedina;
import com.nautilus.game.isodraugth.pieces.anim.SceneAnim;
import com.nautilus.game.isodraugth.pieces.anim.SceneAnimSoldier;
import com.nautilus.game.isodraugth.players.PlayerSideA;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 * mac     2560 x 1600 Retina
 * @author AlessioADM
 */
public class ISODraugth extends Application {
    
    public static final int MAP_WIDTH = 8;
    public static final int MAP_HIGHT = 8;
    Casella map[][] = new Casella[MAP_HIGHT][MAP_WIDTH];
    TerrainFree free = new TerrainFree();
    TerrainOccupy occupy = new TerrainOccupy();
   double percX=1;   
   double percY=1;
   
  //  double perc=1;
    public PlayerSideA playerA;
    static  Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    double screeenWidth ;
    double screenHight;
    double sceneWidth;
    double sceneHight;
    //static  double screeenWidth = 215*8;
    //static double screenHight = (225*8)/2;
    //static  double sceneWidth = screeenWidth+225;
    //static double sceneHight = screenHight+112;
    public Point2DAndMap move;
    public Cursor cursor = new Cursor(Color.BLUEVIOLET,false);
    //Score scoreA;
    Canvas mapScreen,mapScreenIntro;
    //Score scoreB;
    //public static Point2D center = new Point2D((screeenWidth / 2), 100);
    public static Point2D center;
    public BoardGroup board;
    Group root;
    Score score;
    Scene scene;
    BorderPane pan;
    public Cursor aim = new Cursor(Color.RED,true);    

    void initMap() {
        for (int y = 0; y < MAP_WIDTH; y++) {
            for (int x = 0; x < MAP_HIGHT; x++) {
                if (y == 7 && x % 2 == 0) {
                    map[y][x] = new Casella(x, y, Casella.PEDINA_B);
                } else if (y == 6 && x % 2 == 1) {
                    map[y][x] = new Casella(x, y, Casella.PEDINA_B);
                } else if (y == 5 && x % 2 == 0) {
                    map[y][x] = new Casella(x, y, Casella.PEDINA_B);
                } else {
                    map[y][x] = new Casella(x, y, Casella.EMPTY);
                }
            }

        }

    }


    ;
    @Override
    public void start(Stage primaryStage) {
        //TODO rivedere il panello quando scala deve scalare anche la finestra principale
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();
        root=new Group();
        System.out.println("-----ScreenBounds--------->"+primaryScreenBounds.getWidth()+","+primaryScreenBounds.getHeight());
        screeenWidth=primaryScreenBounds.getWidth();
        screenHight=primaryScreenBounds.getHeight();
        percX=((100*screeenWidth)/(free.ISO_W*(MAP_WIDTH)))/100;
        percY=((100*screenHight)/((free.ISO_H_UP*MAP_HIGHT)+free.ISO_SUB_H))/100;
        sceneWidth=free.ISO_W*MAP_WIDTH;
        sceneHight=(free.ISO_H_UP*MAP_HIGHT)+free.ISO_SUB_H;
        center=new Point2D((sceneWidth / 2), 0);
        //scoreA = new Score();
        //scoreB = new Score();
        //pan=new BorderPane();
        System.out.println("-----SceneBounds--------->"+sceneWidth+","+sceneHight);
        initMap();
        playerA = new PlayerSideA(this, "Alessio", PlayerSideA.WHITE, map);
        board = new BoardGroup(playerA);
        /**StackPane panel = new StackPane();
        panel.setBackground(Background.EMPTY);
        panel.setMinSize(800, 600);
        panel.setMaxSize(screeenWidth, screenHight);*/

      //  mapScreen = new Canvas(sceneWidth,sceneHight );
        mapScreen = new Canvas(sceneWidth,sceneHight );
        mapScreenIntro = new Canvas(sceneWidth,sceneHight ); 
        //pan.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));


       
        // primaryStage.setFullScreen(true);
        GraphicsContext gc = mapScreen.getGraphicsContext2D();
         GraphicsContext gcIntro = mapScreenIntro.getGraphicsContext2D();
         Image img=new Image("LocandinaGame.png");
         gcIntro.drawImage(img,0,0,sceneWidth,sceneHight);
       
        gc.setFill(Color.GOLD);
       //gc.set
        gc.fillRect(0, 0, sceneWidth, sceneHight);
        //gc.setFill(Color.CHOCOLATE);
        //gc.fillRect(0, sceneHight/2, sceneWidth, sceneHight/2);
        
        root.getChildren().add(mapScreen);
        //root.getChildren().add(mapScreenIntro);
        //gc.setFill(Color.BLACK);
        board.getChildren().add(cursor);
        
        cursor.setVisible(false);
        root.getChildren().add(board);
        board.getChildren().add(aim);
        aim.setVisible(false);
        buildISOMap(gc, board);

        //gc.fillRect(0,0,  1024, 768);
        System.out.println(" w,h=" + primaryStage.getHeight() + "," + primaryStage.getWidth());
        //mapScreen.setLayoutX(1000);
        //mapScreen.setLayoutY(-100);
        //
        //gc.fillPolygon(xp, yp, 4);
        // gc.strokePolygon(new double[]{0,110,150,40}, new double[]{0,0,20,20}, 4 );
        //  gc.setStroke(Color.AQUAMARINE);
        // gc.strokeRect(0, 0, 300, 250);  
        // gc.strokeRect(100, 100, 100, 100);
      //  root.getChildren().add(board);
       // scoreA.setScaleX(0.3);
       // scoreA.setScaleY(0.3);
       // scoreA.setLayoutX(0);
       // scoreA.setLayoutY(0);
          //board.getChildren().add(scoreA);
      //  pan.setTop(scoreA);
      //  pan.getTop().setTranslateX(-100);
      //  pan.getTop().setTranslateY(-100); 
        
       // pan.getTop().autosize();
        //scoreB.setScaleX(perc);
        //scoreB.setScaleY(perc);
        //pan.setLeft(scoreB);
        //scoreA.setLayoutY(0);
        //scoreA.setLayoutX((screeenWidth/2)+300);
        //board.getChildren().add(scoreB);
        //scoreB.setLayoutY(0);
        //scoreB.setLayoutX((screeenWidth/2)-800);
        root.setOnMouseMoved(new MousePointer(this));
        root.setOnMouseClicked(new MouseSelection(this));
        //pan.setCenter(root);
        root.setScaleX(percX);
        root.setScaleY(percY);
        
       // root.setScaleZ(0.50);
        System.out.println("-LocalTOScene-->>"+root.localToScene(0,0).toString());
    
        //root.relocate(0, 0);
        root.setTranslateX(-root.localToScene(0,0).getX());
        root.setTranslateY(-root.localToScene(0,0).getY());        
        //root.setTranslateX(0);
       // root.setTranslateY(0);
        //scene.setFill(Color.BLUEVIOLET);
        primaryStage.setTitle("ISO Draugth");
        //primaryStage.setHeight(root.getBoundsInParent().getHeight());
        //primaryStage.setHeight(root.getBoundsInParent().getWidth());
        System.out.println("--Bound-"+root.getBoundsInParent().getWidth()+","+root.getBoundsInParent().getWidth());
        //scene = new Scene(pan, pan.getBoundsInParent().getWidth(), pan.getBoundsInParent().getHeight(), Color.AQUAMARINE);
        scene = new Scene(root, Color.BLACK);
        //primaryStage.set
        primaryStage.setScene(scene);
            
         primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }



    void buildISOMap(GraphicsContext gc, Group board) {

        

        for (int y = 0; y < MAP_WIDTH; y++) {

            for (int x = 0; x < MAP_HIGHT; x++) {

                double vx = (ISOCoverter.SQ_WD * x), vy = (ISOCoverter.SQ_HG * y);
                double convX = ISOCoverter.covertPlaneXToScreenISOX(vx, vy);
                double convY = ISOCoverter.convertPlaneYToScreenISOY(vx, vy);

                double convXC = ISOCoverter.covertPlaneXToScreenISOX(vx + ISOCoverter.SQ_WD / 2, vy + ISOCoverter.SQ_HG / 2);
                double convYC = ISOCoverter.convertPlaneYToScreenISOY(vx + ISOCoverter.SQ_WD / 2, vy + ISOCoverter.SQ_HG / 2);

                double x1 = convX + center.getX();
                double y1 = convY + center.getY();

                double xs = convXC + center.getX();
                double ys = convYC + center.getY();

                if (y % 2 == 0) {

                    if (x % 2 == 0) {
                        gc.drawImage(occupy.getImg(), x1 - free.offsx, y1);
                    } else {
                        gc.drawImage(free.getImg(), x1 - free.offsx, y1);
                    }
                } else {

                    if (x % 2 == 0) {
                        gc.drawImage(free.getImg(), x1 - free.offsx, y1);
                    } else {
                        gc.drawImage(occupy.getImg(), x1 - free.offsx, y1);
                    }

                }

                //gc.fillOval(x1, y1, 10, 10);
                //gc.fillOval(xs, ys, 10, 5);

                //gc.drawImage(new Image("isoTEST.png"), x1, y1);
                //Polygon p=new Polygon();
                //p.getPoints().add(center.getX()+offsx+80);
                //p.getPoints().add(center.getY()+offsy+50);
                gc.setStroke(Color.BROWN);
                //gc.strokePolyline(new double[]{x1,x2,x3,x4,x5} ,new double[]{y1,y2,y3,y4,y5} , 5);
            }
           //  gc.drawImage(new Image("anim.png"), 50, 150);

        }
        
        score=new Score(gc, free.ISO_W, free.ISO_H);
    }

    public void trainAnim() {
        Casella c = null;
        Pedina p=playerA.getSelected();
        if (p!= null) {
            c = playerA.getSelected().getCasella();
            double xend = (move.getMapx() * ISOCoverter.SQ_WD) + ISOCoverter.SQ_WD / 2;
            double yend = (move.getMapy() * ISOCoverter.SQ_HG) + ISOCoverter.SQ_HG / 2;
            double xstart = (c.x * ISOCoverter.SQ_WD) + ISOCoverter.SQ_WD / 2;
            double ystart = (c.y * ISOCoverter.SQ_HG) + ISOCoverter.SQ_HG / 2;
            double isoXend = ISOCoverter.covertPlaneXToScreenISOX(xend, yend)+center.getX();
            double isoYend = ISOCoverter.convertPlaneYToScreenISOY(xend, yend)+center.getY();
            double isoXstart = ISOCoverter.covertPlaneXToScreenISOX(xstart, ystart)+center.getX();
            double isoYstart = ISOCoverter.convertPlaneYToScreenISOY(xstart, ystart)+center.getY();
            Line line = new Line();
            line.setStrokeWidth(10);
          // Path path=new Path();
         
        //path.setStroke(Color.BLUE);
        //path.setStrokeWidth(2);
        //path.getStrokeDashArray().setAll(5d, 5d);
           // MoveTo mTo=new MoveTo(isoXstart,isoYstart);
           // LineTo hline=new LineTo(isoXend, isoYend);
            //path.getElements().add(mTo);
            //path.getElements().add(hline);
           // line.setFill(Color.BLACK);
            //board.getChildren().add(line);
            line.setStartX(isoXstart);
            line.setStartY(isoYstart);
            line.setEndX(isoXend);
            line.setEndY(isoYend);

             //path.setVisible(true);
            //line.toFront();
            //path.setLayoutX(isoXstart);
            //path.setLayoutY(isoYstart);
            PathTransition pathTransition = new PathTransition(Duration.millis(1000),line,p);
            pathTransition.setCycleCount(1);
            pathTransition.setOrientation(PathTransition.OrientationType.NONE);
            pathTransition.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    p.stopAnim();
   
                }
            });
            //board.getChildren().add(path);
            
            /**TranslateTransition trans = new TranslateTransition();
            trans.setFromX(isoXstart);
            trans.setFromY(isoYstart);
            
            trans.setToX(isoXend);
             trans.setToY(isoYend);
            trans.setNode(p);*/
           // root.getChildren().add(path);
            //path.setTranslateX(-isoXstart);
            //path.setTranslateY(-isoYstart);
            //System.out.println("path x="+path.getLayoutX()+" isoXstart="+isoXstart);
            //System.out.println("path y="+path.getLayoutY()+" isoYstart="+isoYstart);
            p.walkNEplay();
            //trans.play();
            pathTransition.play();
        }else {
        System.out.println("no anim");
        }

    }
public void playAnim(){
    SceneAnim animFull=new SceneAnimSoldier(this);
    animFull.playAnim();
}
}
