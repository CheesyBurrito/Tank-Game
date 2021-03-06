/****************************************************************
 *  File: HitDetection.java
 *  Description: This object is created when a new weapon is put into the pane. It checks if it collides with another enemy tank to make damage.
 *    History:
 *     Date    04/20/2017
 *     ---------- ---------- ----------------------------
 *  Authors  William Adam-Grenier        
 *
 ****************************************************************/
package Weapon;

import GamePane.GamePane;
import HUD.HUD;
import Tanks.Tanks;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;


/**
 *
 * @author willi
 */
public class HitDetection extends AnimationTimer{
    /**The hud of the game*/
    private HUD hud;
    
    /**One of the 4 tanks*/
    private Tanks tanksOne;
    /**One of the 4 tanks*/
    private Tanks tanksTwo;
    /**One of the 4 tanks*/
    private Tanks tanksThree;
    /**One of the 4 tanks*/
    private Tanks tanksFour;
    
    //Variable for the tanks' animation
    /**One of the 4 animation*/
    private Timeline animation;
    /**One of the 4 animation*/
    private Timeline animation2;
    /**One of the 4 animation*/
    private Timeline animation3;
    /**One of the 4 animation*/
    private Timeline animation4;
    
    //Pane of the game
    
    /**Pane of the game*/
    private GamePane pane;
    /**The tank associated with that weapon*/
    private Tanks tank;
    /**The weapon's animation*/
    private WeaponAnimation weaponAnimation;
    /**The weapon*/
    private Weapon weapon;

    /**
     * The constructor of this object
     * @param weaponAnimation
     * @param hud
     * @param tanksOne
     * @param tanksTwo
     * @param tanksThree
     * @param tanksFour
     * @param tank
     * @param animation
     * @param animation2
     * @param animation3
     * @param animation4
     * @param pane
     * @param weapon
     */
    public HitDetection(WeaponAnimation weaponAnimation, HUD hud, Tanks tanksOne, Tanks tanksTwo, Tanks tanksThree, Tanks tanksFour, Tanks tank, Timeline animation, Timeline animation2, Timeline animation3, Timeline animation4, GamePane pane, Weapon weapon) {
        this.hud = hud;
        this.tanksOne = tanksOne;
        this.tanksTwo = tanksTwo;
        this.tanksThree = tanksThree;
        this.tanksFour = tanksFour;
        this.tank = tank;
        this.animation = animation;
        this.animation2 = animation2;
        this.animation3 = animation3;
        this.animation4 = animation4;
        this.weaponAnimation = weaponAnimation;
        this.pane = pane;
        this.weapon = weapon;
    }
    
    @Override
    public void handle(long now){
        
        if(weapon.getBoundsInParent().intersects(tanksOne.getBoundsInParent()) && tank != tanksOne && tanksOne.isTankAlive()){
           if(!weaponAnimation.isHitSomething()){
           tanksOne.damageDone(weapon.getDamage());
           }
           weaponAnimation.setHitSomething(true);
       }
        
        else if(weapon.getBoundsInParent().intersects(tanksTwo.getBoundsInParent())&& tank != tanksTwo && tanksTwo.isTankAlive()){
           if(!weaponAnimation.isHitSomething()){
           tanksTwo.damageDone(weapon.getDamage());
           }
           weaponAnimation.setHitSomething(true);
       }
        
        else if(weapon.getBoundsInParent().intersects(tanksThree.getBoundsInParent())&& tank != tanksThree && tanksThree.isTankAlive()){
           if(!weaponAnimation.isHitSomething()){
           tanksThree.damageDone(weapon.getDamage());
           }
           weaponAnimation.setHitSomething(true); 
       }
        
        else if(weapon.getBoundsInParent().intersects(tanksFour.getBoundsInParent())&& tank != tanksFour && tanksFour.isTankAlive()){
           if(!weaponAnimation.isHitSomething()){
           tanksFour.damageDone(weapon.getDamage());
           }
           weaponAnimation.setHitSomething(true);  
       }
        if(weaponAnimation.isHitSomething()){
            this.stop();
        }
    }
}
