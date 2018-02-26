package server;

import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.util.FastTrig;

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
    public void act()
    {
        if(Mayflower.isKeyPressed(Keyboard.KEY_SPACE))
        setLocation(200,200);
    }

    @Override
    public void tick()
    {
        super.tick();
        //System.out.println(this.getX()+":"+this.getY());
        this.move(velocity);

        if(this.isTouching(Asteroid.class))
        {
            //Gets the velocity and rotation of the Asteroid
            double vt = this.getVelocity();
            double at = this.getRotation() * (Math.PI / 180);

            //Gets the velocity and rotation of the touching Asteroid
            Asteroid o = this.getOneIntersectingObject(Asteroid.class);
            double vo = o.getVelocity();
            double ao = o.getRotation() * (Math.PI / 180);

            //Gets the position of the two Asteroids
            int xt = this.getX();
            int yt = this.getY();
            int xo = o.getX();
            int yo = o.getY();

            //Calculates the constants to solve for the final values
            double vtx = vt * FastTrig.cos(-at);
            double vty = vt * FastTrig.sin(-at);
            double vox = vo * FastTrig.cos(-ao);
            double voy = vo * FastTrig.sin(-ao);

            //Computes the final velocity and final angle (inelastic collision)
            double vfx = (vtx + vox)/2;
            double vfy = (vty + voy)/2;
            double vf = Math.sqrt( vfx*vfx + vfy*vfy );
            double af = ( Math.atan( -vfy / vfx ) ) * (180 / Math.PI);

            //Angle check
            if(af < 0)
            {
                af = af + 360;
            }

            //Separates the Asteroids based on x-coordinates
            if( xt > xo )
            {
                xt = xt++;
                this.setLocation(xt, yt);
            }
            else
            {
                xo = xo++;
                o.setLocation(xo, yo);
            }

            //Separates the Asteroids based on y-coordinates
            if( yt > yo )
            {
                yt = yt++;
                this.setLocation(xt, yt);
            }
            else
            {
                yo = yo++;
                o.setLocation(xo, yo);
            }

            //Sets the direction and velocity of the asteroids
            this.setVelocity((int)vf);
            this.setRotation((int)af);
            o.setVelocity((int)vf);
            o.setRotation((int)af);
        }

    }

    public String toString()
    {
        return "asteroid,"+getX()+","+getY()+","+getRotation();
    }
}
