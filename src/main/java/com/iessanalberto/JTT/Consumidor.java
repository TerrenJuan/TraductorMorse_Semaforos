package com.iessanalberto.JTT;
/***************************************************************************************
 *  CLASE: "Consumidor"
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
 *      - Recibe una palabra, y la traduce a código Morse letra a letra.
 ***************************************************************************************/
public class Consumidor implements Runnable {

    Buzon a_Buzon = null;

    private String a_Palabra = "";

    private final String a_Abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  // Abecedario + Números
    private final String[] a_Codigo_Morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", // A-Z
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----." // 0-9
    };

    // Constructor de la clase Consumidor
    public Consumidor(Buzon p_Buzon) {
        a_Buzon = p_Buzon;
    }

    // Sobrecarga del metodo run() por usar la interfaz Runnable, recibe una palabra que traduce letra a letra a código Morse.
    @Override
    public void run() {

        while (a_Buzon.get_Consumidor() < a_Buzon.a_max_palabras) {

            try {
                a_Buzon.a_SemaforoConsumidor.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            a_Palabra = a_Buzon.get_Productor();

            a_Palabra = a_Palabra.toUpperCase();

            System.out.print(a_Palabra + ": ");

            // Traducir cada caracter de la palabra a Morse
            StringBuilder l_palabra_morse = new StringBuilder();

            // Bucle que obtiene la letra de la palabra, y según la posición, obtiene su traducción en Morse
            for (Character l_letra : a_Palabra.toCharArray()) {

                // Obtenemos la letra en código morse
                String l_letra_morse = a_Codigo_Morse[a_Abecedario.indexOf(l_letra)];

                // Concatenamos las "letras" que obtenemos en codigo Morse
                l_palabra_morse.append(l_letra_morse).append(" ");

            }

            // Mostramos por pantalla la palabra traducida
            System.out.println(l_palabra_morse);

            // Aumentamos el contador, para obtener la siguiente palabra
            a_Buzon.a_Contador++;
            a_Buzon.set_Consumidor(a_Buzon.a_Contador);

            // Soltamos el token, para que lo recupere el Productor
            a_Buzon.a_SemaforoProductor.release();

        }

    } // run()

} // Consumidor
