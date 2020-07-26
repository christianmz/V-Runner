plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        applicationId = "com.meazza.v_runner"
        testInstrumentationRunner = "androidx.test.im_avatar.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree("libs") { include(listOf("*.jar")) })

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation("androidx.core:core-ktx:1.5.0-alpha01")
    implementation("androidx.appcompat:appcompat:1.3.0-alpha01")
    implementation("androidx.preference:preference:1.1.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.activity:activity-ktx:1.2.0-alpha07")
    implementation("androidx.fragment:fragment-ktx:1.3.0-alpha06")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta8")

    implementation("androidx.navigation:navigation-fragment-ktx:2.3.0")
    implementation("androidx.navigation:navigation-runtime-ktx:2.3.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.0")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0-alpha06")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.0-alpha06")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-alpha06")

    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")
    kapt("androidx.hilt:hilt-compiler:1.0.0-alpha02")

    implementation("com.google.dagger:hilt-android:2.28.3-alpha")
    kapt("com.google.dagger:hilt-android-compiler:2.28.3-alpha")

    implementation("com.google.android.gms:play-services-location:17.0.0")
    implementation("com.google.android.gms:play-services-maps:17.0.0")

    implementation("com.google.firebase:firebase-core:17.4.4")
    implementation("com.google.firebase:firebase-auth:19.3.2")
    implementation("com.google.firebase:firebase-storage:19.1.1")
    implementation("com.google.firebase:firebase-firestore:21.5.0")
    implementation("com.google.firebase:firebase-analytics:17.4.4")
    implementation("com.google.firebase:firebase-crashlytics:17.1.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.3.2")

    implementation("io.coil-kt:coil:0.11.0")
    implementation("org.jetbrains.anko:anko:0.10.8")
    implementation("pub.devrel:easypermissions:3.0.0")
    implementation("com.jakewharton.timber:timber:4.7.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation("com.jakewharton.threetenabp:threetenabp:1.2.4")
    implementation("com.google.android.material:material:1.3.0-alpha01")

    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
