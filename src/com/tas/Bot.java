package com.tas;

import twitter4j.TwitterException;
import java.io.IOException;
import java.io.PrintStream;

public class Bot
{
    private static PrintStream consolePrint;

    public static void main(String[] args) throws TwitterException, IOException
    {
        try {
            Tweeter birb = new Tweeter(consolePrint);
            birb.tweet();
        }
        catch (TwitterException t)
        {
            t.toString();
        }
    }
}
