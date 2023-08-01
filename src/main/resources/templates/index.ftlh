<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<table border="2px">
    <thead>
    <tr>
        <th>tree id</th>
        <th>name</th>
        <th>age</th>
        <th>is green</th>
        <th>delete</th>
    </tr>
    </thead>
    <tbody>
    <#list trees as tree>
        <tr>
            <td><a href="/trees/${tree.getId()}"><p>${tree.getId()}</a></td>
            <td>${tree.getName()}</td>
            <td>${tree.getAge()}</td>

            <#if tree.getIsGreen()>
                <td>GREEN</td>
            <#else>
                <td>NOT GREEN</td>
            </#if>
            <td><a href="/trees/delete/${tree.getId()}"><p>DELETE</a></td>
        </tr>
    </#list>
    </tbody>
</table>

</body>
</html>