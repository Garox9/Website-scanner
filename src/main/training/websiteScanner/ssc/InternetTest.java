package main.training.websiteScanner.ssc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class InternetTest {

    private static String LattestArticleHeadline;

    public static void main(String[] args) {

        while (true) {

            try {
                URL url = new URL("http://debukkitsblog.blogspot.com");
                Scanner s = new Scanner(url.openStream(), "UTF-8");
                while (s.hasNextLine()) {

                    String line = s.nextLine();

                    if (line.contains("JAVA Leistungskurs #")) {

                        if (!line.equals(LattestArticleHeadline)) {
                            sendMeEmailOrSomething(line);
                            LattestArticleHeadline = line;
                        }
                        break;
                    }
                }
                s.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("\nSeite wurde untersucht");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){ }
        }
    }
    private static void sendMeEmailOrSomething (String input) {
        System.out.println("Ein neues Tutorial ist erschienen");
        String output = input.substring(input.indexOf(">") + 1,input.lastIndexOf("<"));
        System.out.println(output);
    }
}
