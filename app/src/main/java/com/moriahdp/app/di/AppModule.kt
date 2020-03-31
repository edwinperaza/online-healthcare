package com.moriahdp.app.di

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.moriahdp.app.util.AppPreferences
import com.moriahdp.app.data.remote.net.CovidCountryService
import com.moriahdp.app.data.remote.source.CovidCountryRemoteDataSource
import com.moriahdp.app.data.repository.implementation.CovidCountryRepositoryImpl
import com.moriahdp.app.data.repository.interfaces.CovidCountryRepository
import com.moriahdp.app.domain.usecase.GetAllCovidCountryUseCase
import com.moriahdp.app.presentation.viewmodel.CovidCountryViewModel
import com.moriahdp.app.presentation.viewmodel.FeedViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
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

    single {
        Firebase.firestore
    }

    /* Retrofit */
    single {
        Retrofit.Builder()
            .baseUrl("https://api.covid19api.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(CovidCountryService::class.java) as CovidCountryService }


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
    factory { CovidCountryRemoteDataSource(get()) }

    /* Repositories */
    factory<CovidCountryRepository> { CovidCountryRepositoryImpl(get()) }

    /* View models */
    viewModel { CovidCountryViewModel(get()) }
    viewModel { FeedViewModel() }

    /* UseCases */
    factory { GetAllCovidCountryUseCase(get()) }

}
