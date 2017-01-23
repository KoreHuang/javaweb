<%@page import="com.video.vo.DirectionVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/global_style.css" type="text/css" />
</head>

<body>
	<!--head-->
	<div id="head" class="main_top"> 
		 <div class="logopanel">
		 	<a>云思订房系统后台管理系统</a>
         </div><!--logopanel-->
		 <div class="headerpanel">
			 <div class="headerright">
			 	<p><span>用户名！</span>云思订房系统欢迎您！</p>
				<a class="edit_password" href="#"><img src="images/top_icon1.png" width="88" height="30" /></a>
				<a class="" href="#"><img src="images/top_icon2.png" width="88" height="30" /></a> 
				<div class="clr"></div>	
			 </div> 
			 <div class="clr"></div>
		  </div><!--headerpanel-->
		 <div class="clr"></div>	
	</div>
	<!--head结束-->
	
	<!--main_left开始-->
	<div id="main_left">
		<div class="main_left_border">
				
			<!--一级目录-->
			<ul class="mainmenu">
				<li > 
					<a href="order_list.html">
						<img src="images/next_icon.png" width="10" height="5"/>
						<span class="order_icon">后台管理</span>
						<div class="clr"></div>	
					</a>
					<!--二级目录-->
					<ul class="navmenu">
						<li>
							<a href="showDireList.do?page=1&pageSize=3"><span class="none_nav" >课程方向管理</span></a>
						</li>
						<li>
							<a href="#"><span class="none_nav" >课程类型管理</span></a>
						</li>
						<li>
							<a href="#"><span class="none_nav" >课程管理</span></a>
						</li>
					</ul>
					<!--二级目录结束-->					
				</li>
			</ul><!--mainmenu-->
			
			
		</div>
	</div>
	<!--main_left结束-->
		
	<!--main_middle开始-->
	<div id="main_middle">
		<img id="left_on"  src="images/middle_btn1.png" width="8" height="60" />
		<img id="left_off" src="images/middle_btn2.png" width="8" height="60" style="display:none" />
	</div>
	<!--main_middle结束-->
		
	<!--main_right-->
	
	<div id="main_right"> 
		<div class="main_right_top">订单管理 > <span>全部订单</span></div>
		<div class="main_right_body"> 
			<div class="user_manage">
				<div class="search_all">
					<div class="search_one">
						<label>订单号：</label>
						<input type="text" />
					</div>
					<div class="search_one">
						<label>旅客：</label>
						<input type="text" />
					</div>
					<div class="search_one">
						<label>预定日期时间：</label>
						<input type="text" />
					</div>
					<a class="search_btn">查询</a>
				</div><!--search_all-->
				<div class="set_all">
					<div class="sta_number">
						<p>系统中共有<span>500</span>个订单</p>
					</div><!--sta_number-->
				</div>
				 <table border="0" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th>
								<input type="radio" />
							</th>
							<th>课程方向</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listDire }" var="dire">
						<tr>
							<td><input type="radio" /></td>
							<td>${dire.direction}</td>
							<td>
								<a href="order_detail.html"  class="td_link">查看详情</a>
								<a href="edit_order.html"  class="td_link">修改</a>
								<a href="#" class="td_link">删除</a>
							</td>
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
				<div class="page_all">
					<div class="pl_option">
						<a href="create_fx.jsp">添加课程方向</a>
						<a>批量删除</a>
					</div>
					<div class="page">
						<ul>
							<li>
								<a href="showDireList.do?page=1&pageSize=3"><span class="arrow_left"></span></a>
							</li>
							<%
								int totalPage = (Integer)request.getAttribute("totalPage");
								for(int i=0;i<totalPage;i++){
								%>
									<li><a href="showDireList.do?page=<%=(i+1) %>&pageSize=3"><%=i+1 %></a></li>	
								
							<%}%>
							
							<!-- <li class="page_active">
								<a>3</a>
							</li>
							 -->
							<li>
								<a href="showDireList.do?page=<%=totalPage %>&pageSize=3"><span class="arrow_right"></span></a>
							</li>
							<div class="clr"></div>
						</ul>
					</div>
					<div class="clr"></div>
				</div><!--page_all-->	
			</div><!--user_manage-->
		</div> <!--main_right_body-->
	</div>
</body>
</html>
