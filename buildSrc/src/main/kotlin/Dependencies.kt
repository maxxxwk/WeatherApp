object Versions {
    const val compileSdk = 33
    const val minSdk = 21
    const val targetSdk = 33

    const val kotlinCompilerExtensionVersion = "1.4.0"

    const val lifecycle = "2.5.1"

    const val composeUI = "1.3.3"
    const val composeActivity = "1.6.1"
    const val composeMaterial = "1.3.1"
    const val composeNavigation = "2.5.3"

    const val junit = "4.13.2"
    const val junit_android = "1.1.5"

    const val immutableCollections = "0.3.5"

    const val dagger = "2.44.2"

    const val okHttp = "4.10.0"

    const val kotlinxSerialization = "1.4.1"

    const val retrofit = "2.9.0"
    const val kotlinxSerializationConverter = "0.8.0"

    const val coil = "2.2.2"

    const val androidGradlePlugin = "7.4.0"
    const val kotlin = "1.8.0"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kapt = "kapt"
    const val serialization = "plugin.serialization"
}

object Libraries {
    const val viewmodel_ktx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val viewmodel_compose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"

    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val composeUI = "androidx.compose.ui:ui:${Versions.composeUI}"
    const val composeUIToolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${Versions.composeUI}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterial}"
    const val composeNavigation =
        "androidx.navigation:navigation-compose:${Versions.composeNavigation}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"

    const val immutableCollections =
        "org.jetbrains.kotlinx:kotlinx-collections-immutable:${Versions.immutableCollections}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val kotlinxSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val kotlinxSerializationConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.kotlinxSerializationConverter}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
}

object AndroidTestLibraries {
    const val junit = "androidx.test.ext:junit:${Versions.junit_android}"
    const val junitCompose = "androidx.compose.ui:ui-test-junit4:${Versions.composeUI}"
}

object DebugLibraries {
    const val composeUITooling = "androidx.compose.ui:ui-tooling:${Versions.composeUI}"
    const val composeUITestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeUI}"
}

object KaptCompilers {
    const val dagger = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}
