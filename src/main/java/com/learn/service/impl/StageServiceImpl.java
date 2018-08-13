package com.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.bean.Stage;
import com.learn.bean.StageExample;
import com.learn.dao.StageMapper;
import com.learn.pojo.StageListVO;
import com.learn.service.StageService;
import com.learn.utils.MsgStatus;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageServiceImpl implements StageService {

    @Autowired
    private StageMapper stageMapper;

    @Override
    public PageInfo<StageListVO> getDataList(Integer pageNum, Integer pageSize,Integer courseId) {
        if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        List<StageListVO> stageList= stageMapper.stageList(courseId);
        return new PageInfo<StageListVO>(stageList);
    }

    @Override
    public Stage selectById(Integer id) {
        Stage stage=stageMapper.selectByPrimaryKey(id);
        return stage;
    }

    @Override
    public ResponseResult save(Stage stage) {
        ResponseResult res= new ResponseResult();
        try{
            stageMapper.insert(stage);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("新增阶段成功！");
        }catch(Exception e){
            res.setMessage("新增阶段失败！");
        }
        return res;
    }

    @Override
    public ResponseResult delete(Integer stageId) {
        ResponseResult res= new ResponseResult();
        try{
            stageMapper.deleteByPrimaryKey(stageId);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("删除阶段成功！");
        }catch(Exception e){
            res.setMessage("删除阶段失败！");
        }
        return res;
    }

    @Override
    public ResponseResult update(Stage stage) {
        ResponseResult res= new ResponseResult();
        try{
            stageMapper.updateByPrimaryKeySelective(stage);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("修改阶段成功！");
        }catch(Exception e){
            res.setMessage("修改阶段失败！");
        }
        return res;
    }

    @Override
    public List<Stage> getAllList() {
        StageExample example = new StageExample();
        example.setOrderByClause("weight desc,update_time desc");
        List<Stage> stageList= stageMapper.selectByExample(example);
        return  stageList;
    }

    @Override
    public List<Stage> getList(Integer id) {
        StageExample example = new StageExample();
        StageExample.Criteria criteria= example.createCriteria();
        criteria.andCourseIdEqualTo(id);
        example.setOrderByClause("weight desc,update_time desc");
        List<Stage> stageList= stageMapper.selectByExample(example);
        return  stageList;
    }
}
