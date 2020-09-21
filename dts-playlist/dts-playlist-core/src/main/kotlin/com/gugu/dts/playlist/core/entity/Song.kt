package com.gugu.dts.playlist.core.entity

import com.gugu.dts.playlist.api.`object`.ISong

class Song(
        override val name: String,
        override val path: String,
        override val playedTimes: Int = 0,
        override val bpm: Double = 0.0
) : ISong {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Song) return false

        if (name != other.name) return false
        if (path != other.path) return false
        if (playedTimes != other.playedTimes) return false
        if (bpm != other.bpm) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + path.hashCode()
        result = 31 * result + playedTimes
        result = 31 * result + bpm.hashCode()
        return result
    }

    override fun toString(): String {
        return "Song(name='$name', path='$path', playedTimes=$playedTimes, bpm=$bpm)"
    }
}