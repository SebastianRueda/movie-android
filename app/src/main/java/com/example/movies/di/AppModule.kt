package com.example.movies.di

import com.example.movies.BuildConfig
import com.example.movies.data.remotedatasource.RemoteDataSource
import com.example.movies.data.remotedatasource.themoviedb.TheMovieDBDataSource
import com.example.movies.data.repositories.MoviesRepository
import com.example.movies.data.repositories.MoviesRepositoryImpl
import com.example.movies.data.usecases.GetMovieDetailUseCase
import com.example.movies.data.usecases.GetPopularMoviesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    @Named("apiKey")
    fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient(Android) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(moviesRepository: MoviesRepository): GetPopularMoviesUseCase =
        GetPopularMoviesUseCase(moviesRepository)

    @Provides
    @Singleton
    fun provideGetMovieDetailUseCase(moviesRepository: MoviesRepository): GetMovieDetailUseCase =
        GetMovieDetailUseCase(moviesRepository)

    @Provides
    @Singleton
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun provideMovieRepositoryImpl(remoteDataSource: RemoteDataSource, dispatcher: CoroutineDispatcher): MoviesRepositoryImpl =
        MoviesRepositoryImpl(remoteDataSource, dispatcher)

    @Provides
    @Singleton
    fun provideTheMovieDBDataSource(httpClient: HttpClient, @Named("apiKey") apiKey: String): TheMovieDBDataSource =
        TheMovieDBDataSource(httpClient, apiKey)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class MoviesRepositoryModule {
    @Binds
    abstract fun bindMoviesRepository(moviesRepository: MoviesRepositoryImpl): MoviesRepository
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun bindTheMovieDB(theMovieDBDataSource: TheMovieDBDataSource): RemoteDataSource
}