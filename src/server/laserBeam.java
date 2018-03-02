package server;

public class laserBeam extends SpaceActor {
    private int x,y,r;
    public laserBeam(int xpos, int ypos, int rot){
        super("img/laser.png", xpos, ypos, rot);
        x = xpos; y = ypos; r = rot;
        setRotation(r);
    }
    public void tick()
    {
        super.tick();
        this.move(30);
    }
    public String toString()
    {
        return "laser,"+getX()+","+getY()+","+getRotation();
    }
}
