<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/adminlogin.jsp"/>
   <center>Choose An Operation</center>
     <form>
       <table align="center" style="text-align: justify">
        <tr>
         <td><input type="submit" value="View All Donors" formaction="/admin/alldonors"/></td>
         <td><input type="submit" value="View Donors For Specific Blood" formaction="/admin/adminbloodform"/></td>
         <td><input type="submit" value="View Donors By Phone No." formaction="/admin/adminphoneform"/></td> 
        </tr>
       </table>
     </form>
     <hr>
</body>
</html>