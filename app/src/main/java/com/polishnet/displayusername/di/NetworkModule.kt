package com.polishnet.displayusername.di

import android.content.Context
import com.polishnet.displayusername.data.DisplayUserNameRepositoryImpl
import com.polishnet.displayusername.data.DisplayUserPreference
import com.polishnet.displayusername.data.Preference
import com.polishnet.displayusername.domain.DisplayUserNameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    /**
     * provide DisplayUserNamePreferenceDataStore
     */
    @Provides
    @Singleton
    fun provideDisplayUsernamePreferenceDatastore(@ApplicationContext context: Context): Preference {
        return DisplayUserPreference(context)
    }

    /**
     * provide the displayUserNameRepository
     */
    @Provides
    @Singleton
    fun provideDisplayUserNameRepository(displayUsernamePreferenceLocalDataSource: Preference):DisplayUserNameRepository {
        return DisplayUserNameRepositoryImpl(displayUsernamePreferenceLocalDataSource)
    }
}