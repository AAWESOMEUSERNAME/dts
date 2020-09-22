package com.gugu.dts.playlist.inf.repository

import com.gugu.dts.playlist.core.repository.MusicLibraryRepository
import com.gugu.dts.playlist.inf.TestApplication
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(classes = [TestApplication::class])
@Transactional(rollbackFor = [Throwable::class])
@Rollback
internal class MusicLibraryRepositoryImplTest {

    @Autowired
    lateinit var libraryRepo: MusicLibraryRepository

    init {
    }

    @Test
    fun fetchLibraryByName() {
        libraryRepo.fetchLibraryByName("")
    }

    @Test
    fun list() {
    }

    @Test
    fun import() {

    }

}