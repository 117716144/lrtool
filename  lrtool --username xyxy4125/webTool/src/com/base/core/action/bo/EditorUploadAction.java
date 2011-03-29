package com.base.core.action.bo;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletContext;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import com.base.core.BaseAction;
import com.base.core.util.StringUtil;

@SuppressWarnings("serial")
public class EditorUploadAction extends BaseAction implements ServletContextAware{

	private File upload;// 实际上传文件

	private String uploadContentType; // 文件的内容类型
	private String uploadFileName; // 上传文件名
	private String fileCaption;// 上传文件时的备注
	private ServletContext context;

	private String imgPath;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileCaption() {
		return fileCaption;
	}

	public void setFileCaption(String fileCaption) {
		this.fileCaption = fileCaption;
	}

	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String execute(){
		
		try{
		DateFormat format = new SimpleDateFormat("yyMM");
		String formatDate = format.format(new Date());
		String rootpath =context.getRealPath("/");
		if(!StringUtil.isEmpty(rootpath) && rootpath.indexOf("jsproot")==-1){
			rootpath +="wwwroot/";
		}
		String savePath =rootpath + "upload/"+formatDate+"/";
		if(!StringUtil.isEmpty(savePath) && savePath.indexOf("jsproot")!=-1){
			savePath = savePath.replace("jsproot", "wwwroot");
		}
		//文件保存目录URL
		String saveUrl  = this.getRequest().getContextPath() + "/upload/"+formatDate+"/";

		this.getResponse().setContentType("text/html; charset=UTF-8");
		PrintWriter out =this.getResponse().getWriter();
		if(!ServletFileUpload.isMultipartContent(this.getRequest())){
			out.write(getError("请选择文件。"));
			return null;
		}
		//检查目录
		File uploadDir = new File(savePath);
		if(!uploadDir.exists()) {uploadDir.mkdirs();}
		if(!uploadDir.isDirectory()){
			out.write(getError("上传目录不存在。"));
			return null;
		}
		//检查目录写权限
		if(!uploadDir.canWrite()){
			out.write(getError("上传目录没有写权限。"));
			return null;
		}

		if (!StringUtil.isEmpty(uploadFileName)) {
			String[] ExtArr = new String[] { ".gif", ".jpg", ".png", ".bmp" };
			String fileExt = uploadFileName.substring(uploadFileName
					.lastIndexOf("."));
			if (!Arrays.<String> asList(ExtArr).contains(
					fileExt.toLowerCase())) {
				out.write(getError("上传文件扩展名是不允许的扩展名,请重试!"));
				return null;
			}
		} else {
			out.write(getError("请先上传文件!"));
			return null;
		}
		String targetFileName = generateFileName(uploadFileName);
		File target = new File(savePath, targetFileName);
		FileUtils.copyFile(upload, target);
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("url", saveUrl + target.getName());
		out.write(obj.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	private String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String formatDate = format.format(new Date());
		int random = new Random().nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + random + extension;
	}
	
	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toString();
	}
	
	
}
