package health.dept.di.data

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import health.dept.local.LocalSource
import health.dept.local.LocalSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("health.dept.ecarecameroon", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideLocalSource(localSourceImpl: LocalSourceImpl): LocalSource = localSourceImpl
}