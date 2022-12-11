package com.example.love5_2.di

import android.content.Context
import androidx.room.Room
import com.example.love5_2.Prefs
import com.example.love5_2.model.LoveApi
import com.example.love5_2.room.AppDataBase
import com.example.love5_2.room.HistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase {

        return Room.databaseBuilder(context, AppDataBase::class.java, "database")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideHistoryDao(appDataBase: AppDataBase): HistoryDao {
        return appDataBase.historyDao()
    }
    @Singleton
    @Provides
    fun providePrefs(@ApplicationContext context: Context): Prefs {
        return Prefs(context)
    }

}