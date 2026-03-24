# Cross-Platform Mobile Test Automation Framework 📱🚀

This repository contains a robust, cross-platform mobile test automation framework built to test the [Sauce Labs "My Demo App"](https://github.com/saucelabs/my-demo-app-rn) (React Native) on both **Android** and **iOS** platforms using a single, unified codebase.

## 🛠 Tech Stack

* **Language:** Java 21
* **Automation Tool:** Appium 2.x (UIAutomator2 for Android, XCUITest for iOS)
* **Testing Framework:** TestNG
* **Design Pattern:** Page Object Model (POM) with `@AndroidFindBy` and `@iOSXCUITFindBy`
* **Reporting:** Allure Report

## ✨ Key Features

* **Write Once, Run Anywhere:** Utilizes Appium's `AppiumFieldDecorator` to handle platform-specific locators (Accessibility IDs, XPaths) within the same Page Object classes.
* **Automated App Management:** The framework automatically installs and launches the `.apk` or `.app` build on the target emulator/simulator before test execution.
* **Smart Waiting:** Implemented explicit waits (WebDriverWait) in a `BasePage` to ensure stable element interactions and handle rendering delays.
* **Rich Reporting:** Integrated with Allure to provide detailed HTML test reports, including automatic screenshot capture on test failures.

## 📋 Prerequisites

Before running the tests, ensure you have the following installed and configured on your machine (macOS recommended for iOS testing):

1.  **Java JDK:** Version 11 or higher (Java 21 used in this project).
2.  **Node.js & npm:** Required to install Appium.
3.  **Appium Server 2.x:** Installed globally via npm (`npm install -g appium`).
4.  **Appium Drivers:**
    * `appium driver install uiautomator2` (Android)
    * `appium driver install xcuitest` (iOS)
5.  **Android Studio:** With a configured Virtual Device (Emulator).
6.  **Xcode:** With a configured iOS Simulator.
7.  **Allure Commandline:** Installed via Homebrew (`brew install allure`).

## ⚙️ Setup & Configuration

1. **Clone the repository:**
   ```bash
   git clone <your-repository-url>