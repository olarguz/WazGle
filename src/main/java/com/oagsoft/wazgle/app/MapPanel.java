package com.oagsoft.wazgle.app;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author oarcila
 */
public class MapPanel extends JPanel
{

    private BufferedImage imageMap;
    private LinkedList<GraphicObject> graphElement;
    private boolean grafoVisible;

    public MapPanel(String file)
    {
        try
        {
            imageMap = ImageIO.read(new File(file));
        }
        catch (IOException ex)
        {
            imageMap = null;
        }

        grafoVisible = false;

        graphElement = new LinkedList<>();
        graphElement.add(new GraphicNode(new Point(25, 140), 20, false));
        graphElement.add(new GraphicNode(new Point(55, 205), 20, false));
        graphElement.add(new GraphicNode(new Point(90, 280), 20, true));
        graphElement.add(new GraphicEdge((GraphicNode)graphElement.get(0), (GraphicNode)graphElement.get(1)));
        graphElement.add(new GraphicEdge((GraphicNode)graphElement.get(1), (GraphicNode)graphElement.get(2)));
    }

    /**
     * Get the value of grafoVisible
     *
     * @return the value of grafoVisible
     */
    public boolean isGrafoVisible()
    {
        return grafoVisible;
    }

    /**
     * Set the value of grafoVisible
     *
     * @param mostrarNodos new value of grafoVisible
     */
    public void setGrafoVisible(boolean mostrarNodos)
    {
        this.grafoVisible = mostrarNodos;
    }

    public Dimension getMapSize()
    {
        return new Dimension(imageMap.getWidth(), imageMap.getHeight());
    }

    @Override
    protected void paintComponent(Graphics gd)
    {
        super.paintComponent(gd);

        Graphics2D g = (Graphics2D) gd;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (imageMap != null)
        {
            g.drawImage(imageMap, 0, 0, this);
            if (grafoVisible)
            {
                for (GraphicObject element : graphElement)
                {
                    element.draw(g);
                }
            }
        }
        else
        {
            g.drawString("No hay mapa", 200, 200);
        }
    }

}
