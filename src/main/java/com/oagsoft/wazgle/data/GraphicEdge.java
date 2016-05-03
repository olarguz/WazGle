package com.oagsoft.wazgle.data;

import com.oagsoft.wazgle.tools.Geometrics;
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
        this(vIni, vFin, 3);
    }

    @Override
    public void draw(Graphics2D g)
    {
        Point pIni = vIni.getP();
        double rIni = vIni.getRadio() / 2;
        Point pFin = vFin.getP();
        double rFin = vFin.getRadio() / 2;

        double d = Point.distance(pIni.x, pIni.y, pFin.x, pFin.y);
        double tI = rIni / d;
        double tF = (d - rFin) / d;

        Point pAuxIni = Geometrics.calcularPunto(pIni, pFin, tI);
        Point pAuxFin = Geometrics.calcularPunto(pIni, pFin, tF);
        int ancho = (int) (1.0 * peso);

        g.setStroke(new BasicStroke(ancho));
        g.setColor(new Color(0, 0, 255, 155));
        g.drawLine(pAuxIni.x + (int) rIni, pAuxIni.y + (int) rIni, pAuxFin.x + (int) rFin, pAuxFin.y + (int) rFin);

    }
}
