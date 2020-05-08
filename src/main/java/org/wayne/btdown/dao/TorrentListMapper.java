package org.wayne.btdown.dao;

import org.apache.ibatis.annotations.*;
import org.wayne.btdown.domain.TorrentDO;

import java.util.List;

@Mapper
public interface TorrentListMapper {

    @Insert("INSERT INTO torrent_down_list (torrent_id, url, has_down, create_time) VALUES (#{torrentId}, #{url}, #{hasDown}, #{createTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(TorrentDO torrentDO);

    @Select("select * from torrent_down_list where has_down=0")
    List<TorrentDO> selectUnDown();

    @Update("update torrent_down_list set has_down=1 where id = #{id}")
    public int updateById(@Param("id") int id);
}
