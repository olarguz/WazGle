
package com.oagsoft.wazgle.tools;

import java.awt.Event;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author oarcila
 */
public class FactoryItem
{

    /**
     * Este método permite crea opciones en el menú de la aplicación totalmente
     * funcionales con una sola línea. Este método encapsula toda la
     * programación permitiendo crea de forma agil menus colgantes con sus
     * opciones activas.
     *
     * @param title Nombre de la Opción.
     * @param actionCommand Nombre del evento que lanza el menu al activar una
     * opción.
     * @param listener Objeto que responde a los mensajes de activación de la
     * opción.
     * @param shortKey
     * @return Item de Menú listo para agregarse.
     */
    // <editor-fold defaultstate="collapsed" desc="Método :: 'createMenuItem ( String, String, ActionListener, int)'">
    public static JMenuItem createMenuItem(String title, String actionCommand, ActionListener listener, int shortKey)
    {
        JMenuItem opcion = new JMenuItem(title, shortKey);
        opcion.setAccelerator(KeyStroke.getKeyStroke(shortKey, Event.CTRL_MASK));
        opcion.setActionCommand(actionCommand);
        opcion.addActionListener(listener);

        return opcion;
    }    
    // </editor-fold>

}
