package com.oagsoft.wazgle.data;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author oarcila
 */
public class GraphicTrack extends GraphicObject
{
    
    private Point p;

    public GraphicTrack(Point p) {
        this.p = p;
    }

    /**
     * Get the value of p
     *
     * @return the value of p
     */
    public Point getP() {
        return p;
    }

    /**
     * Set the value of p
     *
     * @param p new value of p
     */
    public void setP(Point p) {
        this.p = p;
    }

    @Override
    public void draw(Graphics2D g) 
    {
        Point pAux = new Point(p.x - 20, p.y - 20);
        g.setColor(new Color(200, 200, 200, 50));
        g.fillOval(pAux.x, pAux.y, 40, 40);
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.BLACK);
        g.drawOval(pAux.x, pAux.y, 40, 40);
        g.setStroke(new BasicStroke(5));
        g.setColor(new Color(0, 0, 200, 180));
        g.drawOval(pAux.x+16, pAux.y+16, 8, 8);
    }

}
