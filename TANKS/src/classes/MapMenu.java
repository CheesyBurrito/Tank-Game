/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Cedrik Dubois
 */
public class MapMenu extends Pane{
    
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;
    
    /*
    *
    *For now I'm using the var variable to switch between backgrounds since I only have two.
    *Later on, they will be in an array and it will cycle through that array as players 
    *cycle through the maps.
    *
    */
    
    private Background[] backgrounds = new Background[4];
    private static int backgroundIndex = 1;
    
    private ImageView playBtn;
    private ImageView backBtn;
    private ImageView rightBtn;
    
    private Image[] tanks = new Image[4];
    
    private Image usaTank = new Image("Texture/Menus/MapMenu/USA.png");
    private Image northKoreaTank = new Image("Texture/Menus/MapMenu/North Korea.png");
    private Image canadaTank = new Image("Texture/Menus/MapMenu/Canada.png");
    private Image chinaTank = new Image("Texture/Menus/MapMenu/China.png");
    
    private Image playBtnImage = new Image("Texture/Menus/MapMenu/Play Button.png");
    private Image playBtnHover = new Image("Texture/Menus/MapMenu/Play Button Hover.png");
    private Image playBtnClicked = new Image("Texture/Menus/MapMenu/Play Button Clicked.png");
    
    private Image backBtnImage = new Image("Texture/Menus/PlayerMenu/Back Button.png");
    private Image backBtnHover = new Image("Texture/Menus/PlayerMenu/Back Button Hover.png");
    private Image backBtnClicked = new Image("Texture/Menus/playerMenu/Back Button Clicked.png");
    
    private Image rightBtnImage = new Image("Texture/Menus/PlayerMenu/Right Arrow.png");
    private Image rightBtnHover = new Image("Texture/Menus/PlayerMenu/Right Arrow Hover.png");
    private Image rightBtnClicked = new Image("Texture/Menus/PlayerMenu/Right Arrow Clicked.png");
    
    private ArrayList<Player> players;
    private ArrayList<Text> playerNames = new ArrayList<Text>();
    private ArrayList<ImageView> playerTanks = new ArrayList<ImageView>();
    
    
    private static Text p;
    
    public MapMenu(){
        this.setMinWidth(WIDTH);
        this.setMaxWidth(WIDTH);
        this.setMinHeight(HEIGHT);
        this.setMaxHeight(HEIGHT);
        
        setBackgrounds();
        setTankList();
        setPlayBtn();
        setBackBtn();
        setRightBtn();
        
        
    }
    private void setPlayerTanks(){
        for (int i = 0; i < players.size(); i++){
            System.out.println(players.get(i).getTeam());
        }
    }
    private void setTankList(){
        tanks[0] = northKoreaTank;
        tanks[1] = usaTank;
        tanks[2] = canadaTank;
        tanks[3] = chinaTank;
    }
    private void setLeaderboard(){
        
        
        for (int i = 0; i < playerNames.size(); i++){
            this.getChildren().add(playerNames.get(i));
        }
        
        playerNames.get(0).setTranslateX(400);
        playerNames.get(0).setTranslateY(280);
        
        for (int i = 1; i < playerNames.size(); i++){
            playerNames.get(i).setTranslateX(playerNames.get(i - 1).getTranslateX());
            playerNames.get(i).setTranslateY(playerNames.get(i - 1).getTranslateY() + 80);
        }
        
        
    }
    public void setPlayers(){
        for (int i = 0; i < players.size(); i++){
            playerNames.add(new Text(players.get(i).getUsername()));
        }
        for (int i = 0; i < playerNames.size(); i++){
            playerNames.get(i).setFont(Font.font("Verdana", FontWeight.BOLD, 35));
        }
        setLeaderboard();
        setPlayerTanks();
    }
    public void setPlayerList(ArrayList<Player> players){
        this.players = players;
    }
    private void setRightBtn(){
        rightBtn = new ImageView(rightBtnImage);
        
        this.getChildren().add(rightBtn);
        
        rightBtn.setTranslateX(146.0);
        rightBtn.setTranslateY(-203.0);
        
        /*
        rightBtn.setOnMouseDragged(e -> {
            rightBtn.setTranslateX(e.getSceneX());
            rightBtn.setTranslateY(e.getSceneY());
            System.out.println(rightBtn.getTranslateX() + ", " + rightBtn.getTranslateY());
        });
        */
        
        rightBtn.setOnMouseClicked(e -> {
            if (backgroundIndex == 3)
                backgroundIndex = 0;
            else
                backgroundIndex++;
            
            this.setBackground(backgrounds[backgroundIndex]);
        });
        
        rightBtn.setOnMouseEntered(e -> {
            rightBtn.setImage(rightBtnHover);
        });
        
        rightBtn.setOnMouseExited(e -> {
            rightBtn.setImage(rightBtnImage);
        });
        
        rightBtn.setOnMousePressed(e -> {
            rightBtn.setImage(rightBtnClicked);
        });
        
        rightBtn.setOnMouseReleased(e -> {
            rightBtn.setImage(rightBtnHover);
        });
    }
    private void setBackBtn(){
        backBtn = new ImageView(backBtnImage);
        
        this.getChildren().add(backBtn);
        
        backBtn.setTranslateX(-162.0);
        backBtn.setTranslateY(-207.5);
        
        /*
        backBtn.setOnMouseDragged(e -> {
            backBtn.setTranslateX(e.getSceneX());
            backBtn.setTranslateY(e.getSceneY());
            System.out.println(backBtn.getTranslateX() + ", " + backBtn.getTranslateY());
        });
        */
        
        backBtn.setOnMouseEntered(e -> {
            backBtn.setImage(backBtnHover);
        });
        
        backBtn.setOnMouseExited(e -> {
            backBtn.setImage(backBtnImage);
        });
        
        backBtn.setOnMousePressed(e -> {
            backBtn.setImage(backBtnClicked);
        });
        
        backBtn.setOnMouseReleased(e -> {
            backBtn.setImage(backBtnHover);
        });
        
    }
    private void setPlayBtn(){
        playBtn = new ImageView(playBtnImage);
        
        this.getChildren().add(playBtn);
        
        playBtn.setTranslateX(10.5);
        playBtn.setTranslateY(176.0);
        
        /*
        playBtn.setOnMouseDragged(e -> {
            playBtn.setTranslateX(e.getSceneX());
            playBtn.setTranslateY(e.getSceneY());
            System.out.println(playBtn.getTranslateX() + ", " + playBtn.getTranslateY());
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
    private void setBackgrounds(){
        backgrounds[0] = new Background(new BackgroundImage(new Image("Texture/Menus/MapMenu/Desert Map.png", WIDTH, HEIGHT, false, true), 
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT));
        backgrounds[1] = new Background(new BackgroundImage(new Image("Texture/Menus/MapMenu/Mountain Map.png", WIDTH, HEIGHT, false, true), 
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT));
        backgrounds[2] = new Background(new BackgroundImage(new Image("Texture/Menus/MapMenu/Space Map.png", WIDTH, HEIGHT, false, true), 
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT));
        backgrounds[3] = new Background(new BackgroundImage(new Image("Texture/Menus/MapMenu/Snow Map.png", WIDTH, HEIGHT, false, true), 
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT));
        
        
        this.setBackground(backgrounds[backgroundIndex]);
    }
}