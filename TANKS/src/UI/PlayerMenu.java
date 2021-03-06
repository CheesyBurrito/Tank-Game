/****************************************************************
 *  Header File: BXXXXXXX.h
 *  Description: Generic Business Function Header File
 *    History:
 *     Date    Programmer SAR# - Description
 *     ---------- ---------- ----------------------------
 *  Author 03/15/2006           - Created
 *
 ****************************************************************/
package UI;

import Sounds.SoundLib;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Cedrik Dubois
 */
public class PlayerMenu extends Pane {

    private SoundLib sounds;

    /**Width of the pane*/
    private static final int WIDTH = 1200;
    /**Height of the pane*/
    private static final int HEIGHT = 950;

    private Text playerOutput;
    private int numberOfPlayers = 2; //Default value is 2 since you cannot play this game alone
    
    /**The back button*/
    private ImageView backBtn;
    /**The next button*/
    private ImageView nextBtn;
    /**The left button*/
    private ImageView leftBtn;
    /**The right button*/
    private ImageView rightBtn;
    
    /**The mute button*/
    private ImageView muteBtn;
    
        /**Image of the mute button*/
    private Image muteBtnImage = new Image("Texture/Menus/MainMenu/Mute Button.png");
/**Image of the next button*/
    private Image nextBtnImage = new Image("Texture/Menus/CountryMenu/Next Button.png");
    /**Image of the next hover button*/
    private Image nextBtnHover = new Image("Texture/Menus/CountryMenu/Next Button Hover.png");
    /**Image of the next clicked button*/
    private Image nextBtnClicked = new Image("Texture/Menus/CountryMenu/Next Button Clicked.png");
/**Image of the back button*/
    private Image backBtnImage = new Image("Texture/Menus/PlayerMenu/Back Button.png");
    /**Image of the back hover button*/
    private Image backBtnHover = new Image("Texture/Menus/PlayerMenu/Back Button Hover.png");
    /**Image of the button*/
    private Image backBtnClicked = new Image("Texture/Menus/PlayerMenu/Back Button Clicked.png");
/**Image of the left button*/
    private Image leftBtnImage = new Image("Texture/Menus/PlayerMenu/Left Arrow.png");
    /**Image of the left hover button*/
    private Image leftBtnHover = new Image("Texture/Menus/PlayerMenu/Left Arrow Hover.png");
    /**Image of the left clicked button*/
    private Image leftBtnClicked = new Image("Texture/Menus/PlayerMenu/Left Arrow Clicked.png");
/**Image of the right button*/
    private Image rightBtnImage = new Image("Texture/Menus/PlayerMenu/Right Arrow.png");
    /**Image of the right hover button*/
    private Image rightBtnHover = new Image("Texture/Menus/PlayerMenu/Right Arrow Hover.png");
    /**Image of the right clicked button*/
    private Image rightBtnClicked = new Image("Texture/Menus/PlayerMenu/Right Arrow Clicked.png");
    
    


    /**
     *
     * @param sounds
     */
    public PlayerMenu(SoundLib sounds) {
        this.sounds = sounds;

        this.setMaxHeight(HEIGHT);
        this.setMinHeight(HEIGHT);
        this.setMaxWidth(WIDTH);
        this.setMinWidth(WIDTH);

        setBackground();

        setText();
        setLeftBtn();
        setRightBtn();
        setNextBtn();
        setBackBtn();
        setMuteBtn();

    }
/**Sets the elements*/
    private void setMuteBtn() {
        muteBtn = new ImageView(muteBtnImage);

        this.getChildren().add(muteBtn);

        muteBtn.setTranslateX(456.0);
        muteBtn.setTranslateY(654.0);

        /*
        muteBtn.setOnMouseDragged(e -> {
            muteBtn.setTranslateX(e.getSceneX());
            muteBtn.setTranslateY(e.getSceneY());
            System.out.println(muteBtn.getTranslateX() + ", " + muteBtn.getTranslateY());
        });
         */
        muteBtn.setOnMouseReleased(e -> {
            if (sounds.isSoundPlaying()) {
                sounds.getBackgroundMusic().pause();
                sounds.setSoundPlaying(false);
            } else if (sounds.isSoundPlaying() == false) {
                sounds.getBackgroundMusic().play();
                sounds.setSoundPlaying(true);
            }
        });
    }

    /**
     *
     * @param scene
     * @param cursor
     * @param m
     */
    public void setScene(Scene scene, ImageView cursor, MouseEvent m) {
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
    /**Sets the elements*/
    private void setBackBtn() {
        backBtn = new ImageView(backBtnImage);

        this.getChildren().add(backBtn);

        backBtn.setTranslateX(-173.0);
        backBtn.setTranslateY(-195.5);

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
            if (sounds.isSoundPlaying()) {
                sounds.getBtnClicked().seek(Duration.ZERO);
                sounds.getBtnClicked().play();
            }
        });

        backBtn.setOnMouseReleased(e -> {
            backBtn.setImage(backBtnHover);
        });
    }
