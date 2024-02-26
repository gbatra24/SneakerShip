package com.gagan.sneakership.di.modules

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.gagan.sneakership.data.local.AppDao
import com.gagan.sneakership.data.local.AppDatabase
import com.gagan.sneakership.data.local.CartItemEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AppModuleTest {

    private lateinit var appDao: AppDao
    private lateinit var appDatabase: AppDatabase

    @Before
    fun setUp(){
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        appDao = appDatabase.appDao()
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Test
    fun provideRemoteData_NotNull() {
        val remoteData = AppModule.provideRemoteData()
        Assert.assertNotNull(remoteData)
    }

    @Test
    fun provideRepository_NotNull() {
        val repo = AppModule.provideRepository(AppModule.provideRemoteData(), appDatabase)
        Assert.assertNotNull(repo)
    }

    @Test
    fun writeAndReadCart() = runBlocking {
        val item = CartItemEntity(0, "url",
            2000, "title")
        appDao.insertCartItem(item)

        val result = appDao.getCartItems()

        Assert.assertEquals(1, result.size)
    }
}