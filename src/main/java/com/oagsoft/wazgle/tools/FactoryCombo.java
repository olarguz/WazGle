package com.oagsoft.wazgle.tools;

import com.oagsoft.wazgle.data.GraphicCombo;
import com.oagsoft.wazgle.data.GraphicEdge;
import com.oagsoft.wazgle.data.GraphicNode;
import com.oagsoft.wazgle.data.GraphicObject;
import com.oagsoft.wazgle.data.GraphicTrack;
import java.awt.Point;
import java.util.LinkedList;

/**
 *
 * @author oarcila
 */
public class FactoryCombo 
{

    public static GraphicCombo create(Point p, LinkedList<GraphicObject> graphElement) {
            GraphicNode nAux = new GraphicNode(p, 0, false);
            GraphicTrack track = new GraphicTrack(p);
            GraphicEdge edge = null;

            GraphicNode nEncontrado = Search.buscarMasCercano(p, graphElement);
            if ( nEncontrado != null)
            {
                edge = new GraphicEdge(nAux, nEncontrado);
            }
            
            return new GraphicCombo(edge, track);
    }
    
}
