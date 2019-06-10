<%@page import="com.fang.model.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- 
    这个界面的作用是实现播放视频的界面，
     -->
     
      <c:set var="path" value="http://localhost:8080${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="/Blog/jsp/css/indexTitle.css" type="text/css" rel="stylesheet">
 <link rel="stylesheet" href="/Blog/jsp//css/search.css" type="text/css">
 <script type="text/javascript" src="/Blog/html/js/param.js"></script>
 
 <style type="text/css">
 	
 	body{
 	background: #fff;
 	}
 
 </style>
 
   <script>
   
 
   
   /**
    * 当前视频播放界面的视频的地址
    * 请注意，这里是需要与jsp的参数进行交互的，我们进行点击进入当前的界面时，
    * 需要设置该值。用来保存系统的顶级参数
    * @type {string}
    */
    var currentVideoAddress="${requestScope.video.videoAddress}";
        //处理点击事件
        window.onload = function (ev) {
        	//当前视频的地址
        	//alert(currentVideoAddress)
           var formatDateAndTime = function (timeAndDate) {
                var year = timeAndDate.substring(0, 4);
                var month = timeAndDate.substring(4, 6)
                var day = timeAndDate.substring(6, 8)
                var hours = timeAndDate.substring(8, 10)
                var seconds = timeAndDate.substring(10, 12);
                var time = year + "-" + month + "-" + day + " " + hours + ":" + seconds;
                return time;
            }


            //定义打开相应的div  这个div里面就是相应的笔记 ，视频简介
            var ulobj = document.getElementsByClassName("classContent")[0];
            var spanObj = ulobj.getElementsByTagName("span");
            var scrollbarSet = ulobj.getElementsByTagName("div");
            var contentContainer = document.getElementsByClassName("contentDetail");

            var divCommentArea = document.getElementById("commentArea");
            var commentCountNumber = document.getElementById("commentCountNumber");
            for (var i = 0; i < spanObj.length; i++) {
                spanObj[i].index = i;
                spanObj[i].onclick = function (ev) {
                    this.className = "currentSelect";
                    scrollbarSet[this.index].className = "scrollBar";
                    //alert(this.index)
                    if (this.index == 1) {
                        spanObj[0].className = "";
                        scrollbarSet[0].className = "";
                        contentContainer[0].style.display = "none"
                        // divCommentArea.innerHTML = "";
                        // commentCountNumber.innerText = "0";
                    } else {
                        spanObj[1].className = "";
                        scrollbarSet[1].className = "";
                        contentContainer[1].style.display = "none"
                    }
                    //下面的代码的作用是打开相对应的div
                    contentContainer[this.index].style.display = "block"

                }
            }


            //定义搜索界面的点击事件的处理
            var imgButton = document.getElementById("searchButton");
            imgButton.onclick = function (ev) {
                var inputObj = document.getElementsByClassName("inputSearch")[0];
                if (inputObj.value == "全站搜索" || "" == inputObj.value) {
                    alert("请填写正确的查询条件")
                } else {
                    //在这里进行查询
                }
            }


            function Request() {
                /**
                 * 创建一个ajax对象
                 */
                this.createAJAX = function () {
                    var xhr;
                    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                        xhr = new XMLHttpRequest();
                    }
                    else {// code for IE6, IE5
                        xhr = new ActiveXObject("Microsoft.XMLHTTP");
                    }

                    return xhr;
                }

                /**
                 * @param url 请求的资源的地址
                 * @param parseJsonData ajax响应数据产生的回调函数
                 */
                this.requestGet = function (url, parseJsonData) {
                    var xhr = this.createAJAX();
                    //alert(xhr)
                    xhr.open("GET", url, true);
                    xhr.send();
                    xhr.onreadystatechange = function (ev) {
                        // alert(xhr.status)
                        if (xhr.readyState == 4) {
                            if (xhr.status == 200) {
                                var response = xhr.responseText;
                                parseJsonData(response);
                            }
                        }
                    }
                }

                /**
                 * @param url 请求的url
                 * @param parseJsonData 响应的回调函数
                 * @param requestparam 请求的参数
                 */
                this.requestPost = function (url, parseJsonData, requestparam) {
                    var xhr = this.createAJAX();
                    xhr.open("POST", url, true);
                    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    xhr.send(requestparam);
                    //alert(requestparam)
                    xhr.onreadystatechange = function (ev) {
                        // alert(xhr.status)
                        if (xhr.readyState == 4) {
                            if (xhr.status == 200) {
                                var response = xhr.responseText;
                                parseJsonData(response);
                            }
                        }
                    }
                }

            }

            function ParseRequest() {

                //获得用户对该文章的评论
                this.parseVideoComment = function (responseJsonData) {
                    // alert(responseJsonData)

                    var divCommentArea = document.getElementById("commentArea");
                    var commentCountNumber = document.getElementById("commentCountNumber");

                    var jsonComment = JSON.parse(responseJsonData);

                    divCommentArea.innerHTML = "";
                    commentCountNumber.innerText = 0;

                    if (jsonComment.length == 0) {
                        divCommentArea.innerHTML = "";
                        commentCountNumber.innerText = 0;
                        return;
                    }

                    for (var i = 0; i < jsonComment.length; i++) {
                        var user_videoComment = jsonComment[i];
                        var userObj = user_videoComment.user;
                        var name = userObj.name;
                        var userHeadAddress = userObj.picture;
                        var videoCommentObj = user_videoComment.videoComment;
                        var commentContent = videoCommentObj.content;
                        var commentTime = videoCommentObj.commentTime;

                        var date = commentTime.substring(0, 4) + "年"
                            + commentTime.substring(4, 6) + "月"
                            + commentTime.substring(6, 8) + "日 "
                            + commentTime.substring(8, 10) + ":"
                            + commentTime.substring(10, 12);

                        var innerHtml = "                                   <div class=\"commentSingle\">\n" +
                            "                                        <img src=\"" + serverRoot+userHeadAddress + "\" align=\"top\" width=\"50px\" height=\"50px\">\n" +
                            "                                        <div class=\"allComment\">\n" +
                            "                                            <div class=\"dimension\"></div>\n" +
                            "                                            <h5><span class=\"currentSelect \">" + name + "</span></h5>\n" +
                            "                                            <p class=\"commentContent\">" + commentContent + "</p>\n" +
                            "                                            <span class=\"commentDate\">" + date + "</span>\n" +
                            "                                        </div>\n" +
                            "                                    </div>\n";
                        divCommentArea.innerHTML += innerHtml;
                        commentCountNumber.innerText = jsonComment.length;
                    }
                }

                //点击评论的功能实现
                this.sendUserComment = function (responseJsonData) {
                    //这里响应的数据是我们的评论是否成功，如果成功，就从新刷新用户的评论
                    //alert(responseJsonData)
                    var responseData = JSON.parse(responseJsonData);
                    var loginurl = "http://localhost:8080/Blog/html/html/login.html";
                    switch (responseData.errorCode) {
                        case 1:
                            break;
                        case 2:
                            alert(responseData.errorCause)
                            break;
                        case 3:
                            location.href = loginurl;
                            break;
                    }
                    if (responseData.errorCode == 3) {
                        return;
                    }
                    if(responseData.errorCode == 1){//成功的情况下，就去刷新整个页面
                    //下面的代码是用来对评论进行刷新的
                    var request = new Request();
                    var parseRequest = new ParseRequest();
                    // alert(currentVideoAddress)
                    var requestUrl = videoServerAddress + "?videoAddress=" + currentVideoAddress
                        + "&videoComment=10";
                    request.requestGet(requestUrl, parseRequest.parseVideoComment)
                    
                    //清除文本框里面的值
                    var userComment = document.getElementsByName("userComment")[0];
                    userComment.value="";
                    }
                }
                //最新评论的刷新实现
                this.nowArticleComment = function () {
                    //直接调用parseArticleComment进行刷新
                    var request = new Request();
                    var requestUrl = videoServerAddress + "?videoAddress=" + currentVideoAddress
                        + "&videoComment=10";
                    request.requestGet(videoCommentTest, this.parseVideoComment)
                }

                //最新的视频播放的地址列表
                this.nowVideoPlayListData = function (responseJsonData) {
                    // alert(responseJsonData)
                    var jsonVideo = JSON.parse(responseJsonData);
                    progressVideoClassfy(jsonVideo)
                    progressSpanClick();
                }
                
                
                
                /*
                下面的代码是用来检测用户是否已经登录
                */
                
                /**
                 * 用户状态的查询
                 * @param ev
                 */
                this.userLoginInfo = function (jsonResponse) {
                   
                    var userStatus = JSON.parse(jsonResponse);
                    var responseResult=userStatus.responseResult;
                    if (responseResult.errorCode == 1) {
                        var userInfo = userStatus.user;
                        var urlAddress="http://localhost:8080/Blog/UserServlet?cancellation=true";
                        //代表已经登录了
                        var innerhtml = "            <a href=\"userCenter.html\"><img data-v-07578fd8=\"\" height=\"30\" src=\"" + serverRoot+userInfo.picture + "\" class=\"img-item-user\"/></a>\n" +
                            "            <a href=\"\" class=\"cancellationButton\"><span data-v-07578fd8=\"\" class=\"item-text\">注销</span></a>"
                        var loginBox = document.getElementById("login-box");
                        loginBox.innerHTML = innerhtml;
  
                        var cancellationButton=document.getElementsByClassName("cancellationButton")[0];
                        cancellationButton.onclick=function(ev){
                        	var request = new Request();
                            var parseData = new ParseRequest();		
                            //请求下线地址返回数据
                            request.requestGet(urlAddress, parseData.parseCanellationData);
                        }
                    }
                }
                    
                    this.parseCanellationData=function(jsonResponse){
                    	//alert(jsonResponse);
                    	window.location.reload();
                    }
                    
                    /**
                    请求获得视频播放的数量，以及更新当前的视频的播放量的服务返回数据的回调函数
                    */
                    this.parseVideoWatchCount=function(jsonResponse){
                    	//alert(jsonResponse);
                    	var countObj=JSON.parse(jsonResponse);
                    	var count=countObj.count;
                    	var spanObj=document.getElementById("watchCount");
                    	spanObj.innerHTML=count;
                    }
            }

            //视频处理的服务器地址
            var videoServerAddress = "http://localhost:8080/Blog/VideoCommentServlet";
            //视频评论请求的url
            //var videoComment = videoServerAddress + "?videoAddress=" + ${requestScope.video.videoAddress}
            //   +"&videoComment=10";

            var videoCommentTest = videoServerAddress + "?videoAddress="+currentVideoAddress+"&videoComment=10";


            //点击评论的部分url
            //var sendUserComment = videoServerAddress + "?videoAddress" + ${requestScope.video.videoAddress}
            //     +"&content=";

            var nowVideoPlayList = "http://localhost:8080/Blog/VideoServlet?allVideo=1";

            /***
             * ajax请求数据
             */
            function ajaxRequestData() {
                var request = new Request();
                var parseRequest = new ParseRequest();
                request.requestGet(videoCommentTest, parseRequest.parseVideoComment);
                request.requestGet(nowVideoPlayList, parseRequest.nowVideoPlayListData)
            }

            //调用
            ajaxRequestData();

            /**
             * 这个是通过点击事件来触发ajax请求的执行函数
             */
            function ajaxnowCommentClick() {
                var nowComment = document.getElementById("commentMenu");
                var videoSource = document.getElementsByTagName("video")[0];
                nowComment.onclick = function (ev) {
                    var request = new Request();
                    var parseRequest = new ParseRequest();
                    // alert(currentVideoAddress)
                    var requestUrl = videoServerAddress + "?videoAddress=" + currentVideoAddress
                        + "&videoComment=10";
                    request.requestGet(requestUrl, parseRequest.parseVideoComment)
                }


                //下面底点击评论的点击实现
                var commentSubmit = document.getElementById("commentSubmit");
                var userComment = document.getElementsByName("userComment")[0];
                commentSubmit.onclick = function (ev) {
                	
                	if(userComment.value==null||userComment.value.length==0){
                		userComment.focus();
                		alert("请输入评论内容")
                		return;
                	}
                	//alert(currentVideoAddress)
                    var request = new Request();
                    var parseRequest = new ParseRequest();
                    var requestUrl = "http://localhost:8080/Blog/VideoCommentServlet";
                    var requestParam = "videoAddress=" + currentVideoAddress
                        + "&content=" + userComment.value;
                    //alert(requestParam)
                    request.requestPost(requestUrl, parseRequest.sendUserComment, requestParam);
                }

            }

            //直接调用
            ajaxnowCommentClick();

            /**
             * 用来解析我们查询所有的视频信息的数据
             * 进行分类
             * @param jsonData
             */
            function progressVideoClassfy(jsonData) {
                var array = new Array();
                array[0] = jsonData[0].classfy;
                for (var i = 0; i < jsonData.length; i++) {
                    for (var j = 0; j < array.length; j++) {
                        if (jsonData[i].classfy != array[j]) {
                            array[array.length] = jsonData[i].classfy;
                        }
                    }
                }
                var classArray = new Array();

                for (var j = 0; j < array.length; j++) {
                    var videoArray = new Array();
                    for (var i = 0; i < jsonData.length; i++) {
                        if (jsonData[i].classfy == array[j]) {
                            videoArray[videoArray.length] = jsonData[i];
                        }
                    }

                    var classObj = {
                        "classfy": array[j],
                        "videoArray": videoArray
                    };
                    classArray[j] = classObj;
                }

                var videoPlayListBox = document.getElementById("videoPlayListBox");


                for (var i = 0; i < classArray.length; i++) {
                    var videoClassfy = classArray[i].classfy;
                    var innerOutHtml = "<div class=\"videoPlayListSingle\">\n" +
                        "                        <p>" + videoClassfy + "</p>\n" +
                        "                        <ul>\n";

                    for (var j = 0; j < classArray[i].videoArray.length; j++) {
                        var authorid = classArray[i].videoArray[j].authorid;
                        var classOrder = classArray[i].videoArray[j].classOrder;
                        var uploadTime = classArray[i].videoArray[j].uploadTime;
                        var videoAddress = classArray[i].videoArray[j].videoAddress;
                        var videoDestribute = classArray[i].videoArray[j].videoDestribute;
                        var videoName = classArray[i].videoArray[j].videoName;
                        var videoNote = classArray[i].videoArray[j].videoNote;

                        var videoSingle = JSON.stringify(classArray[i].videoArray[j]);

                        var innerInHtml = "            <li class=\"videoPlayItem\">\n" +
                            "                                <a href=\"#\">\n" +
                            "                                    <span class=\"classVideoFont\">第" + classOrder + "节课</span>\n" +
                            "                                </a>\n" +
                            "                                <span  class='hiddleInfo'>" + videoSingle + "</span>" +
                            "                            </li>\n";
                        innerOutHtml += innerInHtml;
                    }
                    var closeTag = "            </ul>\n" +
                        "      </div>";
                    innerOutHtml += closeTag;
                    videoPlayListBox.innerHTML += innerOutHtml;
                }
            }

            /**
             * 处理对页面右边视频播放列表的点击事件的处理
             这个还应该有下面的功能，实现的效果是，我们点击视频播放，我们需要发送一个ajax请求到服务器，修改对应视频的观看量，同时将阅读量进行返回
             
             */
            function progressSpanClick() {
                //被进行点击事件处理的span
                var linkspan = document.getElementsByClassName("classVideoFont")
                //隐藏信息，用来实现对数据的存储
                var hiddleInfos = document.getElementsByClassName("hiddleInfo");
                //视频播放的名称
                var videoName = document.getElementById("videoName");
                //视频播放的简介
                var contentDetailContent = document.getElementById("contentDetailContent");
                //视频播放的笔记
                var studyNote = document.getElementById("studyNote");

                var videoSource = document.getElementsByTagName("video")[0];
                for (var i = 0; i < linkspan.length; i++) {
                    linkspan[i].index = i;
                    linkspan[i].onclick = function (ev) {
                        var videoSingleJsonObj = JSON.parse(hiddleInfos[this.index].innerText);
                        videoName.innerText = videoSingleJsonObj.videoName;
                        videoSource.src = serverRoot+videoSingleJsonObj.videoAddress;
                        currentVideoAddress =videoSingleJsonObj.videoAddress;
                        videoSource.autoplay = true;

                        //下面是去更新具体的数据

                        //1学习笔记
                        studyNote.innerHTML = videoSingleJsonObj.videoNote;

                        //2.课程简介
                        contentDetailContent.innerHTML = videoSingleJsonObj.videoDestribute;

                        //评论数量
                        var requestUrl = videoServerAddress + "?videoAddress=" + videoSingleJsonObj.videoAddress
                            + "&videoComment=10";
                        var request = new Request();
                        var parseRequest = new ParseRequest();
                        request.requestGet(requestUrl, parseRequest.parseVideoComment);

                        //最新评论的点击处理
                        //搞定了

                        //评论主体以及评论内容
                        //搞定了
                        //alert(videoSingleJsonObj.videoAddress)
                        requestUrl="http://localhost:8080/Blog/VideoServlet?videoAddress="+videoSingleJsonObj.videoAddress+"&opration=watchCount";
                        request.requestGet(requestUrl,parseRequest.parseVideoWatchCount);
                        
                    }
                }
            }
            
            
            /**
            检验用户是否已经登录
            */
            (function(){
            	var requestUserStatus="http://localhost:8080/Blog/UserServlet?status=1";
                var req = new Request();
                var parseRequest = new ParseRequest();
                req.requestGet(requestUserStatus, parseRequest.userLoginInfo);
            })();
            
            
        }
    </script>
     <style>
        .body {
            background-color: #f7f7f7;
        }

        div.contentBox {
            width: 1200px;
            margin: 0 auto;
            overflow: hidden;
            background-color: #f7f7f7;

        }

        div.contentBox div.leftPlayBox {
            overflow: hidden;
            width: 65%;
            margin-top: 20px;
            float: left;
            background-color: #ffffff;
        }

        div.contentBox div.leftPlayBox div.videoPlayBox {
            /*margin:20px 0px 20px 0px;*/
            margin-bottom: 20px;
            padding-bottom: 20px;
            border-bottom: 1px solid #ccc;
        }

        div.contentBox .videoPlayBox h3.titleOut {
            text-align: center;
            margin: 20px 0px 20px 0px;
        }

        div.contentBox .videoPlayBox span.title {
            color: #0e91ff;
        }

        .currentSelect {
            color: #ff1e21;
            display: inline-block;
        }

        div.classDescributeBox div.scrollBar {
            height: 2px;
            width: 64px;
            background-color: #ff1e21;
        }

        div.classDescributeBox li.classDescribute {
            display: inline-block;
            margin-right: 30px;
            margin-left: 30px;
        }

        div.classDescributeBox div.contentDetail {
            overflow: hidden;
        }

        div.classDescributeBox div.contentDetail div.contentDetailContent {
            font-family: "microsoft yahei";
            margin: 10px 0px 100px 10px;

        }

        div.classDescributeBox div.contentDetail div.commentArea {
            margin-left: 10px;
       		overflow: hidden;
        }

        div.commentSingle {
            margin-bottom: 20px;
        }

        div.classDescributeBox div.contentDetail div.commentArea textarea.videoComment {

            border: 1px solid #b1afb4;
            border-radius: 3px;
            padding: 5px;
            margin-left: 10px;
            width: 650px;
            height: 128px;
            resize: none;

        }

        div.classDescributeBox div.contentDetail div.commentArea input.commentSubmit {
            display: block;
            float: right;
            margin: 5px 50px 10px 0px;
            color: #ff1e21;
            text-decoration: underline;
            background: none;
        }

        div.classDescributeBox div.contentDetail div.commentArea img.userHeader {
			width:50px;
			height:50px;
			border-radius: 25px;
        }

        div.allComment {
            display: inline-block;
        }

        div.classDescributeBox div.contentDetail div.commentList span.commentCount {
            background-color: #e5e3e8;
            border: 1px solid #bfbfbf;
            border-radius: 4px;
            margin-left: 10px;
            color: #8b8b8b;
            padding: 2px;
            /*font-size: 12px;*/
        }

        div.classDescributeBox div.contentDetail div.commentList li.commentMenu {
            display: inline-block;
            float: right;
            margin-right: 50px;
        }

        div.classDescributeBox div.contentDetail div.commentList li.commentMenu span {
            background-color: #e5e3e8;
            border: 1px solid #bfbfbf;
            border-radius: 4px;
            color: #ff1e21;
            width: 66px;
            padding: 2px;
        }

        div.classDescributeBox div.contentDetail div.commentList span.commentCount span.commentCountNumber {
            color: #ff1e21;
        }

        .dimension {
            height: 5px;
        }

        p.commentContent {
            font-size: 13px;
        }

        div.allComment span.commentDate {
            font-size: 14px;
        }

        /**
        下面是视频播放的列表相关的信息
         */
        div.rightPlayBox div.videoPlayListBox {
            margin: 10px 0px 10px 0px;
            background-color: #FFFFFF;
            width: 100%;
        }

        /**
        下面是关于对右边播放列表的设置
         */
        li.videoPlayItem {
            width: 30%;
            height: 30px;
            margin-left: 5px;
            text-align: center;
            color: #a0a0a0;
            margin-bottom: 5px;
            display: inline-block;
            line-height: 30px;
            border: 1px solid #8b84e6;
            border-radius: 5px;
        }

        div.videoPlayListBox p {
            text-align: center;
            padding: 10px 0px;
        }

        div#studyNote {
            margin: 10px;
            padding: 10px;
            background-color: black;
            color: #ffffff;
            display: none;
        }

        span.classVideoFont {
            color: #a0a0a0;
            font-size: 14px;
        }

        span.hiddleInfo {
            display: none;
        }

        div.rightPlayBox div.side-nav li.nav-1 {
            width: 40%;
            height: 40px;
            text-align: center;
            float: left;
            line-height: 40px;
            margin-right: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
        }
        
        
          /*登录界面的头像显示的布局*/ 
       img.img-item-user {
            position: relative;
            top: 10px;
            margin-right: 10px;
            border-radius: 15px;
        }
        
    </style>
