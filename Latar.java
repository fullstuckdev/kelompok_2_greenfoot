import greenfoot.*;

public class Latar extends World
{
    private BackKotak[] backkotak=new BackKotak[3];
    private BtnClick btnclick=new BtnClick();
    private BtnAnswer btnanswer=new BtnAnswer();
    private boolean ketengah=false;
    private int mA=1,mB=1,mC=1,ma=1,mb=1,mc=1,md=1,me=1,mf=1,ope=0;
    public static int Level=0;
    
    public Latar()
    {    
        super(900,600,1,false); 
        
        setBackground(new GreenfootImage("burlap.jpg"));
        
        prepare();
    }
    
    private int getNilaiNot(int a,int btsa,int btsb)
    {
        while(a==0)a=btsa+Greenfoot.getRandomNumber(btsb-btsa);
        return a;
    }
    
    private void prepare()
    {    
        int level=Level;
        mA=1;mB=1;mC=1;ma=1;mb=1;mc=1;md=1;me=1;mf=1;ope=0;
        if(level>=0 && level<10){
            mb=md=mf=2+Greenfoot.getRandomNumber(3);
            if(level>5)ope=1;
            if(level>0 && level<5){
                ma=getNilaiNot(0,1,11);
                mc=getNilaiNot(0,1,11);
            }else if(level>=5 && level<10){
                ma=getNilaiNot(0,-10,11);
                mc=getNilaiNot(0,-10,11);
            }
            me=(ope==0)?mc+ma:ma-mc;
        }else if(level>=10 && level<20){
            int tmp=0;
            while(tmp==0)tmp=-5+Greenfoot.getRandomNumber(10);
            mb=md=mf=tmp;
            if(level>5)ope=1;
            if(level>10 && level<15){
                ma=getNilaiNot(0,1,11);
                mc=getNilaiNot(0,1,11);
            }else if(level>=15 && level<20){
                ma=getNilaiNot(0,-10,11);
                mc=getNilaiNot(0,-10,11);
            }
            me=(ope==0)?mc+ma:ma-mc;
        }else if(level>=20 && level<50){
            mb=getNilaiNot(0,2,5);
            md=getNilaiNot(0,2,5);
            mf=getNilaiNot(0,2,5);            
            ope=Greenfoot.getRandomNumber(2);
            if(level>20 && level<25){
                ma=getNilaiNot(0,1,11);
                mc=getNilaiNot(0,1,11);
            }else if(level>=25 && level<30){
                ma=getNilaiNot(0,-10,11);
                mc=getNilaiNot(0,-10,11);
            }else if(level>=30 && level<50){
                ma=getNilaiNot(0,-20,21);
                mc=getNilaiNot(0,-20,21);
            }
            me=(ope==0)?md*ma+mb*mc:md*ma-mb*mc;
            me=mf*me/(mb*md);
        }    
        
        if(level>=30){
            mA=getNilaiNot(0,1,5);
            mB=getNilaiNot(0,1,5);
            mC=getNilaiNot(0,1,5); 
        }
        
        int a=150,b=300,dx=300,dy=10;
        backkotak[0]=new BackKotak();
        backkotak[1]=new BackKotak();
        backkotak[2]=new BackKotak();
        addObject(backkotak[0],a,135+dy);
        addObject(backkotak[1],a+dx,135+dy);
        addObject(backkotak[2],a+2*dx,135+dy);
        addObject(new Title("Fraction "+(level+1)+"/50"),(int)(0.5*getWidth()-300),(int)(0.5*getHeight()-10));
                
        addObject(new Operator(ope),b,135+dy);
        addObject(new Operator(2),b+dx,135+dy);
        
        addObject(new Kotak(mA*ma,mA*mb),a,430+dy);
        addObject(new Kotak(mB*mc,mB*md),a+dx,430+dy);
        addObject(new Kotak(mC*me,mC*mf),a+2*dx,430+dy);
                
        addObject(btnclick,(int)(1.5*getWidth()),(int)(0.5*getHeight()+100));                
        addObject(btnanswer,(int)(-1.5*getWidth()),(int)(0.5*getHeight()+100));
    }
    
    public void getAnswer()
    {
        boolean a=checkAnswer();
        addObject(new Tanda(a),(int)(0.5*getWidth()+250),(int)(0.5*getHeight()-100));
        btnanswer.Mode=1;
        btnanswer.setIku(new GreenfootImage("answerbtn1.png"));
    }
    
    public boolean checkAnswer()
    {
        for(int i=0;i<backkotak.length;i++){
            if(backkotak[i].kotak==null)return false;
        }
        double sum=backkotak[0].kotak.getValue();
        if(ope==0)sum+=backkotak[1].kotak.getValue();
        else sum-=backkotak[1].kotak.getValue();        
        return Math.abs(sum-backkotak[2].kotak.getValue())<0.00000001;
    }
    
    public boolean checkTerisi()
    {
        boolean terisi=true;
        for(int i=0;i<backkotak.length;i++){
            if(backkotak[i].kotak==null)terisi=false;
        }
        return terisi;
    }
    
    public void setBtn()
    {
        ketengah=checkTerisi();
    }
    
    public void act()
    {
        int kec=30;
        if(ketengah){
            int po=(int)(0.5*getWidth()+125);
            if(btnclick.getX()>po)btnclick.setLocation(btnclick.getX()-kec,btnclick.getY());
            else btnclick.setLocation(po,btnclick.getY());
            po=(int)(0.5*getWidth()-125);
            if(btnanswer.getX()<po)btnanswer.setLocation(btnanswer.getX()+kec,btnanswer.getY());
            else btnanswer.setLocation(po,btnanswer.getY());
        }else{
            int po=(int)(1.5*getWidth());
            if(btnclick.getX()<po)btnclick.setLocation(btnclick.getX()+kec,btnclick.getY());
            else btnclick.setLocation(po,btnclick.getY());
            po=(int)(-1.5*getWidth());
            if(btnanswer.getX()>po)btnanswer.setLocation(btnanswer.getX()-kec,btnanswer.getY());
            else btnanswer.setLocation(po,btnanswer.getY());
        }
    }
}
