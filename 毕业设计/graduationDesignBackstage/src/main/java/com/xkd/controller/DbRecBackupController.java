package com.xkd.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkd.entity.BaseDbbackup;
import com.xkd.service.DbRecBackupService;
import com.xkd.util.FileDealWith;

/***
 * 数据库的备份和恢复
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/dbRecBackupController")
public class DbRecBackupController {

	@Resource(name = "dbRecBackupService")
	private DbRecBackupService	dbRecBackupService;

	@RequestMapping("list.do")
	public String list(Model model) {
		model.addAttribute("list", dbRecBackupService.list());
		return "db/backups";
	}

	@RequestMapping("backup.do")
	@ResponseBody
	public BaseDbbackup backup(BaseDbbackup baseDbbackup) {
		return dbRecBackupService.backup(baseDbbackup);
	}

	@RequestMapping("recover.do")
	@Transactional
	@Async
	@ResponseBody
	public BaseDbbackup recover(BaseDbbackup baseDbbackup) {
		return dbRecBackupService.recover(baseDbbackup);
	}

	@RequestMapping("download.do")
	public void download(HttpServletResponse response, String filePath) {
		try {
			FileDealWith.downloadFile(response, filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
