/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author MSI
 */
public class GamePane extends Pane{
    
    double width = 1200;
    double height = 800;
    
    
    MapGeneration mapGeneration = new MapGeneration(200, 200, 500);
    
    public GamePane(){
        paneSetup(this);
        movingBallSetup(this);
    }
    
    public void paneSetup(Pane pane){
        frontGroundSetup(pane);
        backGroundSetup(pane);
    }
    
    public void movingBallSetup(Pane pane){
        TanksAnimation tanksAnimation = new TanksAnimation(mapGeneration, pane, 2);  
    }
    
    public void backGroundSetup(Pane pane){
        
        BackgroundImage myBI= new BackgroundImage(new Image("Pictures/Backgrounds/Background.png", width, height, false, true),
        
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
       
        pane.setBackground(new Background(myBI));
    }
    
   public void frontGroundSetup(Pane pane){
       
       Rectangle rect;
       double yLocation = 0;
       
       for (int i = 0; i < width; i++){
            rect = new Rectangle();
            yLocation = mapGeneration.getY(i);
            
            //rect.setStyle();
            rect.setTranslateX(i);
            rect.setHeight(height - yLocation);
            rect.setTranslateY(yLocation);
            
            rect.setWidth(.25);
            
            //rect.setFill(Color.TRANSPARENT);
            //rect.setStroke(Color.GREEN);
            pane.getChildren().add(rect);
            
        }
   }

}
