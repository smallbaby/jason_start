package com.jason.jason_start.jest;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.cluster.NodesInfo;
import io.searchbox.core.*;
import io.searchbox.indices.IndicesExists;
import io.searchbox.indices.aliases.GetAliases;
import io.searchbox.params.Parameters;
import io.searchbox.params.SearchType;
import lombok.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jason
 * Date 2020/5/30
 */
public class App1 {
    private static final int SIZE = 20000;

    public static void main(String[] args) throws Exception {
        JestClient es = getJestClient();
        // nodesInfo(es);
        // searchAll(es);
        // searchAll1(es, "autobi_rdm_app_rcmd_rway_di");
        //searchAllByLimit(es, "autobi_rdm_app_rcmd_rway_di");
        // indicesExists(es, "autobi_rdm_app_rcmd_rway_di");
        // shards(es, "autobi_rdm_app_rcmd_rway_di");
        searchScroll(es, "autobi_rdm_app_rcmd_rway_di");
        //searchScroll(es, "monitor_test_20200409");
    }

    /**
     * 通过http协议，查询Es.
     * 1、多条件过滤
     * 2、分页查询
     *
     * @param jestClient client
     * @param index      index
     * @throws IOException e
     */
    public static void searchScroll(JestClient jestClient, String index) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        long startTime = System.currentTimeMillis();
        // 多条件过滤
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.rangeQuery("dt").from("2020-03-29").to("2020-05-29"));
                //.must(QueryBuilders.matchQuery("hour", 99));
        searchSourceBuilder
                .query(boolQueryBuilder).fetchSource(new String[] {"dt","hour","autoplay_click_pv"}, null);
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(index)
                .setParameter(Parameters.SIZE, SIZE)
                .setParameter(Parameters.SCROLL, "1m")
                .build();
        JestResult result = jestClient.execute(search);
        String scrollId = result.getJsonObject().get("_scroll_id").getAsString();
        long total = result.getJsonObject().get("hits").getAsJsonObject().get("total").getAsLong();
        JsonArray ja = result.getJsonObject().get("hits").getAsJsonObject().get("hits").getAsJsonArray();
        int all = 0;
        while (ja.size() != 0) {
            for (int i = 0; i < ja.size(); i++) {
                System.out.println("第 " + i + " 页.");
                all += 1;
                //System.out.println(i + " --" + ja.get(i).getAsJsonObject().get("_source"));
            }
            SearchScroll scroll = new SearchScroll.Builder(scrollId, "1m").build();
            result = jestClient.execute(scroll);
            ja = result.getJsonObject().get("hits").getAsJsonObject().get("hits").getAsJsonArray();
        }
        System.out.println("总共查询获取到：" + all + " 条数据.");
        System.out.println("总耗时：" + (System.currentTimeMillis() - startTime));
    }

    /**
     * @param jestClient jc
     * @param index      i
     * @throws IOException io
     */
    public static void search(JestClient jestClient, String index) throws IOException {

        QueryBuilder qb0 = QueryBuilders.rangeQuery("dt").from("2020-05-28").to("2020-05-29");
        QueryBuilder qb1 = QueryBuilders.termQuery("rway_name", "UCF召回");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(qb0).must(qb1);
        System.out.println(boolQueryBuilder.toString());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(boolQueryBuilder);

        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(index)
                .setParameter(Parameters.SIZE, SIZE)
                .setParameter(Parameters.SCROLL, "1m")
                .build();
        SearchResult result = jestClient.execute(search);
        String scrollId = result.getJsonObject().get("_scroll_id").getAsString();
        long total = result.getTotal();
        System.out.println("本次查询共查到：" + total + "个关键字！");

        if (total > 0) {
            JsonArray ja = result.getJsonObject().get("hits").getAsJsonObject().get("hits").getAsJsonArray();
            for (int i = 0; i < ja.size(); i++) {
                System.out.println("--" + ja.get(i).getAsJsonObject().get("_source"));
            }

            SearchScroll scroll = new SearchScroll.Builder(scrollId, "1m").build();
            JestResult jestResult = jestClient.execute(scroll);

            System.out.println("JA： " + jestResult.getJsonObject());
        }
    }

    // 获取索引 别名
    public boolean getIndexAliases(JestClient jestClient, String index) {
        try {
            JestResult jestResult = jestClient.execute(new GetAliases.Builder().addIndex(index).build());
            System.out.println(jestResult.getJsonString());
            if (jestResult != null) {
                return jestResult.isSucceeded();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static JestClient getJestClient() {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                //.Builder("http://lf-up-es.es6.autohome.com.cn")
                .Builder("http://lf-bdp.es6.autohome.com.cn/")
                .gson(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create())
                .multiThreaded(true)
                .readTimeout(10000)
                .build());
        return factory.getObject();
    }

    public static void searchAllByLimit(JestClient jestClient, String index) {
        long startTime = System.currentTimeMillis();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(index)
                .setParameter(Parameters.SIZE, 10)
                .setParameter(Parameters.SCROLL, "1m")
                .build();
        SearchResult result = null;
        try {
            result = jestClient.execute(search);
            System.out.println("本次查询共查到：" + result.getTotal() + "个关键字！");
            String id = result.getJsonObject().get("_scroll_id").getAsString();
            System.out.println(id);
            JsonObject o = result.getJsonObject();
            JsonObject oo = o.get("hits").getAsJsonObject();
            JsonArray ja = (JsonArray) oo.get("hits");
            for (int i = 0; i < ja.size(); i++) {
                System.out.println(i + "---" + ja.get(0).getAsJsonObject().get("_id"));
            }
            //System.out.println("--" + readMoreFromSearch(jestClient, id, 10l));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void getDataByQuery(JestClient jestClient, String index) throws IOException {
        String k = "2020-05-29";
        // String query = "{\"from\": 0, \"size\": 100, \"query\": {\"match\": {\"dt\": \"" + k + "\"}}}";
        String query = "{\"from\": 0, \"size\": 100, \"query\": {\"match\": {}}}";
        Search search = new Search.Builder(query)
                .addIndex("autobi_rdm_app_rcmd_rway_di")
                .build();
        SearchResult result = jestClient.execute(search);
        System.out.println("本次查询共查到：" + result.getTotal() + "个关键字！");
    }


    public static void searchAll1(JestClient jestClient, String index) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(index)
                .setParameter(Parameters.SIZE, 10_00)
                .setParameter(Parameters.EXPLAIN, false)
                //.setSearchType(SearchType.SCAN)
                .build();
        SearchResult result = null;
        try {
            result = jestClient.execute(search);
            System.out.println("本次查询共查到：" + result.getTotal() + "个关键字！");
            JsonObject o = result.getJsonObject();
            JsonObject oo = o.get("hits").getAsJsonObject();
            JsonArray ja = (JsonArray) oo.get("hits");
            for (int i = 0; i < ja.size(); i++) {
                System.out.println(ja.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询全部
     *
     * @throws Exception
     */
    private static void searchAll(JestClient jestClient) throws Exception {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex("autobi_rdm_app_rcmd_rway_di")
                .build();
        SearchResult result = jestClient.execute(search);
        System.out.println("本次查询共查到：" + result.getTotal() + "篇文章！");

        JsonObject jo = result.getJsonObject();
        System.out.println(jo);
        List<SearchResult.Hit<Performance, Void>> hits = result.getHits(Performance.class);
        for (SearchResult.Hit<Performance, Void> hit : hits
        ) {
            Performance p = hit.source;
            System.out.println(p.getDt() + "\t" + p.getHour() + "\t" + p.getPosition() + "\t" + p.getAll_req_rway_cnt() + "\t" + p.getClick_pv());
        }
    }

    public JestResult nodesInfo(JestClient jestClient) {
        NodesInfo nodesInfo = new NodesInfo.Builder().build();
        JestResult result = null;
        try {
            result = jestClient.execute(nodesInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param jestClient
     * @return
     */
    public static JestResult indicesExists(JestClient jestClient, String index) {
        IndicesExists indicesExists = new IndicesExists.Builder(index).build();
        JestResult result = null;
        try {
            result = jestClient.execute(indicesExists);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void shards(JestClient jestClient, String index) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        SearchShards searchShards = new SearchShards.Builder().addIndex(index).build();
        JestResult result = jestClient.execute(searchShards);
        System.out.println(result);
        JsonArray ja = result.getJsonObject().get("shards").getAsJsonArray();
        Integer shards = 0;
        for (int i = 0; i < ja.size(); i++) {
            JsonArray _ja = ja.get(i).getAsJsonArray();
            for (int j = 0; j < _ja.size(); j++) {
                shards += _ja.get(j).getAsJsonObject().get("shard").getAsInt();
            }
        }
        System.out.println(shards);
    }

}

@Data
class Performance {
    private String all_req_rway_cnt;
    private String click_pv;
    private String dt;
    private String hour;
    private String position;
}