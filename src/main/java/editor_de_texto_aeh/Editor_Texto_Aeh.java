package editor_de_texto_aeh;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// La clase principal que extiende JFrame para la interfaz de usuario del editor de texto
public class Editor_Texto_Aeh extends JFrame {
    private JPanel panel1;
    private JButton button1, button2, button3, button4, saveButton; // Botones para aplicar estilos y color al texto
    private JComboBox comboBox1, comboBox2; // Combobox para seleccionar fuente y tamaño de texto
    private JTextPane textPane1; // Área de texto donde se muestra el texto

    // Constructor de la clase Editor_Texto_Aeh
    public Editor_Texto_Aeh() {
        setLayout(null); // Establecer el diseño a nulo para permitir el posicionamiento manual de los componentes
        setTitle("Desing Preview [Editor de Texto]"); // Establecer el título de la ventana
        setSize(400, 300); // Establecer el tamaño de la ventana

        // Creación y configuración de botones
        button1 = new JButton("negrita");
        button1.setBounds(10, 60, 90, 30);
        add(button1);

        button2 = new JButton("cursiva");
        button2.setBounds(110, 60, 90, 30);
        add(button2);

        button3 = new JButton("subrayado");
        button3.setBounds(210, 60, 90, 30);
        add(button3);

        button4 = new JButton("Color");
        button4.setBounds(510, 60, 90, 30);
        add(button4);

        saveButton = new JButton("Guardar");
        saveButton.setBounds(510 , 610 , 90, 30);
        add(saveButton);

        // Creación y configuración de combobox para seleccionar la fuente
        comboBox1 = new JComboBox();
        comboBox1.setBounds(310, 60, 90, 30);
        add(comboBox1);
        comboBox1.addItem("Arial");
        comboBox1.addItem("Calibri");
        comboBox1.addItem("Verdana");
        comboBox1.addItem("Times New Roman");
        comboBox1.addItem("Courier New");
        comboBox1.addItem("Comic Sans MS");
        comboBox1.addItem("Helvetica");
        comboBox1.addItem("Trebuchet MS");
        comboBox1.addItem("Tahoma");
        comboBox1.addItem("Georgia");

        // Creación y configuración de combobox para seleccionar el tamaño de fuente
        comboBox2 = new JComboBox();
        comboBox2.setBounds(410, 60, 90, 30);
        add(comboBox2);
        comboBox2.addItem(10);
        comboBox2.addItem(12);
        comboBox2.addItem(14);
        comboBox2.addItem(16);
        comboBox2.addItem(17);
        comboBox2.addItem(18);
        comboBox2.addItem(20);
        comboBox2.addItem(22);
        comboBox2.addItem(24);
        comboBox2.addItem(26);
        comboBox2.addItem(28);
        comboBox2.addItem(30);
        comboBox2.addItem(32);

        // Creación del área de texto
        textPane1 = new JTextPane();
        JScrollPane scrolTexto = new JScrollPane(textPane1);
        textPane1.setBounds(10, 110, 590, 450);
        add(textPane1);

        // Agregar action listeners a los botones y combobox
        button1.addActionListener(new Action_Listener("Negrita", textPane1));
        button2.addActionListener(new Action_Listener("Cursiva", textPane1));
        button3.addActionListener(new Action_Listener("Subrayado", textPane1));
        button4.addActionListener(new Action_Listener("Color", textPane1));
        saveButton.addActionListener(new saveListener(textPane1));

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el tamaño de fuente seleccionado y aplicarlo al texto
                int size = (Integer) comboBox2.getSelectedItem();
                Action fontAction = new StyledEditorKit.FontSizeAction(String
                        .valueOf(size), size);
                fontAction.actionPerformed(e);
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la fuente seleccionada y aplicarla al texto
                String fontName = (String) comboBox1.getSelectedItem();
                Font currentFont = textPane1.getFont();
                Font newFont = new Font(fontName, currentFont.getStyle(), currentFont.getSize());
                textPane1.setFont(newFont);
            }
        });
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        Editor_Texto_Aeh editor = new Editor_Texto_Aeh();
        editor.setBounds(0, 0, 622, 700); // Establecer la posición y tamaño de la ventana principal
        editor.setVisible(true); // Hacer visible la ventana
        editor.setDefaultCloseOperation(EXIT_ON_CLOSE); // Establecer la acción al cerrar la ventana
    }
}
