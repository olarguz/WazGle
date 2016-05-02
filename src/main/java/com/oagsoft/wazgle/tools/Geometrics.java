package com.oagsoft.wazgle.tools;

import java.awt.Point;

/**
 *
 * @author oarcila
 */
public class Geometrics
{

    /**
     * Metodo que permite calcular un punto sobre una linea usando la ecuacion
     * parametrica. <code>P(t) = p<sub>0</sub> + t <b>v</b></code>. Usando esta
     * ecuacion se calcula v con el punto inicial y el punto final de la recta.
     * En cuanto al valor del parametro cuando t tiene valores entre 0 y 1 el
     * punto esta entre el punto inicial y el punto final, cuando el valor de t
     * es menor a 0 los valores estan antes del punto inicial y cuando los
     * valores son mayores a 1 el punto esta despues del punto final.
     *
     * @param pI Punto Inicial de la recta
     * @param pF Punto Final de la recta.
     * @param t Parametro para calcular el nuevo punto
     * @return Nuevo punto
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: 'calcularPunto(Point, Point, double)'">
    public static Point calcularPunto(Point pI, Point pF, double t)
    {
        double x = pI.x + t * (pF.x - pI.x);
        double y = pI.y + t * (pF.y - pI.y);

        return new Point((int) x, (int) y);
    }
    //</editor-fold>

}
