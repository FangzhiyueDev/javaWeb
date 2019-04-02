
create database Blog default charset=utf8;
--创建用户表

create table user(
	name char(6),
	qqNumber varchar(12),
	occupation varchar(20),
	hobby varchar(100),
	likeSinger varchar(12),
	likeMusic varchar(12),
	motto varchar(255),
	userid int(10) primary key,
	picture varchar(255),
	password varchar(12),
	nikeName varchar(8)
)default charset=utf8;
--插入管理员的用户信息的id
insert into user(userid) values(123456);
--插入一个普通用户的信息
insert into user(userid,password) values(34567,"rwe");
insert into user(userid,password) values(12245,"erwew");
insert into user(userid,password) values(56784,"rwefw");
insert into user(userid,password) values(34756,"erwwe");
insert into user(userid,password) values(90865,"fsdgs");
insert into user(userid,password) values(24235,"stwe");
insert into user(userid,password) values(43421,"wqtq");
insert into user(userid,password) values(67953,"26hw");
insert into user(userid,password) values(78574,"whwy4");
insert into user(userid,password) values(35367,"wywhw");
insert into user(userid,password) values(72747,"wy643");
insert into user(userid,password) values(472674,"weuwry");
insert into user(userid,password) values(73742,"85eje");
insert into user(userid,password) values(47346,"euey");


update user set name='无名帅蟀' where userid <> 34567

update user set name='芳芳不慌' where password="rwe";





create table manager(

	password varchar(12) not null,
	userid int(10) not null,
	managerId int(10) primary key,
	permission varchar(255),
	authorid int(10) not null,
	foreign key (userid) references user(userid) on delete cascade on update cascade,
	foreign key (authorid) references author(authorid) on delete cascade on update cascade 
)default charset=utf8;

--插入一条管理员数据
insert into manager(password,userid,managerId,authorid) values('123',123456,000000,111111);

--创建作者表
create table author(
	authorid int(10) primary key,
	nikeName varchar(8) 
)default charset=utf8;

drop table author;






--插入一条作者数据
insert into author values(111111,'fangyue');

--创建阅读记录信息表
create table readRecords(

	readRecordsid int(10) primary key auto_increment,
	userid int(10) not null,
	articlePublishTime varchar(12) not null,
	foreign key (userid) references user(userid) on delete cascade on update cascade,
	foreign key (articlePublishTime) references article(articlePublishTime) on delete cascade on update cascade
)default charset=utf8;

--插入一条阅读记录
--文章我们将内容存放在数据库中，使用文章发布的时间挫作为该表的主键
--12245  24235  34756  35367  43421  47346  56784  67953  72747  73742
--201811141808 201811141810 201811141811  201811141812 201811151354
insert into readRecords(userid,articlePublishTime) 
values(34756,'201811141810'),
(35367,'201811141812'),
(56784,'201811141808'),
(67953,'201811151354');

select articlePublishTime,count(articlePublishTime) 
from readRecords 
group by articlePublishTime
limit 6;

--创建文章评论表	
create table articleComment(
	userid int(10) not null,
	content varchar(255),
	articleCommentid int(10) primary key auto_increment,
	articlePublishTime varchar(12) not null,
	foreign key (userid) references user(userid) on delete cascade on update cascade,
	foreign key (articlePublishTime) references article(articlePublishTime) on delete cascade on update cascade
)default charset=utf8;
--插入文章评论表
--12245  24235  34756  35367  43421  47346  56784  67953  72747  73742
--201811141808 201811141810 201811141811  201811141812 201811151354
insert into articleComment(userid,content,articlePublishTime,commentTime)
values(34567,'浅显易懂，很不错','201811141808','201811141809'),
(12245,'这么好的文章，强烈推荐','201811141810','201811141815'),
(47346,'站长，能不能更改一下友情链接','201811151354','201811151400'),
(72747,'写的比较简单，只适合新手学习','201811151354','201811151432')

delete from articleComment;

alter table articleComment add commentTime varchar(12);

select user.picture,user.userid,user.name,articleComment.content,articleComment.commentTime
from user join articleComment on user.userid=articleComment.userid
order by articleComment.commentTime desc
limit 5;




