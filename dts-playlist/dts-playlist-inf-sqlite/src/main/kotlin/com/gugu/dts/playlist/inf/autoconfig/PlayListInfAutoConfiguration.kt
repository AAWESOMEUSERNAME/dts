package com.gugu.dts.playlist.inf.autoconfig

import com.gugu.dts.playlist.core.repository.MusicLibraryRepository
import com.gugu.dts.playlist.inf.mapper.MusicLibraryMapper
import com.gugu.dts.playlist.inf.mapper.SongMapper
import com.zaxxer.hikari.HikariDataSource
import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.AutoConfigureBefore
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import repository.MusicLibraryRepositoryImpl
import javax.sql.DataSource

@Configuration
@MapperScan("com.gugu.dts.playlist.inf.mapper")
@AutoConfigureAfter(value = [MybatisAutoConfiguration::class])
@AutoConfigureBefore(value = [DataSourceAutoConfiguration::class])
class PlayListInfAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(DataSource::class)
    fun dataSource(): DataSource {
        val ds = HikariDataSource()
        ds.jdbcUrl = ClassLoader.getSystemResource("/db/dts-playlist.db").path
        ds.username = "root"
        ds.password = "root"
        return ds
    }

    @Bean
    @ConditionalOnMissingBean(MusicLibraryRepository::class)
    fun musicLibraryRepository(libraryMapper: MusicLibraryMapper, songMapper: SongMapper): MusicLibraryRepository {
        return MusicLibraryRepositoryImpl(libraryMapper, songMapper)
    }
}