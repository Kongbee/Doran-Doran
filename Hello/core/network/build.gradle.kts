plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.purple.hello.core.network"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = KotlinOptions.jvmTarget
    }
}

dependencies {

    implementation(appDependencies)
    testImplementation(defaultUnitTest)
    androidTestImplementation(defaultAndroidTest)

    implementation(retrofit2Dependencies)
    implementation(KotlinxSerializationJson.KOTLIN_SELIAIZATION_JSON)
    implementation(Okhttp3LoggingInterceptor.OKHTTP3_LOGGING_INTERCEPTOR)
}
