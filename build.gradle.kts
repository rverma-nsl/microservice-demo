plugins {
    id("org.morfly.airin")
    id("com.google.devtools.ksp") version "1.7.10-1.0.6"

}

airin {
    templates {
        register<JavaLibrary>()
        register<Workspace>()
    }
}