# 🌍 Compose Multiplatform Learning Project

This repository is my personal Compose Multiplatform learning project. The goal is to deeply understand how to architect and develop shared code across Android, iOS, and potentially desktop/web platforms using **Compose Multiplatform**.

> 📌 This project follows the structure and guidance from **Philipp Lackner’s Compose Multiplatform YouTube course**. I plan to extended, customized, and annotated the code as part of my **hands-on learning experience**.


## 📚 Goals

- Learn **Compose Multiplatform** for building reactive UI across Android and Desktop
- Explore core libraries and patterns used in real-world apps:
  - **Koin** for dependency injection
  - **Room** for local persistence on Android
  - **Ktor** and **OkHttp** for networking
  - **Kotlinx Serialization** for data parsing
- Understand clean architecture layering within a Compose MP context


## 🏗️ Tech Stack

| Layer               | Technology            |
|--------------------|------------------------|
| UI                 | [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform) |
| Networking         | [Ktor](https://ktor.io/) (shared) + [OkHttp](https://square.github.io/okhttp/) (under the hood / Android) |
| Serialization      | [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization) |
| Persistence        | [Room (Android)](https://developer.android.com/jetpack/androidx/releases/room) |
| Dependency Injection | [Koin](https://insert-koin.io/) |
| Build              | Gradle (Kotlin DSL) |
| Platforms          | Android