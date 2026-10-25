PROYECTO: Alcancía POO I - Unidad 4
FECHA: entrega lunes 5
CÓMO ABRIR: BlueJ -> Open Project -> esta carpeta. Ejecutar Principal.main.
AUTOR: completado a partir del archivo de la profesora (alcanciaPOO1-copy).

QUÉ PEDÍA EL AUDIO
1. Terminar la interfaz, conectar los eventos y refrescar las etiquetas.
2. Al pulsar "Vaciar alcancía": contadores en 0 Y cambiar cerdito.png por rota.png.

ERRORES DEL ARCHIVO DE LA PROFE (por eso no compilaba ni hacía nada)
1. Alcancia(): escribía "int monedas50 = 0". Eso crea variables LOCALES
   que tapan a los atributos. El atributo no se inicializa ahí.
   Corrección: this.monedas50 = 0;
2. JFAlcancia implementa ActionListener pero no tiene actionPerformed.
   Eso no compila.
3. Escribió addActionAListener (con una A de más). El método es addActionListener.
4. Los botones y el panel del centro se crean y nunca se agregan a la ventana
   (falta principal.add(...) y setContentPane).
5. Llama a agregarMonedas(50) en la vista, pero ese método está en el modelo.
6. actualizarInterfaz() está vacío: el saldo nunca cambia en pantalla.
7. setVisible(true) está ANTES de crear la interfaz.
8. La imagen apunta a "src/images/cerdo.png". En BlueJ la carpeta es "images/"
   y el audio pide cerdito.png. Por eso el cerdito no salía.
9. Faltan el detalle de monedas, el total y el botón Vaciar.
10. No cambia a rota.png al vaciar.

IMÁGENES
- images/cerdito.png: alcancía vacía, al abrir.
- images/cerdo.png: la alcancía de la profe. Sale cuando ya hay monedas (se está llenando).
- images/rota.png: sale solo al pulsar Vaciar alcancía.
- Alcancia = MODELO. Atributos privados, constructor, agregarMonedas, getSaldo,
  getTotalMonedas, getters por denominación, vaciar.
- JFAlcancia = VISTA. Extiende JFrame. Tiene un objeto Alcancia.
- Principal = main, con SwingUtilities.invokeLater.
- interface ActionListener (de código) NO es lo mismo que interfaz gráfica.
  La gráfica es la clase que extiende JFrame.
  ActionListener se implementa con implements y obliga a escribir actionPerformed.
