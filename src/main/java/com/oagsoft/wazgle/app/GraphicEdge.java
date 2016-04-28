package com.oagsoft.wazgle.app;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author oarcila
 */
public class GraphicEdge extends GraphicObject
{

    private GraphicNode vIni;
    private GraphicNode vFin;
    private double peso;

    public GraphicEdge(GraphicNode vIni, GraphicNode vFin, double peso)
    {
        this.vIni = vIni;
        this.vFin = vFin;
        this.peso = peso;
    }

    public GraphicEdge(GraphicNode vIni, GraphicNode vFin)
    {
        this(vIni, vFin, 1);
    }

    @Override
    public void draw(Graphics2D g)
    {
        Point pIni = vIni.getP();
        double rIni = vIni.getRadio()/2;
        Point pFin = vFin.getP();
        double rFin = vFin.getRadio()/2;

        Point pAuxIni = pIni;
        Point pAuxFin = pFin;
        int ancho = 2;

        g.setStroke(new BasicStroke(ancho));
        g.setColor(Color.BLUE);
        g.drawLine(pAuxIni.x + (int) rIni, pAuxIni.y + (int) rIni, pAuxFin.x + (int) rFin, pAuxFin.y + (int) rFin);

    }
}
