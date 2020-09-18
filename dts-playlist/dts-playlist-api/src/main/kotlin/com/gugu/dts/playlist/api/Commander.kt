package com.gugu.dts.playlist.api

import com.gugu.dts.playlist.api.`object`.IMusicLibraryDTO

interface Commander {
    fun importLibray(library: IMusicLibraryDTO)
}