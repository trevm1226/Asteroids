package server;

public class turret extends SpaceActor{
    private int x,y,r;
    public turret(int xpos, int ypos, int rot)
    {
        super("img/turret.png", xpos,ypos,rot);
    }



    @Override
    public void tick() {
        super.tick();
    }
    public String toString()
    {
        return "turret,"+getX()+","+getY()+","+getRotation();
}
}
