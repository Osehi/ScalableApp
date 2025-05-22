package com.polishnet.displayusername

import com.polishnet.displayusername.data.fakedata.FakeDisplayUsernameRepository
import com.polishnet.displayusername.di.NetworkModule
import com.polishnet.displayusername.domain.DisplayUserNameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class]
)
object FakeRepositoryModule {

    @Provides
    @Singleton
    fun provideFakeDisplayUsernameRepository() : DisplayUserNameRepository {
        return FakeDisplayUsernameRepository()
    }
}