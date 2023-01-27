object Versions {
    const val compileSdk = 33
    const val minSdk = 21
    const val targetSdk = 33

    const val kotlinCompilerExtensionVersion = "1.4.0"

    const val lifecycle = "2.5.1"

    const val composeUI = "1.3.3"
    const val composeActivity = "1.6.1"
    const val composeMaterial = "1.3.1"

    const val junit = "4.13.2"
    const val junit_android = "1.1.5"

    const val androidGradlePlugin = "7.4.0"
    const val kotlin = "1.8.0"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
}

object Libraries {
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val composeUI = "androidx.compose.ui:ui:${Versions.composeUI}"
    const val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeUI}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterial}"
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
