package com.learn.controller;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Catalog;
import com.learn.bean.Course;
import com.learn.bean.Module;
import com.learn.bean.Stage;
import com.learn.pojo.CatalogListVO;
import com.learn.service.*;
import com.learn.utils.MsgStatus;
import com.learn.utils.PageBean;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    private CatalogService catalogService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private StageService stageService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UploadService uploadService;


    @RequestMapping("/back/catalog/list")
    public ModelAndView list(ModelAndView modelAndView){
        List<Course> courseList=courseService.getAllList();
        List<Stage> stageList=stageService.getAllList();
        List<Module> moduleList=moduleService.getAllList();
        modelAndView.setViewName("/cms/catalog/list");
        modelAndView.addObject("courseList",courseList);
        modelAndView.addObject("stageList",stageList);
        modelAndView.addObject("moduleList",moduleList);
        return modelAndView;
    }

    @RequestMapping("/back/catalog/dataList")
    @ResponseBody
    public PageBean<CatalogListVO> dataList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize,
                                            @RequestParam(value = "courseId",required=false) int courseId, @RequestParam(value = "stageId",required=false) int stageId, @RequestParam(value = "moduleId",required=false) int moduleId){
        PageInfo pageInfo = catalogService.getDataList((start / pageSize) + 1, pageSize,courseId,stageId,moduleId);
        return new PageBean<CatalogListVO>(pageInfo);
    }

    @RequestMapping("/back/catalog/addCatalogWithFile")
    @ResponseBody
    public ResponseResult addCatalogWithFile(@RequestParam("uploadfile") MultipartFile file, Catalog catalog){
        String fileName = file.getOriginalFilename().toString();
        ResponseResult res=uploadService.uploadImg(file);
        if(res.getCode()== MsgStatus.FAILED){
            return res;
        }else{
            String url=(String)res.getObj();
            catalog.setVideo(url);
            catalog.setCreateTime(new Date());
            res=catalogService.save(catalog);
        }
        return res;
    }

    @RequestMapping("/back/catalog/addCatalog")
    @ResponseBody
    public ResponseResult addCatalog(Catalog catalog){
        ResponseResult res=new ResponseResult();
        catalog.setCreateTime(new Date());
        res=catalogService.save(catalog);
        return res;
    }

    @RequestMapping("/back/catalog/updateCatalog")
    @ResponseBody
    public ResponseResult updateCatalog(Catalog catalog,Integer delete){
        if(delete==0){
            if(catalog.getVideo() != null && catalog.getVideo().trim().length() != 0){
                uploadService.deleteFile(catalog.getVideo());
                catalog.setVideo("");

            }
        }
        ResponseResult res=new ResponseResult();
        catalog.setUpdateTime(new Date());
        res=catalogService.update(catalog);
        return res;
    }

    @RequestMapping("/back/catalog/updateCatalogWithFile")
    @ResponseBody
    public ResponseResult updateCatalogWithFile(@RequestParam("uploadfile") MultipartFile file,Catalog catalog){
        if(catalog.getVideo() != null && catalog.getVideo().trim().length() != 0){
            uploadService.deleteFile(catalog.getVideo());}
        ResponseResult res=uploadService.uploadImg(file);
        if(res.getCode()== MsgStatus.FAILED){
            return res;
        }else{
            String url=(String)res.getObj();
            catalog.setVideo(url);
            catalog.setUpdateTime(new Date());
            res=catalogService.update(catalog);
        }
        return res;
    }

    @RequestMapping("/back/catalog/deleteCatalog")
    @ResponseBody
    public ResponseResult deleteCatalog(Integer catalogId,String url){
        if(url!=null){
            uploadService.deleteFile(url);}
        ResponseResult res=new ResponseResult();
        res=catalogService.delete(catalogId);
        return res;
    }

}
