plugins {
    `java-library`
    id("kotlin")
}

dependencies {
    implementation(fileTree("libs") { include(listOf("*.jar")) })
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
