import javax.swing.*;
import java.awt.*;

public class TDFrame extends JFrame
{
    TDPanel mainPanel;

    public TDFrame()
    {
        super("Tower Defense");
        setSize(800,800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        mainPanel = new TDPanel();
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }
}
