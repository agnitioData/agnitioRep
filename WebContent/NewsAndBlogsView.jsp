<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News & Blogs View</title>

 <style type="text/css">
body
{
   background-color: #fff;
}

#navigation {
	height:38px; list-style-type:none; font-family:Verdana, Geneva, sans-serif; color:#fff; font-size:13px;
}
#navigation li {
	list-style-type:none; float:left;
}
#navigation li a {
	color:#fff; display:block; text-decoration:none; padding:9px 32px 11px; background:url(../images/navigation_division.png) no-repeat right 0;
}
#navigation li a:hover, #navigation li a.active {
	color:#000;
}
.slide {
	height: 670px;
    padding: 10px 0 0 19px;
    width: 960px;
	overflow:hidden
}
div#menu {
    /*top:40px;
    left:0px;*/
    width:100%;
}
#sliding_logos {
	width:930px; height:107px; background:url(../images/partner_university_bg.png) no-repeat 0 0; margin:25px 0 0 26px;padding: 23px 0 0 15px; float:left;
}
ul.footer_links {
	list-style-type:none;
	float:left;
	width:110px;
	padding:5px 20px 0px 20px;
	min-height:147px;
	background:url(../images/footer_menu_separator.png) no-repeat right 0;	
}
ul.footer_links li {
	list-style-type:none;
}
ul.footer_links li a {
	color:#000;
	text-decoration:none;
	font-weight:bold;
	font-family:Verdana, Geneva, sans-serif; 
	font-size:11px;
	line-height:13px;
	display:block;
	padding: 3px 0;
}
ul.footer_links li a:hover {
	text-decoration:underline;
}
ul.footer_links li ul {
	padding:0 0 0 5px;
}
ul.footer_links li ul li a {
	font-weight:normal;
}
ul#top_links {
	height:35px; list-style-type:none; font-family:Verdana, Geneva, sans-serif; color:#fff; font-size:12px; float:right;
}
ul#top_links li {
 float:left; list-style-type:none;
}
ul#top_links li a {
	color:#fff; text-decoration:none; display:block; background:url(../images/bullet1.png) no-repeat right 12px; padding:8px 12px 8px 30px;
}
ul#top_links li a:hover {
	color:#000;
}




div#menu {
	/*background: transparent url(../images/menu_m.png) repeat-x scroll 0 0;
	position: absolute;*/
	top: 0;
	left: 0;
	color: #fff;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 13px;
	line-height: 150%;	
	margin-left:10px;
}

ul.menu {
	clear: both;
	float: none;
	cursor: pointer;
	z-index: 1000;
	position: relative;
}

div#menu ul {
	padding: 0px;
	list-style: none;
	float: left;
	z-index: 1001;
	position: relative;
    margin-left: 0px;
    margin-right: 0px;
    margin-top: 0px;
}

div#menu li {
	position: relative;
	margin: 0px;
	padding: 0px;
	display: block;
	overflow: visible;
	float: left;  
	z-index: 1002;
	background:url(../images/navigation_division.png) no-repeat right 0
}
div#menu li.last {
	background:none;
}
/* menu::level1 */
div#menu li a {
	display: block;
	float: left;
	text-decoration: none;
	color: #fff;
	overflow: hidden;
	z-index: 1003;
  position: relative;
    top: 0px;
    left: 0px;
}
div#menu li a.active span {
    color:#000;
}
div#menu li span {  
	color: #fff; 
	display: block;
	padding: 9px 22px;
  background-repeat: no-repeat;
	background-position: 95% 0px;
	z-index: 1004;
	position: relative;
}

div#menu li span.bg { 
	display: block;
  background: transparent url('../images/menu_level1_item.png') repeat-x scroll 0pt 100%;
  padding: 0;
	height: 30px;
	z-index: 5;
	position: relative;
  float: left;
}

div#menu li.current {  
	font-weight: bold;
}

