<%
    int min = -100;
    try {
        String minValue = request.getParameter("val_min");
        min = Integer.parseInt(minValue);
    }catch(Exception ex){}

    int max = 100;
    try{
        String maxValue = request.getParameter("val_max");
        max = Integer.parseInt(maxValue);
    }catch(Exception ex){}

    int inc = 5;
    try {
        String incValue = request.getParameter("val_inc");
        inc = Integer.parseInt(incValue);
    }catch(Exception ex){}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv=\"Content-Type\"content=\"text/html; charset=UTF-8\">
    </head>
    <body>
        <table border=\"1\">
            <tr>
                <th>Celsius</th>
                <th>Fahrenheit</th>
            </tr>
            <%
                for (int celsius = min; celsius <= max; celsius += inc) {
                    double fahr = 1.8 * celsius + 32;
            %>
            <tr>
                <td> <%= celsius%></td>
                <td> <%= fahr%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>