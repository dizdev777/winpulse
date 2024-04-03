plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.winpul.pulseinf.winpulseelite"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.winpul.pulseinf.winpulseelite"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation ("com.facebook.android:facebook-android-sdk:latest.release")
    implementation ("com.miui.referrer:homereferrer:1.0.0.6")
    implementation("com.google.errorprone:error_prone_annotations:2.23.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.appsflyer:af-android-sdk:6.12.4")

    implementation("androidx.navigation:navigation-compose:2.7.6")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-ads-identifier:18.0.1")
    implementation("com.onesignal:OneSignal:[5.1.2, 5.1.2]")
    implementation("com.airbnb.android:lottie:6.2.0")
    implementation("com.android.installreferrer:installreferrer:2.2")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.facebook.android:facebook-android-sdk:latest.release")
    implementation("com.squareup.okhttp3:mockwebserver:4.9.1")

}