div#menu li.current ul {  
	font-weight: normal;
}

/* menu::level2 */
div#menu ul.menu ul {
	padding: 0px 0px 10px;
	background: transparent url('../images/menu_dropdown_bg.png') no-repeat scroll 0pt 100%; 
	_background: transparent url('../images/menu_dropdown_bg.gif') no-repeat scroll 0pt 100%;	
	left: -999em; 
	width: 165px;
	position: absolute;
	top: 37px;
}
div#menu ul.menu ul li {
	background:none;
}
div#menu ul.menu ul li span {  
	color: #ED8C13;
    display: block;
    line-height: 16px;
    padding: 5px 15px 8px;
}
div#menu li:hover ul, div#menu li.sfhover ul { 
	left: 0px; 
	z-index: 100;
	visibility: visible; 
}

div#menu li li { 
	width: 100%; 
	text-indent: 0px;
	float: none; 
	height: auto;
}

div#menu li li a, div#menu li li span.separator { 
	margin: 0px 1px;
	padding: 0px; 
	/*background: url('../images/menu_level2_item.gif') no-repeat scroll 100% bottom;*/
	border-bottom:1px solid #ccc;
	height: auto; 
	float: none; 
	display: block; 
	line-height: 25px; 
	width: 163px;
}

div#menu li li a.parent { 
	background: url('../images/menu_level2_item_parent.gif') no-repeat scroll 100% bottom;
}

/* menu::level3 */
div#menu li ul ul { 
	margin: -37px 0 0 164px;
}

div#menu li:hover ul ul, div#menu li.sfhover ul ul { 
	border-top: 1px solid #cccccc; 
}

div#menu li:hover ul ul, div#menu li.sfhover ul ul, div#menu li:hover ul ul ul, div#menu li.sfhover ul ul ul, div#menu li:hover ul ul ul ul, div#menu li.sfhover ul ul ul ul { 
	left: -999em; 
}
div#menu li li:hover ul, div#menu li li.sfhover ul, div#menu li li li:hover ul, div#menu li li li.sfhover ul, div#menu li li li li:hover ul, div#menu li li li li.sfhover ul { left: 0pt; z-index: 100; }

div#menu a:hover {
	color: #FFFFAA;
}
div#menu span:hover {
	color: #000;
}
div#menu li ul span:hover {
	color: #000;
}
div#menu ul.menu ul li span:hover {
	color:#000;
}
 
.midmain
{
   height:150px;
   width:962px;
   position:relative;
   margin-top:25px;
   padding:0px 10px
}
.midmain_1
{
   height:350px;
   width:95%;
   position:relative;
   margin-left:10px;
   margin-top:25px;   
   margin: auto;
}

/*tabslide out styling ends*/

/* pages css   */
#pagemain
{
    width:980px;
     border:1px solid #dfdfdf;
	 padding:10px 6px 10px 9px;
	 margin:0px;
}
#pagemain_ask
{
    width:980px;
    height:430px;
	padding:20px 0
     
}

.pagemain
{
    float: left;
    margin-left: 0px;
    width: 240px;
}
.pagemain_2
{
    width:683px;
    margin-left:15px;
    background-color:White;
  
    float:left;
   padding:10px;
margin-bottom:10px;
}

.midPagesmenulinks_tab1_1
{
   /* background-color: #605F64;*/
    padding: 10px;
    width: 220px;
}
.midQucklink_tab1
{
    background-color: #EB810B;
    border-bottom: 1px solid #734A02;
    color: #FFFFFF;
    font-size: 18px;
    font-weight: bold;
    height: 25px;
    padding: 2px 10px;
    text-align: left;
}
.midQucklink_tab1_2
{
    background-color: #fff;
    border: 1px solid #E8E3D9;
    padding: 10px;
  
}
.Linkul_inner
{
    list-style:none;
}
.Linkul_inner a
{
    background:url(../images/bullets.png) no-repeat 0 5px;
    text-decoration:none;
    color:Black;
    font-weight:normal; 
    padding-left:12px;
    font-size:14px;
}
.Linkul_inner a:hover
{
  
    text-decoration:underline;   
}

