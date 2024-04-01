plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "network.twisty.proxyserver"
version = "1.0-ALPHA.all"

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()

    //libs
    maven(url = "https://papermc.io/repo/repository/maven-public/")
    maven(url = "https://jitpack.io/")

}

tasks {
    java {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
    compileJava { options.encoding = "UTF-8"}

    java {
        shadowJar { archiveFileName.set("proxy.jar") }
    }
}

dependencies {

    // bungee-api
    compileOnly("io.github.waterfallmc:waterfall-api:1.17-R0.1-SNAPSHOT")

    // framework
    implementation("com.github.SaiintBrisson.command-framework:shared:1.2.0")
    implementation("com.github.SaiintBrisson.command-framework:bungee:1.2.0")

    // luckperms
    compileOnly("net.luckperms:api:5.3")

    // lombok
    compileOnly("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")

}
