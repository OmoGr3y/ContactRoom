package com.toor.contactroom.db.dao

import androidx.room.*
import com.toor.contactroom.db.entities.ContactEntity


@Dao
interface ContactDao {

    @Query("SELECT * FROM contact")
    fun selectAllContact(): List<ContactEntity>

    @Insert
    fun insertContacts(contactEntity: ContactEntity)


    @Delete
    fun deleteContact(contactEntity: ContactEntity)


    @Update
    fun updateContact(contactEntity: ContactEntity)
}