/**Sets the elements*/
    private void setNextBtn() {
        nextBtn = new ImageView(nextBtnImage);

        this.getChildren().add(nextBtn);

        nextBtn.setTranslateX(123.0);
        nextBtn.setTranslateY(134.0);

        /*
        nextBtn.setOnMouseDragged(e -> {
            nextBtn.setTranslateX(e.getSceneX());
            nextBtn.setTranslateY(e.getSceneY());
            System.out.println(nextBtn.getTranslateX() + ", " + nextBtn.getTranslateY());
        });
         */
        nextBtn.setOnMouseEntered(e -> {
            nextBtn.setImage(nextBtnHover);
        });

        nextBtn.setOnMouseExited(e -> {
            nextBtn.setImage(nextBtnImage);
        });

        nextBtn.setOnMousePressed(e -> {
            nextBtn.setImage(nextBtnClicked);
            if (sounds.isSoundPlaying()) {
                sounds.getBtnClicked().seek(Duration.ZERO);
                sounds.getBtnClicked().play();
            }
        });

        nextBtn.setOnMouseReleased(e -> {
            nextBtn.setImage(nextBtnHover);
        });
    }
    //Updates the current players selected*/
    private void updatePlayers(boolean var) {
        if (var) {
            if (numberOfPlayers > 2) {
                numberOfPlayers--;
                playerOutput.setText(numberOfPlayers + "");
            } else {
                numberOfPlayers = 4;
                playerOutput.setText(numberOfPlayers + "");
            }
        } else {
            if (numberOfPlayers < 4) {
                numberOfPlayers++;
                playerOutput.setText(numberOfPlayers + "");
            } else {
                numberOfPlayers = 2;
                playerOutput.setText(numberOfPlayers + "");
            }
        }
    }
/**Sets the elements*/
    private void setLeftBtn() {
        leftBtn = new ImageView(leftBtnImage);

        this.getChildren().add(leftBtn);

        leftBtn.setTranslateX(-94.5);
        leftBtn.setTranslateY(-37.0);

        /*
        leftBtn.setOnMouseDragged(e -> {
            leftBtn.setTranslateX(e.getSceneX());
            leftBtn.setTranslateY(e.getSceneY());
            System.out.println(leftBtn.getTranslateX() + ", " + leftBtn.getTranslateY());
        });
         */
        leftBtn.setOnMouseEntered(e -> {
            leftBtn.setImage(leftBtnHover);
        });

        leftBtn.setOnMouseExited(e -> {
            leftBtn.setImage(leftBtnImage);
        });

        leftBtn.setOnMousePressed(e -> {
            leftBtn.setImage(leftBtnClicked);
            if (sounds.isSoundPlaying()) {
                sounds.getBtnClicked().seek(Duration.ZERO);
                sounds.getBtnClicked().play();
            }
        });

        leftBtn.setOnMouseReleased(e -> {
            leftBtn.setImage(leftBtnHover);
            updatePlayers(true);
        });
    }
/**Sets the elements*/
    private void setRightBtn() {
        rightBtn = new ImageView(rightBtnImage);

        this.getChildren().add(rightBtn);

        rightBtn.setTranslateX(-8.5);
        rightBtn.setTranslateY(-17.0);

        /*
        rightBtn.setOnMouseDragged(e -> {
            rightBtn.setTranslateX(e.getSceneX());
            rightBtn.setTranslateY(e.getSceneY());
            System.out.println(rightBtn.getTranslateX() + ", " + rightBtn.getTranslateY());
        });
         */
        rightBtn.setOnMouseEntered(e -> {
            rightBtn.setImage(rightBtnHover);
        });

        rightBtn.setOnMouseExited(e -> {
            rightBtn.setImage(rightBtnImage);
        });

        rightBtn.setOnMousePressed(e -> {
            rightBtn.setImage(rightBtnClicked);
            if (sounds.isSoundPlaying()) {
                sounds.getBtnClicked().seek(Duration.ZERO);
                sounds.getBtnClicked().play();
            }
        });

        rightBtn.setOnMouseReleased(e -> {
            rightBtn.setImage(rightBtnHover);
            updatePlayers(false);
        });
    }
/**Sets the elements*/
    private void setText() {
        playerOutput = new Text(numberOfPlayers + "");

        this.getChildren().add(playerOutput);

        playerOutput.setTranslateX(538.5);
        playerOutput.setTranslateY(309.5);

        /*
        //Only used for modifying psoition of text
        
        playerOutput.setOnMouseDragged(e -> {
            playerOutput.setTranslateX(e.getSceneX());
            playerOutput.setTranslateY(e.getSceneY());
            System.out.println(playerOutput.getTranslateX() + ", " + playerOutput.getTranslateY());
        });
         */
        playerOutput.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
    }
/**Sets the elements*/
    private void setBackground() {
        BackgroundImage myBI = new BackgroundImage(new Image("Texture/Menus/PlayerMenu/Background.png", WIDTH, HEIGHT, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        this.setBackground(new Background(myBI));
    }
    
    /**
     *
     * @return
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     *
     * @return
     */
    public ImageView getNextBtn() {
        return nextBtn;
    }

    /**
     *
     * @return
     */
    public ImageView getBackBtn() {
        return backBtn;
    }

}
