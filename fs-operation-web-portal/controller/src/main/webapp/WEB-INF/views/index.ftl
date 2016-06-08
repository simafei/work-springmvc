<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
    <table>
        <#list results as row>
        <tr>
            <td>${ row.name }</td><td>${ row.stat_date }</td><td>${ row.n_click_times }</td>
        </tr>
        </#list>
    </table>
</body>
</html>