
//FacesAWTMain.java
//FacesAWTMain 目標 インナークラスのFaceObjクラスを作ってみよう。描画処理を移譲してください。
//3x3の顔を描画してください。色などもぬってオリジナルな楽しい顔にしてください。
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTMain {

    public static void main(String[] args) {
        new FacesAWTMain();
    }

    FacesAWTMain() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    // インナークラスを定義
    class FaceFrame extends Frame {
        private int xStart;
        private int yStart;
        FaceObj[] fobjs = new FaceObj[9];

        FaceFrame() {
            xStart = 50;
            yStart = 50;
        }

        public void paint(Graphics g) {
            // この中には、g.drawLine というのは入ってこない
            // Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す
            Color color = new Color(255, 123, 24, 100);
            g.setColor(color);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fobjs[j + 3 * i] = new FaceObj();
                    fobjs[j + 3 * i].setPosition(xStart + 250 * j, yStart + 250 * i);
                    fobjs[j + 3 * i].setEmotionLevel(j, i);
                    fobjs[j + 3 * i].drawFace(g);
                    /*
                     * fobjs[i+3*j]= new FaceObj();
                     * fobjs[i+3*j].setPosition(w*i+xStart,h*j+yStart);
                     * fobjs[i+3*j].setEmotionLevel(i,j);
                     * fobjs[i+3*j].drawFace(g);
                     */
                }
            }
        }
    }// FaceFrame end

    // Faceクラスを作ってみよう。
    private class FaceObj {
        final private int width = 200;
        final private int height = 200;
        private int xPos;
        private int yPos;
        private int EmoVecA; // 眉の形（0 <-> 2 : 下がる <-> 上がる）
        private int EmoVecB; // 口の形（0 <-> 2 : 下がる <-> 上がる）

        public void drawFace(Graphics g) {
            this.drawRim(g);
            this.drawBrow(g, 30 * EmoVecA);
            this.drawNose(g, 40);
            this.drawEye(g, 35);
            this.drawMouth(g, 100);
        }

        public void drawRim(Graphics g) {
            g.drawLine(xPos, yPos, xPos + width, yPos);
            g.drawLine(xPos, yPos, xPos, yPos + height);
            g.drawLine(xPos, yPos + height, xPos + width, yPos + height);
            g.drawLine(xPos + width, yPos, xPos + width, yPos + height);
        }

        public void drawBrow(Graphics g, int updown) { // xは目の幅 呼ばれる方(=定義する方)
            int wx1 = xPos + width * 2 / 8;
            int wx2 = xPos + width * 5 / 8;
            int wy = yPos + height / 5;
            g.drawLine(wx1, wy + updown, wx1 + width * 1 / 8, wy);
            g.drawLine(wx2, wy, wx2 + width * 1 / 8, wy + updown);
        }

        public void drawNose(Graphics g, int nx) { // xは鼻の長さ
            g.drawLine(xPos + width / 2, yPos + height / 2, xPos + width / 2, yPos + height / 2 + nx);
        }

        public void drawEye(Graphics g, int r) { // rは目の半径
            g.drawOval(xPos + 45, yPos + 65, r, r);
            g.drawOval(width + xPos - 45 - r, yPos + 65, r, r);

        }

        public void drawMouth(Graphics g, int mx) { // xは口の幅
            int xMiddle = xPos + width / 2;
            int yMiddle = yPos + height - 30;
            g.drawLine(xMiddle - mx / 2, yMiddle, xMiddle, yMiddle + 15 * EmoVecB);
            g.drawLine(xMiddle + mx / 2, yMiddle, xMiddle, yMiddle + 15 * EmoVecB);
        }

        public void setPosition(int x, int y) {
            xPos = x;
            yPos = y;
        }

        public void setEmotionLevel(int vecA, int vecB) {
            EmoVecA = vecA - 1;
            EmoVecB = vecB - 1;
        }
    }

}// Faces class end
