package client;

public class turret extends SpaceActor{
    private int x,y,r,i;
    public turret(int xpos, int ypos, int rot, int id)
    {
        super("img/turret.png", xpos,ypos,rot, id);
    }



    @Override
    public void tick() {
        super.tick();
    }


}