create table article(
	articleDestribute varchar(255),
	articleName varchar(40),
	articlePublishTime varchar(12) primary key,
	authorid int(10),
	foreign key (authorid) references author(authorid) on delete cascade on update cascade
)default charset=utf8;



   select * from article where class in (select class from article)
   
   select * from article where class in 
   （);
   

--插入文章表
insert into article(articleDestribute,articleName,articlePublishTime,authorid)
values('学习seo优化 ','你应该知道的seo优化的方方面面','201810121308',111111)

insert into article(articleDestribute,articleName,articlePublishTime,authorid)
values('学习seo优化 ','你应该知道的seo优化的方方面面','201810121308',111111),

alter table article add articleAddress varchar(255);


delete from article;

insert into article(articleDestribute,articleName,articlePublishTime,authorid,articleAddress,articlePictureAddress)
values('1_常见标记','html里面的常用标记','201811141808',111111,'http://localhost:8080/Blog/article/1_common_mark.html','http://localhost:8080/Blog/html/img/one.jpeg'),
('2_css技术美化网页','使用css样式修饰，让你的html网页更加美观','201811141810',111111,'http://localhost:8080/Blog/article/2_css_technology_beautifies_webpage.html','http://localhost:8080/Blog/html/img/two.jpeg'),
('3_css的-div-盒子模型 ','使用div实现网页的复杂布局','201811141811',111111,'http://localhost:8080/Blog/article/3_css_division_box_model.html','http://localhost:8080/Blog/html/img/three.jpeg'),
('4_列表与超链接 ','使用常见列表超链接，使你的网页不在孤单','201811141812',111111,'http://localhost:8080/Blog/article/4_list_and_link.html','http://localhost:8080/Blog/html/img/four.jpeg'),
('5_js简单入门，了解js的发展历史，js的简单运算，定义变量，赋值等操作，了解js的基本组成部分','5_js简单入门','201811151354',111111,'http://localhost:8080/Blog/article/float_and_position.html','http://localhost:8080/Blog/html/img/five.jpeg');


insert into article(articleDestribute,articleName,articlePublishTime,authorid,articleAddress,class)
values('5_js简单入门，了解js的发展历史，js的简单运算，定义变量，赋值等操作，了解js的基本组成部分','js简单入门','201811151354',111111,'http://localhost:/8080/article/5_js简单入门.html','javascript学习基础')


update article set class="html基础入门"


select articleDestribute,articleName,
articlePublishTime,authorid,class,articlePictureAddress from article
where class='html基础'
order by articlePublishTime desc
 limit 6;



update article set articlePictureAddress='http://localhost:8080/Blog/html/img/one.jpeg'

alter table article modify articleAddress varchar(100)

update article set class='html基础'

alter table article add articlePictureAddress varchar(255);


alter table article add class varchar(40);



--创建图片表  用来实现对系统的主界面的图片进行更新的图片表的信息
create table picture(
	authorid int(10) not null ,
	pictureAddress varchar(255),
	uploadTime varchar(12),
	pictureid int(10) auto_increment primary key,
	foreign key (authorid) references author(authorid) on delete cascade on update cascade
) default charset=utf8; 

delete from picture;

--插入一条图片表的数据
insert into picture(authorid,pictureAddress,uploadTime)
values(111111,'http://localhost:8080/Blog/html/img/one.jpeg','201811120900');

insert into picture(authorid,pictureAddress,uploadTime)
value(111111,'http://localhost:8080/Blog/html/img/two.jpeg','201811120900');

insert into picture(authorid,pictureAddress,uploadTime)
value(111111,'http://localhost:8080/Blog/html/img/three.jpeg','201811120900');

insert into picture(authorid,pictureAddress,uploadTime)
value(111111,'http://localhost:8080/Blog/html/img/four.jpeg','201811120900');

insert into picture(authorid,pictureAddress,uploadTime)
value(111111,'http://localhost:8080/Blog/html/img/five.jpeg','201811120900');

insert into picture(authorid,pictureAddress,uploadTime)
value(111111,'http://localhost:8080/Blog/html/img/six.jpeg','201811120900');




