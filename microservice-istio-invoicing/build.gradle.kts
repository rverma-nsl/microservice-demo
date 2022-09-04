plugins {
    id("java-library")
    id("com.ewolff.java-conventions")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.3")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.7.3")
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.3")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")
    implementation("org.webjars:bootstrap:5.2.0")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth:3.1.3")
    implementation("org.springframework.experimental:spring-native:0.11.1")
    runtimeOnly("org.postgresql:postgresql:42.5.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.3")
    testImplementation("org.hsqldb:hsqldb:2.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    testImplementation("au.com.dius.pact.consumer:junit5:4.3.14")
}

description = "microservice-istio-invoicing"
repositories {
    mavenCentral()
}