.midPages_1
{
    margin-bottom: 15px;
    margin-top: 15px;
    width: 240px;
}
.midPages_1_1
{
    margin:0;
}
.midPages_1-2
{
    margin-top:15px;
}
.midPages_1-3
{
    margin-top:15px;
}
.page
{
    text-align:justify;
}
h1 {
    padding-bottom:5px;
    font-size:22px;
    color:#605F64;
    border-bottom:1px solid #605F64;
    margin-bottom:20px;
}
h2 {
    padding-bottom:10px;
    font-size:20px;
    color:#ff8a00;
}
h3 {
    padding-bottom:0px;
    font-size:17px;
	color:#2e5b9e;
	font-weight:bold;
	margin:10px 0 0 0;
}
p 
{
  margin: 0;
  padding-bottom:12px;
}
.page_Salient
{
  margin-left:80px;
 width:480px;
 height:200px;
 background-color:#e7e7e7;
 border-top-width: 1px;
border-bottom-width: 1px;
border-top-style: solid;
border-bottom-style: solid;
border-top-color: #000000;
border-bottom-color: #000000;
border-right-width: 1px;
border-left-width: 1px;
border-right-style: solid;
border-left-style: solid;
border-right-color: #000000;
border-left-color: #000000;
border-top-left-radius: 15px 10px;
border-top-right-radius: 15px;
border-bottom-right-radius: 15px;
border-bottom-left-radius: 15px 10px;
}
.page_Salient_td
{
font-size:13px;
width:400px;
height:22px;
font-weight:bold;
}
.page_Salient_Full
{
  margin-left:5px;
 width:620px;
 height:200px;
 background-color:#e7e7e7;
 border-top-width: 1px;
border-bottom-width: 1px;
border-top-style: solid;
border-bottom-style: solid;
border-top-color: #000000;
border-bottom-color: #000000;
border-right-width: 1px;
border-left-width: 1px;
border-right-style: solid;
border-left-style: solid;
border-right-color: #000000;
border-left-color: #000000;
border-top-left-radius: 15px 10px;
border-top-right-radius: 15px;
border-bottom-right-radius: 15px;
border-bottom-left-radius: 15px 10px;
}
.page_Salient_td
{
font-size:14px;
width:400px;
height:18px;
font-weight:bold;
}
.page_Salient_td_full
{
font-size:14px;
width:545px;
height:18px;
font-weight:bold;
}
.academiccelender
{
    width:694px;
    height:auto;
}
.tabletr
{
    background-color:#fadfc4;
    font-family:Calibri;
    font-size:15px;
    color:#000211;
    height:30px;
}
.tabletrpr
{
    font-family:Calibri;
    font-size:15px;
    color:#000211;
}
.tbaletr1
{
    background-color:#fbefe3;
    font-family:Calibri;
    font-size:15px;
    color:#000211;
    height:30px;
    
}
.universitylist
{
font-family:Calibri;
font-size:15px;  
background-color:#d0e8f2;
width:100%;
border-collapse:collapse;
color:#000211
}
.our_partner
{
font-family:Calibri;
font-size:14px;  
background-color:#989898;
color:White;
padding:2px 5px;
line-height:20px
}
.our_partnertr
{
font-family:Calibri;
font-size:20px;  
background-color:#615f5f;
color:White;
padding:2px 5px;
line-height:24px
}

