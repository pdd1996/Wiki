package com.pdd.wiki.controller;

import com.pdd.wiki.req.EbookQueryReq;
import com.pdd.wiki.req.EbookSaveReq;
import com.pdd.wiki.resp.CommonResp;
import com.pdd.wiki.resp.EbookQueryResp;
import com.pdd.wiki.resp.PageResp;
import com.pdd.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

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
    public CommonResp list(EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        // 数据库取来的数据赋值给 list
        PageResp<EbookQueryResp> list = ebookService.list(req);
        resp.setContent(list);

        return resp;
    }

    // post @RequestBody - json
    // post form 就不用
    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);

        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp save(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        ebookService.delete(id);

        return resp;
    }
}
