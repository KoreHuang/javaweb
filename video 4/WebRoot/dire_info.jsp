<%@page import="com.video.vo.DTypeVO"%>
<%@page import="java.util.List"%>
<%@page import="com.video.vo.DirectionVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/global_style.css" type="text/css" />
</head>

<body>
		
	<%
		DirectionVO dvo =(DirectionVO) request.getAttribute("dvo");
	%>	
		
		<div class="main_right_top">订单管理 > <span>全部订单</span></div>
		<div class="main_right_body"> 
			<div class="user_manage">
				<div class="search_all">
					<div class="search_one">
						<label>课程方向：</label>
						<%=dvo.getDirection() %>
					</div>
				</div><!--search_all-->
				<div class="set_all">
					<div class="sta_number">
						<p>有<span>500</span>个课程类型</p>
					</div><!--sta_number-->
				</div>
				 <table border="0" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th>
								<input type="radio" />
							</th>
							<th>课程类型</th>
							<th>所属方向</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<%
						List<DTypeVO> listType =(List<DTypeVO>)request.getAttribute("listType");
						for(DTypeVO dtype : listType){
					%>
						<tr>
							<td><input type="radio" /></td>
							<td><%=dtype.getTname() %></td>
							<td><%=dvo.getDirection() %></td>
							<td>
								<a href="edit_order.html"  class="td_link">修改</a>
								<a href="#" class="td_link">删除</a>
							</td>
						</tr>
						<%} %>
					</tbody>
				</table>
				<div class="page_all">
					<div class="pl_option">
						<a>批量删除</a>
						<a>批量删除</a>
					</div>
					<div class="page">
						<ul>
							<li>
								<a><span class="arrow_left"></span></a>
							</li>
							<li>
								<a>1</a>
							</li>
							<li>
								<a>2</a>
							</li>
							<li class="page_active">
								<a>3</a>
							</li>
							<li>
								<a>4</a>
							</li>
							<li>
								<a>5</a>
							</li>
							<li>
								<a><span class="arrow_right"></span></a>
							</li>
							<div class="clr"></div>
						</ul>
					</div>
					<div class="clr"></div>
				</div><!--page_all-->	
			</div><!--user_manage-->
		</div> <!--main_right_body-->
	
</body>
</html>