.applytoday
{
    position:absolute;
    right:-50px;
    top:64px;
    z-index:1000;
}
.askquestion
{
    position:absolute;
    right:-40px;
    top:180px;
    z-index:1000;
}
.fees
{
    position:absolute;
    right:-40px;
    top:272px;
    z-index:1000;
}
.questiontable
{
      width:930px;
      height:auto;
       background-color:#e7e7e7;
 border-top-width: 1px;
border-bottom-width: 1px;
border-top-style: solid;
border-bottom-style: solid;
border-top-color: #000000;
border-bottom-color: #000000;
border-right-width: 1px;
border-left-width: 1px;
border-right-style: solid;
border-left-style: solid;
border-right-color: #000000;
border-left-color: #000000;
border-top-left-radius: 15px 10px;
border-top-right-radius: 15px;
border-bottom-right-radius: 15px;
border-bottom-left-radius: 15px 10px;
}
.questiontables
{
      width:993px;
      height:auto;
       background-color:#e7e7e7;
 border-top-width: 1px;
border-bottom-width: 1px;
border-top-style: solid;
border-bottom-style: solid;
border-top-color: #000000;
border-bottom-color: #000000;
border-right-width: 1px;
border-left-width: 1px;
border-right-style: solid;
border-left-style: solid;
border-right-color: #000000;
border-left-color: #000000;
border-top-left-radius: 15px 10px;
border-top-right-radius: 15px;
border-bottom-right-radius: 15px;
border-bottom-left-radius: 15px 10px;
position:absolute;
}
.questiontableaskaquestions
{
      width:993px;
      height:auto;
       background-color:#e7e7e7;
 border-top-width: 1px;
border-bottom-width: 1px;
border-top-style: solid;
border-bottom-style: solid;
border-top-color: #000000;
border-bottom-color: #000000;
border-right-width: 1px;
border-left-width: 1px;
border-right-style: solid;
border-left-style: solid;
border-right-color: #000000;
border-left-color: #000000;
border-top-left-radius: 15px 10px;
border-top-right-radius: 15px;
border-bottom-right-radius: 15px;
border-bottom-left-radius: 15px 10px;
position:absolute;
}
.quetionstablesnew
{
      width:930px;
      height:422px;
}
.quetionstableapply
{
      width:930px;
      height:480px;
}
.questionaddress
{
      width:930px;
      height:auto;
       background-color:#e7e7e7;
 border-top-width: 1px;
 padding:50px;
border-bottom-width: 1px;
border-top-style: solid;
border-bottom-style: solid;
border-top-color: #000000;
border-bottom-color: #000000;
border-right-width: 1px;
border-left-width: 1px;
border-right-style: solid;
border-left-style: solid;
border-right-color: #000000;
border-left-color: #000000;
border-top-left-radius: 15px 10px;
border-top-right-radius: 15px;
border-bottom-right-radius: 15px;
border-bottom-left-radius: 15px 10px;
}
.questiontable2
{
      width:930px;
      height:auto;
       background-color:#fbe6d1;

}
.Question1
{
    width:200px;
    height:22px;
}
.Question2
{
    width:200px;
    height:22px; 
}
.Question3
{
     width:200px;
    height:22px;
}
.Question4
{
     width:300px;
    height:22px;
}
.Questintext
{
    font-family:Calibri;
    color:Black;
    font-size:14px;
    width:200px;
    height:22px;
    border: solid 1px #ea860e; 
    
}
.QuestionEnroll
{
    width:900px;
    height:22px;
}
.Questionimpdates
{
    width:750px;
    height:22px;
    margin-left:150px;
    text-align:center;
}
.Questionimpdate1
{
    width:200px;
    height:22px;
    font-family:Calibri;
    font-size:15px;
    font-style:normal;
    font-weight:bold;
    padding-left:20px;
    
}
.Questionimpdate2
{
     
    width:400px;
    height:22px;
    font-family:Calibri;
    font-size:15px;
     color:#000211;
      padding-left:20px;
}
.FAQ1
{
    width:20px;
    height:22px;
    font-family:Calibri;
    font-size:15px;
    font-style:normal;
    font-weight:bold;
    padding-left:20px;
    
}
.FAQ2
{
     
    width:800px;
    height:22px;
    font-family:Calibri;
    font-size:15px;
     color:#000211;
      padding-left:20px;
}
.Questionimpdat
{
    width:800px;
    height:22px;
    font-family:Calibri;
    font-size:18px;
    font-style:normal;
    font-weight:bold;
     color:#000211;
}
.tbaletr1
{
    background-color:#fbefe3;
    font-family:Calibri;
    font-size:15px;
    color:#000211;
    
}
.tablefirsttr
{
    margin-left:230px;
    font-size:18px;
    font-family:Calibri;
}
.acadamicone
{
    font-family:Calibri;
    font-size:16px;
    font-style:normal;
    font-weight:bold;
    margin-left:200px;
}



