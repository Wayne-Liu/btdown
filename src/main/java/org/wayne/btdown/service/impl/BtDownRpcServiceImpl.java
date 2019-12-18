package org.wayne.btdown.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wayne.btdown.common.HttpUtils;
import org.wayne.btdown.dao.TorrentListMapper;
import org.wayne.btdown.domain.SearchInfo;
import org.wayne.btdown.domain.TorrentDO;
import org.wayne.btdown.service.BtDownRpcService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.alibaba.fastjson.JSON.toJSONString;

@Service
public class BtDownRpcServiceImpl implements BtDownRpcService {
    private String url = "http://www.ciligou.co/search?word=";
    private String baseUrl = "http://www.ciligou.co";

    @Autowired
    private TorrentListMapper torrentListMapper;

    @Override
    public String btdownUrl(String torrNum) {
        String htmlBody = HttpUtils.httpPostJson(url+torrNum, toJSONString(new HashMap<>()));
        Document doc = Jsoup.parse(htmlBody);
        Element element = doc.getElementById("Search_list_wrapper");
        Elements liElements = element.getElementsByTag("li");
        List<SearchInfo> searchInfos = new ArrayList<>();
        for (Element li : liElements) {
            if (li.getElementsByClass("Search_title_wrapper").size() == 0) {
                continue;
            }
            SearchInfo searchInfo = new SearchInfo();

            Elements aElements = li.select("div").first().getElementsByTag("a");
            searchInfo.setUrl(baseUrl+aElements.attr("href"));
            searchInfo.setTitle(aElements.text());
            Elements listInfo = li.getElementsByClass("Search_list_info");
            String searchIcon = listInfo.first().getElementsByClass("Search_result_type").text();
            searchInfo.setSearchHot(Integer.parseInt(searchIcon));
            String sizeDateInfo = listInfo.text();
            String[] sizeDateInfos = sizeDateInfo.split("：");
            String[] sizes = sizeDateInfos[1].replace("创建时间","").split(" ");
            if (sizes[1].equals("GB")) {
                searchInfo.setSize(Double.parseDouble(sizes[0]) * 1024);
            } else {
                searchInfo.setSize(Double.parseDouble(sizes[0]));
            }
            String date = sizeDateInfos[2].replace("文件格式","");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                searchInfo.setCreateTime(sdf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            searchInfos.add(searchInfo);
        }

        Collections.sort(searchInfos, new Comparator<SearchInfo>() {
            @Override
            public int compare(SearchInfo o1, SearchInfo o2) {
                int score1 = (int)o1.getSize() + o1.getSearchHot();
                int score2 = (int)o2.getSize() + o2.getSearchHot();
                if (score1 > score2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (SearchInfo searchInfo : searchInfos) {
            System.out.println(searchInfo.getSearchHot() + "-----" + searchInfo.getSize());
        }

        List<SearchInfo> screeningInfo = new ArrayList<>();
        if (searchInfos.size() > 1) {
            screeningInfo.add(searchInfos.get(searchInfos.size()-2));
            screeningInfo.add(searchInfos.get(searchInfos.size()-1));
        } else if (searchInfos.size() == 1) {
            screeningInfo.add(searchInfos.get(searchInfos.size()-1));
        }

        for (SearchInfo searchInfo : screeningInfo) {
            String torrentPage = HttpUtils.httpPostJson(searchInfo.getUrl(),toJSONString(new HashMap<>()));
            Document torrentDocument = Jsoup.parse(torrentPage);
            String downUrl = torrentDocument.getElementById("down-url").attr("href");
            System.out.println(searchInfo);

            TorrentDO torrentDO = new TorrentDO();
            torrentDO.setUrl(downUrl);
            torrentDO.setCreateTime(new Date());
            torrentDO.setHasDown(0);
            torrentDO.setTorrentId(torrNum);
            torrentListMapper.insert(torrentDO);

        }

        return htmlBody;
    }


}
