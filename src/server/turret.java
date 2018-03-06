package server;

public class turret extends SpaceActor{
    private int x,y,r;
    private spaceshipActor ship;
    public turret(int xpos, int ypos, int rot,spaceshipActor ship)
    {
        super("img/turret.png", xpos,ypos,rot);
        this.ship = ship;
    }

    public void shoot()
    {
        getWorld().addObject(new laserBeam(this.getCenterX(),this.getCenterY(),getRotation()),this.getCenterX(),this.getCenterY());
    }

    public void turnRight()
    {
        r+=5;
        setRotation(r);
    }

    public void turnLeft()
    {
        r-=5;
        setRotation(r);
    }

    @Override
    public void tick() {
        super.tick();
        this.setLocation(ship.getCenterX(), ship.getCenterY());
    }
}
