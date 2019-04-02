/**
 * http://usejsdoc.org/
*/

/**
 * 处理模块数据的返回数据的对象
 * @returns
 */
function ResponseModel(){
	
	this.parseSelectMode=function(jsonResponse){
		var jsonData=JSON.parse(jsonResponse);
		if(jsonData.errorCode==1){
			//响应成功
			location.href=location.href;
		}
	}
	
}



/**
 * 发送菜单包含的模块信息。实现的功能是界面的动态包含技术
 * @param modeName
 * @returns
 */
function sendMenuIncludeMode(modeName){
    var request=new Request();
    var url="http://localhost:8080/Blog/ModeServlet?modeName="+modeName;
    var response=new ResponseModel();
    request.requestGet(url,response.parseSelectMode);
        		
}



/*
 * 主界面处理点击事件的效果
 */
function progressMenuClick() {
                    var contentMenu=document.getElementById("contentMenu");
                    var liSet=contentMenu.getElementsByTagName("li");
                    for(var i=0;i<liSet.length;i++){
                        liSet[i].index=i;
                        liSet[i].onclick=function(ev){
                            this.className="liMenuSelect";
                            sendMenuIncludeMode(this.innerText);
                        }
                        liSet[i].onmouseover=function(ev){
                        	 this.className="liMenuSelect";
                        }
                        
                        liSet[i].onmouseout=function (ev) {
                            this.className="";
                        }
            }
 }