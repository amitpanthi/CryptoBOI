package com.tas;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Random;
import java.io.*;
import java.util.ArrayList;
import java.lang.Thread;

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
        while(true) {
            try {
                int number_of_iterations = 0;
                int random_number, encryption_selector;
                String original;
                ArrayList<String> Strings;
                ArrayList<String> Answers = new ArrayList<>();
                Strings = getStrings(new File("Z:\\code I'll never see again\\CryptoBOI\\src\\com\\tas\\lines.txt"));

                Random RNG = new Random();
                random_number = RNG.nextInt(Strings.size());
                encryption_selector = RNG.nextInt(4);

                switch (encryption_selector) {
                    case 0:
                        String jack = "";
                        HillCipher hill = new HillCipher();
                        original = Strings.get(random_number);
                        jack = hill.encryption(original, 3);
                        Status status = twitter.updateStatus("Hill Encrypted text: " + jack);
                        System.out.println("Successfully tweeted " + status.getText());
                        Answers.add(original);
                        break;

                    case 1:
                        String chhoo = "";
                        Railfence rail = new Railfence();
                        original = Strings.get(random_number);
                        chhoo = rail.encryption(original, 3);
                        status = twitter.updateStatus("Railfence encrypted text: " + chhoo);
                        System.out.println("Successfully tweeted " + status.getText());
                        Answers.add(original);
                        break;

                    case 2:
                        String sirens = "";
                        Base64_op base = new Base64_op();
                        original = Strings.get(random_number);
                        sirens = base.encryption(original);
                        status = twitter.updateStatus("Base64 encrypted text: " + sirens);
                        System.out.println("Successfully tweeted " + status.getText());
                        Answers.add(original);
                        break;

                    case 3:
                        String caesar_e = "";
                        Caesar caes = new Caesar();
                        original = Strings.get(random_number);
                        caesar_e = caes.encryption(original, 3);
                        status = twitter.updateStatus("Caesar encrypted text: " + caesar_e);
                        System.out.println("Successfully tweeted " + status.getText());
                        Answers.add(original);
                        break;
                }

                try {
                    Thread.sleep(900000);
                    twitter.updateStatus("Answer to the last cipher is: " + Answers.get(number_of_iterations));
                    Thread.sleep(60000);
                    number_of_iterations++;
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            catch (TwitterException t)
            {
                t.toString();
            }
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