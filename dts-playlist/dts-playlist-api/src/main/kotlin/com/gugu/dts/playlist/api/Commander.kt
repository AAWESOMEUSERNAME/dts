package com.gugu.dts.playlist.api

import com.gugu.dts.playlist.api.`object`.IMusicLibrary
import com.gugu.dts.playlist.api.`object`.IMusicLibraryDTO

interface Commander {
    fun importLibray(library: IMusicLibraryDTO)
    fun resetLibrayPlayedTimes(library: IMusicLibrary)
}