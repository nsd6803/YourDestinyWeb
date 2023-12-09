<#import "common/admin.ftlh" as c>
<#import "common/navbar.ftlh" as nav>
 <#assign specializations = ['Therapist', 'Cardiologist', 'Dermatologist', 'Gynecologist', 'Ophthalmologist',
     'Orthopedist', 'Psychiatrist', 'Surgeon', 'Endocrinologist', 'Nephrologist', 'Gastroenterologist']>
<@c.admin>


    <div style="margin: 20px; max-width: 1200px; margin: auto; padding: 20px; margin-top: 30px;
-webkit-box-shadow: 1px 0px 14px -4px rgba(70, 81, 90, 0.11);
-moz-box-shadow: 1px 0px 14px -4px rgba(70, 81, 90, 0.11);
box-shadow: 1px 0px 14px -4px rgba(70, 81, 90, 0.11); border-radius: 15px">
        <form action="/doctor/create" method="post" id="change" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="name" required>
            </div>

            <div class="form-group">
                <label for="price">Price</label>
                <input name="price" type="number" min=1 class="form-control" id="price" placeholder="price"
                       required>
            </div>

            <div class="form-group">
                <label for="specialization">Specializations</label>
                <select class="form-control" id="specialization" name="specialization">
                    <#list specializations as specialization>
                        <option value="${specialization}">${specialization}</option>
                    </#list>
                </select>
            </div>



            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
        <button type="submit" class="btn btn-primary" form="change">Save</button>
    </div>
</@c.admin>