# NewsApp
Is an android application that consumes the news.org Api to fetch and display news, The app uses the Model View ViewModel architecture to allow separation of the application components
It has been built using MVVM architecture and Jetpack components

</br>
Minimum API level supported: 21 [Supports Over 87% Devices](https://developer.android.com/about/dashboards)
 
Build System: [Gradle](https://gradle.org/)

## Table of Contents
- [Prerequisite](#prerequisite)
- [Architecture](#architecture)
- [Libraries](#libraries)
- [Screenshots](#screenshots)

## Prerequisite
To run the project have the following tools
* Android Studio 4.0 or above
* Clone the here [clone]("link here")/[fork]("here")
## Architecture
* The app is build with MVVM architecture to allow separation of concerns to allow data not to be destroyed over configuration changes
<img src="assets/mvvm_architecture.png">

## Libraries
Libraries used in the whole application are:

* [Jetpack](https://developer.android.com/jetpack)
* [Navigation Components](https://developer.android.com/guide/navigation/navigation-getting-started) - provides simple navigation across the app 
* [Koin](https://insert-koin.io/) - Light weight dependency injection library
* [Gson](https://github.com/square/gson) - Convert JSON to Java/Kotlin objects
* [Room](https://developer.android.com/codelabs/android-room-with-a-view) - Persistence library build ontop of Sqlite
* [Retrofit](https://square.github.io/retrofit/) - A Type-safe HTTP client for android and java to consumes REST apis
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI related data in a lifecycle concious way
* [View Binding](https://developer.android.com/topic/libraries/data-binding) - Jetpack library for binding with views
* [OkHttp-logging-Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor) - Logs OkHttp network traffic
* [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library support for coroutines.
* [Glide]("https://Glide.com/") - Image library
* [Material Design](https://material.io/develop/android/docs/getting-started/) - Build awesome beautiful UIs.
## Screenshots
