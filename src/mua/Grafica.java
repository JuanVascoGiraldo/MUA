package mua;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Grafica extends JPanel {
    
    double v1, x1, a, xf, t;
    int w, h, l;
    public int xpos=0;
    
    public Grafica(double v1, double x1, double a, int w , int h, int l, double xf, double t) {
        init();
        this.v1 = v1;
        this.x1 = x1;
        this.a = a;
        this.w = w;
        this.h = h;
        this.l =l;
        this.xf = xf;
        this.t = t;
    }

    public void init() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override 
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawLine(l, h/2, w+l, h/2);
        g.drawLine(w/2+l, 0,w/2 + l , h);
        
        g.setColor(Color.black);
        g.drawRect(w/2+l+this.getXpos(), h/2-10, 10, 10);
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

}
