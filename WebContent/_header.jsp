<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div style="background: rgba(0, 0, 0, 0.78); height: 55px; padding: 5px; margin: 0;position: fixed;top:0px; width:100%">
  <div style="float: left">
     <h2 style="color: white;">LabComponent</h2>
  </div>
 
  <div style="float: right; padding: 10px; text-align: right; color: white;">
 
     <!-- User store in session with attribute: loginedUser -->
     Hello <b><%= request.getAttribute("username") %></b>
   <br/>
 
  </div>
 
</div>
