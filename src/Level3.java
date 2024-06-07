import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Level3 extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 100); // 赤い四角形を塗りつぶして描画
        g.setColor(Color.BLUE);
        g.fillOval(200, 50, 100, 100); // 青い円を塗りつぶして描画
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Level 3: Colors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new Level3());
        frame.setVisible(true);
    }
}


