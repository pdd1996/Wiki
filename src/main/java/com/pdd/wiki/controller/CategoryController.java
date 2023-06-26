package com.pdd.wiki.controller;

import com.pdd.wiki.req.CategoryQueryReq;
import com.pdd.wiki.req.CategorySaveReq;
import com.pdd.wiki.resp.CommonResp;
import com.pdd.wiki.resp.CategoryQueryResp;
import com.pdd.wiki.resp.PageResp;
import com.pdd.wiki.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    // 统一的返回
    @GetMapping("/list")
    // CommonResp 统一返回 后端统一通用的返回格式
    // 泛型 + List
    public CommonResp list(@Valid CategoryQueryReq req) {
        CommonResp<PageResp<CategoryQueryResp>> resp = new CommonResp<>();
        // 数据库取来的数据赋值给 list
        PageResp<CategoryQueryResp> list = categoryService.list(req);
        resp.setContent(list);

        return resp;
    }

    // post @RequestBody - json
    // post form 就不用
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody CategorySaveReq req) {
        CommonResp resp = new CommonResp<>();
        categoryService.save(req);

        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp save(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        categoryService.delete(id);

        return resp;
    }
}
