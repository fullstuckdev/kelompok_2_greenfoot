import greenfoot.*;



public class Kotak extends Actor
{
    private int a=1,b=2,pox=0,poy=0;
    private boolean drag=false;
    private int rx=0,ry=0;
    private BackKotak backkotak;
    
    public Kotak()
    {
        
    }
    
    public Kotak(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
    
    public double getValue()
    {
        return (1.0*a/b);
    }
    
    private void checkBackKotak()
    {
        Actor actor=getOneIntersectingObject(BackKotak.class);
        if(actor!=null){
            setLocation(actor.getX()+2,actor.getY()+2);
            backkotak=((BackKotak)actor);
            backkotak.kotak=this;
        }else{
            setLocation(pox,poy);
        }
    }
    
    public void addedToWorld(World Latar)
    {
        GreenfootImage image=new GreenfootImage(215,215);
        image.drawImage(new GreenfootImage("bayangan.png"),0,0);
        image.setColor(new Color(235,206,137));
        image.fillRect(5,5,215-16,215-16);
        image.setColor(new Color(52,26,26));        
        Font font=image.getFont();
        font=font.deriveFont(48.0f);
        image.setFont(font);
        image.drawString(""+a,100,80);
        for(int i=0;i<8;i++)image.drawLine(50,105+i,155,105+i);
        image.drawString(""+b,100,170);
        setImage(image);
        
        pox=getX();poy=getY();
    }
    
    public void act() 
    {
        if(Greenfoot.mouseDragged(this)){
            MouseInfo mouse=Greenfoot.getMouseInfo();
            if(!drag){
                drag=true;
                rx=mouse.getX()-getX();
                ry=mouse.getY()-getY();                
                if(backkotak!=null){
                    backkotak.kotak=null;
                    backkotak=null;
                }
                ((Latar)getWorld()).setBtn();
            }else{
                setLocation(mouse.getX()-rx,mouse.getY()-ry);
            }
        }
        if(Greenfoot.mouseDragEnded(this)){
            drag=false;
            checkBackKotak();
            ((Latar)getWorld()).setBtn();
        }
    }    
}
