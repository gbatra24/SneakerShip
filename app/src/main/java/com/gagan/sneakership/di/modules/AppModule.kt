package com.gagan.sneakership.di.modules

import android.content.Context
import androidx.room.Room
import com.gagan.sneakership.data.local.AppDatabase
import com.gagan.sneakership.data.remote.RemoteData
import com.gagan.sneakership.data.repository.ProductsRepository
import com.gagan.sneakership.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRemoteData(): RemoteData {
        return RemoteData()
    }

    @Provides
    @Singleton
    fun provideRepository(remoteData: RemoteData, database: AppDatabase): Repository {
        return ProductsRepository(remoteData, database.appDao())
    }

    @Singleton
    @Provides
    fun provideSavedNewsDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        AppDatabase.PRODUCTS_DATABASE
    ).build()

    @Singleton
    @Provides
    fun provideSavedNewsDao(database: AppDatabase) = database.appDao()
}