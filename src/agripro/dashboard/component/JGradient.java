package agripro.dashboard.component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class JGradient extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        Color color1 = new Color(0, 51, 51);
        Color color2 = new Color(0, 102, 102);
        GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, width, height, 0, 15);
    }
}
