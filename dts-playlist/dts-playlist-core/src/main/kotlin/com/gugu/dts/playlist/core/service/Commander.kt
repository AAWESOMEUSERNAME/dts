package com.gugu.dts.playlist.core.service

import com.gugu.dts.playlist.api.ICommander
import com.gugu.dts.playlist.api.`object`.IMusicLibrary
import com.gugu.dts.playlist.api.`object`.IMusicLibraryDTO
import com.gugu.dts.playlist.core.repository.MusicLibraryRepository

class Commander(private val libraryRepo: MusicLibraryRepository) : ICommander {

    override fun importLibray(library: IMusicLibraryDTO): IMusicLibrary {
        return libraryRepo.import(library)
    }
}