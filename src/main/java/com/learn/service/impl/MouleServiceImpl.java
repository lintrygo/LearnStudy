package com.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.bean.Module;
import com.learn.bean.ModuleExample;
import com.learn.dao.ModuleMapper;
import com.learn.pojo.ModuleListVO;
import com.learn.service.ModuleService;
import com.learn.utils.MsgStatus;
import com.learn.utils.ResponseResult;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MouleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public PageInfo<ModuleListVO> getDataList(Integer pageNum, Integer pageSize,Integer courseId,Integer stageId) {
        if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        List<ModuleListVO> stageList= moduleMapper.moduleList(courseId,stageId);
        return new PageInfo<ModuleListVO>(stageList);
    }

    @Override
    public Module selectById(Integer id) {
        Module module=moduleMapper.selectByPrimaryKey(id);
        return module;
    }

    @Override
    public ResponseResult save(Module entity) {
        ResponseResult res= new ResponseResult();
        try{
            moduleMapper.insert(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("新增模块成功！");
        }catch(Exception e){
            res.setMessage("新增模块失败！");
        }
        return res;
    }

    @Override
    public ResponseResult delete(Integer id) {
        ResponseResult res= new ResponseResult();
        try{
            moduleMapper.deleteByPrimaryKey(id);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("删除模块成功！");
        }catch(Exception e){
            res.setMessage("删除模块失败！");
        }
        return res;
    }

    @Override
    public ResponseResult update(Module entity) {
        ResponseResult res= new ResponseResult();
        try{
            moduleMapper.updateByPrimaryKeySelective(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("修改模块成功！");
        }catch(Exception e){
            res.setMessage("修改模块失败！");
        }
        return res;
    }

    @Override
    public List<Module> getAllList()
    {
        ModuleExample example = new ModuleExample();
        example.setOrderByClause("weight desc,update_time desc");
        List<Module> moduleList= moduleMapper.selectByExample(example);
        return  moduleList;
    }

    @Override
    public List<Module> getList(Integer id) {
        ModuleExample example = new ModuleExample();
        ModuleExample.Criteria criteria=example.createCriteria();
        criteria.andStageIdEqualTo(id);
        example.setOrderByClause("weight desc,update_time desc");
        List<Module> moduleList= moduleMapper.selectByExample(example);
        return  moduleList;
    }
}
