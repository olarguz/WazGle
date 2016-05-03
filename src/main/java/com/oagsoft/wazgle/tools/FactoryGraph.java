package com.oagsoft.wazgle.tools;

import com.oagsoft.wazgle.data.GraphicEdge;
import com.oagsoft.wazgle.data.GraphicNode;
import com.oagsoft.wazgle.data.GraphicObject;
import java.awt.Point;
import java.util.LinkedList;

/**
 *
 * @author oarcila
 */
public class FactoryGraph
{

    /**
     * Este metodo crea un grafo de prueba que sirve como ejemplo para el inicio
     * del proyecto. Este medoto debe ser eliminado del programa principal y
     * reemplazado por el metodo que lee el grafo almacenado en un archivo xml.
     *
     * @return Los elementos del grafo. Vertices y aristas
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: 'LinkedList<GraphicObject> create()'">
    public static LinkedList<GraphicObject> create()
    {
        
        LinkedList<GraphicObject> graphElement = new LinkedList<>();
        
        graphElement.add(new GraphicNode(new Point(17, 105), 20, false));       //  0
        graphElement.add(new GraphicNode(new Point(23, 188), 20, false));       //  1
        graphElement.add(new GraphicNode(new Point(23, 265), 20, true));        //  2
        graphElement.add(new GraphicNode(new Point(141, 265), 20, false));      //  3
        graphElement.add(new GraphicNode(new Point(135, 185), 20, false));      //  4
        graphElement.add(new GraphicNode(new Point(123, 88), 20, false));      //  5
        graphElement.add(new GraphicNode(new Point(133, 369), 20, false));      //  6
        
        graphElement.add(new GraphicEdge((GraphicNode) graphElement.get(0), (GraphicNode) graphElement.get(1)));
        graphElement.add(new GraphicEdge((GraphicNode) graphElement.get(1), (GraphicNode) graphElement.get(2)));
        graphElement.add(new GraphicEdge((GraphicNode) graphElement.get(2), (GraphicNode) graphElement.get(3)));
        graphElement.add(new GraphicEdge((GraphicNode) graphElement.get(3), (GraphicNode) graphElement.get(4)));
        graphElement.add(new GraphicEdge((GraphicNode) graphElement.get(4), (GraphicNode) graphElement.get(5)));
        graphElement.add(new GraphicEdge((GraphicNode) graphElement.get(3), (GraphicNode) graphElement.get(6)));
        
        return graphElement;
    }
    //</editor-fold>

}
