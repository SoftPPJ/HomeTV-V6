plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.softppj.hometv"
    compileSdk = 35
    buildFeatures { buildConfig = true }
    defaultConfig {
        val masterPlaylistUrl = providers.environmentVariable("MASTER_PLAYLIST_URL").orElse("").get()
        val escapedMasterPlaylistUrl = masterPlaylistUrl.replace("\\", "\\\\").replace("\"", "\\\"")
        buildConfigField("String", "MASTER_PLAYLIST_URL", "\"${escapedMasterPlaylistUrl}\"")
        applicationId = "com.softppj.myhometv.v6"
        minSdk = 23
        targetSdk = 32
        versionCode = 6
        versionName = "6.0.0-dev"
    }
    applicationVariants.all {
        outputs.all {
            val apkOutput = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            apkOutput.outputFileName = "HomeTV-V6.apk"
        }
    }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
    kotlinOptions { jvmTarget = "17" }
}
dependencies {
    implementation("androidx.media3:media3-exoplayer:1.5.1")
    implementation("androidx.media3:media3-exoplayer-hls:1.5.1")
    implementation("androidx.media3:media3-exoplayer-dash:1.5.1")
    implementation("androidx.media3:media3-exoplayer-rtsp:1.5.1")
    implementation("androidx.media3:media3-exoplayer-smoothstreaming:1.5.1")
    implementation("androidx.media3:media3-ui:1.5.1")
    // FFmpeg software audio decoder. Media3 hardware/platform decoders remain preferred.
    // Jellyfin 1.5.0+1 matches the existing Media3 1.5.x API; GPLv3 applies.
    implementation("org.jellyfin.media3:media3-ffmpeg-decoder:1.5.0+1")
    implementation("org.videolan.android:libvlc-all:3.5.1")
}
