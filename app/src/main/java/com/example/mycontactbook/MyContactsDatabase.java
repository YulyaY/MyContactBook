package com.example.mycontactbook;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {com.example.mycontactbook.Contact.class}, version = 1)
public abstract class MyContactsDatabase extends RoomDatabase {

    public abstract ContactDao getContactDao();

}
