/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1140412.sendEmailSMS;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Tiago
 */
public class EmailSMSHandler {

    /**
     * Opens system default email app and loads the recipients, subject and body
     *
     * @param recipients
     * @param subject
     * @param body
     * @return boolean
     * @throws IOException
     * @throws URISyntaxException
     */
    public static boolean sendMail(List<String> recipients, String subject, String body) throws IOException, URISyntaxException {
        if (recipients.isEmpty() || body.isEmpty()) {
            return false;
        }
        String uriStr = String.format("mailto:%s?subject=%s&body=%s",
                join(",", recipients),
                urlEncode(subject),
                urlEncode(body));

        Desktop.getDesktop().mail(new URI(uriStr));
        saveEmailSMS("Email", recipients, subject, body);
        return true;
    }

    /**
     * Encodes a string
     *
     * @param str
     * @return
     */
    private static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Join strings
     *
     * @param sep
     * @param list
     * @return
     */
    private static String join(String sep, List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            if (sb.length() > 0) {
                sb.append(sep);
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    /**
     * Saves emails and SMS locally
     *
     * @param type
     * @param recipients
     * @param subject
     * @param body
     */
    public static void saveEmailSMS(String type, List<String> recipients, String subject, String body) throws IOException {

        String defaultpath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

        Path path = Paths.get(defaultpath + "/sentEmailsSMS.txt");
        FileWriter file;
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            file = new FileWriter(defaultpath + "/sentEmailsSMS.txt",true);
        } else {
            file = new FileWriter(new File(defaultpath + "/sentEmailsSMS.txt"));
        }
        String aux = "";
        for (String s : recipients) {
            aux += s + ",";
        }
        if (type.equals("Email")) {

            String save = type + ";" + aux + ";" + subject + ";" + body+"\n";
            file.append(save);
        } else {
            String save = type + ";" + aux + ";" + body+"\n";
            file.append(save);
        }
        file.close();

    }

    public static List<String> getSentMessages() {
        List<String> ret = new ArrayList<>();
        try {
            String defaultpath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            Scanner file = new Scanner(new FileReader(defaultpath + "/sentEmailsSMS.txt"));
            while(file.hasNext()){
            ret.add(file.next());
            }
            file.close();
        } catch (FileNotFoundException ex) {
            
        }
        return ret;
    }
}
