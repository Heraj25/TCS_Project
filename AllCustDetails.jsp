<%@ page import="java.util.ArrayList" %>
<%@ page import="com.database.Customer" %>
<%@ page import="com.database.Customeer" %>

<!DOCTYPE html>

<html>

<head>
    <title>All Customers</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<center>
<body>

    <h2>All Customers</h2>
    <table>
        <thead>
            <tr>
                <th>SSN ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Contact Number</th>
                <th>Aadhar</th>
                <th>PAN</th>
                <th>Account Number</th>
                <th>Account Type</th>
                <th>Balance</th>
            </tr>
        </thead>
        <tbody>
            <%
                ArrayList<Customeer> customers = (ArrayList<Customeer>) request.getAttribute("customers");
                if (customers != null && !customers.isEmpty()) {
                    for (Customeer customer : customers) {
            %>
                        <tr>
                            <td><%= customer.getSsnId() %></td>
                            <td><%= customer.getName() %></td>
                            <td><%= customer.getEmail() %></td>
                            <td><%= customer.getAddress() %></td>
                            <td><%= customer.getContactNumber() %></td>
                            <td><%= customer.getAadhar() %></td>
                            <td><%= customer.getPan() %></td>
                            <td><%= customer.getAccountNumber() %></td>
                            <td><%= customer.getAccountType() %></td>
                            <td><%= customer.getBalance() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="9" style="text-align: center;">No customers found.</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <br>
    <br>
   <a href="EmpHome.jsp">Go back to homepage.</a>
</body>
 </center>
</html>
