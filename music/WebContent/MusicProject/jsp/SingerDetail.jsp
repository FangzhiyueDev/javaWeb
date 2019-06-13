<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/music/MusicProject/index.js"></script>
    <title>Title</title>
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


        window.onload = function (ev) {


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


            function touchEvent() {

                var trSet = document.getElementsByClassName("playListSingle");
                for (var i = 0; i < trSet.length; i++) {

                    trSet[i].onclick = function (ev) {
                        //在这里执行具体的操作流程
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

                    trSet[i].onmouseover = function (ev) {
                        this.style.backgroundColor = "#111";
                        this.style.color = "#fff";
                    }

                    trSet[i].onmouseout = function (ev) {
                        this.style.backgroundColor = "";
                        this.style.color = "";
                    }

                }

            }


            touchEvent()


        }
    </script>

    <style>

        * {
            margin: 0px;
            padding: 0px;
            border: 0px;
        }

        div.container {
            width: 1000px;
            margin: 0 auto;
            overflow: hidden;
        }

        div.container ul.singerInfo li {
            display: block;
            height: 40px;
        }

        div.container ul.playAbout li {
            display: block;
            float: left;
            width: 200px;
            line-height: 30px;
            font-size: 16px;
            background-color: #2f302e;
            color: #ffffff;
            border-radius: 5px;
            margin-right: 10px;
            height: 30px;
            text-align: center;
            border: 1px solid #9a9a9c;
        }

        div.container table.tableMusicDis td.title {
            font-size: 20px;
        }

        div.container table.tableMusicDis {
            font-size: 14px;
            color: #535353;
        }

        div.container table.tableMusicDis tr.playListSingle {
            height: 40px;
        }


    </style>

</head>
<body>

<sql:setDataSource driver="com.mysql.jdbc.Driver" user="root" password="123" url="jdbc:mysql://localhost:3306/wwMusic"/>
<sql:query var="singer" >
	select singer.*, m.name musicName, m.id musicId, m.playTime,m.musicAddress
	from singer
       left join music m on singer.Id = m.singerId
	WHERE singer.Id=?;
   <sql:param value="${param.singerId}"></sql:param>
	
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

<div class="container">
    <!--左边的容器-->
    <img src="${path}${singer.rows[0].image}" style="float: left;width: 250px;height:250px;" width="250px;" class="albumImage"/>
    <div class="" style="float: left;padding-left: 200px;width: 500px">
        <h2 style="margin-bottom: 20px">${singer.rows[0].name}</h2>
        <ul class="singerInfo">
            <li>外文名: <span>${singer.rows[0].englishName}</span></li>
            <li>国籍: <span>${singer.rows[0].county}</span></li>
            <li>出生地: <span>${singer.rows[0].birthArea}</span></li>
            <li>职业: <span>${singer.rows[0].job}</span></li>
            <li>代表作品: <span style="color: red;text-decoration: underline;">${singer.rows[0].works}</span></li>
            <li><a href="#">更多</a></li>
        </ul>
    </div>

    <ul class="playAbout">
        <li>播放热门歌曲</li>
        <li>关注1315.4万</li>
    </ul>

    <div class="" style="margin-top: 20px">
        <table width="1000px" class="tableMusicDis">
            <tr style="height: 50px;">
                <td class="title">歌曲</td>
                <td class="title">歌手</td>
                <td class="title">时长</td>
            </tr>

		<c:forEach items="${singer.rows}" var="music">
            <tr class="playListSingle">
                <td>${music.musicName}</td>
                <td>${music.name}</td>
                <td>${music.playTime}</td>
                <td style="display: none" >${music.musicAddress}</td>
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
