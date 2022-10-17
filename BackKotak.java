import greenfoot.*;

public class BackKotak extends Actor
{
    private int ID=0;
    private static int numID=0;
    public Kotak kotak;
    
    public void addedToWorld(World Latar)
    {
        setImage(new GreenfootImage("backkotak.png"));
        ID=numID;
        numID++;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
