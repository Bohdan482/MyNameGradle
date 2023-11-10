plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
//    implementation("com.google.code.gson:gson:2.10.1")

}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    archiveFileName.set("myname.jar")
    manifest.attributes["Main-Class"] = "org.example.Main"
    manifest.attributes["Class-Path"] = configurations
            .runtimeClasspath
            .get()
            .joinToString(separator = " ") { file ->
                "libs/${file.name}"
            }
}