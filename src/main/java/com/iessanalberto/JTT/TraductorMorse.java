package com.iessanalberto.JTT;

/***************************************************************************************
 *  APLICACIÓN: "Traductor Morse"
 ***************************************************************************************
 *  PROGRAMACIÓN DE SERVICIOS Y PROCESOS 2DAM - IntelliJ IDEA(2024.1.3)
 ***************************************************************************************
 *  @author  Juan Terrén
 *
 *  @version 1.0 - Versión inicial
 *
 *  @since 16/01/2025
 *
 ***************************************************************************************
 *  COMENTARIOS:
 *
 *      - A partir de una cadena de texto, traducirla a código morse.
 ***************************************************************************************/
public class TraductorMorse {

    public static String TEXTO_A_TRADUCIR = "En un lugar de la mancha 1605".toUpperCase();

    public static void main(String[] args) {

        Buzon l_Buzon = new Buzon();

        // Se crean los constructores de ambos codigos
        Productor l_Productor = new Productor(l_Buzon);
        Consumidor l_Consumidor = new Consumidor(l_Buzon);

        // Se crean los hilos que ejecutaran ambos codigos
        Thread l_HiloProductor = new Thread(l_Productor);
        Thread l_HiloConsumidor = new Thread(l_Consumidor);

        // Se ejecutan los hilos creados
        l_HiloProductor.start();
        l_HiloConsumidor.start();

    } // main()

} // TraductorMorse