# Clase Editor_Texto_Aeh.

### a. Descripcion
 Esta clase representa la ventana principal de la aplicación de editor de texto.
 Proporciona una interfaz de usuario para que los usuarios puedan editar y formatear texto.
### b. Constructores:
#### i. Editor_Texto_Aeh():
 Constructor por defecto que inicializa la interfaz de usuario del editor de texto.
 Configura el diseño de la ventana y agrega los componentes necesarios como botones y combobox.
 Asigna action listeners a los componentes para manejar las interacciones del usuario.
### c. Métodos:
#### i. main(String[] args):
 Método principal que inicia la aplicación.
 Crea una instancia de Editor_Texto_Aeh, configura su tamaño y visibilidad, y establece la acción al cerrar la ventana.
### d. Campos:
#### i. panel1:
 Un panel que contiene los componentes de la interfaz de usuario.
#### ii. button1, button2, button3, button4:
 Botones utilizados para aplicar estilos de formato al texto (negrita, cursiva, subrayado y color respectivamente).
#### iii. comboBox1, comboBox2:
 Combobox que permite al usuario seleccionar la fuente y el tamaño del texto.
#### iv. textPane1:
 Un área de texto enriquecido (JTextPane) donde se muestra y edita el texto.

# Clase Action_Listener

### a. Descripción:
 Esta clase implementa la interfaz ActionListener para manejar los eventos de acción generados por los botones del editor de texto.
### b. Constructores:
#### i. Action_Listener(String styleName, JTextPane textPane):
 Constructor que inicializa el nombre del estilo y el área de texto donde se aplicarán los estilos.
### c. Métodos:
#### i. actionPerformed(ActionEvent e):
 Método que se llama cuando se produce un evento de acción, como hacer clic en un botón.
 Este método aplica el estilo asociado al texto seleccionado en el área de texto.
 Dependiendo del tipo de estilo (negrita, cursiva, subrayado o color), se actualizan los atributos de estilo del texto utilizando las clases y métodos proporcionados por la biblioteca Swing de Java.
### d. Campos:
#### i. styleName:
 Nombre del estilo que se aplicará al texto (por ejemplo, "Negrita", "Cursiva", "Subrayado" o"Color").
#### ii. textPane:
 Un área de texto donde se aplicarán los estilos de formato.


#  Clase SaveListener
### a. Constructores:
 “public saveListener” Este constructor crea una nueva instancia de GuardarListener y recibe como parámetro un JTextPane. El JTextPane proporcionado debe contener el texto que se desea guardar en el archivo.
### b. Metodos:
 “public void actionPerformed” Este método se activa cuando se realiza la acción de guardar, que generalmente es desencadenada por un evento de clic en un botón o una opción de menú. Al activarse este método, se ejecuta la lógica para guardar el texto en un archivo.

 “private void saveTextToFile():Este método maneja la acción de guardar el texto en un archivo. Inicia abriendo un cuadro de diálogo utilizando un objeto JFileChooser, que permite al usuario seleccionar la ubicación y el nombre del archivo donde se guardará el texto. Una vez que el usuario elige una ubicación y un nombre de archivo válidos y confirma la acción, el texto contenido en el JTextPane se escribe en el archivo especificado. Si el proceso se completa con éxito, se muestra un mensaje de
confirmación al usuario. En caso de que ocurra algún error durante el proceso de
guardado, ya sea debido a problemas de acceso al archivo o problemas de escritura, se
maneja la excepción y se muestra un mensaje de error al usuario, proporcionando
detalles sobre el problema ocurrido.
### c. Flujo de operación:

1. Cuando se realiza la acción de guardar, se activa el método actionPerformed(ActionEvent e).
2. Dentro de este método, se llama al método saveTextToFile() para manejar la acción de
   guardar el texto en un archivo.
3. El método saveTextToFile() abre un cuadro de diálogo para que el usuario seleccione la
   ubicación y el nombre del archivo.
4. Una vez que el usuario selecciona una ubicación y un nombre de archivo válidos y confirma la
   acción, el texto contenido en el JTextPane se escribe en el archivo especificado.
5. Se muestra un mensaje de confirmación al usuario si el proceso se completa con éxito.
6. En caso de que ocurra algún error durante el proceso de guardado, se maneja la excepción y
   se muestra un mensaje de error al usuario, proporcionando detalles sobre el problema
   ocurrido.


# Consideraciones adicionales

### a. Interfaz de usuario:
 La interfaz de usuario proporciona una experiencia intuitiva para el usuario, con botones y combobox claramente etiquetados que permiten al usuario formatear el texto de manera fácil y rápida.
### b. Gestión de eventos:
 Se implementa un mecanismo eficaz para manejar los eventos generados por los componentes de la interfaz de usuario.
 Los action listeners asociados a los botones y combobox aseguran que los cambios de formato se apliquen de manera consistente y precisa al texto seleccionado.
### c. Personalización del texto:
 Los usuarios tienen la capacidad de personalizar diversos aspectos del texto, como el estilo, la fuente, el tamaño y el color, lo que les permite crear documentos con un aspecto visualmente atractivo y coherente.
### d. Reusabilidad del código:
 La separación de la lógica de presentación y la lógica de aplicación mediante el uso de clases como Editor_Texto_Aeh y Action_Listener promueve la reutilización del código y facilita su mantenimiento y extensión en el futuro.