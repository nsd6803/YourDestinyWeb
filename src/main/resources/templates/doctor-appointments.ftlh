<#import "common/admin.ftlh" as c>
<#import "common/navbar.ftlh" as nav>

<@c.admin>
    <table class="table" style="width: 100%;   ">
        <thead class="thead-dark" style="border-radius: 12px">
        <tr>
            <th scope="col"></th>
            <th scope="col">ID</th>
            <th scope="col">Doctor</th>
              <th scope="col">Patient</th>
            <th scope="col">Time</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list appointments as appointment>
            <tr>
                <td></td>
                <td>${appointment.id}</td>
                <td>${doctor.name}</td>
                <#if appointment.user??>
                    <td>${appointment.user.fullName}</td>
                <#else>
                    <td></td>
                </#if>
                <td>${appointment.getDate()}</td>
                <td>

                    <form action="/appointment/delete/${appointment.id?c}" id="del" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="hidden" name="doctorId" value="${doctor.id}">
                        <input class="btn btn-danger" type="submit" value="delete">
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>


      <form class="form-inline my-2 my-lg-0">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter" style="width: fit-content; margin: auto">Add new appointment</button>
                    </form>

                      <!-- Modal -->
                                <div class="modal fade" id="exampleModalCenter" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Create an Appointment</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <form method="post" action="/appointment/add/">

                                                     <div class="mb-3">
                                                        <select  class="form-select" id="appointmentDate" aria-label="Time selection" name="date">

                                                        </select>
                                                    </div>
                                                    <div class="mb-3">
                                                        <select  class="form-select" aria-label="Time selection" name="time">
                                                            <option value="09:00">09:00</option>
                                                            <option value="09:30">09:30</option>
                                                            <option value="10:00">10:00</option>
                                                            <option value="10:30">10:30</option>
                                                            <option value="11:00">11:00</option>
                                                            <option value="11:30">11:30</option>
                                                            <option value="12:00">12:00</option>
                                                            <option value="12:30">12:30</option>
                                                            <option value="13:00">13:00</option>
                                                            <option value="13:30">13:30</option>
                                                            <option value="14:00">14:00</option>
                                                            <option value="14:30">14:30</option>
                                                            <option value="15:00">15:00</option>
                                                            <option value="15:30">15:30</option>
                                                            <option value="16:00">15:30</option>
                                                        </select>
                                                    </div>
                                                       <input type="hidden" name="doctorId" value="${doctor.id}">
                                                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                                                    <button type="submit" class="btn btn-primary">Create</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </div>

<script>
const dateForm = document.querySelector('#appointmentDate');


const today = new Date();
for (i = 1; i < 10; i++) {
    const date = new Date(today.getTime() + (i * 24 * 60 * 60 * 1000));
    const str = date.getFullYear() + "-"
    + ((date.getMonth() + 1) < 10 ? '0' + (date.getMonth() + 1) : (date.getMonth() + 1)) + "-"
    + (date.getDate() < 10 ? '0' + date.getDate() : date.getDate());
    const dateSelection = document.createElement('option');
    dateSelection.value = str;
    dateSelection.text = str;
    dateForm.appendChild(dateSelection);
}



</script>
</@c.admin>