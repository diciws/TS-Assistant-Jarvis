package io.jarvis.chatsystem.bot;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import io.jarvis.chatsystem.chat.chat;

import java.util.ArrayList;
import java.util.logging.Level;

//*------------[Jarvis]------------
//* by ZentornoLP and dici
//* TODO:
//* #

public class jarvis {

    public static final TS3Config config = new TS3Config();
    public static final TS3Query query = new TS3Query(config);
    public static final TS3Api api = query.getApi();
    public static final ArrayList<String> words = new ArrayList<String>();


    public static void main(String[] args) {
        System.out.println("------------------[\033Jarvis0m]------------------");
        System.out.println("Start \033Jarvis0m ...");
        System.out.println("________________________________________");
        System.out.println(" ");
        System.out.println("Version: 32m[v1.0]0m");
        System.out.println("Updates: http://github.com/diciws");
        System.out.println("________________________________________");
        System.out.println(" ");
        System.out.println("Starting Jarvis-System...");
        System.out.println("Connecting to IP...");
        config.setHost("tntfreaks.de");

        query.connect();
        //api.login("Jarvis", "passwd");
        api.login("serveradmin", "passwd");
        api.selectVirtualServerById(1);
        api.setNickname("Jarvis");
        config.setDebugLevel(Level.OFF);
        System.out.println("Connected to Server!");
        System.out.println("Nickname set '\033Jarvis0m'");
        System.out.println("Loading Files...");
        chat.start();
        System.out.println("32mAll Files enabled!\033");
        System.out.println(" ");
        System.out.println("Success, \033[1mSYSTEM\033[0m connected");
        System.out.println("------------------[\033Jarvis0m]------------------");

    }

}