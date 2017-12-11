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

<table>
  <tr>
    <th>ID</th>
    <td>${lists.id}</td>
  </tr>
  <tr>
      <th>Name</th>
      <td>${lists.name}</td>
    </tr>
    <tr>
        <th>Email</th>
        <td>${lists.email}</td>
      </tr>
    <tr>
        <th>Age</th>
        <td>${lists.age}</td>
    </tr>
    <tr>
        <th>Address</th>
        <td>${lists.address}</td>
    </tr>
    <tr>
        <th>Contact</th>
        <td>${lists.contact}</td>
    </tr>
  </table>
  <a href="/">Back</a>
</body>
</html>
