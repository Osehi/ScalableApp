package com.polishnet.displayusername.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.polishnet.displayusername.data.DisplayUserNameRepositoryImpl
import com.polishnet.displayusername.data.DisplayUserPreference
import com.polishnet.displayusername.data.DisplayUsernamePreferenceLocalDataSource
import com.polishnet.displayusername.data.Preference
import com.polishnet.displayusername.data.PreferenceConstant.DATASTORE_NAME
import com.polishnet.displayusername.data.PreferenceConstant.PREFERENCE_NAME
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
     *  provide preferenceDataStore
     */
    @Provides
    @Singleton
    fun providePreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile(PREFERENCE_NAME)
            }
        )

    }
    /**
     * provide displayUsernamePreferenceLocalDataStore
     */
    @Provides
    @Singleton
    fun providesDisplayUsernamePreferenceLocalDataSource(dataStore: DataStore<Preferences>): Preference {
        return DisplayUsernamePreferenceLocalDataSource(dataStore)
    }


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
    fun provideDisplayUserNameRepository(displayUsernamePreferenceLocalDataSource: DisplayUsernamePreferenceLocalDataSource):DisplayUserNameRepository {
        return DisplayUserNameRepositoryImpl(displayUsernamePreferenceLocalDataSource)
    }
}