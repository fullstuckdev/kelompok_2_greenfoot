import greenfoot.*;



public class Title extends Actor
{
    private String judul="";
    
    public Title(String judul)
    {
        this.judul=judul;
    }
    
    public void addedToWorld(World Latar)
    {
        GreenfootImage image=new GreenfootImage(200,50);
        image.setColor(new Color(56,21,21));      
        Font font=image.getFont();
        font=font.deriveFont(32.0f);
        image.setFont(font);
        image.drawString(judul,5,48);
        setImage(image);
    }    
}
