object AppMetaData {
    const val id = "com.oppong.codechallenge"
    const val compileSdkVersion = 28
    const val targetSdkVersion = 28
    const val minSdkVersion = 19
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    // Application
    const val kotlin = "1.3.41"
    const val appCompat = "28.0.0"

    // Core
    const val androidSupport = "28.0.0"

    // UI
    const val constraintLayout = "1.1.3"


    // Test
    const val jUnit = "4.12"
    const val testRunner = "1.0.2"
    const val testEspresso = "3.0.2"
}

object Libraries {

    // Core
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val appCompat = "com.android.support:appcompat-v7:${Versions.appCompat}"

    // UI
    const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"
    const val design = "com.android.support:design:${Versions.androidSupport}"
    const val recyclerView = "com.android.support:recyclerview-v7:${Versions.androidSupport}"

    // Test
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
    const val testEspresso = "com.android.support.test.espresso:espresso-core:${Versions.testEspresso}"

}