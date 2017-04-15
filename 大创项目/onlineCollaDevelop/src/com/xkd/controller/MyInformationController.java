package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkd.service.MyInformationService;

/**
 * 我的信息控制器
 * @author RBB
 *
 */
@Controller
@RequestMapping("/myInformation")
public class MyInformationController  implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 我的信息服务
	 */
	@Resource(name="MyInformationService")
    private MyInformationService myInformationService;
    /**
     * 进入我的项目
     * @return
     */
    @RequestMapping("/toMyInformation.do")
    public String toMyInformation() {
        return "my_information";
    }

}
