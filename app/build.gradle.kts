plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Dependencies.android.compileSdk
    buildToolsVersion = Dependencies.android.buildTools

    defaultConfig {
        applicationId = "com.alacrity.music"
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":music"))

    di()
    log()
    gson()
    core()
    room()
    audio()
    async()
    jetpack()
    reflection()
    image()
}

fun DependencyHandlerScope.core() {
    implementation(Dependencies.other.kotlin)
    implementation(Dependencies.other.ktxCore)
    implementation(Dependencies.other.appcompat)
    implementation(Dependencies.other.material)
}

fun DependencyHandlerScope.room() {
    implementation(Dependencies.room.runtime)
    kapt(Dependencies.room.compiler)
    implementation(Dependencies.room.ktx)
}

fun DependencyHandlerScope.di() {
    implementation(Dependencies.di.dagger2)
    kapt(Dependencies.di.dagger2compiler)
}

fun DependencyHandlerScope.image() {
    implementation(Dependencies.image.landscapist)
    implementation(Dependencies.image.glide)
    kapt(Dependencies.image.glideCompiler)
}

fun DependencyHandlerScope.async() {
    implementation(Dependencies.async.coroutinesCore)
    implementation(Dependencies.async.coroutinesAndroid)
}

fun DependencyHandlerScope.log() {
    implementation(Dependencies.other.timber)
}

fun DependencyHandlerScope.jetpack() {
    implementation(Dependencies.jetpack.lifecycleExtensions)
    implementation(Dependencies.jetpack.lifecycleViewModel)
    implementation(Dependencies.compose.runtime)
    implementation(Dependencies.compose.ui)
    implementation(Dependencies.compose.foundationLayout)
    implementation(Dependencies.compose.material)
    implementation(Dependencies.compose.icons)
    implementation(Dependencies.compose.uiUtil)
    implementation(Dependencies.compose.foundation)
    implementation(Dependencies.compose.animation)
    implementation(Dependencies.compose.activity)
    implementation(Dependencies.compose.navigation)
    implementation(Dependencies.compose.insets)
    implementation(Dependencies.compose.uiController)
    implementation(Dependencies.compose.permissions)
    implementation(Dependencies.compose.viewPager)
    implementation(Dependencies.compose.collapsingToolbar)
}

fun DependencyHandlerScope.audio() {
    implementation(Dependencies.audio.dash)
    implementation(Dependencies.audio.hls)
    implementation(Dependencies.audio.ui)
    implementation(Dependencies.audio.session)
    implementation(Dependencies.audio.exoPlayer)
}

fun DependencyHandlerScope.gson() {
    implementation(Dependencies.other.gson)
}

fun DependencyHandlerScope.reflection() {
    implementation(Dependencies.other.reflection)
}

