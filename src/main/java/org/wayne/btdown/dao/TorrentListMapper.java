package org.wayne.btdown.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.wayne.btdown.domain.TorrentDO;

@Mapper
public interface TorrentListMapper {

    @Insert("INSERT INTO torrent_down_list (torrent_id, url, has_down, create_time) VALUES (#{torrentId}, #{url}, #{hasDown}, #{createTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(TorrentDO torrentDO);


}
