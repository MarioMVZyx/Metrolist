package com.metrolist.android

import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalStartupPresentation = staticCompositionLocalOf<StartupPresentation?> { null }

internal class StartupPresentation {
    var contentLaidOut = false
    var homeRequired = false
    var homeLaidOut = false
    var homeCacheReady = false
    var avatarReady = true

    fun keepSplash(
        startupReady: Boolean,
        recovering: Boolean,
        restoringBackup: Boolean,
    ): Boolean {
        if (recovering || restoringBackup) return false
        return !startupReady || !contentLaidOut || (homeRequired && !homeLaidOut)
    }
}
