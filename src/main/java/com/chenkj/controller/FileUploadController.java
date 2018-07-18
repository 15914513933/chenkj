package com.chenkj.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.crypto.KeyGenerator;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chenkj.model.FUploadRecord;
import com.chenkj.model.User;
import com.chenkj.result.ResultBean;
import com.chenkj.service.impl.FileUploadServiceImpl;
import com.chenkj.util.KeyGeneratorUtil;

@Controller
public class FileUploadController {
	
	@Autowired
	private FileUploadServiceImpl fileUploadService;
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
    public ResultBean<String> upload(HttpServletRequest req,@RequestParam("fsection") String fsection,
    		@RequestParam("fitem") String fitem,@RequestParam("file") MultipartFile file) {
		ResultBean<String> result = new ResultBean<String>();
		if(!file.isEmpty()) {
			if(fsection==null||fsection.equals("")){
				fsection = "default";
			}
			if(fitem==null||fitem.equals("")){
				fitem = "default";
			}
			String id = KeyGeneratorUtil.generateKey();
			String rootPath = FUploadRecord.FILE_ROOT_PATH ;
			String path = File.separator + fsection + File.separator + fitem;
			String fname = file.getOriginalFilename();
			String fext = fname.substring(fname.lastIndexOf(".")+1, fname.length());
			File filepath = new File(path);
			if (!filepath.getParentFile().exists()) { 
				filepath.getParentFile().mkdirs();
			}
			String fpath = path + File.separator + id + "." + fext;
			try {
				file.transferTo(new File(rootPath + fpath));
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg(e.getMessage());
				return result;
			}
			User user = (User)req.getSession().getAttribute("USER_SESSION");
			FUploadRecord uploadRecord = new FUploadRecord();
			uploadRecord.setId(id);
			uploadRecord.setFname(fname);
			uploadRecord.setFext(fext);
			uploadRecord.setFsection(fsection);
			uploadRecord.setFitem(fitem);
			uploadRecord.setFpath(fpath);
			uploadRecord.setCreatetime(new Timestamp(System.currentTimeMillis()));
			uploadRecord.setCreator(user.getUserid());
			
			if(fileUploadService.saveUploadRecord(uploadRecord)){
				result.setData(id);
			}else{
				new File(rootPath + fpath).delete();
				result.setMsg("上传失败！");
			}
		} else {
			result.setMsg("文件为空！");
		}
		return result;
    }
}
