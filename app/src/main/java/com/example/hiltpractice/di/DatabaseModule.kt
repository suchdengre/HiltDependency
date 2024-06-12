package com.example.hiltpractice.di

import android.content.Context
import androidx.room.Room
import com.example.hiltpractice.db.ProductDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesProductDb(@ApplicationContext context: Context):ProductDb{
       return Room.databaseBuilder(context,ProductDb::class.java,"ProductDB1").allowMainThreadQueries().build()
    }
}