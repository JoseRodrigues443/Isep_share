/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1150825.networkingTools.domain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import lapr4.blue.s2.ipc.n1150433.networkAnalizer.domain.TrafficAnalizer;

/**
 *
 * @author João Coelho
 * Edited by Débora Costa 1150433
 */
public class SecureCommunication {

    static private int num[];
    static private Object message = "";

    /**
     *
     */
    static protected final String ENCRYPTION_KEY = "pterodactilo";

    /**
     *
     */
    static protected final int NUMCODE = 562;

    /**
     * EDITED by Débora Costa (1150433) added the secure outgoing traffic counter
     * 
     * In the case of an Object it returns an array of bytes
     * In the case of a String it returns a String
     * 
     * @param message
     * @return
     * @throws IOException
     */
    public Object enCrypt(Object message) throws IOException {
        if (message instanceof String) {
            this.message = (String) message;
            num = new int[((String) message).length()];
            TrafficAnalizer.secureOutgoing();
            return numberEncryption();
        } else {
            this.message = message;
            TrafficAnalizer.secureOutgoing();
            return keyEncryption();
        }
    }

    /**
     * EDITED by Débora Costa (1150433) added the secure incoming traffic counter
     * 
     * It receives an Object String and returns a String
     * 
     * @param message
     * @param num
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deCrypt(Object message, int[] num) throws IOException, ClassNotFoundException {
        this.message = message;
        this.num = num;
        TrafficAnalizer.secureIncoming();
        return (String) keyDecryption();
    }
    
    /**
     * EDITED by Débora Costa (1150433) added the secure incoming traffic counter
     * 
     * It receives a byte array and returns a Object
     * 
     * @param message
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deCrypt(Object message) throws IOException, ClassNotFoundException {
        this.message = message;
        TrafficAnalizer.secureIncoming();
        return keyDecryption();
    }

    /**
     *
     * @return
     */
    public int[] keyNum() {
        return num;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    protected static String numberEncryption() throws IOException {
        System.out.println("");
        System.out.println("Início encriptaNumero");
        System.out.println("");
        char ch[] = ((String) message).toCharArray();
        String temporary = "";
        for (int i = 0; i < ((String) message).length(); i++) {
            int temp = ch[i];
            num[i] = (int) (Math.random() * 255) + 1;
            char c = (char) ((temp + num[i]) % 256);
            System.out.println("c " + c);
            ch[i] = c;
            System.out.println("mensagem ");

            for (int j = 0; j < ((String) message).length(); j++) {
                System.out.print(ch[j]);
            }
            System.out.println("");
            temporary += ch[i];
        }
        System.out.println(temporary);
        System.out.println("");
        message = temporary;
        orderTrade();
        return (String) keyEncryption();
    }

    /**
     *
     */
    protected static void orderTrade() {
        System.out.println("");
        System.out.println("Início trocaTransposição");
        System.out.println("");
        char ch[] = ((String) message).toCharArray();
        int size = ((String) message).length() / 4;
        int middle = size * 2 + 1;
        int last = ((String) message).length();
        if (((String) message).length() % 4 == 0) {
            middle -= 1;
        }
        System.out.println("size " + size + " middle " + middle + " last " + last);
        char temp;
        String temporaria = "";
        for (int i = 0; i < size; i++) {
            temp = ch[middle - 1 - i];
            ch[middle - 1 - i] = ch[i];
            ch[i] = temp;
            temp = ch[middle + i];
            ch[middle + i] = ch[last - 1 - i];
            ch[last - 1 - i] = temp;
            System.out.println("Sequência " + i + " atual: ");
            for (int j = 0; j < ((String) message).length(); j++) {
                System.out.print(ch[j]);
            }
            System.out.println("");
        }
        for (int i = 0; i < ((String) message).length(); i++) {
            temporaria += ch[i];
        }
        System.out.println(temporaria);
        System.out.println("");
        message = temporaria;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    protected static Object keyEncryption() throws IOException {
        System.out.println("");
        System.out.println("Início encriptaChave");
        System.out.println("");
        int count = 0;
        // convert secret text to byte array
        byte[] secret;
        if (message instanceof String) {
            secret = ((String) message).getBytes(StandardCharsets.ISO_8859_1);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos);
            try {
                out.writeObject(message);
                out.flush();
                secret = bos.toByteArray();
            } finally {
                bos.close(); // ignore close exception
            }
        }
        byte[] encoded = new byte[secret.length];

        // Generate key (has to be exchanged)
        byte[] key = ENCRYPTION_KEY.getBytes();

        // Encrypt
        for (int i = 0; i < secret.length; i++) {
            encoded[i] = (byte) (secret[i] ^ key[count]);
            if (count >= key.length - 1) {
                count = 0;
            } else {
                count++;
            }
        }
        if (message instanceof String) {
            message = new String(encoded, StandardCharsets.ISO_8859_1);
            keyNumberEncryption();
            return (String) message;
        } else {
            return encoded;
        }
    }

    /**
     *
     */
    protected static void keyNumberEncryption() {
        for (int i = 0; i < num.length; i++) {
            num[i] += NUMCODE;
        }
    }

    /**
     *
     * @return
     */
    protected static String numberDecryption() {
        System.out.println("");
        System.out.println("Início desencriptaNumero");
        System.out.println("");
        char ch[] = ((String) message).toCharArray();
        String temporaria = "";
        for (int i = 0; i < ((String) message).length(); i++) {
            int temp = ch[i];
            char c;
            if (temp - num[i] <= 0) {
                c = (char) (temp - num[i] + 256);
            } else {
                c = (char) (temp - num[i]);
            }
            System.out.println("c " + c);
            ch[i] = c;
            System.out.println("mensagem ");
            for (int j = 0; j < ((String) message).length(); j++) {
                System.out.print(ch[j]);
            }
            System.out.println("");
            temporaria += ch[i];
        }
        System.out.println(temporaria);
        System.out.println("");
        message = temporaria;
        return (String) message;
    }

    /**
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    protected static Object keyDecryption() throws IOException, ClassNotFoundException {
        System.out.println("");
        System.out.println("Início desencriptaChave");
        System.out.println("");
        int count = 0;
        byte[] encoded;
        if (message instanceof String) {
            encoded = ((String) message).getBytes(StandardCharsets.ISO_8859_1);
        } else {
            encoded = (byte[]) message;
        }
        byte[] decoded = new byte[encoded.length];
        byte[] key = ENCRYPTION_KEY.getBytes();

        // Decrypt
        for (int i = 0; i < encoded.length; i++) {
            decoded[i] = (byte) (encoded[i] ^ key[count]);
            if (count >= key.length - 1) {
                count = 0;
            } else {
                count++;
            }
        }
        if (message instanceof String) {
            message = new String(decoded, StandardCharsets.ISO_8859_1);
            keyNumberDecryption();
            orderTrade();
            return numberDecryption();
        } else {
            ByteArrayInputStream bis = new ByteArrayInputStream(decoded);
            ObjectInput in = null;
            try {
                in = new ObjectInputStream(bis);
                message = in.readObject();
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ex) {
                    // ignore close exception
                }
            }
            return message;
        }
    }

    /**
     *
     */
    protected static void keyNumberDecryption() {
        for (int i = 0; i < num.length; i++) {
            num[i] -= NUMCODE;
        }
    }

}
