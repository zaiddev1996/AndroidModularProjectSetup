package health.dept.di.app

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import health.dept.navigation.MainActivityNavigation
import health.dept.navigation.MainActivityNavigationImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppNavigationModule {

    @Singleton
    @Provides
    fun provideModuleNavigator(): MainActivityNavigation = MainActivityNavigationImpl()
}