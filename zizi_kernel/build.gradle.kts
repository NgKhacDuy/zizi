plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  id("maven-publish")
}

android {
  namespace = "com.zizi.zizi_kernel"
  compileSdk = 36

  defaultConfig {
    minSdk = 29

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions { jvmTarget = "11" }
}

dependencies {
  implementation(libs.androidx.core.ktx)
  implementation(libs.material)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  implementation(libs.timber)
  implementation(libs.logger)
}

configure<PublishingExtension> {
  publications.create<MavenPublication>("release") {
    groupId = "com.github.NgKhacDuy"
    artifactId = "zizi_kernel"
    version = "1.0.0"
    pom.packaging = "jar"
    artifact("${layout.buildDirectory}/libs/zizi_kernel.jar")
  }
}
