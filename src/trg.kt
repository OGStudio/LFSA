package org.opengamestudio

/**
 * Register platform functions relevant to all targets
 */
fun trgRegisterCommonPlatformFunctions(
    ctrl: ctxController
) {
    ctrl.registerCallback({ cc: ctxContext ->
        val c = cc as Context
        pltPrintToConsole(c)
    })
}

/**
 * Register settings relevant to all targets
 */
fun trgRegisterCommonSettings(
    ctrl: ctxController
) {
    ctrl.set("httpPort", 8080)
}

/**
 * Register behaviour relevant to all targets
 */
fun trgRegisterCommonShoulds(
    ctrl: ctxController
) {
    arrayOf(
        ::shouldReplyOverHTTP,
    ).forEach { f ->
        ctrl.registerFunction { c -> f(c as Context) }
    }
}
