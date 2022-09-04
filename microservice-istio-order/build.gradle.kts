plugins {
    id("com.ewolff.java-conventions")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.2")
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.2")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.6.2")
    implementation("org.webjars:bootstrap:3.3.6")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth:3.1.0")
    implementation("org.springframework.experimental:spring-native:0.11.1")
    runtimeOnly("org.postgresql:postgresql:42.3.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.2")
    testImplementation("org.hsqldb:hsqldb:2.5.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("au.com.dius.pact.provider:junit5spring:4.3.2")
    testImplementation("org.apache.httpcomponents:httpclient:4.5.13")
}

description = "microservice-istio-order"
