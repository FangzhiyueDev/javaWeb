<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/music/MusicProject/index.js"></script>
    <title>Title</title>
    <style>
        a {
            text-decoration: none;
        }

        * {
            margin: 0px;
            padding: 0px;
            border: 0px;
        }

        div.leftContainer {

            width: 300px;
            overflow: hidden;

        }

        div.leftContainer li {
            display: block;
            margin-top: 10px;
            margin-bottom: 10px;
            font-size: 14px;
            color: #606060;
        }

        div.leftContainer li span {
            font-size: 13px;
            color: red;
            text-decoration: underline;
        }

        div.rightContainer {
            margin-left: 40px;
        }

        div.rightContainer div.oprateSet {
            width: 600px;

        }

        div.rightContainer div.oprateSet button {
            margin: 0px 60px 10px 0px;
            text-align: left;
        }

        div.rightContainer ul.albumDes {
            font-size: 20px;
        }

        div.rightContainer ul.albumDes li {
            margin: 20px 60px 10px 0px;
        }
    </style>
    
    <script>
    
    function sendAjax(url, response) {
        var xhr;
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                response(xhr.responseText);
            }
        }
        xhr.open("GET", url, true);
        xhr.send();
    }
    
    	window.onload=function(){
    		
    		 var onLoadUserData = function () {

                 var url1 = "?loginStatus=false";
                 sendAjax(serverRoot+"/UserLoginAction" + url1,
                     function (response) {
                         var user = JSON.parse(response);//传递的是user对象
                         if (user == null || user.name == null) {
                         } else {
                             setLoginStatus(true, user.name);
                         }
                     });
             };
             onLoadUserData();	
             
  
             //下面是点击事件的处理
             function clickEvent(){
            	 
            	 var trSet=document.getElementsByClassName("albumListMusic");
            
            	 for(var i=0;i<trSet.length;i++){
            		 trSet[i].onclick=function(ev){
            		
            			  var source = document.getElementById("audioResource");
            			  var tdSet=this.getElementsByTagName("td");
            			  var mn=tdSet[0].innerText;
            			  var sn=tdSet[1].innerText;
            			  var image=document.getElementsByClassName("albumImage")[0].src;
            			  var musicAddress=tdSet[3].innerText;
                          source.src = serverRoot + musicAddress;
                          var img = document.getElementById("playingMusic");
                          var musicName = document.getElementById("musicName");
                          var singerName = document.getElementById("singerName");
                          img.src = image;
                          musicName.innerText = mn;
                          singerName.innerText =sn;
                          source.play();
            		 }
            		 trSet[i].onmouseover=function(ev){
            			 this.style.backgroundColor="#111";
            			 this.style.color="#fff"
            		 }
            		 trSet[i].onmouseout=function(ev){
            			 this.style.backgroundColor="";
            			 this.style.color=""
            		 }
            	 }
            	 
             }
             clickEvent();
    	}
    </script>
</head>
<body>
<sql:setDataSource driver="com.mysql.jdbc.Driver" user="root" password="123" url="jdbc:mysql://localhost:3306/wwMusic"/>



<sql:query var="albums" >
	select music.id, music.name musicName, s.name singerName, music.playTime,music.musicAddress, a.*
	from music
       join album a on music.albumId = a.id
       join singer s on music.singerId = s.Id
	where albumId = ?
   <sql:param value="${param.albumId}"></sql:param>
	
</sql:query>


 <c:set var="path" value="${pageContext.request.contextPath}"/>


<!--创建导航条-->
<div style="overflow: hidden" id="navigateBarOut"></div>
<script src="../template/mode/model.js"></script>
<script src="../template/navigateBar.js"></script>
<link rel="stylesheet" href="../template/css/navigateBar.css">
<script>

    var navigateBarOut = document.getElementById("navigateBarOut")

    navigateBarOut.style.marginBottom = "20px"

    navigateBarOut.innerHTML = createView;

    createNavigate(null, [
        new ClickItem("爱看", "../html/index.html"), new ClickItem("我的音乐", "../html/myMusic.html")
    ], "login.html", "register.html")
</script>




<div style="width: 1000px;margin: 0 auto;">
    <div class="leftContainer" style="float: left;">
        <img src="${path}${albums.rows[0].image}" width="240px" style="display: block" class="albumImage"/>
        <ul>
            <li>专辑语种 <span>${albums.rows[0].language}</span></li>
            <li>唱片公司 <span>${albums.rows[0].company}</span></li>
            <li>专辑类别 <span>${albums.rows[0].classfyType}</span></li>
        </ul>

        <h3 style="margin-top: 20px;margin-bottom: 20px">专辑介绍</h3>
        <p style="margin-bottom: 20px">${albums.rows[0].describute}</p>
        <p><a href="#">更多</a></p>
    </div>


    <div class="rightContainer" style="float: left;">
        <img src="${path}${ albums.rows[0].image}" width="40px" style="border-radius: 3px"/>
        <span style="margin-left: 10px;font-size: 13px;color: #9a9a9c;">${albums.rows[0].publishTime}  发行</span>
        <h2 style="margin-top: 10px;margin-bottom: 10px">${albums.rows[0].name}</h2>
        <h6 style="color: #6f6f71;font-size: 14px;margin-bottom: 10px">${albums.rows[0].type}</h6>
        <div class="oprateSet">
            <button>全部播放</button>
            <button>收藏<span>3245</span></button>
            <button>分享</button>
            <button>手机试听</button>
            <button>更多&gt;</button>
        </div>

        <ul class="albumDes">
            <li><span style="">${albums.rowCount}</span> 首歌</li>
            <li>歌曲</li>
            <li>歌手</li>
            <li>时长</li>
        </ul>

        <h3 style="margin-top: 40px;margin-bottom: 30px">Disc 1</h3>
        <table style="width: 600px;">
        
        <c:forEach items="${albums.rows}" var="album">
            <tr style="height: 40px;" class="albumListMusic">
                <td >${album.musicName}</td>
                <td>${album.singerName}</td>
                <td>${album.playTime}</td>
                <td style="width:0px;display: none;">${album.musicAddress}</td>
            </tr>
        </c:forEach>
        </table>
    </div>
</div>

<!--这个是播放的列表-->

<div style="width: 100%;
height: 50px;background-image: url('../images/bg.jpg');
position:fixed;z-index: 15;bottom:0px; left:0px;">


    <div style="width: 1000px;overflow: hidden;margin: 0 auto;position: relative;top: 5px;
background: #111111;color: #ffffff;">

        <audio controls style="width: 500px;" id="audioResource">
        </audio>
           <img src="../images/上一页.svg"/>
        <img src="../images/下一页.svg" style="position: relative;top: -2px;"/>
        <div style="display: inline-block">
            <img src="" id="playingMusic" height="30px"/>
            <ul>
                <li><span id="singerName"></span></li>
                <li><span id="musicName"></span></li>
            </ul>
        </div>
    </div>
</div>


</body>
</html>