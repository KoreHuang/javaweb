package com.video.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class Upload extends HttpServlet{




	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();  
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/");//获取应用所在服务器的位置
		factory.setRepository(new File(path));  
		factory.setSizeThreshold(1024*1024);//设置创建缓冲大小  

		ServletFileUpload upload = new ServletFileUpload(factory);  
		upload.setSizeMax(-1);//设置上传文件限制大小,-1无上限  
		try {  

			List<FileItem> list = upload.parseRequest(request);
			String va = null;  
			for(FileItem item : list){  
				if(item.isFormField()){//判断元素是否是一个普通的表单元素
					System.out.println(item.getFieldName());
				}else{  
					//获取上传文件的的文件名
					String s = item.getName();
					//获得上传文件的文件类型后缀
					s = s.substring(s.lastIndexOf("."));
					String nFileName = System.currentTimeMillis()
							+ s;
					System.out.println(nFileName);

					InputStream is = item.getInputStream();
					FileOutputStream fos = 
							new FileOutputStream(path+nFileName);//设置上传文件的路径
					int t = 0;
					while((t = is.read())!= -1){
						fos.write(t);
					}

					fos.close();
				}  
			}  
		} catch (Exception e) {  

			e.printStackTrace();  
		}  
	}


	public static void main(String[] args) {

	}


}
