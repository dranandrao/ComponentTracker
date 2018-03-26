<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div style="background: rgba(0, 0, 0, 0.78); height: 55px; padding: 5px; margin: 0;position: fixed;top:0px; width:100%">
  <div style="float: left">
     <h2 style="color: white;">LabComponent</h2>
  </div>
 
  <div style="float: right; padding: 10px; text-align: right; color: white;">
 
     <!-- User store in session with attribute: loginedUser -->
     Hello <b>${loginedUser.userName}</b>
   <br/>
 
  </div>
 
</div>