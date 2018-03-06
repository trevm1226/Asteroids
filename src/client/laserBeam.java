package client;

public class laserBeam extends SpaceActor {
    private int x,y,r,hit;
    public laserBeam(int xpos, int ypos, int rot){
        super("img/laser.png", xpos, ypos, rot);
        x = xpos; y = ypos; r = rot;
        setRotation(r);
        hit=0;
    }
    public void end()
    {
        int x = this.getX();
        int y = this.getY();

        if( x < -(this.getImage().getHeight()) )
        {
            hit++;
        }
        if( x > 1024 )
        {
            hit++;
        }
        if( y < -(this.getImage().getHeight()) )
        {
            hit++;
        }
        if( y > 768 )
        {
            hit++;
        }
        if(hit==3){
            getWorld().removeObject(this);
        }
    }
    public void tick()
    {
        super.tick();
        this.move(30);
        end();
    }
    public String toString()
    {
        return "laser,"+getX()+","+getY()+","+getRotation();
    }
}
