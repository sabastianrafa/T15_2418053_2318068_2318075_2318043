import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Jalan extends World
{
    private boolean gameOver = false;

    public Jalan()
    {    
        super(600, 400, 1); 
        prepare();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean state) {
        gameOver = state;
    }

    private void prepare()
    {
        Car car = new Car();
        addObject(car, getWidth() / 2, getHeight() - 50);

        for (int i = 0; i < 5; i++) {
            Rumah rumah = new Rumah();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(100);
            addObject(rumah, x, y);
        }
    }
}
