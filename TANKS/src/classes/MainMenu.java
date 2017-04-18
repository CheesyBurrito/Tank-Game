/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Cedrik Dubois
 */
public class MainMenu extends Pane{
    
   
    
    
    private static final int HEIGHT = 800;
    private static final int WIDTH = 1200;
    
    private ImageView playBtn;
    private ImageView loadBtn;
    
    private Image playBtnImage = new Image("Texture/Menus/MainMenu/Play Button.png");
    private Image playBtnHover = new Image("Texture/Menus/MainMenu/Play Button Hover.png");
    private Image playBtnClicked = new Image("Texture/Menus/MainMenu/Play Button Clicked.png");
    
    private Image loadBtnImage = new Image("Texture/Menus/MainMenu/Load Button.png");
    private Image loadBtnHover = new Image("Texture/Menus/MainMenu/Load Button Hover.png");
    private Image loadBtnClicked = new Image("Texture/Menus/MainMenu/Load Button Clicked.png");
    
    public MainMenu(){
        this.setMaxHeight(HEIGHT);
        this.setMinHeight(HEIGHT);
        this.setMaxWidth(WIDTH);
        this.setMinWidth(WIDTH);
        
        setBackground();
        
        setPlayBtn();
        setLoadBtn();
        
        this.requestFocus();
        
    }
    public void setScene(Scene scene, ImageView cursor){
        
        scene.setOnMouseEntered(e -> {
            this.getChildren().add(cursor);
            cursor.setTranslateX(e.getSceneX());
            cursor.setTranslateY(e.getSceneY());
        });
        
        scene.setOnMouseExited(e -> {
            this.getChildren().remove(cursor);
        });
        
        scene.setOnMouseMoved(e -> {
            cursor.setTranslateX(e.getSceneX());
            cursor.setTranslateY(e.getSceneY());
        });
    }
    public void setScene(Scene scene, ImageView cursor, MouseEvent m){
        this.getChildren().remove(cursor);
        
        this.getChildren().add(cursor);
        cursor.setTranslateX(m.getSceneX());
        cursor.setTranslateY(m.getSceneY());
        
        scene.setOnMouseEntered(e -> {
            this.getChildren().add(cursor);
            cursor.setTranslateX(e.getSceneX());
            cursor.setTranslateY(e.getSceneY());
        });
        
        scene.setOnMouseExited(e -> {
            this.getChildren().remove(cursor);
        });
        
        scene.setOnMouseMoved(e -> {
            cursor.setTranslateX(e.getSceneX());
            cursor.setTranslateY(e.getSceneY());
        });
        
    }
    
    private void setLoadBtn(){
        loadBtn = new ImageView(loadBtnImage);
        
        this.getChildren().add(loadBtn);
        
        loadBtn.setTranslateX(-19.0);
        loadBtn.setTranslateY(126.0);
        
        /*
        This is used just to place the buttons in the pane.
        I'm leaving it here for now in case we decide to do any modifications
        /
        
        loadBtn.setOnMouseDragged(e -> {
            loadBtn.setTranslateX(e.getSceneX());
            loadBtn.setTranslateY(e.getSceneY());
            System.out.println(e.getSceneX() + ", " + e.getSceneY());
        });
        */
        
        loadBtn.setOnMouseEntered(e -> {
            loadBtn.setImage(loadBtnHover);
            
        });
        
        loadBtn.setOnMouseExited(e -> {
            loadBtn.setImage(loadBtnImage);
            
        });
        
        loadBtn.setOnMouseClicked(e -> {
            System.out.println("Load button pressed");
        });
        
        loadBtn.setOnMousePressed(e -> {
            loadBtn.setImage(loadBtnClicked);
        });
        
        loadBtn.setOnMouseReleased(e -> {
            loadBtn.setImage(loadBtnHover);
        });
    }
    private void setPlayBtn(){
        
        playBtn = new ImageView(playBtnImage);
        
        this.getChildren().add(playBtn);
        
        playBtn.setTranslateX(-6.0);
        playBtn.setTranslateY(-16.0);
        
        /*
        This is used just to place the buttons in the pane.
        I'm leaving it here for now in case we decide to do any modifications
        /
        
        playBtn.setOnMouseDragged(e -> {
            playBtn.setTranslateX(e.getSceneX());
            playBtn.setTranslateY(e.getSceneY());
            System.out.println(e.getSceneX() + ", " + e.getSceneY());
        });
        */  
        
        
        playBtn.setOnMouseEntered(e -> {
            playBtn.setImage(playBtnHover);
            
        });
        
        playBtn.setOnMouseExited(e -> {
            playBtn.setImage(playBtnImage);
            
        });
        
        playBtn.setOnMousePressed(e -> {
            playBtn.setImage(playBtnClicked);
        });
        playBtn.setOnMouseReleased(e -> {
            playBtn.setImage(playBtnHover);
        });

    }
    public ImageView getPlayBtn(){
        return playBtn;
    }
    private void setBackground(){
        BackgroundImage myBI= new BackgroundImage(new Image("Texture/Menus/MainMenu/Background.png", WIDTH, HEIGHT, false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
       
        this.setBackground(new Background(myBI));
    }

}
