package com.guojiyue.demo1.controller;

import com.guojiyue.demo1.dao.KindMapper;
import com.guojiyue.demo1.entity.Kind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "/kind")
public class KindController {
    // 数据访问类9988
    @Autowired
    KindMapper kindMapper;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("title","新闻分类");

        model.addAttribute("kinds",kindMapper.selectAll());
        return "/kind/list";
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public Kind selectByPrimaryKey(@RequestParam int id){
        return kindMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable int id, HttpServletResponse response) throws IOException {
        kindMapper.deleteByPrimaryKey(id);
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        out.print("<script language=\"javascript\">alert('删除成功！');window.location.href='http://localhost:8671/kind/list'</script>");
     }
}
