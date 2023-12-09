<#import "common/page.ftlh" as c>
<#import "common/navbar.ftlh" as nav>

<@c.page>
    <style type="text/css">
        body {
            background-color: RGB(248, 249, 250);
        }
    </style>
    <form action="/login" method="post"
          style="max-width: 400px; padding: 12px; margin: auto; margin-top: 20px; border-radius: 12px;
             padding-top: 20px; background-color: white" ;>
        <!-- Email input -->

        <div class="form-outline mb-4">
            <input type="text" id="username" class="form-control" name="username"/>
            <label class="form-label" for="username">Username</label>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <input type="password" id="password" class="form-control" name="password"/>
            <label class="form-label" for="password">Password</label>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <!-- Submit button -->
        <div style="margin: auto; width: fit-content">
            <input type="submit" value="Log in" class="btn btn-primary">
            <a type="button" class="btn btn-secondary" href="/"
               style="color:white; margin: auto; margin-left: 6px;">Main page</a>
            <div class="text-center" style="margin-top: 6px">
                <p>Not a member? <a href="/registration">Register</a></p>
            </div>
        </div>

    </form>

</@c.page>