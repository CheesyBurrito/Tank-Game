/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Weapon;

import MapGeneration.MapGeneration;
import Tanks.Tanks;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author willi
 */
public class WeaponAnimation {
    
    /**
     * An WeaponAnimation Object is created when the weapon is used in the game 
     *    to attack an other player.
     * 
     */
    
    private double initialXPosition;
    private double initialYPosition;
    private double initialVelocity = .5;
    private double gravity = .0005;
    private double currentYPosition;
    private double canonAngle;
    private double angleLaunched; // angle must be between 0 and 1 included
    private double initialYVelocity;
    private double yspeed;
    private double xspeed;
    
    MapGeneration mapGeneration;
    Weapon weapon;
    Timeline animationWeapon;
    Tanks tank;
    Pane pane;  
    
    public WeaponAnimation(Weapon weapon, Tanks tank, MapGeneration mapGeneration, Pane pane){
        this.pane = pane;
        this.tank = tank;
        this.weapon = weapon;
        this.mapGeneration = mapGeneration;
        setupAnimation();
        launchAnimation();
    }
    
    public WeaponAnimation(Weapon weapon, MapGeneration mapGeneration, Pane pane){
        this.pane = pane;
        this.weapon = weapon;
        this.mapGeneration = mapGeneration;
    }
    
    private void setupAnimation(){
       // pane.getChildren().remove(weapon);
        
        
        
        canonAngle = tank.getCannon().getCanonAngle();
        
        
        
        if(tank.isIsImageFlipped()){
            canonAngle = Math.PI - canonAngle;
        }
        
        
        
        angleLaunched = mapGeneration.derivativeFunction(tank.getTranslateX()) - canonAngle;
        
        this.initialXPosition = tank.getTranslateX() + (50 * Math.cos(angleLaunched));
        this.initialYPosition = tank.getTranslateY() + (50 * Math.sin(angleLaunched) - 35);
        
        
        initialYVelocity = initialVelocity * Math.sin(angleLaunched);
        yspeed = initialVelocity * Math.sin(angleLaunched);
        xspeed = initialVelocity * Math.cos(angleLaunched);
        
        weapon.setTranslateX(weapon.getTranslateX() + initialXPosition);
        weapon.setTranslateY(weapon.getTranslateY() + initialYPosition - 1);
        
        
        weapon.setRotate(Math.toDegrees(angleLaunched));
        
        animationWeapon =  new Timeline(new KeyFrame(Duration.millis(1), e -> {
            
            currentYPosition = mapGeneration.getY(weapon.getTranslateX());
            weapon.setTranslateY(weapon.getTranslateY() + yspeed);
            weapon.setTranslateX(weapon.getTranslateX() + xspeed); 
            
           //System.out.println("weapon Translate X: " + weapon.getTranslateX() + " Weapon Translate Y: " + weapon.getTranslateY() + " Tank Translate X: " + tank.getTranslateX() + " Tank Translate Y: " + tank.getTranslateY() +" currentYPos: " + currentYPosition + " xspeed: " + xspeed + " yspeed: " + yspeed + " rotation angle:" + angleLaunched);
            
            if(weapon.getTranslateX()<= 0 || weapon.getTranslateX() >= 1200){
                yspeed = 0;
                xspeed = 0;
                animationWeapon.getKeyFrames().clear();
                animationWeapon.stop();
                
                pane.getChildren().remove(animationWeapon);
                pane.getChildren().remove(weapon);
                //add animation explosion
                
            }
            if (weapon.getTranslateY() < currentYPosition ){
                yspeed += gravity;
            }
            else{
                yspeed = 0;
                xspeed = 0;
                animationWeapon.getKeyFrames().clear();
                animationWeapon.stop();
                pane.getChildren().remove(animationWeapon);
                
                //pane.getChildren().removeAll(weapon);
            }
            if(weapon.getTranslateY() > currentYPosition){
                weapon.setTranslateY(currentYPosition);
            } 
            
            if(tank.isIsImageFlipped()){
            weapon.setRotate(projectileRotationReverse() + 90);
        }
            
            else
            weapon.setRotate(projectileRotation());
            }));
        
        
    }
    
    
    public void launchAnimation(){
        
        //setupAnimation();
        //pane.getChildren().remove(weapon);
        pane.getChildren().add(weapon);
        animationWeapon.setCycleCount(2000);
        animationWeapon.playFromStart();
        //animationWeapon.play();
        
        animationWeapon.setOnFinished(e ->{
            System.out.println("Hey");
            pane.getChildren().removeAll(weapon);
            animationWeapon.getKeyFrames().clear();
            
        });
    }
    
    private double projectileRotationReverse(){
        return Math.toDegrees(Math.acos((yspeed / Math.sqrt(Math.pow((yspeed), 2) + Math.pow(xspeed, 2)))));
    }
    
    private double projectileRotation(){
        return Math.toDegrees(Math.asin((yspeed / Math.sqrt(Math.pow((yspeed), 2) + Math.pow(xspeed, 2)))));
    }
      
}