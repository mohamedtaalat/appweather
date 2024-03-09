package com.example.msptask5.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.msptask5.ApiPackage.Current


@Database(entities = [Current::class], version = 1, exportSchema = false)
    abstract class BuildDatabase: RoomDatabase() {
        abstract fun dao():Dao

        companion object{
            @Volatile
            private var INSTANCE:BuildDatabase?=null
            fun getDatabase(context: Context):BuildDatabase{
                return INSTANCE ?: synchronized(this){
                    val instance= Room.databaseBuilder(
                        context.applicationContext,
                       BuildDatabase::class.java,
                        " User"
                    ).allowMainThreadQueries().fallbackToDestructiveMigration()
                        .build()
                    INSTANCE=instance
                    return instance
                }
            }


        }
    }
