package com.huahong.tolerant.orm.service;

import com.huahong.tolerant.orm.model.Hr;

/**
 * File：HrService <br>
 * Created on 2020/4/6.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public interface HrService {
    /**
     * 得到一个hr
     * @param id
     * @return
     */
    Hr getASimpleHr(Integer id);
}
