package server;

public class spaceshipActor extends SpaceActor {

    private int x,y,r,id, turnRate;
    private Double v, maxV;
    private boolean isAccelerating, isDecelerating, isTurningLeft, isTurningRight;


    public spaceshipActor(int x, int y, int r, int i)
    {
        super("img/spaceship.png", x, y, r);
        this.x = x; this.y = y; this.r = r; this.id = i;
        v = 0.0;
        turnRate = 1;
        maxV = 15.0;
    }

    public boolean isAccelerating()
    {
        return isAccelerating;
    }


    public void addVelocity()
    {
        if(v<maxV){v+=.1;}
       // System.out.println("workingup");
    }

    public void lessVelocity()
    {
        if(v>0){v-=.1;}
        //System.out.println("down");
    }

    public void turnLeft()
    {
        if(v == 0) turn(-1*turnRate);
        else turn((int)(-1*turnRate*v));
    }

    public void turnRight()
    {
        if(v == 0) turn(turnRate);
        else turn((int)(turnRate*v));
    }

    public void makeAccel(int x)
    {
        if(x == 1)isAccelerating = true;
        else isAccelerating = false;
    }
    public void makeDecel(int x)
    {
        if(x == 1)isDecelerating = true;
        else isDecelerating = false;
    }
    public void makeTurnL(int x)
    {
        if(x == 1)isTurningLeft = true;
        else isTurningLeft = false;
    }
    public void makeTurnR(int x)
    {
        if(x == 1)isTurningRight = true;
        else isTurningRight = false;
    }


    @Override
    public void tick()
    {
        super.tick();
        // System.out.println(v);
        //System.out.println(isAccelerating);
        if(isAccelerating)addVelocity();
        else if(!isAccelerating)lessVelocity();
        if(isTurningRight)turnRight();
        else if(isTurningLeft)turnLeft();
        this.move(v);
    }

    public String toString()
    {
        return "ship,"+getX()+","+getY()+","+getRotation();
    }
}