package com.iessanalberto.JTT;

import static com.iessanalberto.JTT.TraductorMorse.TEXTO_A_TRADUCIR;
 /***************************************************************************************
 *  CLASE: "Productor"
 ***************************************************************************************
 *  @author  Juan Terrén
 *
 *  @version 1.1 - Versión corregida
 *
 *  @since 23/01/2025
 *
 ***************************************************************************************
 *  COMENTARIOS:
 *
 *      - Recibe una cadena de texto y la trozea en palabras.
 ***************************************************************************************/
public class Productor implements Runnable {

    Buzon a_Buzon = null;

    String[] a_Palabras = TEXTO_A_TRADUCIR.split(" ");

    // Constructor de la clase Productor
    public Productor(Buzon p_Buzon) {
        a_Buzon = p_Buzon;
    }

    // Sobrecarga del metodo run() por usar la interfaz Runnable, la tarea de trozear la cadena se genera aquí.
    @Override
    public void run() {

        // Adquirimos el token del semáforo para el productor
        a_Buzon.adquirirSemaforoProductor();

        while (a_Buzon.get_Consumidor() < a_Palabras.length) {

            a_Buzon.a_Max_Palabras = a_Palabras.length;

            // Coloca una palabra en el buzón
            a_Buzon.set_Productor(a_Palabras[a_Buzon.get_Consumidor()]);

            // Soltamos el token, para que el Consumidor sepa que tiene una palabra lista
            a_Buzon.soltarSemaforoConsumidor();

            // Se puede ajustar el tiempo de espera entre producciones
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    } // run()

} // Productor
