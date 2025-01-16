package com.iessanalberto.JTT;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/***************************************************************************************
 *  APLICACIÓN: "Traductor Morse"
 ***************************************************************************************
 *  PROGRAMACIÓN DE SERVICIOS Y PROCESOS 2DAM - IntelliJ IDEA(2024.1.3)
 ***************************************************************************************
 *  @author  Juan Terrén
 *
 *  @version 1.0 - Versión inicial
 *           1.1 - Versión corregida
 *
 *  @since 16/01/2025
 *         23/01/2025
 *
 ***************************************************************************************
 *  COMENTARIOS:
 *
 *      - Corrección de errores, uso de la clasea Thread en vez de lac lase ThreadPoolExecutor
 *      - Corrección en el uso de los semáforos
 *      - Optimización del código, añadiendo los métodos de los semáforos en el buzón, uso de
 *        String en vez de StringBuilder
 ***************************************************************************************/
public class TraductorMorse {

    public static String TEXTO_A_TRADUCIR = "En un lugar de la mancha en 1605".toUpperCase();
    private static volatile Buzon a_Buzon = new Buzon();
    private static final int NUMERO_HILOS = 2;

    public static void main(String[] args) {

        // Creamos el pool de hilos
        ThreadPoolExecutor l_Executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(NUMERO_HILOS);


        // Se crean los constructores de ambos codigos
        Productor l_Productor = new Productor(a_Buzon);
        Consumidor l_Consumidor = new Consumidor(a_Buzon);

        // Lanzamos las tareas
        l_Executor.execute(l_Productor);
        l_Executor.execute(l_Consumidor);

        // Apagamos el ejecutor
        l_Executor.shutdown();

    } // main()

} // TraductorMorse