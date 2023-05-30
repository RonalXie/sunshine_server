package com.ronalxie.service.impl;

import com.github.pagehelper.PageHelper;
import com.ronalxie.mapper.CategoryMapper;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.category.CategoryEntity;
import com.ronalxie.model.category.dto.CategorySearchDto;
import com.ronalxie.model.category.vo.CategoryBaseVo;
import com.ronalxie.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryBaseVo> seachList(PageParam pageParam, CategorySearchDto categorySearchDto) {
        CategoryEntity categoryEntity=new CategoryEntity();
        if (!ObjectUtils.isEmpty(categorySearchDto)){
            BeanUtils.copyProperties(categorySearchDto,categoryEntity);
        }
        if (pageParam.getPageSize()!=0){
            int pageSize=pageParam.getPageSize();
            int pageNum=pageParam.getPageNum();
            PageHelper.startPage(pageNum,pageSize);
        }
        List<CategoryEntity> categoryEntities=categoryMapper.searchList(categoryEntity);
        List<CategoryBaseVo> categoryBaseVoList=new ArrayList<>();
        categoryEntities.forEach(item->{
            CategoryBaseVo categoryBaseVo=new CategoryBaseVo();
            BeanUtils.copyProperties(item,categoryBaseVo);
            categoryBaseVoList.add(categoryBaseVo);

        });
        return categoryBaseVoList;
    }
}
