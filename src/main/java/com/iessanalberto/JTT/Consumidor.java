package com.iessanalberto.JTT;

import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class Consumidor implements Runnable {

    Buzon a_Buzon = null;

    private String l_word = "";

    public Consumidor(Buzon p_Buzon) {
        a_Buzon = p_Buzon;
    }

    // Mapa de caracteres del alfabeto a código Morse
    private static final HashMap<Character, String> a_Codigo_Morse = new HashMap<>();



    // Llenamos el mapa con los caracteres del alfabeto y su equivalencia en Morse
    static {
        a_Codigo_Morse.put('A', ".-");
        a_Codigo_Morse.put('B', "-...");
        a_Codigo_Morse.put('C', "-.-.");
        a_Codigo_Morse.put('D', "-..");
        a_Codigo_Morse.put('E', ".");
        a_Codigo_Morse.put('F', "..-.");
        a_Codigo_Morse.put('G', "--.");
        a_Codigo_Morse.put('H', "....");
        a_Codigo_Morse.put('I', "..");
        a_Codigo_Morse.put('J', ".---");
        a_Codigo_Morse.put('K', "-.-");
        a_Codigo_Morse.put('L', ".-..");
        a_Codigo_Morse.put('M', "--");
        a_Codigo_Morse.put('N', "-.");
        a_Codigo_Morse.put('O', "---");
        a_Codigo_Morse.put('P', ".--.");
        a_Codigo_Morse.put('Q', "--.-");
        a_Codigo_Morse.put('R', ".-.");
        a_Codigo_Morse.put('S', "...");
        a_Codigo_Morse.put('T', "-");
        a_Codigo_Morse.put('U', "..-");
        a_Codigo_Morse.put('V', "...-");
        a_Codigo_Morse.put('W', ".--");
        a_Codigo_Morse.put('X', "-..-");
        a_Codigo_Morse.put('Y', "-.--");
        a_Codigo_Morse.put('Z', "--..");
        a_Codigo_Morse.put('1', ".----");
        a_Codigo_Morse.put('2', "..---");
        a_Codigo_Morse.put('3', "...--");
        a_Codigo_Morse.put('4', "....-");
        a_Codigo_Morse.put('5', ".....");
        a_Codigo_Morse.put('6', "-....");
        a_Codigo_Morse.put('7', "--...");
        a_Codigo_Morse.put('8', "---..");
        a_Codigo_Morse.put('9', "----.");
        a_Codigo_Morse.put('0', "-----");
        a_Codigo_Morse.put('.', ".-.-.-");
        a_Codigo_Morse.put(',', "--..--");
        a_Codigo_Morse.put('?', "..--..");

    }

    @Override
    public void run() {

        try {
            a_Buzon.a_SemaforoConsumidor.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        l_word = a_Buzon.get_Productor();
        System.out.println(l_word);
        System.out.print(l_word+": ");

        // Traducir cada caracter de la palabra a Morse
        StringBuilder l_palabra_morse = new StringBuilder();
        for (char l_letra : l_word.toCharArray()) {
            String l_letra_morse = a_Codigo_Morse.get(l_letra);
            l_palabra_morse.append(l_letra_morse).append(" ");
        }

        // Mostramos por pantalla la palabra traducida
        System.out.println(l_palabra_morse);

        a_Buzon.a_SemaforoProductor.release();
    }




}
