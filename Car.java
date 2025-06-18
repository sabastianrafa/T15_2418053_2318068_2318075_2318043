import greenfoot.*;

public class Car extends Actor
{
    private int counter = 0;
    private int nyawa = 5;
    private int flashTimer = 0;
    private int leftKeyHold = 0;
    private int rightKeyHold = 0;
    private boolean wasPressingA = false;
    private boolean wasPressingD = false;

    public void act()
    {
        if (((Jalan)getWorld()).isGameOver()) return;
    
        handleMovement();
        showUI();
        checkCollision();
        handleFlashEffect();
    }

    private void handleMovement()
    {
        // Left movement
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 5, getY());
            leftKeyHold++;
            wasPressingA = true;
        } else if (wasPressingA) {
            counter += Math.min(10, leftKeyHold);
            leftKeyHold = 0;
            wasPressingA = false;
        }
    
        // Right movement
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 5, getY());
            rightKeyHold++;
            wasPressingD = true;
        } else if (wasPressingD) {
            counter += Math.min(10, rightKeyHold);
            rightKeyHold = 0;
            wasPressingD = false;
        }
    }

    private void showUI()
    {
        getWorld().showText("Skor: " + counter, 100, 20);
        getWorld().showText("Health: " + nyawa, 100, 40);
    }

    private void checkCollision()
    {
        Actor rumah = getOneIntersectingObject(Rumah.class);
        if (rumah != null)
        {
            // Reset posisi rumah
            rumah.setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), 0);
    
            // Kurangi nyawa dan aktifkan efek flash
            nyawa--;
            flashTimer = 10;
    
            if (nyawa <= 0)
            {
                showGameOver();
                Greenfoot.stop();
            }
            
            
        }
    }

    private void handleFlashEffect()
    {
        if (flashTimer > 0) {
            getImage().setTransparency(flashTimer % 2 == 0 ? 50 : 255);
            flashTimer--;
        } else {
            getImage().setTransparency(255);
        }
    }

    private void showGameOver()
    {
        getWorld().showText("Game Over", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        ((Jalan)getWorld()).setGameOver(true);
        Greenfoot.stop();
    }
}