<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Celsius - Fahrenheit</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="converte.jsp">
            <fieldset>
                <legend>Conversão Celsius - Fahrenheit</legend>
                <label for="val_min">Valor minimo</label>
                <input type="text" name="val_min" id ="val_min"/>
                
                <br>
                <br>

                <label for="val_max">Valor maximo</label>
                <input type="text" name="val_max" id ="val_max"/>

                <br>
                <br>

                <label for="val_inc">Valor do incremento</label>
                <input type="text" name="val_inc" id ="val_inc"/>

                <br>
                <br>

                <input type="submit" value="Inicializa valores"/>
                <input type="submit" value="Solicita conversão"/>
            </fieldset>
        </form>
    </body>
</html>