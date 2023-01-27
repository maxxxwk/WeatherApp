@file:Suppress("UnstableApiUsage")

plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    kotlin(Plugins.kapt)
    kotlin(Plugins.serialization).version(Versions.kotlin)
}

android {
    namespace = "com.maxxxwk.weatherapp"
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.maxxxwk.weatherapp"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField(
            "String",
            "BASE_URL",
            "\"https://api.openweathermap.org/data/2.5/\""
        )
        buildConfigField(
            "String",
            "API_KEY",
            "\"809f4ed63f50a4fd859afbba5c7dfb74\""
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(Libraries.viewmodel_ktx)
    implementation(Libraries.viewmodel_compose)

    implementation(Libraries.composeActivity)
    implementation(Libraries.composeUI)
    implementation(Libraries.composeUIToolingPreview)
    implementation(Libraries.composeMaterial)
    implementation(Libraries.composeNavigation)

    implementation(Libraries.immutableCollections)

    implementation(Libraries.dagger)
    kapt(KaptCompilers.dagger)

    implementation(Libraries.okHttp)
    implementation(Libraries.okHttpLoggingInterceptor)

    implementation(Libraries.kotlinxSerialization)

    implementation(Libraries.retrofit)
    implementation(Libraries.kotlinxSerializationConverter)

    implementation(Libraries.coil)

    testImplementation(TestLibraries.junit)

    androidTestImplementation(AndroidTestLibraries.junit)
    androidTestImplementation(AndroidTestLibraries.junitCompose)

    debugImplementation(DebugLibraries.composeUITooling)
    debugImplementation(DebugLibraries.composeUITestManifest)
}