--创建每日一语表(谚语表)
create table proverb(
	publishTime varchar(12),
	content varchar(255),
	authorid int(10) not null,
	proverbid int(10) auto_increment primary key,
	foreign key (authorid) references author(authorid) on delete cascade on update cascade
)default charset=utf8;

--插入每日一语表的信息
insert into proverb(publishTime,content,authorid) values('201811120904','我是一只鸟',111111);

insert into proverb(publishTime,content,authorid) values('201811120404',"生活应该简单才行",111111);
insert into proverb(publishTime,content,authorid) values('201811120404',"没有什么是不能过去的",111111);
insert into proverb(publishTime,content,authorid) values('201811120404',"简简单单，生活应该充满平淡",111111);
insert into proverb(publishTime,content,authorid) values('201811120404',"墙角的花，你孤芳自赏时，天地变小了",111111);
insert into proverb(publishTime,content,authorid) values('201811120404',"生命的舟，人参的诗",111111);
insert into proverb(publishTime,content,authorid) values('201811120404',"没有什么使我们不能前进",111111);
insert into proverb(publishTime,content,authorid) values('201811120404',"孔子曰，三人行必有我师",111111);
insert into proverb(publishTime,content,authorid) values('201811120404',"不能生的精彩，就要活的强大",111111);
insert into proverb(publishTime,content,authorid) values('201811120404',"岁岁天天年年",111111);
insert into proverb(publishTime,content,authorid) values('201811120404',"花儿的世界，你不懂，我也不懂",111111);

insert into proverb(publishTime,content,authorid) values('201811141630',"土地是以它的肥沃和收获而被估价的；才能也是土地，不过它生产的不是粮食，而是真理。如果只能滋生瞑想和幻想的话，即使再大的才能也只是砂地或盐池，那上面连小草也长不出来的",111111);


