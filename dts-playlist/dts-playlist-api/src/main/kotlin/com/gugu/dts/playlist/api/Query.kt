package com.gugu.dts.playlist.api

import com.gugu.dts.playlist.api.`object`.IMusicLibrary

interface Query {
    fun fetchLibraryByName(name: String): IMusicLibrary
    fun listLibrary(): List<IMusicLibrary>
}