<#import "common/admin.ftlh" as c>

<@c.admin>
    <table class="table" style="width: 100%;   ">
        <thead class="thead-dark" style="border-radius: 12px">
        <tr>
            <th scope="col">Username</th>
            <th scope="col">Roles</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a class="btn btn-primary" role="button" href="/users/${user.id?c}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.admin>
