package editor_de_texto_aeh;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class saveListener implements ActionListener {
    private JTextPane textPane; // JTextPane donde se encuentra el texto que se va a guardar

    // Constructor que recibe el JTextPane como parámetro
    public saveListener(JTextPane textPane) {
        this.textPane = textPane;
    }

    // Método que se ejecuta cuando se realiza la acción de guardar
    @Override
    public void actionPerformed(ActionEvent e) {
        saveTextToFile(); // Llama al método para guardar el texto en un archivo
    }

    // Método para guardar el texto en un archivo
    private void saveTextToFile() {
        // Se crea un cuadro de diálogo para seleccionar la ubicación y nombre del archivo
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);

        // Si el usuario selecciona una ubicación y nombre de archivo
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile(); // Obtiene el archivo seleccionado
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                writer.write(textPane.getText()); // Escribe el texto del JTextPane en el archivo
                writer.close(); // Cierra el escritor
                // Muestra un mensaje de éxito al usuario
                JOptionPane.showMessageDialog(null, "El texto se ha guardado exitosamente.");
            } catch (IOException ex) { // Manejo de excepciones en caso de error al guardar el archivo
                ex.printStackTrace(); // Imprime el rastreo de la pila en caso de error (para depuración)
                // Muestra un mensaje de error al usuario
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo.");
            }
        }

    }
}

