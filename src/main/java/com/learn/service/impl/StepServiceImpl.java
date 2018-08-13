package com.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.bean.Step;
import com.learn.bean.StepExample;
import com.learn.dao.StepMapper;
import com.learn.pojo.StepListVO;
import com.learn.service.StepService;
import com.learn.utils.MsgStatus;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepServiceImpl implements StepService {

    @Autowired
    private StepMapper stepMapper;

    @Override
    public PageInfo<StepListVO> getDataList(Integer pageNum, Integer pageSize, Integer courseId, Integer stageId, Integer moduleId, Integer catalogId) {
        if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        List<StepListVO> stepList= stepMapper.stepList(courseId,stageId,moduleId,catalogId);
        return new PageInfo<StepListVO>(stepList);
    }

    @Override
    public ResponseResult save(Step entity) {
        ResponseResult res= new ResponseResult();
        try{
            stepMapper.insert(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("新增步骤成功！");
        }catch(Exception e){
            res.setMessage("新增步骤失败！");
        }
        return res;
    }

    @Override
    public ResponseResult delete(Integer id) {
        ResponseResult res= new ResponseResult();
        try{
            stepMapper.deleteByPrimaryKey(id);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("删除步骤成功！");
        }catch(Exception e){
            res.setMessage("删除步骤失败！");
        }
        return res;
    }

    @Override
    public ResponseResult update(Step entity) {
        ResponseResult res= new ResponseResult();
        try{
            stepMapper.updateByPrimaryKeySelective(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("修改步骤成功！");
        }catch(Exception e){
            res.setMessage("修改步骤失败！");
        }
        return res;
    }

    @Override
    public List<Step> getAllList() {
        return null;
    }

    @Override
    public List<Step> getList(Integer id) {
        StepExample example = new StepExample();
        StepExample.Criteria criteria= example.createCriteria();
        criteria.andCatalogIdEqualTo(id);
        example.setOrderByClause("weight desc,update_time desc");
        List<Step> stepList= stepMapper.selectByExampleWithBLOBs(example);
        return  stepList;
    }

}
