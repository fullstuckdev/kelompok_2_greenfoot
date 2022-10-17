import greenfoot.*;

public class BtnAnswer extends BtnClick
{
    public int Mode=0;
    
    public void addedToWorld(World Latar)
    {
        image=new GreenfootImage("answerbtn.png");
        setImage(image);
    }    
    
    public void setIku(GreenfootImage img)
    {
        image=new GreenfootImage(img);
        setImage(image);
    }
    
    public void onClick()
    {        
        if(Mode==0){
            ((Latar)getWorld()).getAnswer();
        }else{
            ((Latar)getWorld()).Level=0;
            Greenfoot.stop();
        }
    }
}
