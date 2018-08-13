package com.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.bean.Catalog;
import com.learn.bean.CatalogExample;
import com.learn.dao.CatalogMapper;
import com.learn.pojo.CatalogListVO;
import com.learn.pojo.ModuleListVO;
import com.learn.service.CatalogService;
import com.learn.utils.MsgStatus;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public PageInfo<CatalogListVO> getDataList(Integer pageNum, Integer pageSize, Integer courseId, Integer stageId, Integer moduleId) {
        if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        List<CatalogListVO> catalogList= catalogMapper.catalogList(courseId,stageId,moduleId);
        return new PageInfo<CatalogListVO>(catalogList);
    }

    @Override
    public ResponseResult save(Catalog entity) {
        ResponseResult res= new ResponseResult();
        try{
            catalogMapper.insert(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("新增目录成功！");
        }catch(Exception e){
            res.setMessage("新增目录失败！");
        }
        return res;
    }

    @Override
    public ResponseResult delete(Integer id) {
        ResponseResult res= new ResponseResult();
        try{
            catalogMapper.deleteByPrimaryKey(id);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("删除目录成功！");
        }catch(Exception e){
            res.setMessage("删除目录失败！");
        }
        return res;
    }

    @Override
    public ResponseResult update(Catalog entity) {
        ResponseResult res= new ResponseResult();
        try{
            catalogMapper.updateByPrimaryKeySelective(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("修改目录成功！");
        }catch(Exception e){
            res.setMessage("修改目录失败！");
        }
        return res;
    }

    @Override
    public List<Catalog> getAllList() {
        CatalogExample example = new CatalogExample();
        example.setOrderByClause("weight desc,update_time desc");
        List<Catalog> catalogList= catalogMapper.selectByExample(example);
        return  catalogList;
    }

    @Override
    public List<Catalog> getList(Integer id) {
        CatalogExample example = new CatalogExample();
        CatalogExample.Criteria criteria= example.createCriteria();
        criteria.andModuleIdEqualTo(id);
        example.setOrderByClause("weight desc,update_time desc");
        List<Catalog> catalogList= catalogMapper.selectByExample(example);
        return  catalogList;
    }

}

