package com.example.gabrielepanarello.viewpager.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriele Panarello on 14/03/2018.
 */

public class MainSingleton {

    private static MainSingleton ourInstance = new MainSingleton();
    private static List<Contact> contactsList;

    public static MainSingleton getInstance(){
        return ourInstance;
    }

    private MainSingleton(){
        List<Contact> contactList = new ArrayList<Contact>();
    }

    public static List<Contact> getItemList() {
        return contactsList;
    }

    public static void setContactList(List<Contact> singleContactList) {
        contactsList = singleContactList;
    }

}
