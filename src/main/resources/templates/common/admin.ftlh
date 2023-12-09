<#macro admin>
<#import "page.ftlh" as c>

<@c.page>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/">ADMIN</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">


                <ul class="navbar-nav mr-auto">

                    <li class="nav-item active">
                        <a class="nav-link" href="/">Main page</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/doctor/new">Add doctor</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/doctor/list">Edit schedule</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/users">User management </a>
                    </li>
                </ul>
        </div>
    </nav>
<#nested>

</@c.page>
</#macro>