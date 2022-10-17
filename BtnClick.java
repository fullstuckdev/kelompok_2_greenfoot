import greenfoot.*;

public class BtnClick extends Actor
{
    protected GreenfootImage image=null;
    private int jeda=0;
    
    public void addedToWorld(World Latar)
    {
        image=new GreenfootImage("nextbtn.png");
        setImage(image);
    }
    
    public void onClick()
    {
        if(((Latar)getWorld()).Level<50)((Latar)getWorld()).Level++;
        Greenfoot.setWorld(new Latar());
    }
    
    public void act() 
    {
        if(jeda>0)jeda--;
        if(Greenfoot.mouseClicked(this)){
            GreenfootImage img=new GreenfootImage(image);
            img.scale((int)(0.9*img.getWidth()),(int)(0.9*img.getHeight()));
            setImage(img);
            jeda=20;
        }
        if(jeda==1){
            onClick();
            setImage(image);
        }
    }   
}
