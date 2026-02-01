import java.awt.*;

public class Turret
{
    private int myRange;
    private double myPeriod;
    private int myDamage;
    private int myType;
    private World myWorld;
    private double myTimeSinceLastFire;
    private int[] myLoc;

    public Turret(int range, double period, int damage, int type, World myWorld)
    {
        this.myRange = range;
        this.myPeriod = period;
        this.myDamage = damage;
        this.myType = type;
        this.myWorld = myWorld;
        myTimeSinceLastFire = 999;
        myLoc = new int[2];
        myLoc[0] = -100;
        myLoc[1] = -100;
    }

    public void setMyLoc(int[] myLoc)
    {
        this.myLoc = myLoc;
    }

    public void setMyLoc(int x, int y)
    {
        myLoc[0] = x;
        myLoc[1] = y;
    }

    public void drawSelf(Graphics g)
    {
        switch (myType)
        {
            case 0:
                g.setColor(Color.BLACK);
                g.drawOval(myLoc[0]-18, myLoc[1]-18, 36, 36);
                g.drawLine(myLoc[0]-12, myLoc[1]-12, myLoc[0]+12, myLoc[1]+12);
                g.drawLine(myLoc[0]-12, myLoc[1]+12, myLoc[0]+12, myLoc[1]-12);
                break;
            case 1:
                g.setColor(Color.BLACK);
                ((Graphics2D)g).setStroke(new BasicStroke(2));
                g.drawOval(myLoc[0]-18, myLoc[1]-18, 36, 36);
                g.drawLine(myLoc[0]-12, myLoc[1]-12, myLoc[0]+12, myLoc[1]+12);
                g.drawLine(myLoc[0]-12, myLoc[1]+12, myLoc[0]+12, myLoc[1]-12);
                ((Graphics2D)g).setStroke(new BasicStroke(1));
        }

    }
}
