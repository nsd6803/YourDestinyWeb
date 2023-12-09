<#import "common/admin.ftlh" as c>
<#import "common/admin.ftlh" as c>
<#import "common/navbar.ftlh" as nav>

<@c.admin>
   <#assign specializations = ['Therapist', 'Cardiologist', 'Dermatologist', 'Gynecologist', 'Ophthalmologist',
        'Orthopedist', 'Psychiatrist', 'Surgeon', 'Endocrinologist', 'Nephrologist', 'Gastroenterologist']>
    <h1 style="text-align: center; margin-top: 15px">Item ID:${doctor.id?c}</h1>
    <div style="margin: 20px; max-width: 1200px; margin: auto; padding: 20px; margin-top: 30px;
-webkit-box-shadow: 1px 0px 14px -4px rgba(70, 81, 90, 0.11);
-moz-box-shadow: 1px 0px 14px -4px rgba(70, 81, 90, 0.11);
box-shadow: 1px 0px 14px -4px rgba(70, 81, 90, 0.11); border-radius: 15px">
        <form action="/doctor/edit" method="post" id="change" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${doctor.name}" required>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input name="price" type="number" min=1 class="form-control" id="price" value="${doctor.price?c}"
                       required>
            </div>

            <div class="form-group">
                <label for="specialization">Specialization</label>
                <select class="form-control" id="specialization" name="specialization">
                    <#list specializations as s>
                        <option value="${s}" <#if (s == doctor.specialization)> selected="selected"</#if>>${s}</option>
                    </#list>
                </select>
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="hidden" name="doctorId" value="${doctor.id?c}">


        </form>
        <button type="submit" class="btn btn-primary" form="change">Save</button>
        <input class="btn btn-danger" type="submit" value="delete" form="del">
        <form action="/doctor/delete/${doctor.id?c}" id="del" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">

        </form>
    </div>
</@c.admin>