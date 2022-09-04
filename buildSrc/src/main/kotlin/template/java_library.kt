@file:Suppress("FunctionName", "SpellCheckingInspection")

package template

import org.morfly.airin.starlark.lang.BUILD
import org.morfly.airin.starlark.lang.bazel
import org.morfly.airin.starlark.library.*


fun java_library_template(
    name: String,
) = BUILD.bazel {
    load("@rules_java//java:defs.bzl", "java_library", "java_import")

    `package`(default_visibility = list["//visibility:public"])

    java_library(
        name = name,
        srcs = glob("src/main/java/**/*.java"),
        resources = glob("src/main/resources/**"),
        visibility = list["//visibility:private"],
        neverlink = True,
    )

//    java_import(
//        name = "kotlinx_coroutines_core_jvm",
//        jars = list["@maven_secondary//:v1/https/repo1.maven.org/maven2/org/jetbrains/kotlinx/kotlinx-coroutines-core-jvm/1.5.1/kotlinx-coroutines-core-jvm-1.5.1.jar"],
//        deps = list[
//                ":sun_misc_stubs",
//                artifact("org.jetbrains.kotlin:kotlin-stdlib-common"),
//                artifact("org.jetbrains.kotlin:kotlin-stdlib-jdk8"),
//        ],
//    )
}