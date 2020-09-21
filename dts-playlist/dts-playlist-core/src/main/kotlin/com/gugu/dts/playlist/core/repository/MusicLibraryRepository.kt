package com.gugu.dts.playlist.core.repository

import com.gugu.dts.playlist.api.`object`.IMusicLibraryDTO
import com.gugu.dts.playlist.core.entity.MusicLibrary

interface MusicLibraryRepository {
    fun import(library: IMusicLibraryDTO): MusicLibrary
    fun fetchLibraryByName(name: String): MusicLibrary
    fun list(): List<MusicLibrary>
}
