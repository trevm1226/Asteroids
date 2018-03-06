package client;

public class spaceshipActor extends SpaceActor {

    private int x,y,r,id, turnRate;
    private Double v, maxV;
    private boolean isAccelerating, isDecelerating, isTurningLeft, isTurningRight;
    private turret turd;


    public spaceshipActor(int x, int y, int r, int i)
    {
        super("img/spaceship.png", x, y, r);
        this.x = x; this.y = y; this.r = r; this.id = i;
        turd = new turret(x,y,r);
        v = 0.0;
        turnRate = 1;
        maxV = 15.0;
    }

    public boolean isAccelerating()
    {
        return isAccelerating;
    }
    public boolean isTurningLeft(){return isTurningLeft;}
    public boolean isTurningRight(){return isTurningRight;}
    public boolean isDecelerating(){return isDecelerating;}


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
        if(v == 0) {
            turn(-1*turnRate);
            turd.turn(-1*turnRate);
        }
        else {
            turn((int)(-1*turnRate*v));
            turd.turn((int)(-1*turnRate*v));
        }
        System.out.println("runningbb");
    }

    public void turnRight()
    {
        if(v == 0)
        {
            turn(turnRate);
            turd.turn(turnRate);
        }
        else
        {
            turn((int)(turnRate*v));
            turd.turn((int)(turnRate*v));
        }
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
        //System.out.println(x + "x");
        if(x == 1)isTurningLeft = true;
        else isTurningLeft = false;
    }

    public void makeTurnR(int x)
    {
        if(x == 1)isTurningRight = true;
        else isTurningRight = false;
    }

    public void shoot()
    {
        getWorld().addObject(new laserBeam(this.getCenterX(),this.getCenterY(),getRotation()),this.getCenterX(),this.getCenterY());
    }

    @Override
    public void tick()
    {
        super.tick();
        // System.out.println(v);
        //System.out.println(isAccelerating);
        //System.out.println(isTurningLeft + "isturningleft");
       // System.out.println(isTurningRight + "isturningright");
        if(isAccelerating)addVelocity();
        else if(!isAccelerating)lessVelocity();
        if(isTurningRight)turnRight();
        else if(isTurningLeft)turnLeft();
        this.move(v);
        turd.move(v);
    }

    public String toString()
    {
        return "ship,"+getX()+","+getY()+","+getRotation();
    }
}