import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Level4 extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(50, 50, 200, 200); // 線を描画

        g2d.setColor(Color.GREEN);
        g2d.fillArc(250, 50, 100, 100, 0, 180); // 緑の円弧を描画
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Level 4: Custom Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new Level4());
        frame.setVisible(true);
    }
}