</head>
<body>
 <div data-v-07578fd8="" class="header-wrap clearfix">
    <img data-v-07578fd8="" src="http://localhost:8080/Blog/jsp/images/logo.9bde9cc.png" alt="段亮个人博客" class="logo fl">
    <div data-v-07578fd8="" class="nav-wrap">
        <ul data-v-07578fd8="" class="nav-list">
            <li data-v-07578fd8="" class="nav-item "><a href="../../Blog/html/html/index.html">首页</a></li>
            <li data-v-07578fd8="" class="nav-item"><a href="../../Blog/html/html/videoPage.html" class="linkPage active">免费视频教程</a></li>
            <li data-v-07578fd8="" class="nav-item"><a href="../../Blog/html/html/webMode.html" class="linkPage">网站模板</a></li>
            <li data-v-07578fd8="" class="nav-item"><a href="../../Blog/html/html/studyPage.html" class="linkPage">学无止境</a></li>
            <li data-v-07578fd8="" class="nav-item"><a href="../../Blog/html/html/personalNotePage.html" class="linkPage">个人日记</a></li>
            <li data-v-07578fd8="" class="nav-item"><a href="../../Blog/html/html/learnMe.html" class="linkPage">关于方志月</a></li>
            <li data-v-07578fd8="" class="nav-item"><a href="../../Blog/html/html/leaveMessage.html" class="linkPage">留言板</a></li>
        </ul>
        <div data-v-07578fd8="" class="login-box" id="login-box">
             <a href="../../Blog/html/html/login.html"><span data-v-07578fd8="" class="item-text">登录</span></a>/
             <a href="../../Blog/html/html/login.html"><span data-v-07578fd8="" class="item-text">注册</span></a>
        </div>
    </div>
