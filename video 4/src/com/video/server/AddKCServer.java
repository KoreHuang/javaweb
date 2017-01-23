package com.video.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.video.vo.KcPO;

public class AddKCServer extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
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
			
			KcPO kPO = new KcPO();
			
			//遍历提交过来的表单数据
			for(FileItem item : list){  
				if(item.isFormField()){//判断元素是否是一个普通的表单元素
					if("dire".equals(item.getFieldName())){
						kPO.setDire(item.getString("utf-8"));
					}else if("info".equals(item.getFieldName())){
						kPO.setInfo(item.getString("utf-8"));
					}else if("kname".equals(item.getFieldName())){
						kPO.setKname(item.getString("utf-8"));
					}else if("author".equals(item.getFieldName())){
						kPO.setAuthor(item.getString("utf-8"));
					}else if("type".equals(item.getFieldName())){
						kPO.setType(item.getString("utf-8"));
					}
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
					
					kPO.setImgName(nFileName);
					
				}  
			} 
			
			//将其他数据保存至数据库
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/video","root","123456");
			
			PreparedStatement pre = 
					conn.prepareStatement
			("INSERT INTO v_kc(v_name,v_info,v_head,t_id,dire_id,author,create_time) VALUES(?,?,?,?,?,?,sysdate())");
			
			
			
			pre.setString(1,kPO.getKname());
			pre.setString(2,kPO.getInfo());
			pre.setString(3,kPO.getImgName());
			pre.setString(4,kPO.getType());
			pre.setString(5, kPO.getDire());
			pre.setString(6,kPO.getAuthor());
			
			pre.executeUpdate();
			
		} catch (Exception e) {  

			e.printStackTrace();  
		}  
	}
	
}
