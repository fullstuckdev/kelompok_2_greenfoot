import greenfoot.*;

public class Tanda extends Actor
{
    public boolean keadaan=false;
    
    public Tanda(boolean a)
    {
        keadaan=a;
    }
    
    public void addedToWorld(World Latar)
    {
        if(keadaan){
            setImage(new GreenfootImage("benar.png"));
        }else{
            setImage(new GreenfootImage("salah.png"));            
        }
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
