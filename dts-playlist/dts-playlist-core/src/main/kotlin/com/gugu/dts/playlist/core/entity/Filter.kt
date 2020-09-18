package com.gugu.dts.playlist.core.entity

import com.gugu.dts.playlist.api.`object`.IFilter
import com.gugu.dts.playlist.api.`object`.ISong

class Filter(
        private val startBpm: Double,
        private val endBpm: Double
) : IFilter {
    override fun filter(songs: List<ISong>): List<ISong> {
        return songs.filter {
            it.bpm.compareTo(startBpm) > 0 && it.bpm.compareTo(endBpm) < 0
        }
    }
}