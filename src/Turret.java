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

    private static BasicStroke thinLine;
    private static BasicStroke thickLine;

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

        if (null == thickLine)
            thinLine = new BasicStroke(1);
        if (null == thickLine)
            thickLine = new BasicStroke(2);
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
                ((Graphics2D)g).setStroke(thickLine); // use a thicker pen.
                g.drawOval(myLoc[0]-18, myLoc[1]-18, 36, 36);
                g.drawLine(myLoc[0]-12, myLoc[1]-12, myLoc[0]+12, myLoc[1]+12);
                g.drawLine(myLoc[0]-12, myLoc[1]+12, myLoc[0]+12, myLoc[1]-12);
                ((Graphics2D)g).setStroke(thinLine); // restore the pen to thin for the next thing we draw.
                break;
            case 2:
            default:
                g.setColor(Color.BLACK);
                int[] x_vals = {myLoc[0]-18, myLoc[0]-9, myLoc[0]+9, myLoc[0]+18,
                myLoc[0]+9, myLoc[0]-9, myLoc[0]-18};
                int[] y_vals = {myLoc[1], myLoc[1]-18, myLoc[1]-18, myLoc[1], myLoc[1]+18, myLoc[1]+18, myLoc[1]};
                g.drawPolygon(x_vals, y_vals, 7);
                for (int i=0; i<3; i++)
                    g.drawLine(x_vals[i], y_vals[i], x_vals[i+3], y_vals[i+3]);
        }

    }
}
