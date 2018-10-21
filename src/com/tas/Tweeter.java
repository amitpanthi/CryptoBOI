package com.tas;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Random;
import java.io.*;
import java.util.ArrayList;

public class Tweeter
{
    private Twitter twitter;
    private PrintStream consolePrint;
    private ArrayList<Status> statuses;

    public Tweeter(PrintStream console)
    {
        twitter = TwitterFactory.getSingleton();
        consolePrint = console;
        statuses = new ArrayList<Status>();
    }

    public void tweet() throws TwitterException, IOException, FileNotFoundException
    {
        try{
            int random_number, encryption_selector;
            ArrayList<String> Strings;
            Strings = getStrings(new File("Z:\\code I'll never see again\\CryptoBOI\\src\\com\\tas\\lines.txt"));

            Random RNG = new Random();
            random_number = RNG.nextInt(Strings.size());
            encryption_selector = RNG.nextInt(4);

            switch(encryption_selector) {
                case 0:
                    String jack = "";
                    HillCipher hill = new HillCipher();
                    jack = hill.encryption(Strings.get(random_number), 3);
                    Status status = twitter.updateStatus("Hill Encrypted text: " + jack);
                    System.out.println("Hogaya bhai hogaya " + status.getText());
                    break;

                case 1:
                    String chhoo = "";
                    Railfence rail = new Railfence();
                    chhoo = rail.encryption(Strings.get(random_number), 3);
                    status = twitter.updateStatus("Railfence encrypted text: " + chhoo);
                    System.out.println("Hogaya bhai hogaya " + status.getText());
                    break;

                case 2:
                    String sirens = "";
                    Base64_op base = new Base64_op();
                    sirens = base.encryption(Strings.get(random_number));
                    status = twitter.updateStatus("Base64 encrypted text: " + sirens);
                    System.out.println("Hogaya bhai hogaya " + status.getText());
                    break;

                case 3:
                    String caesar_e = "";
                    Caesar caes = new Caesar();
                    caesar_e = caes.encryption(Strings.get(random_number), 3);
                    status = twitter.updateStatus("Caesar encrypted text: " + caesar_e);
                    System.out.println("Hogaya bhai hogaya " + status.getText());
                    break;
            }
        }

        catch (TwitterException t)
        {
            t.toString();
        }
    }

    public ArrayList<String> getStrings(File input)
    {
        ArrayList<String> Strings = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            String line = br.readLine();
            while(line != null)
            {
                Strings.add(line);
                line = br.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return Strings;
    }
}