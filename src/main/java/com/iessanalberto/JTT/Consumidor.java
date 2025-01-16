package com.iessanalberto.JTT;
/***************************************************************************************
 *  CLASE: "Consumidor"
 ***************************************************************************************
 *  @author  Juan Terrén
 *
 *  @version 1.0 - 1.1 - Versión corregida
 *
 *  @since 23/01/2025
 *
 ***************************************************************************************
 *  COMENTARIOS:
 *
 *      - Recibe una palabra, y la traduce a código Morse letra a letra.
 ***************************************************************************************/
public class Consumidor implements Runnable {

    Buzon a_Buzon = null;

    private String a_Palabra = "";

    private final String a_Abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";  // Abecedario + Números
    private final String[] a_Codigo_Morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "--.--", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", // A-Z
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----." // 0-9
    };

    // Constructor de la clase Consumidor
    public Consumidor(Buzon p_Buzon) {
        a_Buzon = p_Buzon;
    }

    // Sobrecarga del metodo run() por usar la interfaz Runnable, recibe una palabra que traduce letra a letra a código Morse.
    @Override
    public void run() {

        while (a_Buzon.get_Consumidor() < a_Buzon.a_Max_Palabras) {

            // Adquirimos el token del semáforo para el consumidor
            a_Buzon.adquirirSemaforoConsumidor();

            a_Palabra = a_Buzon.get_Productor();

            System.out.print(a_Palabra + ": ");

            // Traducir cada caracter de la palabra a Morse
            String l_Palabra_Morse = "";

            // Bucle que obtiene la letra de la palabra, y según la posición, obtiene su traducción en Morse
            for (Character l_Letra : a_Palabra.toCharArray()) {

                // Obtenemos la letra en código morse
                String l_Letra_Morse = a_Codigo_Morse[a_Abecedario.indexOf(l_Letra)];

                // Concatenamos las "letras" que obtenemos en codigo Morse
                l_Palabra_Morse += (l_Letra_Morse)+(" ");

            }

            // Mostramos por pantalla la palabra traducida
            System.out.println(l_Palabra_Morse);

            // Aumentamos el contador, para obtener la siguiente palabra
            a_Buzon.a_Contador++;
            a_Buzon.set_Consumidor(a_Buzon.a_Contador);

            // Soltamos el token, para que lo recupere el Productor
            a_Buzon.soltarSemaforoProductor();

        }

    } // run()

} // Consumidor
