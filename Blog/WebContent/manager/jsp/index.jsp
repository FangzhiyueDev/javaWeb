<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="../js/request.js"></script>
    <style type="text/css">
        *{
            margin: 0px;
            border: 0px;
            padding: 0px;
            list-style: none;
        }
        

        div.leftMenu{
            width:200px;
            height: 600px;
            float:left;
        }

        div.leftMenu div.top{
            height: 80px;
            width: 100%;
            line-height: 80px;
            font-size: 30px;
            background-color:#dfe0de;
            font-weight: bold;
            text-align: center;
        }
        div.leftMenu div.bottom{
            background-color: #4b4c4a;
            height:520px;
            width:100%;
        }

        ul.contentMenu li{
            text-align: center;
            color: #ccc;
            height: 40px;
            line-height: 40px;
            cursor: pointer;
            font-size: 14px;
        }

        ul.contentMenu li img{
            position: relative;
            top: 8px;
            margin-right: 5px;
        }

        /*li被点击后的class
        */
        .liMenuSelect{
            text-align: center;
            color: #fff;
            background:#2f302e;
            height: 40px;
            line-height: 40px;
            font-size: 16px;
        }
        
        div.rightContent{
        width:85%;
        height:600px;
        background-color: #ccc;
        overflow: hidden;
        }
        
    </style>
    <script type="text/javascript">
    	
    </script>
    <script type="text/javascript" src="../js/index.js"></script>
    <script type="text/javascript">
        window.onload=function(){

            /**
             * 处理菜单点击的效果
             */
            (function(){
            	progressMenuClick();
            })();  
        }

    </script>
</head>
<body>
<div class="leftMenu">
    <div class="top">BaLaBaLa</div>
    <div class="bottom">
        <ul class="contentMenu" id="contentMenu">
            <li><img alt="" src="../img/articleMana.svg">文章管理</li>
            <li><img src="../img/linkMana.svg"/>友链管理</li>
            <li><img src="../img/tupian.svg">图片管理</li>
            <li><img src="../img/proverbMana.svg"/>一言管理</li>
            <li><img alt="" src="../img/videomanage.svg">视频管理</li>
        </ul>
    </div>
</div>

<div class="rightContent">
		<c:if test="${sessionScope.mode==null}">
			<c:import url="content.jsp" ></c:import>
		</c:if>
</div>


</body>
</html>