</div>

<div class="body">
    <div class="contentBox">
        <div class="content">
            <!--左边-->
            <div class="leftPlayBox">
                <!--视频播放布局-->
                <div class="videoPlayBox">
                    <h3 class="titleOut"><span class="title" id="videoName">${requestScope.video.videoName}</span></h3>
                    <!--视频播放-->
                    <div class="videoPlayer">
                    <!--测试数据 http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4 -->
                        <video width="100%" height="100%" controls src="${path}${requestScope.video.videoAddress}">
                            <!--<source src="../video/HTML基础02_标准结构.mp4" id="videoSource">-->
                            你的浏览器不支持html渲染播放
                        </video>
                    </div>
                </div>

                <!--课程简介部分-->

                <script>
                </script>

                <div class="classDescributeBox">
                    <ul class="classContent">
                        <li class="classDescribute">
                            <a href="#"><span class="currentSelect">课程简介</span></a>
                            <div class="scrollBar"></div>
                        </li>
                        <li class="classDescribute">
                            <a href="#"><span>学习笔记</span></a>
                            <div></div>
                        </li>
                        <!-- 自己根据实际需求添加的新的功能，对文章的播放量进行统计 -->
                        <li class="classDescribute">
                            <a href="#">播放量: <span class="currentSelect" id="watchCount">${requestScope.watchCount}</span></a>
                            <div></div>
                        </li>
                    </ul>

                    <!--主体信息的呈现部分-->
                    <div>
                        <div class="contentDetail" id="classDescributeDetail">

                            <!--该div封装了课程简介的详细信息-->

                            <div class="contentDetailContent" id="contentDetailContent">
                                <!--这个div的内容是自动填充的，由我们的数据进行填充-->
                                ${requestScope.video.videoDestribute}
                            </div>

                            <!--用户留言-->
                            <div class="commentArea">
                                <img src="http://localhost:8080/Blog/jsp/images/head.jpeg" class="userHeader" align="left" hspace="10px">
                                <form action="#" method="post">
                                    <textarea name="userComment" value="有什么想对方志月这小子说的" class="videoComment"></textarea>
                                    <input type="button" value="点击评论" class="commentSubmit" id="commentSubmit">
                                </form>
                            </div>
                            <!--留言列表-->
                            <div class="commentList">
                                <span class="commentCount"><span class="commentCountNumber"
                                                                 id="commentCountNumber">1</span>条评论</span>
                                <li class="commentMenu" id="commentMenu"><span>最新评论</span></li>
                                <!--分割线-->
                                <div style="background-color: #cccccc;height: 1px;margin:10px"></div>
                                <div class="commentArea" id="commentArea">
                                <!-- 
                                    <div class="commentSingle">
                                    <img src="http://localhost:8080/Blog/jsp/images/head.jpeg" align="top" width="50px" height="50px">
                                    <div class="allComment">
                                    <div class="dimension"></div>
                                    <h5><span class="currentSelect ">帅帅的小伙子</span></h5>
                                    <p class="commentContent">这么帅气的视频，我一定要好好看完这些东西</p>
                                    <span class="commentDate">2018年11月14日</span>
                                    </div>
                                    </div> -->

                                </div>
                            </div>
                        </div>
                        <!--学习笔记的界面显示-->
                        <div class="contentDetail" id="studyNote">${requestScope.video.videoNote}</div>
                    </div>
                </div>
            </div>
            <!--右边-->
            <div class="rightPlayBox">
                <div class="searchArea">
                    <div class="searchBox">
                        <input type="text" maxlength="40" size="24" value="全站搜索" class="inputSearch">
                        <img src="http://localhost:8080/Blog/html/img/search.svg" class="searchIcon" id="searchButton"/>
                        <script>
                        </script>
                    </div>
                </div>

                <div class="classMenu">
                    <!--常见模块-->
                    <div data-v-d0a26284="" class="side-nav">
                        <ul data-v-d0a26284="" class="clearfix">
                            <li data-v-d0a26284="" class="nav-1 bgcolor_1"><a data-v-d0a26284="" href="learnMe.html"
                                                                              class="fontColor">关于我</a>
                            </li>
                            <li data-v-d0a26284="" class="nav-2 bgcolor_2"><a data-v-d0a26284="" href="videoPage.html"
                                                                              class="fontColor">视频教程</a>
                            </li>
                            <li data-v-d0a26284="" class="nav-1 bgcolor_3"><a data-v-d0a26284=""
                                                                              href="#"
                                                                              class="fontColor">SEO优化</a></li>
                            <li data-v-d0a26284="" class="nav-2 bgcolor_4">
                                <!--下面的链接部分需要进行检测，我们需要判断用户是否在线，如果在线，跳转到留言界面，反之跳转到登录界面-->
                                <a data-v-d0a26284=""
                                   href="leaveMessage.html"
                                   class="fontColor">留言版</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="videoPlayListBox" id="videoPlayListBox">
                 
                </div>
            </div>
      
        </div>
    </div>
</div>
</body>
</html>