package com.base.core.action.bo;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import com.base.core.BaseAction;
import com.base.core.util.StringUtil;

@SuppressWarnings("serial")
public class UploadAction extends BaseAction implements ServletContextAware{

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

	public String execute() throws Exception {
		try {

			// String targetDirectory =
			// PropertiesManager.getProperty("ARCHIVE_DIRECTORY")+"/upload";
			DateFormat format = new SimpleDateFormat("yyMM");
			String formatDate = format.format(new Date());
			String targetDirectory = context.getRealPath("/") + "upload/"+formatDate+"/";
			if (!StringUtil.isEmpty(uploadFileName)) {
				String[] ExtArr = new String[] { ".gif", ".jpg", ".png", ".bmp" };
				String fileExt = uploadFileName.substring(uploadFileName
						.lastIndexOf("."));
				if (!Arrays.<String> asList(ExtArr).contains(
						fileExt.toLowerCase())) {
					addActionError("上传文件扩展名是不允许的扩展名,请重试!");
					return INPUT;
				}
			} else {
				addActionError("请先上传文件!");
				return INPUT;
			}
			String targetFileName = generateFileName(uploadFileName);
			File target = new File(targetDirectory, targetFileName);
			FileUtils.copyFile(upload, target);

			setUploadFileName(target.getPath());// 保存文件的存放路径
			// imgPath
			// ="http://172.16.6.106"+context.getContextPath()+"/upload/"+targetFileName;
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}
		return INPUT;
	}

	private String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String formatDate = format.format(new Date());
		int random = new Random().nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + random + extension;
	}
	
	
	
}
