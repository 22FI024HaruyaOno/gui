import java.awt.Color;
import java.awt.Graphics;

class GUIAnimatinFaceLook {// 顔のオブジェクト

    int h = 100;
    int w = 100;

    int xStart = 0;
    int yStart = 0;

    public void setXY(int x, int y) {
        this.xStart = x;
        this.yStart = y;
    }

    public void setSize(int h, int w) {
        this.h = h;
        this.w = h;
    }

    public GUIAnimatinFaceLook() {

    }

    public void makeFace(Graphics g, String emotion) {
        // **ここにemotion毎の顔を用意する。*///
        if (emotion.equals("normal")) {
            makeNormal(g, 0);
        } else if (emotion.equals("angry")) {
            makeAngry(g, 5);
        } else if (emotion.equals("smile")) {
            makeSmile(g, -5);
        }

    }

    public void makeEyes(Graphics g, int eyeSize, int updown) {
        g.setColor(Color.black);
        g.drawLine(xStart + (h * 1 / 3) - eyeSize / 2, yStart + (w * 1 / 3) - eyeSize / 2,
                xStart + (h * 1 / 3) + eyeSize / 2, yStart + (w * 1 / 3) - eyeSize / 2 + updown * 2);
        g.drawLine(xStart + (h * 2 / 3) - eyeSize / 2, yStart + (w * 1 / 3) - eyeSize / 2 + updown * 2,
                xStart + (h * 2 / 3) + eyeSize / 2, yStart + (w * 1 / 3) - eyeSize / 2);
        g.drawOval(xStart + (h * 1 / 3) - eyeSize / 2, yStart + (w * 1 / 3), eyeSize, eyeSize);
        g.drawOval(xStart + (h * 2 / 3) - eyeSize / 2, yStart + (w * 1 / 3), eyeSize, eyeSize);
    }// makeEyes() end

    public void makeNose(Graphics g, int noseSize) {
        g.drawLine(xStart + (h * 1 / 2), yStart + (w * 2 / 4), xStart + (h * 1 / 2), yStart + (w * 2 / 4) + noseSize);
    }// makeNose() end

    public void makeMouth(Graphics g, int mouseSize, int updown) {
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 3 * w / 4;
        g.drawLine(xMiddle, yMiddle + 5, xMiddle - mouseSize, yMiddle + updown + 5);
        g.drawLine(xMiddle, yMiddle + 5, xMiddle + mouseSize, yMiddle + updown + 5);
    }

    public void makeNormal(Graphics g, int updown) {
        makeEyes(g, w / 5, updown);
        makeNose(g, h / 5);
        makeMouth(g, w / 4, updown);
    }

    public void makeAngry(Graphics g, int updown) {
        makeEyes(g, w / 5, updown);
        makeNose(g, h / 5);
        makeMouth(g, w / 4, updown);
    }

    public void makeSmile(Graphics g, int updown) {
        makeEyes(g, w / 5, updown);
        makeNose(g, h / 5);
        makeMouth(g, w / 4, updown);
    }
}// FaceObj End
