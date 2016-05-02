package com.oagsoft.wazgle.data;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author oarcila
 */
public class GraphicNode extends GraphicObject
{

    private Point p;
    private int radio;
    private boolean seleccionado;

    public GraphicNode(Point p, int radio, boolean selecionado)
    {
        this.p = p;
        this.radio = radio;
        this.seleccionado = selecionado;
    }

    public Point getP()
    {
        return p;
    }

    public int getRadio()
    {
        return radio;
    }

    /**
     * Get the value of seleccionado
     *
     * @return the value of seleccionado
     */
    public boolean isSeleccionado()
    {
        return seleccionado;
    }

    /**
     * Set the value of seleccionado
     *
     * @param seleccionado new value of seleccionado
     */
    public void setSeleccionado(boolean seleccionado)
    {
        this.seleccionado = seleccionado;
    }

    @Override
    public void draw(Graphics2D g)
    {
        int borde = 2;
        Color color = new Color(250, 50, 50);
        if (seleccionado)
        {
            borde = 4;
            color = new Color(250, 0, 0);
        }

        g.setStroke(new BasicStroke(borde));
        g.setColor(new Color(10, 10, 250, 50));
        g.fillOval(p.x, p.y, radio, radio);
        g.setColor(color);
        g.drawOval(p.x, p.y, radio, radio);
    }
}
