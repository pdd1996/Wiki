package com.pdd.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdd.wiki.domain.Ebook;
import com.pdd.wiki.domain.EbookExample;
import com.pdd.wiki.mapper.EbookMapper;
import com.pdd.wiki.req.EbookReq;
import com.pdd.wiki.resp.EbookResp;
import com.pdd.wiki.resp.PageResp;
import com.pdd.wiki.util.CopyUtil;
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

    public PageResp<EbookResp> list(EbookReq req) {

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
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);

        PageResp<EbookResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }
}
