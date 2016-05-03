package com.oagsoft.wazgle.view;

import com.oagsoft.wazgle.data.GraphicNode;
import com.oagsoft.wazgle.data.GraphicObject;
import com.oagsoft.wazgle.data.GraphicTrack;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author oarcila
 */
public class MapPanel extends JPanel implements MouseListener, MouseMotionListener
{

    private BufferedImage imageShow;
    private BufferedImage imageMap;
    private BufferedImage imageSat;
    private LinkedList<GraphicObject> graphElement;
    private boolean grafoVisible;
    private GraphicTrack mouseIndicator;

    public MapPanel(String fileA, String fileB, LinkedList<GraphicObject> graphElement)
    {
        try
        {
            imageMap = ImageIO.read(new File(fileA));
            imageSat = ImageIO.read(new File(fileB));
            imageShow = imageMap;
        }
        catch (IOException ex)
        {
            imageShow = null;
        }

        this.graphElement = graphElement;
        grafoVisible = false;

        mouseIndicator = new GraphicTrack(new Point(-50, -50));

        addMouseListener(this);
        addMouseMotionListener(this);
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
        return new Dimension(imageShow.getWidth(), imageShow.getHeight());
    }

    @Override
    protected void paintComponent(Graphics gd)
    {
        super.paintComponent(gd);

        Graphics2D g = (Graphics2D) gd;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (imageShow != null)
        {
            g.drawImage(imageShow, 0, 0, this);
            if (grafoVisible)
            {
                for (Iterator<GraphicObject> it = graphElement.descendingIterator(); it.hasNext();)
                {
                    GraphicObject element = it.next();
                    element.draw(g);
                }
            }
            mouseIndicator.draw(g);
        }
        else
        {
            g.drawString("No hay mapa", 200, 200);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        mouseIndicator.getP().setLocation(x, y);
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        mouseIndicator.getP().setLocation(-50, -50);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        mouseIndicator.getP().setLocation(x, y);
        procesarCercanias(graphElement,mouseIndicator);
        repaint();
    }

    private void procesarCercanias(LinkedList<GraphicObject> graphElement, GraphicTrack mouseIndicator) 
    {
        LinkedList<GraphicNode> l = new LinkedList<>();
        for (GraphicObject elem : graphElement) 
        {
            if ( elem instanceof GraphicNode)
            {
                l.add((GraphicNode) elem);
            }
        }
        
        for (Iterator<GraphicNode> it = l.iterator(); it.hasNext();) 
        {
            GraphicNode elem = it.next();
            Point pI = elem.getP();
            Point pF = mouseIndicator.getP();
            if ( Point.distance((double)pI.x, (double)pI.y, (double)pF.x, (double)pF.y) < 30)
            {
                elem.setSeleccionado(true);
            }
            else
            {
                elem.setSeleccionado(false);
            }
        }
    }

    public void setImagenPlano(boolean b) {
        if ( b)
        {
            imageShow = imageSat;
        }
        else
        {
            imageShow = imageMap;
        }
    }

}
