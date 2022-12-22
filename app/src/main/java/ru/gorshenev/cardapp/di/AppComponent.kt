package ru.gorshenev.cardapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.gorshenev.cardapp.MainActivity
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

}