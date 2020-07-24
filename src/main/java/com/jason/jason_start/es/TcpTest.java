package com.jason.jason_start.es;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Jason
 * Date 2020/5/27
 */
public class TcpTest {
    public static void main(String[] args) throws Exception {
        TransportClient c = createClient();
        System.out.println(c);

    }

    public static TransportClient createClient() {
        TransportClient client = null;
        PreBuiltTransportClient preBuiltTransportClient = null;
        try {
            List<Object> connection = Arrays.asList("127.0.0.1:9300");
            String cluster_name = "elasticsearch";
            String node_name = "";
            boolean sniff = false;
            Settings settings = null;
            if (cluster_name != null && !cluster_name.equals("") && node_name != null && !node_name.equals("")) {
                settings = Settings.builder()
                        .put("cluster.name", cluster_name)
                        .put("node.name", node_name)
                        .put("client.transport.sniff", sniff)
                        .build();
            } else if (cluster_name != null && !cluster_name.equals("")) {
                settings = Settings.builder()
                        .put("client.transport.sniff", sniff)
                        .put("cluster.name", cluster_name)
                        .build();
            } else if (node_name != null && !node_name.equals("")) {
                settings = Settings.builder()
                        .put("client.transport.sniff", sniff)
                        .put("node.name", node_name)
                        .build();
            } else {
                settings = Settings.builder()
                        .put("client.transport.sniff", sniff)
                        .build();
            }
            System.out.println(settings);
            preBuiltTransportClient = new PreBuiltTransportClient(settings);
            for (Object hostAndPort : connection) {
                String host = ((String) hostAndPort).split(":")[0];
                String port = ((String) hostAndPort).split(":")[1];
                preBuiltTransportClient.addTransportAddress(new TransportAddress(InetAddress.getByName(host), Integer.parseInt(port)));
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

//        //获取别名指向的真实索引名称
//        GetAliasesResponse aliasResponse = client.admin().indices()
//				.prepareGetAliases("alias1")
//				.execute().actionGet();
//        List<String> indexList = new ArrayList<String>();
//        for(ObjectObjectCursor<String, List<AliasMetaData>> cursor : aliasResponse.getAliases()) {
//        	indexList.add(cursor.key);
//        }
//        System.out.println(indexList);
        client = preBuiltTransportClient;
        return client;
    }
}