insert into proverb(publishTime,content,authorid) values('201811141630',"
过放荡不羁的生活，容易得像顺水推舟，但是要结识良朋益友，却难如登天。",111111);

 
--创建日志表
create table log(
	logTime varchar(12),
	authorid int(10) not null,
	content varchar(255),
	logid int(10) primary key auto_increment,
	foreign key (authorid) references author(authorid) on delete cascade on update cascade
)default charset=utf8; 

--插入一条日志记录
insert into log(logtime,authorid,content) values('201811031045',111111,'blog 开始开发')


--创建视频表
create table video(
	videoName varchar(20),
	videoAddress varchar(255) primary key,
	videoSize char(10),
	uploadTime varchar(12),
	videoNote text,
	videoDestribute varchar(255),
	authorid int(10) not null,
	foreign key (authorid) references author(authorid) on delete cascade on update cascade
)default charset=utf8; 



alter table video add classOrder int(4); 




--插入一条视频数据
insert into video(videoName,videoAddress,videoSize,uploadTime,videoNote,videoDestribute,authorid)
values('html base','http://10.109.1.201:8080/Blog/video/one.mp3','200mb','201811100534','详细介绍了有关于css的使用','常见的css选择器',111111);

insert into video(videoName,videoAddress,videoSize,uploadTime,videoNote,videoDestribute,authorid)
values('html常用的标签','http://10.109.1.201:8080/Blog/video/two.mp3','200mb','201811100544','html常见标签的使用','标题，文本格式化，段落。。等的使用',111111);

insert into video(videoName,videoAddress,videoSize,uploadTime,videoNote,videoDestribute,authorid)
values('html常用的标签','http://10.109.1.201:8080/Blog/video/two.mp3','200mb','201811100544','html常见标签的使用','标题，文本格式化，段落。。等的使用',111111);

delete from video

alter table video modify videoName varchar(40);

alter table video ADD class varchar(40);

update video set class='网页设计基础教程';

insert into video(videoName,videoAddress,videoSize,uploadTime,videoNote,videoDestribute,authorid)
values('HTML基础02_标准结构','http://10.109.1.201:8080/Blog/video/HTML基础02_标准结构.mp4','221MB','201811131735','HTML基础02_标准结构','HTML基础02_标准结构',111111),
('HTML基础08_表格(下)','http://10.109.1.201:8080/Blog/video/HTML基础08_表格(下).mp4','130M','201811131738','HTML基础08_表格(下)','HTML基础08_表格(下)',111111),
('HTML基础09_表单的设计及运用(上)','http://10.109.1.201:8080/Blog/video/HTML基础09_表单的设计及运用(上).mp4','269M','201811131739','HTML基础09_表单的设计及运用(上)','HTML基础09_表单的设计及运用(上)',111111),
('HTML基础12_CSS基础入门','http://10.109.1.201:8080/Blog/video/HTML基础12_CSS基础入门.mp4','119M','201811131740','HTML基础12_CSS基础入门','HTML基础12_CSS基础入门',111111),
('HTML基础14_CSS中的选择器(下)','http://10.109.1.201:8080/Blog/video/HTML基础14_CSS中的选择器(下).mp4','234M','201811131741','HTML基础14_CSS中的选择器(下)','HTML基础14_CSS中的选择器(下)',111111),
('HTML基础19_浮动','http://10.109.1.201:8080/Blog/video/HTML基础19_浮动.mp4','217M','201811131742','HTML基础19_浮动','HTML基础19_浮动',111111),
('HTML基础21_DIV+CSS布局实例项目二','http://10.109.1.201:8080/Blog/video/HTML基础21_DIV+CSS布局实例项目二.mp4','145M','201811131743','HTML基础21_DIV+CSS布局实例项目二','HTML基础21_DIV+CSS布局实例项目二',111111)

insert into video(videoName,videoAddress,videoSize,uploadTime,videoNote,videoDestribute,authorid)
values('HTML基础02_标准结构','http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','221MB','201811131735','HTML基础02_标准结构','HTML基础02_标准结构',111111),
('HTML基础08_表格(下)','http://localhost:8080/Blog/video/HTML基础08_表格(下).mp4','130M','201811131738','HTML基础08_表格(下)','HTML基础08_表格(下)',111111),
('HTML基础09_表单的设计及运用(上)','http://localhost:8080/Blog/video/HTML基础09_表单的设计及运用(上).mp4','269M','201811131739','HTML基础09_表单的设计及运用(上)','HTML基础09_表单的设计及运用(上)',111111),
('HTML基础12_CSS基础入门','http://localhost:8080/Blog/video/HTML基础12_CSS基础入门.mp4','119M','201811131740','HTML基础12_CSS基础入门','HTML基础12_CSS基础入门',111111),
('HTML基础14_CSS中的选择器(下)','http://localhost:8080/Blog/video/HTML基础14_CSS中的选择器(下).mp4','234M','201811131741','HTML基础14_CSS中的选择器(下)','HTML基础14_CSS中的选择器(下)',111111),
('HTML基础19_浮动','http://localhost:8080/Blog/video/HTML基础19_浮动.mp4','217M','201811131742','HTML基础19_浮动','HTML基础19_浮动',111111),
('HTML基础21_DIV+CSS布局实例项目二','http://localhost:8080/Blog/video/HTML基础21_DIV+CSS布局实例项目二.mp4','145M','201811131743','HTML基础21_DIV+CSS布局实例项目二','HTML基础21_DIV+CSS布局实例项目二',111111)

update video set classOrder=1 where videoName='HTML基础02_标准结构';
update video set classOrder=2 where videoName='HTML基础08_表格(下)';
update video set classOrder=3 where videoName='HTML基础09_表单的设计及运用(上)';
update video set classOrder=4 where videoName='HTML基础12_CSS基础入门';
update video set classOrder=5 where videoName='HTML基础14_CSS中的选择器(下)';
update video set classOrder=6 where videoName='HTML基础19_浮动';
update video set classOrder=7 where videoName='HTML基础21_DIV+CSS布局实例项目二';




select * from video where class in (select class from video group by class)








select videoName,videoAddress,videoSize,uploadTime,videoNote,videoDestribute,authorid from video

--降序查询视频数据
select videoName,videoAddress,videoSize,uploadTime,videoNote,videoDestribute,authorid
from video order by uploadTime desc limit 5;



--创建观看视频记录表
 create table videoWatch(
 	userid int(10) not null,
 	videoAddress varchar(255) not null,
 	videoWatchId int(10) primary key auto_increment,
 	watchTime varchar(12),
 	foreign key (videoAddress) references video(videoAddress) on delete cascade on update cascade,
 	foreign key (userid) references user(userid) on delete cascade on update cascade
 )default charset=utf8; 

 --插入一条观看记录数据
 -- http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4           --201811131735
 --http://localhost:8080/Blog/video/HTML基础08_表格(下).mp4			 --201811131738		
 --http://localhost:8080/Blog/video/HTML基础09_表单的设计及运用(上).mp4  --201811131739
 --http://localhost:8080/Blog/video/HTML基础12_CSS基础入门.mp4			 --201811131740
 --http://localhost:8080/Blog/video/HTML基础14_CSS中的选择器(下).mp4    --201811131741
 --http://localhost:8080/Blog/video/HTML基础19_浮动.mp4				 --201811131742	
 --http://localhost:8080/Blog/video/HTML基础19_浮动.mp4				 --201811131743
 --用户id 12245  24235  34756  35367  43421  47346  56784  67953  72747  73742
 insert into videoWatch(userid,videoAddress,watchTime) 
 values(24235,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (34756,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (35367,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (72747,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (35367,'http://localhost:8080/Blog/video/HTML基础09_表单的设计及运用(上).mp4','201811131739'),
 (35367,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (24235,'http://localhost:8080/Blog/video/HTML基础19_浮动.mp4','201811131743'),
 (35367,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (73742,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (12245,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (35367,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (67953,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (47346,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (35367,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (73742,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (35367,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735'),
 (56784,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','201811131735');
 
 --创建视频评论表
 create table videoComment(
 
 	videoCommentid int(10) primary key auto_increment,
 	userid int(10) not null,
 	videoAddress varchar(255) not null,
 	content varchar(255),
 	foreign key (videoAddress) references video(videoAddress) on delete cascade on update cascade,
 	foreign key (userid) references user(userid) on delete cascade on update cascade
 )default charset=utf8; 
 
 --插入一条视频评论
 insert into videoComment(userid,videoAddress,content) 
 values(34567,'http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4','很棒的课程'),
 (34567,'http://localhost:8080/Blog/video/HTML基础08_表格(下).mp4','讲解的比较系统，比较清楚，我感觉让我对表格的理解又上了一个台阶，很感谢，大力支持')
 
 
 
 select * from videoComment where videoAddress='http://localhost:8080/Blog/video/HTML基础02_标准结构.mp4';
 
 alter table videoComment add commentTime varchar(12);
 
update videoComment set commentTime='201811152035';
 
 --创建留言表
 create table leaveMessage(
     userid int(10) not null,
     leaveMessageid int(10) primary key auto_increment,
     leaveMessageTime varchar(12),
     content varchar(255),
     foreign key (userid) references user(userid) on delete cascade on update cascade 
 )default charset=utf8; 
 
--插入一条留言表
insert into leaveMessage(userid,leaveMessageTime,content) values(34567,'201811111210','很好')


--创建外链表
create table link(
   linkAddress varchar(255),
   linkid int(10) primary key auto_increment,
   authorid int(10) not null,
   content varchar(255)
)default charset=utf8;

--插入外链表
insert into link(linkAddress,authorid,content) values('http://www.baidu.com',111111,'百度一下');


--下面是一些测试数据
	create table test(
	  name varchar(34)
	  )
	  
	  default charset=utf8;
insert into test values('你嘎巴是高温高');

--
  ALTER TABLE test DEFAULT charset utf8;  
 
--删除数据表
drop tablle proverb;


select userid from user
union
select userid from leaveMessage

--内连接，可以获得两个表的数据
  select user.name,user.userid,user.picture,leaveMessage.content,leaveMessage.leaveMessageTime from user join leaveMessage on user.userid=leaveMessage.userid;

   select * from user where userid in (select userid from  leaveMessage);
 






--今天编写sql代码练习数据库

   
   --1查询所有管理员的用户信息、
   
   select * from user where userid in (select userid from manager) 
   























