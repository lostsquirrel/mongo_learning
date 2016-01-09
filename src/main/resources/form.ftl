<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Fruit Picker</title>
    </head>
    <body>
        <h1>Fruit Picker</h1>
        <p>What is your favorite fruit</p>
        <form action="/form" method="post" >
        <#list fruits as fruit>
        <input type="radio" name="fruit" value="${fruit}" /> 
        <label >${fruit}</label>
        <br />
        </#list>
        <input type="submit" name="name" value="Submit">
        </form>
    </body>
</html>
