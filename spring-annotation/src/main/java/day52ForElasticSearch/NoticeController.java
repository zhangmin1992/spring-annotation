package day52ForElasticSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class NoticeController {

	@Autowired
    private TransportClient transportClient;
	
	public void getContent(String title,Integer page,Integer size) {
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //按标题进行查找
        boolQueryBuilder.must(QueryBuilders.matchQuery("name", title));
        
        //在这里输入索引名称和type类型
        SearchResponse response = transportClient.prepareSearch("student").setTypes("_doc")
                // 设置查询类型java
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                // 设置查询关键词
                .setQuery(boolQueryBuilder)
                // 设置查询数据的位置,分页用
                .setFrom(page)
                // 设置查询结果集的最大条数
                .setSize(size)
                // 设置是否按查询匹配度排序
                .setExplain(true)
                // 最后就是返回搜索响应信息
                .get();
        SearchHits searchHits = response.getHits();

        List<Student> list = new ArrayList<Student>();
        
        for (SearchHit searchHit : searchHits) {
            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
            //获得titie数据
            String name = (String) sourceAsMap.get("name");
            //获得阅读量数据
            Integer readCount = (Integer) sourceAsMap.get("readCount");
            //把数据装入对象中
            Student student = new  Student();
            student.setName(name);
            student.setReadCount(readCount);
            list.add(student);
        }
        System.out.println(JSONObject.toJSONString(list));
	}
}
