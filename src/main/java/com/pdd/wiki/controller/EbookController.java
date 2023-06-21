package com.pdd.wiki.controller;

import com.pdd.wiki.req.EbookReq;
import com.pdd.wiki.resp.CommonResp;
import com.pdd.wiki.resp.EbookResp;
import com.pdd.wiki.resp.PageResp;
import com.pdd.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    // 统一的返回
    @GetMapping("/list")
    // CommonResp 统一返回 后端统一通用的返回格式
    // 泛型 + List
    public CommonResp list(EbookReq req) {
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        // 数据库取来的数据赋值给 list
        PageResp<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }
}
