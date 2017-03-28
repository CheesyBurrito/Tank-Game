/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapGeneration;

/**
 *
 * @author 1530178
 */
public class MapGeneration {
    /**
     * 
     * f(x) = a * sin(K * x) + B
     * 
     */
    
    double amplitudeOfWave;
    double startingPoint;
    double lengthOfWave;
    
    public MapGeneration(double startingPoint, double amplitudeOfWave, double lengthOfWave){
        this.amplitudeOfWave = (100 + Math.random() * amplitudeOfWave);
        this.startingPoint = (350 + Math.random() * startingPoint);
        this.lengthOfWave = (300 + Math.random() * lengthOfWave);
    }
    
    public double derivativeFunction(double x){
        return ((amplitudeOfWave * Math.cos( x / lengthOfWave)) / lengthOfWave);
    }
    
    public double getY(double x){
          //return (amplitudeOfWave * Math.sin(x / lengthOfWave) + startingPoint);
          return 700;
    }
}
