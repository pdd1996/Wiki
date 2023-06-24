package com.pdd.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdd.wiki.domain.Ebook;
import com.pdd.wiki.domain.EbookExample;
import com.pdd.wiki.mapper.EbookMapper;
import com.pdd.wiki.req.EbookQueryReq;
import com.pdd.wiki.req.EbookSaveReq;
import com.pdd.wiki.resp.EbookQueryResp;
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
public class EbookService {
    private static final Logger logger = LoggerFactory.getLogger(EbookService.class);
    @Resource
    private EbookMapper ebookMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<EbookQueryResp> list(EbookQueryReq req) {

        // 查询条件 固定
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        // 模糊查询 + 动态判断
        if(!ObjectUtils.isEmpty(req.getBookName())){
            criteria.andBookNameLike("%" + req.getBookName() + "%" );
        }
        // 分页
        /**
         * pageNum 当前页的号码
         * pageSize 每页的数量
         * 举例 pageNum=1 pageSize=3 从第一页取三条数据，如果总数是五条的话，就两页
         * req.getPage() 获取父类的page
         */
        PageHelper.startPage(req.getPage(), req.getSize());
        // 根据条件查询，返回list
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        logger.info("总行数" + pageInfo.getTotal());
        logger.info("总页数" + pageInfo.getPages());

        //  List<Ebook> -> List<EbookResp>
        List<EbookQueryResp> list = CopyUtil.copyList(ebookList, EbookQueryResp.class);

        PageResp<EbookQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    /**
     * 保存
     */
    public void save(EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        if (ObjectUtils.isEmpty(req.getId())){
            // 新增
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        } else {
            // 更新
            ebookMapper.updateByPrimaryKey(ebook);
        }
    }
}
