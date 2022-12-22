package ru.gorshenev.cardapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.gorshenev.cardapp.data.database.AppDataBase
import ru.gorshenev.cardapp.data.network.CardService
import ru.gorshenev.cardapp.data.repository.CardRepository
import ru.gorshenev.cardapp.data.repository.ICardRepository
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideDB(context: Context): AppDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java,
            AppDataBase.DB_NAME,
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Singleton
    @Provides
    fun provideRepository(
        api: CardService,
        dataBase: AppDataBase,
        executionDispatcher: CoroutineDispatcher
    ): ICardRepository {
        return CardRepository(api, dataBase, executionDispatcher)
    }
}