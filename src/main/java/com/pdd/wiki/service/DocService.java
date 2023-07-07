package com.pdd.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdd.wiki.domain.Doc;
import com.pdd.wiki.domain.DocExample;
import com.pdd.wiki.mapper.DocMapper;
import com.pdd.wiki.req.DocQueryReq;
import com.pdd.wiki.req.DocSaveReq;
import com.pdd.wiki.resp.DocQueryResp;
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
public class DocService {
    private static final Logger logger = LoggerFactory.getLogger(DocService.class);
    @Resource
    private DocMapper docMapper;

    @Resource
    private SnowFlake snowFlake;

    public List<DocQueryResp> all() {

        // 查询条件 固定
        DocExample docExample = new DocExample();
        // 根据sort排序
        docExample.setOrderByClause("sort asc");
        // 根据条件查询，返回list
        List<Doc> docList = docMapper.selectByExample(docExample);

        List<DocQueryResp> list = CopyUtil.copyList(docList, DocQueryResp.class);

        return list;
    }
    public PageResp<DocQueryResp> list(DocQueryReq req) {

        // 查询条件 固定
        DocExample docExample = new DocExample();
        DocExample.Criteria criteria = docExample.createCriteria();
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
        List<Doc> docList = docMapper.selectByExample(docExample);

        PageInfo<Doc> pageInfo = new PageInfo<>(docList);
        logger.info("总行数" + pageInfo.getTotal());
        logger.info("总页数" + pageInfo.getPages());

        //  List<Doc> -> List<DocResp>
        List<DocQueryResp> list = CopyUtil.copyList(docList, DocQueryResp.class);

        PageResp<DocQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    /**
     * 保存
     */
    public void save(DocSaveReq req) {
        Doc doc = CopyUtil.copy(req, Doc.class);
        if (ObjectUtils.isEmpty(req.getId())){
            // 新增
            doc.setId(snowFlake.nextId());
            docMapper.insert(doc);
        } else {
            // 更新
            docMapper.updateByPrimaryKey(doc);
        }
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        docMapper.deleteByPrimaryKey(id);
    }
}
