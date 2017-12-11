<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head><title>SpringBoot</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>
<hr/>
<form method="post" action="/save">
  <input type="hidden" name="id" value="${lists.id}"/><br/>
  Name:<br>
  <input type="text" name="name" value="${lists.name}"/>
  <br>
  Email:<br>
  <input type="text" name="email" value="${lists.email}">
  <br>
  Age:<br>
  <input type="number" name="age" value="${lists.age}"/>
  <br>
  Address:<br>
  <input type="text" name="address" value="${lists.address}"/>
  <br>
  Contact:<br>
  <input type="number" name="contact" value="${lists.contact}"/>
  <br>



  <br>
  <input type="submit" value="Submit">
</form>

</body>
</html>
