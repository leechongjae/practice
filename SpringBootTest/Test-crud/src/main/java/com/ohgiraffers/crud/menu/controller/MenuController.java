package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public String findMenuList(Model model){
        List<MenuDTO> menuList = menuService.findAllmenu();

        model.addAllAttributes("menuList", menuList);

        return "menu/list";
    }

    @GetMapping(value = "category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList(){
        return menuService.findAllCategory();
    }

    @GetMapping("regist")
    public void registPage(){}

    public String registMenu(MenuDTO newMenu, RedirectAttributes rttr){

        menuService.registNewMenu(newMenu);
        rttr.addFlashAttribute("successMessage", "신규 메뉴 등록 성공 !");

        return "redirect:/menu/list";

    }
}
