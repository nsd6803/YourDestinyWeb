<#import "common/admin.ftlh" as c>

<@c.admin>
    <style type="text/css">
        body {
            background-color: RGB(248, 249, 250);
        }
    </style>
    <form action="/admin/users/edit" method="post"
          style="max-width: 400px; padding: 12px; margin: auto; margin-top: 20px; border-radius: 12px;
             padding-top: 20px; background-color: white" ;>
        <!-- Email input -->

        <div class="form-outline mb-4">
            <input type="text" disabled id="username" class="form-control" name="username" value="${user.username}"/>
            <label class="form-label" for="username">Username</label>
        </div>
        <div class="row mb-4">
            <#list roles as role>
                <div class="col d-flex justify-content-center">
                    <!-- Checkbox -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="${role}"
                               name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}
                                <#if role == "USER"> onchange="document.getElementById('submit').disabled = !this.checked;" </#if>>
                        <label class="form-check-label" for="${role}">${role}</label>
                    </div>
                </div>
            </#list>
        </div>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <!-- Submit button -->
        <div style="margin: auto; width: fit-content">
            <input type="submit" id="submit" value="Save" class="btn btn-primary">
        </div>
    </form>

</@c.admin>