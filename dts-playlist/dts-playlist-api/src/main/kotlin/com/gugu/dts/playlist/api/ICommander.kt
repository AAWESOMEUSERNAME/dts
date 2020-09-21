package com.gugu.dts.playlist.api

import com.gugu.dts.playlist.api.`object`.IMusicLibrary
import com.gugu.dts.playlist.api.`object`.IMusicLibraryDTO

interface ICommander {
    fun importLibray(library: IMusicLibraryDTO): IMusicLibrary
}