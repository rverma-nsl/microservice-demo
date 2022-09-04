import org.gradle.api.Project
import org.morfly.airin.GradlePerModuleTemplateProvider
import org.morfly.airin.GradleStandaloneTemplateProvider
import org.morfly.airin.starlark.elements.StarlarkFile
import org.morfly.airin.labels
import template.workspace_template
import template.java_library_template
import template.root_build_template

class Workspace : GradleStandaloneTemplateProvider() {

    override fun provide(target: Project, relativePath: String): List<StarlarkFile> = listOf(
        workspace_template(
            name = target.rootProject.name,
            artifactDeps = sharedData.allArtifacts.labels()
        )
    )
}

class JavaLibrary : GradlePerModuleTemplateProvider() {

    override fun provide(target: Project, relativePath: String): List<StarlarkFile> = listOf(
        java_library_template(
            name = target.project.name
        )
    )

    override fun canProvide(target: Project): Boolean =
        target.plugins.hasPlugin("java-library")
}

class RootBuild : GradleStandaloneTemplateProvider() {

    override fun provide(target: Project, relativePath: String): List<StarlarkFile> = listOf(
        root_build_template()
    )
}