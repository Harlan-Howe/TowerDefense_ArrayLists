import java.awt.*;
import java.util.ArrayList;

public class World
{
    private int[][] path = {{20, 380}, {60, 380}, {100, 380}, {100, 340}, {100, 300}, {100, 260}, {100, 220},
        {100, 180}, {100, 140}, {140, 140}, {180, 140}, {220, 140}, {260, 140}, {260, 180}, {260, 220}};
    private ArrayList<Invader> invaderList;
    private ArrayList<Turret> turretList;

    public World()
    {
        invaderList = new ArrayList<Invader>();
        invaderList.add(new Invader(1, 100, 1, this));
        invaderList.get(0).advance(4.3);

        turretList = new ArrayList<Turret>();
        turretList.add(new Turret(50, 2, 20, 2, this));
        turretList.get(0).setMyLoc(140,220);
        turretList.add(new Turret(50, 200, 20, 1, this));
        turretList.get(1).setMyLoc(140,180);
    }


    public void drawPath(Graphics g)
    {
        for (int[] pt:path)
        {
            g.setColor(Color.WHITE);
            g.fillRect(pt[0] - 20, pt[1] - 20, 40, 40);
            g.setColor(Color.BLACK);
            g.drawRect(pt[0] - 20, pt[1] - 20, 40, 40);
        }
    }

    public void drawInvaders(Graphics g)
    {
        for (Invader inv: invaderList)
            inv.drawSelf(g);
    }

    public void drawTurrets(Graphics g)
    {
        for (Turret tur: turretList)
            tur.drawSelf(g);
    }


    public int[][] getPath() { return path;}
}
