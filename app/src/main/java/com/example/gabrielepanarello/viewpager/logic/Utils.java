package com.example.gabrielepanarello.viewpager.logic;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.gabrielepanarello.viewpager.R;
import com.example.gabrielepanarello.viewpager.data.Contact;
import com.example.gabrielepanarello.viewpager.data.MainSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriele Panarello on 14/03/2018.
 */

public class Utils {

    public static void init(){
        List<Contact> lsTmp = new ArrayList<Contact>();
        lsTmp.add(new Contact(01,"Mambo Losco","392123455"));
        lsTmp.add(new Contact(02,"Edo Fendi","3211234556"));
        MainSingleton.getInstance().setContactList(lsTmp);
    }

    public static List<Contact> getContactsList(){
        return MainSingleton.getInstance().getItemList();
    }

    public static void addContact (Contact contact){
        MainSingleton.getInstance().getItemList().add(contact);
    }

    public static void removeContact (int contactPosition){
        MainSingleton.getInstance().getItemList().remove(contactPosition);
    }

    public static int getColorForPosition(Context context, int position) {
        if (position % 2 == 0) {
            return context.getColor(R.color.light_blue);
        } else {
            return context.getColor(R.color.light_gray);
        }
    }

    public static void writeOnSharedPreferences(String number, Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("favourites",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("favourites_key",number);
        editor.commit();
    }

    public static String readOnSharedPreferences(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("favourites",Context.MODE_PRIVATE);
        return sharedPref.getString("favourites_key",null);
    }
}
