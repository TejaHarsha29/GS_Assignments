<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib   prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
   <table>
     <tr>
         <th>FlightId</th>
         <th>Soruce</th>
         <th>Destination</th>
         <th>Fare</th>
         <th>Seats</th>
     </tr>
     <c:forEach var="flg"   items="${flights }">
         <tr>
           <td>${flg.flight_id}</td>
           <td>${flg.source }</td>
           <td>${flg.destination}</td>
           <td>${flg.fare }</td>
           <td>${flg.seats_available }</td>
         </tr>
     </c:forEach>
   </table>
   <form   action="">
        logic for entering passenger details.
   </form>



   <form action="booking" method="post">
   		<table style="border: 1px solid black;" width="50%" align="center">
   			<tr>
   				<th>FlightId</th>
   				<td><input type="text" name="flightId"></td>
   			</tr>
   			<tr>
   				<th>PassengerId</th>
   				<td><input type="text" name="passengerId"></td>
   			</tr>
   			<tr>
   				<th>FirstName</th>
   				<td><input type="text" name="firstname"></td>
   			</tr>
   			<tr>
   				<th>LastName</th>
   				<td><input type="text" name="lastname"></td>
   			</tr>
   			<tr>
   				<th>Mobile</th>
   				<td><input type="text" name="mobile"></td>
   			</tr>
   			<tr>
   				<th>Email</th>
   				<td><input type="email" name="email"></td>
   			</tr>
   			<tr>
   				<th>Travel Date</th>
   				<td><input type="date" name="traveldate"></td>
   			</tr>
   			<tr>
   				<th><input type="submit" value="Book"></th>
   			</tr>
   		</table>
   	</form>


</body>
</html>