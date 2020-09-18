package com.gugu.dts.playlist.core.entity

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

internal class PlayListTest {

    var playList: PlayList = PlayList(
            mutableListOf(
                    Song(
                            name = "test.mp3",
                            path = "D:/test.mp3"
                    )
            )
    )


//    companion object {
//        @BeforeAll
//        @JvmStatic
//        fun beforeAll(){
//            println("beforeAll")
//        }
//    }

    @BeforeEach
    fun init() {
        println("test")

    }

    @Test
    fun add() {
        playList.add(Song("test2.mp3", "D:/test2.mp3"))
        assertTrue { playList.songs.size == 2 }
    }

    @Test
    fun toFile() {
        val file = playList.toFile()
        assertNotNull(file)
    }
}