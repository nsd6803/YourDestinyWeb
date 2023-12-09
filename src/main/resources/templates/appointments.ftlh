<#import "common/page.ftlh" as c>
<#import "common/navbar.ftlh" as nav>

<@c.page>

    <@nav.nav>
    </@nav.nav>
<div style="width: 96%; margin: auto; padding: 10px;">

            <div class="list" style="display: flex; flex-wrap: wrap; justify-content: center; width: fit-content">

                <#list appointments as appointment>
                    <div class="card"
                         style="width: 20rem;  margin-top: 10px; margin-right: 10px; padding-bottom: 0px;">

                        <div class="card-body">

                            <h5 class="card-title">${appointment.getDate()}</h5>
                            <p class="card-text">Doctor: ${appointment.doctor.name}</p>
                            <p class="card-text font-weight-light">Dr. specialization: ${appointment.doctor.specialization}</p>
                            <p class="card-text font-weight-light">Patient: ${user.fullName}</p>
                            <p class="card-text font-weight-light">Patient's birthdate: ${user.getBirth()}</p>
                            <p class="card-text font-weight-light">Price: ${appointment.doctor.price}$</p>
                           <form action="/appointment/cancel" id="cancel" method="post">
                               <input type="hidden" name="_csrf" value="${_csrf.token}">
                               <input type="hidden" name="appointmentId" value="${appointment.id}">

                               <button type="submit" class="btn btn-outline-danger">Cancel an Appointment</button>
                                </form style="margin-bottom=0px">
                        </div>
                    </div>
                <#else>
                    <h3>Appointments not found</h3>
                </#list>
            </div>
        </div>



</@c.page>


