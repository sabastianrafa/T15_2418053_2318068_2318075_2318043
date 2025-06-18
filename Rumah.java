import lang.stride.*;
import java.util.*;
import greenfoot.*;

public class Rumah extends Actor
{
    public void StartObjek(){
        setLocation(getX(), getY() + 5);
        if(getY() > 500)
        {
            setLocation(Greenfoot.getRandomNumber(500), Greenfoot.getRandomNumber(100));
        }
    }
    
    public void act()
    {
        if (((Jalan)getWorld()).isGameOver()) return;
    
        setLocation(getX(), getY() + 5);
    
        if (getY() >= getWorld().getHeight() - 5) {
            int worldWidth = getWorld().getWidth();
            int newX = Greenfoot.getRandomNumber(worldWidth);
            setLocation(newX, 0);
        }
    }
}