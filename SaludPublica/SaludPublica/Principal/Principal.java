package Principal;

import Vista.JFRegistroPersona;

public class Principal
{
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFRegistroPersona();
            }
        });
    }
}
