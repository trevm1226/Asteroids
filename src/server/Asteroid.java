package server;

import mayflower.Keyboard;
import mayflower.Mayflower;

public class Asteroid extends SpaceActor
{
    private int velocity;
    public Asteroid(int x, int y, int r, int velocity)
    {
        super("img/largeAsteroid.png", x, y, r);
        this.velocity = velocity;
        this.setVelocity(velocity);
    }

    @Override
    public void act() {
  if(Mayflower.isKeyPressed(Keyboard.KEY_SPACE))
      setLocation(200,200);
    }

    @Override
    public void tick() {
        super.tick();
      //  System.out.println(this.getX()+":"+this.getY());
        this.move(velocity);
    }

    public String toString()
    {
        return "asteroid,"+getX()+","+getY()+","+getRotation();
    }
}
