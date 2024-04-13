package editor_de_texto_aeh;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase para manejar eventos de los botones del editor de texto
public class Action_Listener implements ActionListener {
    private String styleName; // Nombre del estilo (negrita, cursiva, subrayado, color)
    private JTextPane textPane; // JTextPane donde se aplicarán los estilos

    // Constructor de la clase Action_Listener
    public Action_Listener(String styleName, JTextPane textPane) {
        this.styleName = styleName;
        this.textPane = textPane;
    }

    // Método para manejar eventos de los botones
    public void actionPerformed(ActionEvent e) {
        int start = textPane.getSelectionStart(); // Obtener el inicio de la selección
        int end = textPane.getSelectionEnd(); // Obtener el final de la selección
        StyledDocument doc = textPane.getStyledDocument(); // Obtener el documento de estilos
        Style style = doc.addStyle(styleName, null); // Agregar un nuevo estilo al documento
        AttributeSet attributes = doc.getCharacterElement(start).getAttributes(); // Obtener los atributos de estilo

        // Aplicar el estilo correspondiente
        switch (styleName) {
            case "Negrita":
                boolean isBold = StyleConstants.isBold(attributes);
                StyleConstants.setBold(style, !isBold);
                break;
            case "Cursiva":
                boolean isItalic = StyleConstants.isItalic(attributes);
                StyleConstants.setItalic(style, !isItalic);
                break;
            case "Subrayado":
                boolean isUnderline = StyleConstants.isUnderline(attributes);
                StyleConstants.setUnderline(style, !isUnderline);
                break;
            case "Color":
                Color color = JColorChooser.showDialog(null, "Seleccionar Color", Color.BLACK); // Mostrar un selector de color
                if (color != null) {
                    StyleConstants.setForeground(style, color); // Establecer el color de texto
                }
                break;
        }

        doc.setCharacterAttributes(start, end - start, style, false); // Aplicar los atributos de estilo al texto seleccionado

        // Actualizar visualmente el JTextPane
        textPane.revalidate();
        textPane.repaint();
    }
}
