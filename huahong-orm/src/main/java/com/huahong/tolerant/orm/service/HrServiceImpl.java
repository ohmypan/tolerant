package com.huahong.tolerant.orm.service;

import com.huahong.tolerant.orm.dao.HrMapper;
import com.huahong.tolerant.orm.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * File：HrServiceImpl <br>
 * Created on 2020/4/6.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Service
public class HrServiceImpl implements HrService{

    @Autowired
    private HrMapper hrMapper;

    @Override
    public Hr getASimpleHr(Integer id) {
        return hrMapper.selectByPrimaryKey(id);
    }
}
