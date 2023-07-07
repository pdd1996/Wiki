package com.pdd.wiki.controller;

import com.pdd.wiki.req.DocQueryReq;
import com.pdd.wiki.req.DocSaveReq;
import com.pdd.wiki.resp.DocQueryResp;
import com.pdd.wiki.resp.CommonResp;
import com.pdd.wiki.resp.PageResp;
import com.pdd.wiki.service.DocService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doc")
public class DocController {

    @Resource
    private DocService docService;

    // 统一的返回
    @GetMapping("/all")
    // CommonResp 统一返回 后端统一通用的返回格式
    // 泛型 + List
    public CommonResp all() {
        CommonResp<List<DocQueryResp>> resp = new CommonResp<>();
        // 数据库取来的数据赋值给 list
        List<DocQueryResp> list = docService.all();
        resp.setContent(list);

        return resp;
    }
    @GetMapping("/list")
    // CommonResp 统一返回 后端统一通用的返回格式
    // 泛型 + List
    public CommonResp list(@Valid DocQueryReq req) {
        CommonResp<PageResp<DocQueryResp>> resp = new CommonResp<>();
        // 数据库取来的数据赋值给 list
        PageResp<DocQueryResp> list = docService.list(req);
        resp.setContent(list);

        return resp;
    }

    // post @RequestBody - json
    // post form 就不用
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody DocSaveReq req) {
        CommonResp resp = new CommonResp<>();
        docService.save(req);

        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp save(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        docService.delete(id);

        return resp;
    }
}
