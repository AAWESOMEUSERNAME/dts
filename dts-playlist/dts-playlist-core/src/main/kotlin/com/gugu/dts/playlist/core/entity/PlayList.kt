package com.gugu.dts.playlist.core.entity

import com.gugu.dts.playlist.api.`object`.IPlayList
import com.gugu.dts.playlist.api.`object`.ISong
import java.io.File

class PlayList(override val songs: MutableList<ISong>) : IPlayList {

    override fun add(song: ISong) {
        songs.add(song)
    }

    override fun toFile(): File {
        val str = songs.map { it.path + "\\n" }
        val file = File.createTempFile("playlist", null)
        file.outputStream().use { out ->
            str.forEach {
                out.write(it.toByteArray())
            }
        }
        return file
    }
}