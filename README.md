
# Rick and Morty App
This android app lists rick and morty characters, series episodes and planets.

<img src="https://github.com/emirkarabey/PagingExample/blob/master/screens/rickandmorty.jpg" height="128" width="128" >

# App Gif
![rickandmorty](https://user-images.githubusercontent.com/63194364/177038743-d9a0f6f0-cecc-40c6-a139-2dd248bae9f9.gif)


# Screens
<img src="https://github.com/emirkarabey/RickAndMortyApp/blob/master/screens/character.png" align="left" height="700" width="400" >
<img src="https://github.com/emirkarabey/RickAndMortyApp/blob/master/screens/episode.png" height="700" width="400" >
<img src="https://github.com/emirkarabey/RickAndMortyApp/blob/master/screens/location.png" align="left" height="700" width="400" >
<img src="https://github.com/emirkarabey/RickAndMortyApp/blob/master/screens/menu.png" height="700" width="400" >

# Implementations
You can find following apis implementation in this project.

<ul>
<li>Paging</li>
<li>Hilt</li>
<li>Coroutines</li>
<li>Retrofit</li>
<li>Gson converter</li>
<li>Glide</li>
<li>View Model</li>
<li>Live Data</li>
<li>MVVM</li>
</ul>

# Features
<ul>
<li>Pull data from rick and morty api</li>
<li>Listing characters, episodes, locations.</li>
<li>Uses view model and live data</li>
</ul>




# Libraries Used

* [Architecture][10] - Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [lifecycle][22] - As a user navigates through, out of, and back to your app, the Activity instances in your app transition through different states in their lifecycle.
  * [ViewModel][17] - Easily schedule asynchronous tasks for optimal execution.
  * [livedata][52] - is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
  * [Coroutines][51] - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.



* [UI][30] - Details on why and how to use UI Components in your apps - together or separate
  * [Layout][35] - Lay out widgets using different algorithms.

* Third party and miscellaneous libraries
  * [Retrofit][90] for turns your HTTP API into a Java interface
  * [Glide][94] for image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.
  * [Paging][95] The Paging library helps you load and display pages of data from a larger dataset from local storage or over network.
  * [Hilt][96] Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
  




[11]: https://developer.android.com/topic/libraries/view-binding
[52]: https://developer.android.com/topic/libraries/architecture/livedata
[50]: https://developer.android.com/topic/libraries/architecture/navigation/
[10]: https://developer.android.com/jetpack/compose/architecture
[17]: https://developer.android.com/jetpack/compose/state#viewmodel-state
[30]: https://developer.android.com/guide/topics/ui
[34]: https://developer.android.com/guide/components/fragments
[35]: https://developer.android.com/guide/topics/ui/declaring-layout
[22]: https://developer.android.com/guide/components/activities/activity-lifecycle
[18]: https://developer.android.com/jetpack/guide#fetch-data
[90]: https://square.github.io/retrofit/
[94]: https://github.com/bumptech/glide
[53]: https://developer.android.com/jetpack/androidx/releases/room
[54]: https://developer.android.com/jetpack/androidx/releases/sqlite
[55]: https://developer.android.com/reference/android/widget/GridLayout
[56]: https://developer.android.com/training/swipe/add-swipe-interface
[51]: https://developer.android.com/kotlin/coroutines
[13]: https://developer.android.com/topic/libraries/data-binding
[96]: https://developer.android.com/training/dependency-injection/hilt-android
