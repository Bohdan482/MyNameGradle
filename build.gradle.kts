plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")

}

tasks.test {
    useJUnitPlatform()
}


tasks.jar {
    archiveFileName.set("myname.jar")
    manifest.attributes["Main-Class"] = "org.example.Main"
    val dependencies = configurations
            .runtimeClasspath
            .get()
            .map(::zipTree) // OR .map { zipTree(it) }
    from(dependencies)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

//tasks.jar {
//    archiveFileName.set("myname.jar")
//    manifest.attributes["Main-Class"] = "org.example.Main"
//    manifest.attributes["Class-Path"] = configurations
//            .runtimeClasspath
//            .get()
//            .joinToString(separator = " ") { file ->
//                "libs/${file.name}"
//            }
//}