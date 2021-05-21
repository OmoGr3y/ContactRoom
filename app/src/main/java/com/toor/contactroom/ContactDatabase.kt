package com.toor.contactroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.toor.contactroom.db.dao.ContactDao
import com.toor.contactroom.db.entities.ContactEntity


@Database(
    entities = [ContactEntity::class],
    version = 1
)
abstract class ContactDatabase : RoomDatabase() {

    abstract  fun  contactDao(): ContactDao

    companion object {
        @Volatile private var instance: ContactDatabase? = null
        private val LOCK = Any()

        operator fun invoke (context: Context)  = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            ContactDatabase::class.java, "contact.db").build()


    }

}