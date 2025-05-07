plugins {
	java
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.jb"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.projectlombok:lombok:1.18.26")
	implementation("org.springframework.boot", "spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot", "spring-boot-starter-data-jpa")
	implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
	//developmentOnly("org.springframework.boot:spring-boot-devtools")
	//runtimeOnly ("com.h2database:h2")
	runtimeOnly ("com.microsoft.sqlserver:mssql-jdbc")
	annotationProcessor ("org.projectlombok:lombok")
	runtimeOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
