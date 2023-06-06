package com.pdd.wiki.service;

import com.pdd.wiki.domain.Ebook;
import com.pdd.wiki.domain.EbookExample;
import com.pdd.wiki.mapper.EbookMapper;
import com.pdd.wiki.req.EbookReq;
import com.pdd.wiki.resp.EbookResp;
import com.pdd.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        // 查询条件 固定
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        // 模糊查询 + 动态判断
        if(!ObjectUtils.isEmpty(req.getBookName())){
            criteria.andBookNameLike("%" + req.getBookName() + "%" );
        }
        // 根据条件查询，返回list
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        //  List<Ebook> -> List<EbookResp>
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);

        return list;
    }
}
