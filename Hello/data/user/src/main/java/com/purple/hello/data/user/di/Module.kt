package com.purple.hello.data.user.di

import com.purple.hello.data.user.UserRepository
import com.purple.hello.data.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface Module {

    @Binds
    fun bindsUserRepository(
        userRepositoryImpl: UserRepositoryImpl,
    ): UserRepository
}
