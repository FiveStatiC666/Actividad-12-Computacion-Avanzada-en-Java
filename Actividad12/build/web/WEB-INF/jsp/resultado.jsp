<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Area y perimetro del triangulo!</h1>
        
        <%
            Connection con;
            String url="jdbc:mysql://localhost3306/actividad_12";
            String user="root";
            String contraseña="Lps295195";
            String driver="com.mysql.cj.jdbc.Driver";
           
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,contraseña);
            PreparedStatement ps;
            ResultSet rs;
            ps=con.prepareStatement("SELECT * FROM triangulo");
            rs=ps.executeQuery();
        %>
        <div>
            <table class="table table-hover table-dark">
                <thead>
                    <tr>
                        <th class="text-center">id_triangulo</th>
                        <th class="text-center">base</th>
                        <th class="text-center">altura</th>
                        <th class="text-center">perimetro</th>
                        <th class="text-center">area</th>
                    </tr>
                </thead>
                
                <%
                    while (rs.next())
                    {
                %>
                <tr>
                    <td class="text-center"><%=rs.getInt("id_triangulo")%></td>
                    <td class="text-center"><%=rs.getInt("base")%></td>
                    <td class="text-center"><%=rs.getInt("altura")%></td>
                    <td class="text-center"><%=rs.getInt("perimetro")%></td>
                    <td class="text-center"><%=rs.getInt("area")%></td>
                </tr>
                
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
