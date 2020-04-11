<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="java.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<title>borrowedrecord</title>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.tabfont01 {
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
</style>


<link href="./css/css.css" rel="stylesheet" type="text/css" />

<script type="text/JavaScript">
</script>

<link href="./css/style.css" rel="stylesheet" type="text/css" />

</head>



<SCRIPT language=JavaScript>

function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function submit2(){
	 var date1 = document.getElementById("date1").value;
	
   if(date1==""){
       alert("Please input correctly!");
       return false;
   }else{
       form.submit();
       return true;
   }
}
</SCRIPT>



<body>



	<table width="100%" border="0" cellspacing="0" cellpadding="0">

		<tr>
			<td>
				<table id="subtree1" style="DISPLAY:" width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table width="95%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td height="20">


										<form action="borrowrecordsearch" method="post" onsubmit="return submit2()" >

											<input name="searchBRID" type="text" size="12" id="date1" /> <input
												type="submit" class="right-button02" value="search"   />
											<a class="right-button02" target="mainFrame" href="borrowedrecordList" style="display:inline-block;text-decoration:none">clear</a>
										</form>


										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</td>
								</tr>

								<tr>
									<td height="40" class="font42">

										<table width="100%" border="0" cellpadding="4" cellspacing="1"
											bgcolor="#464646" class="newfont03">

											<tr>
												<td height="20" colspan="15" align="center"
													bgcolor="#EEEEEE" class="tablestyle_title">
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													Borrowed Record List&nbsp;</td>
											</tr>

											<tr>
												<td width="6%" align="center" bgcolor="#EEEEEE">BRID</td>
												<td width="9%" height="20" align="center" bgcolor="#EEEEEE">barcode</td>
												<td width="9%" align="center" bgcolor="#EEEEEE">book name</td>
												<td width="8%" align="center" bgcolor="#EEEEEE">reader account</td>
												<td width="9%" align="center" bgcolor="#EEEEEE">borrowed date</td>
												<td width="10%" align="center" bgcolor="#EEEEEE">returned date</td>
												<td width="5%" align="center" bgcolor="#EEEEEE">fine</td>
											</tr>




											<form name="fom" id="fom" method="post">

												<c:forEach items="${borrowedRecords}" var="borrowedrecord"
													varStatus="re">
													<tr>
														<td height="20" bgcolor="#FFFFFF">${borrowedrecord.bRID}</td>
														<td bgcolor="#FFFFFF">${borrowedrecord.barCode}</td>
														<td bgcolor="#FFFFFF">${borrowedrecord.bookName}</td>
														<td bgcolor="#FFFFFF">${borrowedrecord.readerAccount}</td>
														<td bgcolor="#FFFFFF">${borrowedrecord.borrowedDate}</td>
														<td bgcolor="#FFFFFF">${borrowedrecord.returnedDate}</td>
														<td height="20" bgcolor="#FFFFFF">${borrowedrecord.fine}</td>

														<%-- <input type="hidden" name="barCode1" value="${book.barCode}"  /></input>
	        <input type="hidden" name="ISBN" value="${book.ISBN}"  /></input>
	        <input type="hidden" name="author" value="${book.author}"  /></input>
	        <input type="hidden" name="publishing" value="${book.publishing}"  /></input>
	        <input type="hidden" name="bookName" value="${book.bookName}"  /></input>
	        <input type="hidden" name="location" value="${book.location}"  /></input>
	        <input type="hidden" name="status" value="${book.status}"  /></input>
	        <input type="hidden" name="price" value="${book.price}"  /></input>
	        <input type="hidden" name="dateOfStorage" value="${book.dateOfStorage}" /></input> --%>





													</tr>
												</c:forEach>





												<%-- 	 <tr>
		  	    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td> 
		    <td height="20" bgcolor="#FFFFFF">${book1.barCode}</td>
            <td bgcolor="#FFFFFF">${book1.ISBN}</td>
            <td bgcolor="#FFFFFF">${book1.author}</td>
            <td bgcolor="#FFFFFF">${book1.publishing}</td>
            <td bgcolor="#FFFFFF">${book.bookName}</td>
            <td bgcolor="#FFFFFF">${book1.location}</td>
		    <td height="20" bgcolor="#FFFFFF">${book1.status}</td>
		    <td height="20" bgcolor="#FFFFFF">${book.price}</td>
		    <td height="20" bgcolor="#FFFFFF">${book1.tag1}</td>
			<td height="20" bgcolor="#FFFFFF">${book1.tag2}</td>
			<td height="20" bgcolor="#FFFFFF">${book1.dateOfStorage}</td>
			<td bgcolor="#FFFFFF"><a href="bookedit.jsp?barCode1=${book1.barCode}&ISBN=${book1.ISBN}&author=${book1.author}&publishing=${book1.publishing}&bookName=${book1.bookName}&location=${book1.location}&status=${book1.status}&price=${book1.price}&dateOfStorage=${book1.dateOfStorage}">edit</a>&nbsp; |&nbsp;<a href="bookdeleteServlet?barCode1=${book1.barCode}" >delete</a>&nbsp;</td>
	
		    </tr> --%>

											</form>





										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>



				
			</td>
		</tr>
	</table>
	<script> 
    var errory='<%=request.getParameter("error")%>';
    if(errory=='yes')
    	{
    	alert("已有账号存在");
    	}
    
    var errory1='<%=request.getParameter("error1")%>';
    if(errory1=='yes')
    	{
    	alert("不存在该账号");
    	}
    
    </script>
</body>
</html>
