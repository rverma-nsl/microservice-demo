@file:Suppress("FunctionName", "SpellCheckingInspection")

package template

import org.morfly.airin.starlark.lang.BUILD
import org.morfly.airin.starlark.lang.bazel
import org.morfly.airin.starlark.library.exports_files


fun root_build_template(
    /**
     *
     */
) = BUILD.bazel {
    exports_files(list["debug.keystore"], visibility = list["//visibility:public"])
}