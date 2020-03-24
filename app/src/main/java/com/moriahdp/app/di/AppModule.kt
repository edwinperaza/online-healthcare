package com.moriahdp.app.di

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.moriahdp.app.URL_BASE_COVID_API
import com.moriahdp.app.util.AppPreferences
import com.moriahdp.app.data.remote.net.TaskService
import com.moriahdp.app.data.remote.source.TaskRemoteDataSource
import com.moriahdp.app.data.repository.implementation.TaskRepositoryImpl
import com.moriahdp.app.data.repository.interfaces.TaskRepository
import com.moriahdp.app.domain.usecase.GetAllTasksUseCase
import com.moriahdp.app.presentation.viewmodel.TaskViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    /* Android Services */
    single {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    /* Shared Preferences */
    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            AppPreferences.SHARED_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
    }

    /* OkHttp */
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    single {
        OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
//            .addInterceptor(ChuckInterceptor(androidContext()))
//            .addInterceptor(AuthInterceptor(AppPreferences))
//            .addInterceptor(RefreshAuthTokenInterceptor(AppPreferences))
            .addInterceptor(logging)
            .build()
    }

    /* Retrofit */
    single {
        Retrofit.Builder()
            .baseUrl("https://api.covid19api.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(TaskService::class.java) as TaskService }


    /* Database */
//    single {
//        Room.databaseBuilder(
//            androidApplication(),
//            AppDatabase::class.java,
//            DATABASE_NAME
//        ).fallbackToDestructiveMigration().build()
//    }

    /* Dao Interfaces */
    //factory { get<AppDatabase>().userDao() }

    /* DataSource */
    factory { TaskRemoteDataSource(get()) }

    /* Repositories */
    factory<TaskRepository> { TaskRepositoryImpl(get()) }

    /* View models */
    viewModel { TaskViewModel(get()) }

    /* UseCases */
    factory { GetAllTasksUseCase(get()) }

}
