# Restaurant Menu App

## Overview
This app provides a menu-based interface for a restaurant, allowing users to view and order items from different categories like breakfast, lunch, snacks, and desserts. It includes a splash screen, a main menu, and specific sections for each category.

## Key Features
- **Splash Screen:** Displays for 5 seconds before transitioning to `MainActivity2`.
- **Main Menu:** Features buttons for navigating to Breakfast, Lunch, Snacks, and Desserts.
- **Category Screens:** Each category screen displays a list of items with prices and images. Users can add items to their order.
- **Order Summary:** Users can view their selected items and total price, and proceed to a checkout screen.

## Activities
- **`SplashScreen`:** Shows the splash screen and transitions to `MainActivity2`.
- **`MainActivity2`:** Displays main menu with navigation options for different food categories.
- **`Breakfast/Lunch/Snacks/Desserts`:** Displays a list of items with the ability to add/remove items from the cart and proceed to the payment screen.
- **`Bill`:** Shows a summary of the selected items and total amount.

## Key Classes
- **`MyListAdapter`:** Custom adapter for displaying items in a list view.
- **`MainActivity2`:** Main activity that provides navigation to different food categories.
- **`lunch`:** Activity for lunch items with item addition and subtraction functionality.
- **`snacks`:** Activity for snacks with similar functionality to the lunch activity.
- **`splash_screen`:** Handles the display of the splash screen and transitions to the main activity.

## Dependencies
- Android SDK

## How to Run
1. **Build and Run:** Open the project in Android Studio and build the app.
2. **Launch:** The app will start with the splash screen, followed by the main menu.

## Future Enhancements
- Add user authentication
- Implement a database for managing items and orders
