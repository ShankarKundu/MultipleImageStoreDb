<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>fileuplopad </title>
</head>
<body>
<form action="UploadServlet1" method="post" enctype="multipart/form-data" name="form1" id="form1">
<center>
  <table border="1">
        <tr>
              <td align="center"><b>multiple image upload</b></td>
        </tr>
        <tr>
               <td>specify file<input name="file" type="file" id ="file" multiple></td>
        </tr>
        <tr>
             <td align="center"><input type="submit" value="submit file" name="submit"></td>
        </tr>
   </table>
</center>
</form>
</body>
</html>