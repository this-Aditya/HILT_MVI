# HILT_MVI

HILT_MVI is an Android application that demonstrates the use of Hilt for dependency injection and follows the MVI (Model-View-Intent) pattern. It fetches user data from the [JSONPlaceholder API](https://jsonplaceholder.typicode.com/users), stores it in a local Room database, and displays the users in an activity.

## Features

- Dependency injection using Hilt
- Network call to fetch user data from JSONPlaceholder API
- Local storage of user data using Room database
- MVI architecture for improved separation of concerns

## Libraries Used

- Hilt: For dependency injection
- Retrofit: For network communication
- Room: For local database storage
- Coroutines: For asynchronous programming
- LiveData: For observing data changes
- ViewModel: For managing UI-related data in a lifecycle-aware manner

## Installation

1. Clone the repository: `git clone https://github.com/this-Aditya/HILT_MVI.git`
2. Open the project in Android Studio.
3. Build the project to install the app on your device or emulator.

## Usage

1. Launch the app on your device or emulator.
2. The app will fetch user data from the JSONPlaceholder API and store it in the local database.
3. The user data will be displayed in the main activity.
4. You can interact with the user list, such as scrolling and selecting individual users for more details.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please create a new issue or submit a pull request.

## Credits

The HILT_MVI app is developed by [Aditya Mishra](https://github.com/this-Aditya).
