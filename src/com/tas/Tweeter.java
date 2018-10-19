package com.tas;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

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

    public void tweet(String message) throws TwitterException, IOException, FileNotFoundException
    {
        ArrayList<String> Strings;
        Strings = getStrings(new File("Z:\\code I'll never see again\\CryptoBOI\\src\\com\\tas\\lines.txt"));
        Status status = twitter.updateStatus(Strings.get(0));
        System.out.println("Hogaya bhai hogaya " + status.getText());
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