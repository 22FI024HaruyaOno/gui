import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Level1 extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(50, 50, 100, 100); // 四角形を描画
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Level 1: Basic Shape");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new Level1());
        frame.setVisible(true);
    }
}

