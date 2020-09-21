package com.gugu.dts.playlist.inf.repository

import com.gugu.dts.playlist.api.`object`.IMusicLibraryDTO
import com.gugu.dts.playlist.core.entity.MusicLibrary
import com.gugu.dts.playlist.core.repository.MusicLibraryRepository

class MusicLibraryRepositoryImpl : MusicLibraryRepository {
    override fun import(library: IMusicLibraryDTO): MusicLibrary {
        TODO("Not yet implemented")
    }

    override fun fetchLibraryByName(name: String): MusicLibrary {
        TODO("Not yet implemented")
    }

    override fun list(): List<MusicLibrary> {
        TODO("Not yet implemented")
    }
}
