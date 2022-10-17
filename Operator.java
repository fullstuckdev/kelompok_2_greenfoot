import greenfoot.*;

public class Operator extends Actor
{
    private int mode=0;
    public Operator()
    {
        
    }
    
    public Operator(int a)
    {
        mode=a;
    }
    
    public void addedToWorld(World Latar)
    {
        if(mode==0){
            setImage(new GreenfootImage("tandaplus.png"));
        }else if(mode==1){
            setImage(new GreenfootImage("tandaminus.png"));
        }else if(mode==2){
            setImage(new GreenfootImage("tandaequals.png"));
        }
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
