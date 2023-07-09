package com.pdd.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdd.wiki.domain.Category;
import com.pdd.wiki.domain.CategoryExample;
import com.pdd.wiki.mapper.CategoryMapper;
import com.pdd.wiki.req.CategoryQueryReq;
import com.pdd.wiki.req.CategorySaveReq;
import com.pdd.wiki.resp.CategoryQueryResp;
import com.pdd.wiki.resp.PageResp;
import com.pdd.wiki.util.CopyUtil;
import com.pdd.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private SnowFlake snowFlake;

    public List<CategoryQueryResp> all() {

        // 查询条件 固定
        CategoryExample categoryExample = new CategoryExample();
        // 根据sort排序
        categoryExample.setOrderByClause("sort asc");
        // 根据条件查询，返回list
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);

        List<CategoryQueryResp> list = CopyUtil.copyList(categoryList, CategoryQueryResp.class);

        return list;
    }
    public PageResp<CategoryQueryResp> list(CategoryQueryReq req) {

        // 查询条件 固定
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        // 模糊查询 + 动态判断
//        if(!ObjectUtils.isEmpty(req.getBookName())){
//            criteria.andBookNameLike("%" + req.getBookName() + "%" );
//        }
        // 分页
        /**
         * pageNum 当前页的号码
         * pageSize 每页的数量
         * 举例 pageNum=1 pageSize=3 从第一页取三条数据，如果总数是五条的话，就两页
         * req.getPage() 获取父类的page
         */
        PageHelper.startPage(req.getPage(), req.getSize());
        // 根据条件查询，返回list
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);

        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        logger.info("总行数" + pageInfo.getTotal());
        logger.info("总页数" + pageInfo.getPages());

        //  List<Category> -> List<CategoryResp>
        List<CategoryQueryResp> list = CopyUtil.copyList(categoryList, CategoryQueryResp.class);

        PageResp<CategoryQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    /**
     * 保存
     */
    public void save(CategorySaveReq req) {
        Category category = CopyUtil.copy(req, Category.class);
        if (ObjectUtils.isEmpty(req.getId())){
            // 新增 使用雪花算法生成 id
            category.setId(snowFlake.nextId());
            categoryMapper.insert(category);
        } else {
            // 更新
            categoryMapper.updateByPrimaryKey(category);
        }
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
}
