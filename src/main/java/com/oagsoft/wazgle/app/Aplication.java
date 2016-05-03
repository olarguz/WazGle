package com.oagsoft.wazgle.app;

import com.oagsoft.wazgle.data.GraphicObject;
import com.oagsoft.wazgle.tools.FactoryGraph;
import com.oagsoft.wazgle.view.MapPanel;
import com.oagsoft.wazgle.tools.FactoryItem;
import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author oarcila
 */
public class Aplication extends JFrame implements ActionListener
{

    private MapPanel panel;
    private LinkedList<GraphicObject> elementsGraph;

    public Aplication(String title)
    {
        super(title);

        createGUI();
    }

    /**
     * Metodo que permite craer la interfaz grafica de usuario.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: 'createGUI()'">
    private void createGUI()
    {
        // TODO: Esta linea se debe reemplazar por la lectura del archivo xml.
        elementsGraph = FactoryGraph.create();

        panel = new MapPanel("ImgMap.png", "ImgSat.png", elementsGraph);
        add(BorderLayout.CENTER, panel);
        setJMenuBar(createBarMenu());
        setSize(panel.getMapSize());
        setResizable(false);
    }
    //</editor-fold>

    /**
     * Creación de menu
     *
     * @return El Menu que se le asigna a la aplicación.
     */
    // <editor-fold defaultstate="collapsed" desc="Metodo :: 'createBarMenu ()'">
    private JMenuBar createBarMenu()
    {
        JMenuBar miBarraMenu = new JMenuBar();
        JMenu subMenu = null;

        subMenu = new JMenu("Opciones");
        subMenu.add(FactoryItem.createMenuItem("Opcion", "opcion", this, KeyEvent.VK_I));
        subMenu.addSeparator();
        subMenu.add(FactoryItem.createMenuItem("Salir", "salir", this, KeyEvent.VK_S));
        miBarraMenu.add(subMenu);

        subMenu = new JMenu("Herramientas");
        subMenu.add(FactoryItem.createMenuItem("Mostrar Grafo", "mostrarGrafo", this, KeyEvent.VK_M));
        subMenu.add(FactoryItem.createMenuItem("Imagen Satelite", "imagenSatelite", this, KeyEvent.VK_P));
        miBarraMenu.add(subMenu);

        return miBarraMenu;
    }
    // </editor-fold>

    /**
     * Este método se lanza cada vez que se activa una opción del menú.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        switch (command)
        {
            case "mostrarGrafo":
                mostrarGrafo((JMenuItem) e.getSource());
                break;
            case "ocultarGrafo":
                ocultarGrafo((JMenuItem) e.getSource());
                break;
            case "imagenSatelite": 
                imagenSatelite((JMenuItem) e.getSource());
                break;
            case "imagenPlano":
                imagenPlano((JMenuItem) e.getSource());
                break;
            case "salir":
                salir();
                break;
        }
    }

    /**
     * Este método es el encargado de cerrar el puerto serial cuando se cierra
     * también la aplicación.
     */
    // <editor-fold defaultstate="collapsed" desc="Método :: 'salir ()'">
    private void salir()
    {
        dispose();
    }
    // </editor-fold>

    /**
     * Este método es el encargado de ocultar el grafo del area visible. Ademas
     * actualiza la opcion del menu.
     */
    // <editor-fold defaultstate="collapsed" desc="Método :: 'ocultarGrafo ()'">
    private void ocultarGrafo(JMenuItem b)
    {
        b.setText("Mostrar Grafo");
        b.setActionCommand("mostrarGrafo");
        panel.setGrafoVisible(!panel.isGrafoVisible());
        panel.repaint();
    }
    // </editor-fold>

    /**
     * Este método es el encargado de mostrar el grafo del area visible. Ademas
     * actualiza la opcion del menu.
     */
    // <editor-fold defaultstate="collapsed" desc="Método :: 'mostrarNodos ()'">
    private void mostrarGrafo(JMenuItem b)
    {
        b.setText("Ocultar Grafo");
        b.setActionCommand("ocultarGrafo");
        panel.setGrafoVisible(true);
        panel.repaint();
    }
    // </editor-fold>

    private void imagenSatelite(JMenuItem b) {
        b.setText("Imagen Plano");
        b.setActionCommand("imagenPlano");
        panel.setImagenPlano(true);
        panel.repaint();
    }

    private void imagenPlano(JMenuItem b) {
        b.setText("Imagen Satelite");
        b.setActionCommand("imagenSatelite");
        panel.setImagenPlano(false);
        panel.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Aplication app = new Aplication("WazGle - Buscador de Caminos");
        app.setVisible(true);
    }

}
