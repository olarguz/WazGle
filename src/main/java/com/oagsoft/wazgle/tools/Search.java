package com.oagsoft.wazgle.tools;

import com.oagsoft.wazgle.data.GraphicNode;
import com.oagsoft.wazgle.data.GraphicObject;
import java.awt.Point;
import java.util.LinkedList;

/**
 *
 * @author oarcila
 */
public class Search 
{

    /**
     * 
     * @param pIni
     * @param graphElement
     * @return 
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: buscarMasCercano(Point, LinkedList<GraphicObject>)">
    public static GraphicNode buscarMasCercano(Point pIni, LinkedList<GraphicObject> graphElement)
    {
        GraphicNode nodoCercano = null;
        LinkedList<GraphicNode> nodos = new LinkedList<>();
        for (GraphicObject nAxu : graphElement)
        {
            if ( nAxu instanceof GraphicNode)
                nodos.add((GraphicNode) nAxu);
        }
        
        double distancia = 1000000000;
        for (GraphicNode nAux : nodos)
        {
            Point pAux = nAux.getP();
            double d = Point.distance(pIni.x, pIni.y, pAux.x, pAux.y);
            if ( d < distancia)
            {
                distancia = d;
                nodoCercano = nAux;
            }
        }
        
        return nodoCercano;
    }
    //</editor-fold>

}
