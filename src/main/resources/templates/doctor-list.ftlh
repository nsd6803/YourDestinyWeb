<#import "common/admin.ftlh" as c>
<#import "common/navbar.ftlh" as nav>

<@c.admin>
    <table class="table" style="width: 100%;   ">
        <thead class="thead-dark" style="border-radius: 12px">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">ID</th>
            <th scope="col">Specialization</th>
            <th scope="col">Price</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list doctors as doctor>
            <tr>
                <td><a href="/appointment/list/${doctor.id}">${doctor.name}</a></td>
                <td>${doctor.id}</td>
                <td>${doctor.specialization}</td>
                <td>${doctor.price}</td>
                <td><a class="btn btn-primary" role="button" href="/doctor/list/${doctor.id?c}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.admin>