.midmain #intro{
width:940px;
float:left;
padding:.8em 5px 5px;
-webkit-box-sizing: border-box; /* Safari/Chrome, other WebKit */
-moz-box-sizing: border-box;    /* Firefox, other Gecko */
box-sizing: border-box;
}

.midmain #intro .left{
float:left;
height:auto;
width:250px;
font-family:"Signika";
}

.midmain #intro .left h1{
margin-top:1em;
font-size:24px;
color:#dc8632;
padding-left:0px;
border:0px;
}

.midmain #intro .right{
float:left;
height:auto;
width:680px;
}

.midmain #intro .right p{
margin-top:0.4em;
padding-left:1.2em;
font-size:16px;
color:#333333;
font-family:"Signika"; text-align:justify;
float:left;
border-left:0.1em dotted #000;
line-height:17px;
font-weight:400;
}

.midmain #intro .right p span{
color:#333333;
font-weight:100;
font-size:20px;
line-height:22px
}


#mid-box2{width:100%; height:490px; float:left; }
#mid-box2 h2{font-size:22px; color:#2e5b9e; font-weight:normal; margin-bottom:10px; line-height:18px; border-bottom:2px solid #2e5b9e}

#mid-box2 .tab{width:310px; float:left; margin-bottom:10px; padding-bottom:10px; border-bottom:solid 1px #dedede;}
#mid-box2 .tab .date{width:40px; float:left; font-size:13px; color:#2e5b9e; line-height:18px; height:45px;}
#mid-box2 .tab .date p{font-size:14px; color:#333;}
#mid-box2 .tab .date-text{width:255px; font-size:14px; color:#403F3D; float:left; padding-bottom:4px; line-height:15px;font-family:"Myriad Pro", "Open Sans Cond Light", Arial;


 overflow:hidden; 
  white-space:nowrap; 
  text-overflow:ellipsis; 



}
#mid-box2 .tab .date-text2{width:255px; font-size:14px; color:#333333; float:left; padding-bottom:4px; line-height:15px;font-family:"Myriad Pro", "Open Sans Cond Light", Arial;}

#mid-box2 .tab .date-text a{font-size:13px; color:#333333;}
#mid-box2 .tab .date-text a:hover{font-size:13px; color:#333333;}

#mid-box2 a{text-decoration:none;}

