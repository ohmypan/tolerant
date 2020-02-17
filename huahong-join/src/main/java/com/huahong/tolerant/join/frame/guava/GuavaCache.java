package com.huahong.tolerant.join.frame.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * File：GuavaCache <br>
 * Created on 2020/2/15.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class GuavaCache {
    public static void main(String[] args) {
        LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
                .maximumSize(1000).build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        System.out.println("key:"+key);
                        if("key".equals(key)){
                            return "key return result";
                        }else{
                            return "get-if-absent-compute";
                        }
                    }});
        graphs.put("1111","22222");
    }
}
