package com.peeyoosh.core.data.di

import android.content.Context
import com.peeyoosh.core.domain.usecase.PreferenceUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SimpleModule {

    @Provides
    @Singleton
    fun providePreferenceUseCase(@ApplicationContext context: Context): PreferenceUseCase {
        return PreferenceUseCase(context)
    }
}