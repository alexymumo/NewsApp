# NewsApp
This app consumes the news.org Api to fetch and display news, The app uses the Model View ViewModel architecture to allow separation of the application components

</br>
Minimum API level supported: 21
</br> 
Build System: [Gradle](https://gradle.org/)

### Prequisite
To run the project have the following tools
* Android Studio 4.0 or above

### Architecture
The app is build with MVVM architecture to allow separation of concerns to allow data not to be destroyed over configuration changes
<img src="assets/mvvm_architecture.png" width="280">

### Libraries
* [Jetpack](https://developer.android.com/jetpack)
* [Navigation Components](https://developer.android.com/guide/navigation/navigation-getting-started) - provides simple navigation across the app 
* [Koin] - Light weight dependency injection library
* [Gson] - Convert JSON to Java/Kotlin objects
* [Room] - Persistence library build ontop of Sqlite
* [Retrofit] - A Type-safe HTTP client for android and java to consumes REST apis
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI related data in a lifecycle concious way
* [View Binding](https://developer.android.com/topic/libraries/data-binding) - Jetpack library for binding with views
* [OkHttp-logging-Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor) - Logs OkHttp network traffic
* [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library support for coroutines.

### Screenshots
