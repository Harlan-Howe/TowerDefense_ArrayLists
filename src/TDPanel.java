import javax.swing.*;
import java.awt.*;

public class TDPanel extends JPanel
{
    World myWorld;

    public TDPanel()
    {
        super();
        setBackground(Color.LIGHT_GRAY);
        myWorld = new World();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        myWorld.drawPath(g);
        myWorld.drawInvaders(g);
        myWorld.drawTurrets(g);
    }


}
