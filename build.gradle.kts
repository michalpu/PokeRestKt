import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	kotlin("jvm") version "1.3.50"
	kotlin("plugin.spring") version "1.3.50"
	id("groovy")
	jacoco
}

group = "com.michalpu"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.apache.httpcomponents:httpclient")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.vavr:vavr:0.10.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
	testImplementation("com.github.tomakehurst:wiremock:2.25.0")
	testImplementation("org.spockframework:spock-core:1.3-groovy-2.5")
	testImplementation("org.spockframework:spock-spring:1.3-groovy-2.5")
}

tasks.test {
	useJUnitPlatform()
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.jacocoTestReport {
	reports {
		xml.isEnabled = true
		xml.destination  = File("$buildDir/reports/jacoco/report.xml")
		csv.isEnabled = false
		html.isEnabled = false
	}
	executionData(File("build/jacoco/test.exec"))
}

tasks.test {
	finalizedBy(tasks.jacocoTestReport)
}
