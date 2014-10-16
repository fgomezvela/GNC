/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author JoseAntonio
 */
public final class Splash {

    final SplashScreen splash;
    //texto que se muestra a medida que se va cargando el screensplah
    final String[] texto = {"GNC", "Configuration", "Genes...",
        "Directoy", "Distance Matrices", "icons", "More more genes...",
        "XML files", "Launch..."};

    public Splash() {
        splash = SplashScreen.getSplashScreen();
    }

    public void animar() {
        if (splash != null) {
            Graphics2D g = splash.createGraphics();
            for (int i = 1; i < texto.length; i++) {
                //se pinta texto del array
                g.setColor(Color.white);//color de fondo
                g.fillRect(0, 500, 280, 12);//para tapar texto anterior
                g.setColor(Color.BLACK);//color de texto 
                g.drawString("Loading " + texto[i - 1] + "...", 0, 510);
                g.setColor(Color.green);//color de barra de progeso
                g.fillRect(0, 520, (i * 972 / texto.length), 12);//la barra de progreso
                //g.translate(30, 30);
                //se pinta una linea segmentada encima de la barra verde
                g.setColor(Color.GREEN);//color de barra de progeso
                //g.setColor(new Color(4, 52, 101));
                //g.drawLine(205, 314, 510, 314);
                //se actualiza todo
                splash.update();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            splash.close();
        }
        //una vez terminada la animación se muestra la aplicación principal
        try {
            //BufferedImage image = ImageIO.read(this.getClass().getResource("ULTIMO.jpg"));
            comprobarDirectorio();
            new VentanaPrincipal().setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void comprobarDirectorio() {

        String carpetaGNC = System.getProperty("user.dir") + System.getProperty("file.separator") + "GNC";
        String rutaComparaciones = System.getProperty("user.dir") + System.getProperty("file.separator") + "GNC" + System.getProperty("file.separator") + "Results";
        String rutaInput = System.getProperty("user.dir") + System.getProperty("file.separator") + "GNC" + System.getProperty("file.separator") + "InputNetworks";
        String rutaDB = System.getProperty("user.dir") + System.getProperty("file.separator") + "GNC" + System.getProperty("file.separator") + "BioDatabases";
        String rutaMatrices = System.getProperty("user.dir") + System.getProperty("file.separator") + "GNC" + System.getProperty("file.separator") + "Matrices";
        File carpeta = new File(carpetaGNC);
        File DirComparaciones = new File(rutaComparaciones);
        File ArchivoComparaciones = new File(rutaComparaciones + System.getProperty("file.separator") + "Results.txt");
        File DirInputs = new File(rutaInput);
        File DirDB = new File(rutaDB);
        File DirMAtrices = new File(rutaMatrices);

        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        if (!DirMAtrices.exists()) {
            DirMAtrices.mkdir();
        }

        if (!DirComparaciones.exists()) {
            DirComparaciones.mkdir();
        }

        if (!DirInputs.exists()) {
            DirInputs.mkdir();
        }

        if (!DirDB.exists()) {
            DirDB.mkdir();
        }

        if (!ArchivoComparaciones.exists()) {
            FileWriter fichero = null;
            PrintWriter pw = null;
            try {
                fichero = new FileWriter(ArchivoComparaciones);
                pw = new PrintWriter(fichero);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Nuevamente aprovechamos el finally para 
                    // asegurarnos que se cierra el fichero.
                    if (null != fichero) {
                        fichero.close();
                        pw.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        //moverArchivos();
    }
}