a.email{font-family:Tahoma, Arial; font-size:12px; float:right; color:#333333; text-decoration:none;}
a.email:hover{color:#566666;}


.Studentlife1 { width:100%; float:left; padding-bottom:0px; margin-bottom:7px;}
.Studentlife1 p{font-size:13px; margin-top:4px; float:left; text-align:justify; line-height:16px; background:url('images/abhi.png') no-repeat left top; padding-left:100px;padding-right: 0px;padding-top: 0px;padding-bottom: 0px;min-height: 85px; font-family:"Myriad Pro", "Open Sans Cond Light", Arial}
.Studentlife1 p span{font-size:18px; font-family:"Myriad Pro", "Open Sans Cond Light", Arial; color:#2e5b9e; position:relative; line-height:25px;}
.Studentlife1 p a{  color:#333333; text-decoration:none}
		

.Studentlife2 { width:100%; float:left; padding-bottom:0px; margin-bottom:7px;}
.Studentlife2 p{font-size:13px; margin-top:4px; float:left; text-align:justify; line-height:16px; background:url('images/jagpreet.png') no-repeat left top; padding-left:100px;padding-right: 0px;padding-top: 0px;padding-bottom: 0px;min-height: 85px; font-family:"Myriad Pro", "Open Sans Cond Light", Arial}
.Studentlife2 p span{font-size:18px; font-family:"Myriad Pro", "Open Sans Cond Light", Arial; color:#2e5b9e; position:relative; line-height:25px;}
.Studentlife2 p a{  color:#333333; text-decoration:none}


.Studentlife3 { width:100%; float:left; padding-bottom:0px; margin-bottom:7px;}
.Studentlife3 p{font-size:13px; margin-top:4px; float:left; text-align:justify; line-height:16px; background:url('images/patak.png') no-repeat left top; padding-left:100px;padding-right: 0px;padding-top: 0px;padding-bottom: 0px;min-height: 85px; font-family:"Myriad Pro", "Open Sans Cond Light", Arial;}
.Studentlife3 p span{font-size:18px; font-family:"Myriad Pro", "Open Sans Cond Light", Arial; color:#2e5b9e; position:relative; line-height:25px;}
.Studentlife3 p a{  color:#333333; text-decoration:none}

.Studentlife4 { width:100%; float:left; padding-bottom:0px; margin-bottom:7px;}
.Studentlife4 p{font-size:13px; margin-top:4px; float:left; text-align:justify; line-height:16px; background:url('images/ankita_1.png') no-repeat left top; padding-left:100px;padding-right: 0px;padding-top: 0px;padding-bottom: 0px;min-height: 85px; font-family:"Myriad Pro", "Open Sans Cond Light", Arial;}
.Studentlife4 p span{font-size:18px; font-family:"Myriad Pro", "Open Sans Cond Light", Arial; color:#2e5b9e; position:relative; line-height:25px;}
.Studentlife4 p a{  color:#333333; text-decoration:none}

/* Sitemap CSS*/
.sitemap_container {
	width: 95%;
	display: block;
	padding:0px 20px;}
.sitemap_container .sitemap_holder {
	width: 30%;
	display: block;
	float: left;
	margin: 1% 0 2%;
	margin-right: 3%;
}
.sitemap_container .sitemap_holder h2 {
	display: block;
	float: left;
	width: 100%;
	border-bottom: 1px solid #ccc;
	margin-bottom: 15px;
	padding-bottom: 10px;
	
	color: #4D5762;
	font: 1.4em Georgia;
	letter-spacing: 0.03em;
}

.sitemap_container .sitemap_holder h5 {
	display: block;
	float: left;
	width: 100%;
	padding: 8px 0 4px 0;
	font: 400 1.2em "Signika";
	text-transform:uppercase;
	margin:0px;
	color:#2e5b9e
}
.sitemap_container .sitemap_holder h5 a {
	color:#2e5b9e
}


.sitemap_container .sitemap_holder h6 {
	display: block;
	float: left;
	width: 100%;
	margin: 0;
	padding: 4px 0;
	font: normal 1.2em "Courier New", Courier, monospace;
}

.sitemap_container .sitemap_holder ul {
	width: 100%;
	display: block;
	margin-bottom: 10px;
}
.sitemap_container .sitemap_holder ul li {
	width: 100%;
	display: block;
	padding: 5px 0;
	color:#333333;
	font-size:14px;

}
.sitemap_container .sitemap_holder ul.pull li:before {
   content: "•";
}
.sitemap_container .sitemap_holder ul.pox li:before {
   content: "▪";
}
.sitemap_container .sitemap_holder ul li a {
	padding: 0;
	padding-left: 6px;
	color:#333333;
	text-decoration:none;
}
.sitemap_container .sitemap_holder ul li a:hover {
	text-decoration: underline;
	color:#666666
}
.download
{
      width:500px;
      height:auto;
      margin-left:200px;
       background-color:#e7e7e7;
 border-top-width: 1px;
 padding:50px;
border-bottom-width: 1px;
border-top-style: solid;
border-bottom-style: solid;
border-top-color: #000000;
border-bottom-color: #000000;
border-right-width: 1px;
border-left-width: 1px;
border-right-style: solid;
border-left-style: solid;
border-right-color: #000000;
border-left-color: #000000;
border-top-left-radius: 15px 10px;
border-top-right-radius: 15px;
border-bottom-right-radius: 15px;
border-bottom-left-radius: 15px 10px;
text-align:center;
}


.table {
  width: 100%;
  margin-bottom: 20px;
  border: 1px solid #ddd;
  
}

.table th,
.table td {
  padding: 6px;
  line-height: 18px;
  text-align: left;
  vertical-align: top;
  border-top: 1px solid #dddddd;
}

.table th {
  font-weight: bold;
}

.table thead th {
  vertical-align: bottom;
}
.table{margin: 0px;}
.table tr th{padding: 4px 8px; font-size: 16px; background-color: #F1F1F1; color: #666;}
.table tr th,[class*="block"] .table tr td{border-right: 1px solid #ddd;}
.table tr th:last-child,[class*="block"] .table tr td:last-child{border-right: 0px;}
.table tr td{background-color: #F9F9F9;}
.table tr:nth-child(2n+1) td{background-color: #FFF;}

/* News & Events page */
.newsevents { width:100%; clear:both; padding-left:0px; margin-bottom:10px; float:left}
.newsevents .colg {float: none; width: 100%; height: auto;border-top: 1px dotted #afb4b7;  padding: 5px 0px; margin-bottom: 22px;background-color: transparent; -moz-box-shadow: none;-webkit-box-shadow: none;box-shadow: none; clear:both}
.newsevents .colg:first-child {border-top: none; margin-top: 0;}
.newsevents .colg h3{font-size:16px; padding: 0; margin-bottom:12px;color:#001d40; font-weight:400}
.newsevents .colg h3 a:link, .colg h3 a:visited {text-decoration:none;color:#001d40;}
.newsevents .colg h3 a:hover, .colg h3 a:active {text-decoration:underline;}
.newsevents .colg p {font-size:14px; color:#001d40; line-height:18px;font-style: normal; font-weight: 100;}
.newsevents .colg ul {list-style: none; margin-left:0px; margin-top:10px; float:right}
.newsevents .colg ul li {list-style: none; padding-left:0px;}
.newsevents .colg ul li a.button {float: left; display: block; width: 100px; margin: 0 0 10px 0; line-height: 14px; height: auto; font-size: 11px; padding: 5px 24px 4px 12px; text-align: left;}
.newsevents .colg ul li.readmore a.button {background: #f6f7f7 url(../images/bg-button-icons.png) no-repeat 106px 5px; font-size:13px; text-decoration:none; color:#333333}
.newsevents .colg ul li.readmore a.button:hover  {background-color:#fd9613; background-position: -194px 5px; color:#FFFFFF; text-decoration:none}
.textcount
{
 overflow:hidden; 
  white-space:nowrap; 
  text-overflow:ellipsis; 
  width:100px;
}
  
  </style>
</head>
<body>

    

<div id="mid-box2">
                <h2>News &amp; Blogs</h2>
<s:iterator value="newsAndBlogsList">
					
                     <div class="tab" style="margin-bottom:5px;">
                        <div class="date"><strong><s:property value="date"/></strong></div>
                         <div class="date-text" href="#">
                        <p> <strong><s:property value="titleName"/></strong></p>
                      <a href='<s:property value="newsDescription" />' target="_blank" ><s:property value="newsDescription" /></a>
                        </div>
                      
                    </div>
					
			
	
</s:iterator>				  
</div>





	
</body>
</html>