package server;

public class spaceshipActor extends SpaceActor {

    private int v,x,y,r,maxV;

    public spaceshipActor(int x, int y, int r)
    {
        super("img/spaceship.png", x, y, r);
        this.x = x; this.y = y; this.r = r;
        v = 0;
        maxV = 25;
    }

    public void addVelocity()
    {
        if(v<maxV){v+=5;}
    }

    public void lessVelocity()
    {
        if(v>0){v-=5;}
    }

    public void turnLeft()
    {
        turn(-2);
    }

    public void turnRight()
    {
        turn(2);
    }

    @Override
    public void tick()
    {
        super.tick();
       // System.out.println(v);
        this.move(v);
    }

    public String toString()
    {
        return "ship,"+getX()+","+getY()+","+getRotation();
    }
}