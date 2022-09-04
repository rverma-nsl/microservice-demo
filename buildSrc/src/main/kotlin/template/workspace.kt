@file:Suppress("LocalVariableName", "FunctionName", "SpellCheckingInspection")

package template

import org.morfly.airin.starlark.lang.WORKSPACE
import org.morfly.airin.starlark.library.*


fun workspace_template(
    name: String,
    artifactDeps: List<String>
    /**
     *
     */
) = WORKSPACE {
    workspace(name = name)

    load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

    val RULES_JAVA_VERSION by "5.1.0"
    val RULES_JAVA_SHA by "d974a2d6e1a534856d1b60ad6a15e57f3970d8596fbb0bb17b9ee26ca209332a"

    http_archive(
        name = "rules_java",
        url = "https://github.com/bazelbuild/rules_java/releases/download/{v}/rules_java-{v}.tar.gz".format { "v" `=` RULES_JAVA_VERSION },
        sha256 = RULES_JAVA_SHA,
    )

    load("@rules_java//java:repositories.bzl", "rules_java_dependencies", "rules_java_toolchains")
    "rules_java_dependencies"()
    "rules_java_toolchains"()

    val RULES_JVM_EXTERNAL_TAG by "4.3"
    val RULES_JVM_EXTERNAL_SHA by "6274687f6fc5783b589f56a2f1ed60de3ce1f99bc4e8f9edef3de43bdf7c6e74"

    http_archive(
        name = "rules_jvm_external",
        sha256 = RULES_JVM_EXTERNAL_SHA,
        strip_prefix = "rules_jvm_external-%s" `%` RULES_JVM_EXTERNAL_TAG,
        urls = list["https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" `%` RULES_JVM_EXTERNAL_TAG],
    )

    load("@rules_jvm_external//:defs.bzl", "maven_install")

    maven_install(
        artifacts = artifactDeps,
        repositories = list[
                "https://maven.google.com",
                "https://repo1.maven.org/maven2",
        ],
        override_targets = dict {
            "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm" to "@//third_party:kotlinx_coroutines_core_jvm"
        },
    )

    // Secondary maven artifact repository that works as a workaround for those artifacts
    // that have problems loading with the primary 'maven_install' rule.
    // It loads problematic artifacts separately which are being handled in the 'third-party'
    // package.
    // As a result, the primary 'maven-install' overrides problematic artifacts with the fixed ones
    // from the 'third_party' package.
    maven_install(
        name = "maven_secondary",
        artifacts = list["org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.5.1"],
        repositories = list["https://repo1.maven.org/maven2"],
    )


    val RULES_KOTLIN_VERSION by "v1.7.0-RC-3"
    val RULES_KOTLIN_SHA by "f033fa36f51073eae224f18428d9493966e67c27387728b6be2ebbdae43f140e"

    http_archive(
        name = "io_bazel_rules_kotlin",
        sha256 = RULES_KOTLIN_SHA,
        type = "tar.gz",
        urls = list["https://github.com/bazelbuild/rules_kotlin/releases/download/%s/rules_kotlin_release.tgz" `%` RULES_KOTLIN_VERSION],
    )

    load(
        "@io_bazel_rules_kotlin//kotlin:kotlin.bzl",
        "kotlin_repositories",
        "kt_register_toolchains"
    )
    kotlin_repositories()
    kt_register_toolchains()
}