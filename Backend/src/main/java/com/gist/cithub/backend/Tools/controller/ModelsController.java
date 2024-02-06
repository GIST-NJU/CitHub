package com.gist.cithub.backend.Tools.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gist.cithub.backend.Tools.entity.ProjectsEntity;
import com.gist.cithub.backend.common.utils.PageUtils;
import com.gist.cithub.backend.common.utils.R;
import com.gist.cithub.backend.Tools.entity.ModelsEntity;
import com.gist.cithub.backend.Tools.service.ModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * @author xiangjiantu
 * @email 1223564154@qq.com
 * @date 2022-08-28 17:02:35
 */
@RestController
@RequestMapping("tools/models")
public class ModelsController {
    @Autowired
    private ModelsService modelsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = modelsService.queryPage(params);

        return R.ok().put("page", page);
    }


    @RequestMapping("/listModelsByProjectID")
    public R listModelsByProjectID(@RequestBody Map<String, Object> info) {
        Integer projectid = Integer.parseInt((String) info.get("projectid"));
        List<ModelsEntity> modelsList = modelsService.listModelsByProjectId(projectid);
//        System.out.println(modelsList);
        return R.ok().put("models", modelsList);
    }

    @RequestMapping("/updateModel")
    public R updatePaper(@RequestBody ModelsEntity modelsEntity) {
//        System.out.println(listEntity.toString());
        Boolean updateFlag = modelsService.updateById(modelsEntity);
        if (updateFlag) return R.ok().put("UpdateStatus", "success!").put("UpdateResult", modelsEntity);
        else return R.ok().put("UpdateStatus", "failed!");

    }

    @RequestMapping(value = "/DeleteByModelID", method = RequestMethod.POST)
    public R DeleteByModelID(@RequestBody Map<String, Object> info) {
//        System.out.println(info);
//        System.out.println(info.get("projectid"));
        QueryWrapper<ModelsEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ModelID", info.get("modelid"));
        Boolean deleteFlag = modelsService.remove(queryWrapper);
        if (deleteFlag) return R.ok().put("DeleteStatus", "success!");
        else return R.ok().put("DeleteStatus", "failed!");
    }

    @RequestMapping(value = "/SaveModel", method = RequestMethod.POST)
    public R SaveModel(@RequestBody Map<String, Object> info) {
//        System.out.println(info);
//        System.out.println(info.get("ParametersAndValues"));
//        System.out.println(info.get("modelid"));
        QueryWrapper<ModelsEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ModelID", info.get("modelid"));
        ModelsEntity modelsEntity = modelsService.getOne(queryWrapper);
        modelsEntity.setParamsvalues((String) info.get("ParametersAndValues"));
        modelsEntity.setCons((String) info.get("Cons"));

        modelsEntity.setModelname((String) info.get("modelname"));
        modelsEntity.setModeldescriptions((String) info.get("modeldescriptions"));

        //        将时间戳转为Date类型
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        LocalDateTime lastUpdateTime = LocalDateTime.parse((String) info.get("lastupdatedtime"), formatter);

        modelsEntity.setLastupdatedtime(java.sql.Timestamp.valueOf(lastUpdateTime));


        Object strengthValue = info.get("strength");
        if (strengthValue instanceof Integer) {
            modelsEntity.setStrength((Integer) strengthValue);
        } else if (strengthValue instanceof String) {
            // 如果是字符串，尝试将其转换为整数
            try {
                modelsEntity.setStrength(Integer.parseInt((String) strengthValue));
            } catch (NumberFormatException e) {
                // 处理转换失败的情况，例如记录日志或抛出异常
                e.printStackTrace();
            }
        } else {
            // 处理其他类型的情况，例如记录日志或抛出异常
            System.err.println("Unsupported type for strength: " + strengthValue.getClass());
        }
        boolean updateResult = modelsService.updateById(modelsEntity);

        if (updateResult) {
            return R.ok().put("SaveModelStatus", "success");
        } else {
            return R.ok().put("SaveModelStatus", "fail");

        }
    }

    @RequestMapping(value = "/NewModel", method = RequestMethod.POST)
    public R NewProject(@RequestBody Map<String, Object> info) {
//        System.out.println(info);
        ModelsEntity modelsEntity = new ModelsEntity();
        modelsEntity.setModelname((String) info.get("modelname"));
        modelsEntity.setModeldescriptions((String) info.get("modeldescriptions"));
        modelsEntity.setProjectid(Integer.parseInt((String) info.get("projectID")) );
//        将时间戳转为Date类型
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        LocalDateTime createTime = LocalDateTime.parse((String) info.get("createdtime"), formatter);
        LocalDateTime lastUpdateTime = LocalDateTime.parse((String) info.get("lastupdatedtime"), formatter);

        modelsEntity.setCreatedtime(java.sql.Timestamp.valueOf(createTime));
        modelsEntity.setLastupdatedtime(java.sql.Timestamp.valueOf(lastUpdateTime));
        Boolean flag = modelsService.save(modelsEntity);
        if (flag) return R.ok().put("NewStatus", "success!");
        else return R.ok().put("NewStatus", "failed!");
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{modelid}")
    public R info(@PathVariable("modelid") Integer modelid) {
        ModelsEntity models = modelsService.getById(modelid);

        return R.ok().put("models", models);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ModelsEntity models) {
        modelsService.save(models);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ModelsEntity models) {
        modelsService.updateById(models);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] modelids) {
        modelsService.removeByIds(Arrays.asList(modelids));

        return R.ok();
    }

}