package com.polishnet.displayusername.di

import com.polishnet.displayusername.domain.usecase.GetUsernameUseCase
import com.polishnet.displayusername.domain.usecase.GetUsernameUseCaseInterface
import com.polishnet.displayusername.domain.usecase.SaveUsernameUseCase
import com.polishnet.displayusername.domain.usecase.SaveUsernameUseCaseInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetUsernameUseCase(
        getUsernameUseCase: GetUsernameUseCase
    ): GetUsernameUseCaseInterface

    @Binds
    abstract fun bindSaveUsernameUseCase(
        saveUsernameUseCase: SaveUsernameUseCase
    ): SaveUsernameUseCaseInterface
}